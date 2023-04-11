package edu.colostate.cs415.server;

import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.redirect;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.logging.Logger;

import com.google.gson.Gson;

import edu.colostate.cs415.db.DBConnector;
import edu.colostate.cs415.dto.ProjectDTO;
import edu.colostate.cs415.dto.QualificationDTO;
import edu.colostate.cs415.dto.WorkerDTO;
import edu.colostate.cs415.model.Company;
import edu.colostate.cs415.model.Project;
import edu.colostate.cs415.model.Qualification;
import edu.colostate.cs415.model.Worker;
import spark.Request;
import spark.Response;
import spark.Spark;

public class RestController {

	private static Logger log = Logger.getLogger(RestController.class.getName());
	private static String OK = "OK";
	private static String KO = "KO";

	private DBConnector dbConnector;
	private Company company;
	private Gson gson;

	public RestController(int port, DBConnector dbConnector) {
		port(port);
		this.dbConnector = dbConnector;
		gson = new Gson();
	}

	public void start() {
		// Load data from DB
		company = dbConnector.loadCompanyData();

		// Redirect
		redirect.get("/", "/helloworld");

		// Logging
		after("/*", (req, res) -> logRequest(req, res));
		exception(Exception.class, (exc, req, res) -> handleException(exc, res));

		// Hello World
		get("/helloworld", (req, res) -> helloWorld());

		// API
		path("/api", () -> {
			// Enable CORS
			options("/*", (req, res) -> optionsCORS(req, res));
			after("/*", (req, res) -> enableCORS(res));

			// Qualifications
			path("/qualifications", () -> {
				get("", (req, res) -> getQualifications(), gson::toJson);
				get("/:description", (req, res) -> getQualification(req.params("description")),
						gson::toJson);
				post("/:description", (req, res) -> createQualification(req));
			});	

			// Workers
			path("/workers", () -> {
				get("", (req, res) -> getWorkers(), gson::toJson);
				get("/:name", (req, res) -> getWorkerName(req.params("name")), gson::toJson);
			});

			// Project
			path("/projects", () -> {
				get("", (req, res) -> getProjects(), gson::toJson);
			});

			// finish
			path("/finish", () -> {
				put("", (req, res) -> finishProject(req), gson::toJson);
			});
		});
	}

	public void stop() {
		Spark.stop();
	}

	private String helloWorld() {
		return "Hello World!";
	}

	private QualificationDTO[] getQualifications() {
		QualificationDTO[] dtos = new QualificationDTO[company.getQualifications().size()];
		int i = 0;
		for(Qualification qualification : company.getQualifications())
			dtos[i++] = qualification.toDTO();
		return dtos;
	}

	private QualificationDTO getQualification(String description) {
		for(Qualification qualification : company.getQualifications())
			if(qualification.toString().equalsIgnoreCase(description))
				return qualification.toDTO();	
		throw new RuntimeException("Qualification not found.");
	}

	private ProjectDTO[] getProjects() {
		ProjectDTO[] dtos = new ProjectDTO[company.getProjects().size()];
		int i = 0;
		for(Project project : company.getProjects())
			dtos[i++] = project.toDTO();
		return dtos;
	}

	private String createQualification(Request request) {
		QualificationDTO assignmentDTO = gson.fromJson(request.body(), QualificationDTO.class);
		if (request.params("description").equals(assignmentDTO.getDescription())) {
			company.createQualification(assignmentDTO.getDescription());
		} else
			throw new RuntimeException("Qualification descriptions do not match.");
		return OK;
	}

	private WorkerDTO[] getWorkers() {
		WorkerDTO[] dtos = new WorkerDTO[company.getEmployedWorkers().size()];
		int i = 0;
		for(Worker worker : company.getEmployedWorkers()) {
			dtos[i++] = worker.toDTO();
		}
		return dtos;
	}

	private WorkerDTO getWorkerName(String name) {
		WorkerDTO workerDTO = null;

		for(Worker worker: company.getEmployedWorkers()){
			if(worker.getName().equals(name)){
				workerDTO = worker.toDTO();
			}
		}

		if(workerDTO == null) {
			throw new RuntimeException("Unable to get worker with this name");
		}
		
		return workerDTO;
	}
	
	private String finishProject(Request request) {
		ProjectDTO projectdto = gson.fromJson(request.body(), ProjectDTO.class);
		boolean wasFinished = false;

		for(Project project: company.getProjects()){
			if(project.getName().equals(projectdto.getName())){
				company.finish(project);
				wasFinished = true;
			}
		}	
		
		if(!wasFinished){
			throw new RuntimeException(String.format("No project named %s", projectdto.getName()));
		}

		return OK;
	}

	// Logs every request received
	private void logRequest(Request request, Response response) {
		log.info(request.requestMethod() + " " + request.pathInfo() + "\nREQUEST:\n" + request.body() + "\nRESPONSE:\n"
				+ response.body());
	}

	// Exception handling
	private void handleException(Exception exception, Response response) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace();
		exception.printStackTrace(pw);
		log.severe(sw.toString());
		response.body(KO);
		response.status(500);
	}

	// Enable CORS
	private void enableCORS(Response response) {
		response.header("Access-Control-Allow-Origin", "*");
	}

	// Enable CORS
	private String optionsCORS(Request request, Response response) {
		String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
		if (accessControlRequestHeaders != null)
			response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);

		String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
		if (accessControlRequestMethod != null)
			response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
		return OK;
	}
}