package edu.colostate.cs415.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
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
import edu.colostate.cs415.model.ProjectSize;
import edu.colostate.cs415.model.Qualification;

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
        String  helloString = Request.get("http://localhost:4567/").execute().returnContent().asString();
        assertEquals("Hello World!", helloString);

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
