package edu.colostate.cs415.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import edu.colostate.cs415.db.DBConnector;
import edu.colostate.cs415.dto.ProjectDTO;
import edu.colostate.cs415.dto.WorkerDTO;
import edu.colostate.cs415.model.Company;
import edu.colostate.cs415.model.Project;
import edu.colostate.cs415.model.ProjectSize;
import edu.colostate.cs415.model.Qualification;
import edu.colostate.cs415.model.Worker;

public class RestControllerTest {
    private Gson gson = new Gson();
    private static DBConnector dbConnector = mock(DBConnector.class);
    private static RestController restController = new RestController(4567, dbConnector);
    private static Company company;

    @BeforeClass
    public static void init(){
        when(dbConnector.loadCompanyData()).thenAnswer((i) -> company);
    }

    @Test
    public void testRootGet() throws IOException {
        company = new Company("Company 1");
        restController.start();
        String helloString = Request.get("http://localhost:4567/").execute().returnContent().asString();
        assertEquals("Hello World!", helloString);
    }

    @Test
    public void testGetQualifications() throws IOException {
        company = new Company("Company 2");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        restController.start();
        String responseString = Request.get("http://localhost:4567/api/qualifications").execute().returnContent()
                .asString();
        assertEquals(gson.toJson(company.getQualifications()), responseString);
    }

    @Test
    public void testGetQualification() throws IOException {
        company = new Company("Company 3");
        company.createQualification("First");
        company.createQualification("Second");
        restController.start();
        for (Qualification qual : company.getQualifications()) {
            String responseString = Request.get("http://localhost:4567/api/qualifications/" + qual.toString()).execute()
                    .returnContent().asString();
            assertEquals(gson.toJson(qual), responseString);
        }
    }

    @Test(expected = IOException.class)
    public void testGetQualificationNotFound() throws IOException {
        company = new Company("Company 4");
        company.createQualification("First");
        company.createQualification("Second");
        restController.start();
        String responseString = Request.get("http://localhost:4567/api/qualifications/Third").execute().returnContent()
                .asString();
        assertEquals(gson.toJson("Qualification not found"), responseString);
    }

    @Test
    public void testGetWorkers() throws IOException {
        company = new Company("Company 1");
        Qualification qualification = new Qualification("Qualificaiton");
        Set<Qualification> qualificationSet = new HashSet<>();
        qualificationSet.add(qualification);
        company.createWorker("Name", qualificationSet, 1.0);
        company.createWorker("Name2", qualificationSet, 10.0);

        WorkerDTO[] expectedDTOArray = new WorkerDTO[company.getEmployedWorkers().size()];

        int i = 0;
        for (Worker worker : company.getEmployedWorkers()) {
            expectedDTOArray[i++] = worker.toDTO();
        }

        restController.start();
        String responseString = Request.get("http://localhost:4567/api/workers").execute().returnContent().asString();
        assertEquals(gson.toJson(expectedDTOArray), responseString);
    }

    @Test
    public void testPostWorker() throws IOException {
        company = new Company("Company 1");
        String expectedName = "Worker";
        Qualification qual = new Qualification("qualification");
        Set<Qualification> exepectedQuals = new HashSet<>();
        exepectedQuals.add(qual);
        double expectedSalary = 10.0; 

        Worker expectedWorker = new Worker(expectedName, exepectedQuals, expectedSalary);

        WorkerDTO workerDTO = expectedWorker.toDTO();
        String requestFormattedWorker = gson.toJson(workerDTO);        

        restController.start();
        String response = Request.post("http://localhost:4567/api/workers/" + expectedName)
                                        .bodyString(requestFormattedWorker, ContentType.APPLICATION_JSON)
                                        .execute()
                                        .returnContent()
                                        .asString();    
        assertEquals("OK", response);
    }

    @Test (expected = IOException.class)
    public void testPostWorkerThrowsException() throws IOException {
        company = new Company("Company 1");
        String expectedName = "Worker";
        Qualification qual = new Qualification("qualification");
        Set<Qualification> exepectedQuals = new HashSet<>();
        exepectedQuals.add(qual);
        double expectedSalary = 10.0; 

        Worker expectedWorker = new Worker(expectedName, exepectedQuals, expectedSalary);

        WorkerDTO workerDTO = expectedWorker.toDTO();
        String requestFormattedWorker = gson.toJson(workerDTO);

        String dummyName = "NotTheRightName";

        restController.start();
        Request.post("http://localhost:4567/api/workers/" + dummyName)
               .bodyString(requestFormattedWorker, ContentType.APPLICATION_JSON)
               .execute()
               .returnContent()
               .asString(); 
    }

    @Test
    public void testGetProjects() throws IOException {
        company = new Company("Company 5");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        restController.start();
        String responseString = Request.get("http://localhost:4567/api/projects")
                .execute()
                .returnContent()
                .asString();
        ProjectDTO[] projectDTOS = new ProjectDTO[company.getProjects().size()];
        int i = 0;
        for (Project project : company.getProjects()) {
            projectDTOS[i++] = project.toDTO();
        }
        assertEquals(gson.toJson(projectDTOS), responseString);
    }

    public void testGetProjectsName() throws IOException {
        company = new Company("Company 6");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("Wonder Woman", company.getQualifications(), 186000.0);

        ProjectDTO projDTO = null;

        for (Project project : company.getProjects()) {
            if (project.getName().equals("Project 1")) {
                projDTO = project.toDTO();
            }
        }


        restController.start();
        String responseString = Request.get("http://localhost:4567/api/projects/Project 1")
                .execute()
                .returnContent()
                .asString();

        assertEquals(gson.toJson(projDTO), responseString);
    }

    @Test(expected = IOException.class)
    public void testGetNameWorkerNotInCompany() throws IOException {
        company = new Company("Company 6");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("Wonder Woman", company.getQualifications(), 186000.0);

        restController.start();
        String responseString = Request.get("http://localhost:4567/api/workers/Batman")
                .execute()
                .returnContent()
                .asString();
    }

    @Test
    public void testGetNameWorker() throws IOException {
        company = new Company("Company 6");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("WonderWoman", company.getQualifications(), 186000.0);

        WorkerDTO workerDTO = null;

        for (Worker worker : company.getEmployedWorkers()) {
            if (worker.getName().equals("WonderWoman")) {
                workerDTO = worker.toDTO();
            }
        }

        restController.start();
        String responseString = Request.get("http://localhost:4567/api/workers/WonderWoman")
                .execute()
                .returnContent()
                .asString();

        assertEquals(gson.toJson(workerDTO), responseString);
    }

    @Test
    public void testFinishProject() throws IOException {
        company = new Company("Company 8");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("WonderWoman", company.getQualifications(), 186000.0);

        restController.start();

        String json = "{name: \"Project 1\"}";
        String responseString = Request.put("http://localhost:4567/api/finish")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();

        assertEquals("\"OK\"", responseString);
    }

    @Test(expected = IOException.class)
    public void testAPIStartException() throws IOException {
        company = new Company("Company 7");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("Wonder Woman", company.getQualifications(), 186000.0);
        String json = "{name:\"Project 17\"}";

        restController.start();
        String responseString = Request.put("http://localhost:4567/api/start")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();
    }

    @Test
    public void testAPIStart() throws IOException {
        company = new Company("Company 7");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("Wonder Woman", company.getQualifications(), 186000.0);
        String json = "{name:\"Project 1\"}";

        restController.start();
        String responseString = Request.put("http://localhost:4567/api/start")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();

        assertEquals("\"OK\"", responseString);
    }

    @Test(expected = IOException.class)
    public void testFinishProjectException() throws IOException {
        company = new Company("Company 9");
        company.createQualification("Qualification 1");
        company.createQualification("Qualification 2");
        company.createProject("Project 1", company.getQualifications(), ProjectSize.SMALL);
        company.createWorker("WonderWoman", company.getQualifications(), 186000.0);

        restController.start();

        String json = "{name: \"Project 17\"}";
        String responseString = Request.put("http://localhost:4567/api/finish")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();
    }

    @Test
    public void testProjectPost() throws IOException {
        company = new Company("Company 1");
        String projectName = "Project";
        String[] qualifications = {"Qualification 1", "Qualification 2"};
        ProjectDTO payload = new ProjectDTO(projectName, ProjectSize.SMALL, null, null, qualifications, null);
        String payloadString = gson.toJson(payload);
        restController.start();
        String  response = Request.post("http://localhost:4567/api/projects/" + projectName).bodyString(payloadString, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        assertEquals("OK", response);
    }

    @Test(expected = IOException.class)
    public void testProjectPostNull() throws IOException {
        company = new Company("Company 1");
        String projectName = null;
        String[] qualifications = {"Qualification 1", "Qualification 2"};
        ProjectDTO payload = new ProjectDTO(projectName, ProjectSize.SMALL, null, null, qualifications, null);
        String payloadString = gson.toJson(payload);
        restController.start();
        String  response = Request.post("http://localhost:4567/api/projects/" + projectName).bodyString(payloadString, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        assertEquals("OK", response);
    }

}
