package edu.colostate.cs415.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testConstructorIsValid() {
		Company testCompany = new Company("Test Company");
		assertTrue(testCompany != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorEmptyName() {
		Company testCompany = new Company("Test Company");
		String emptyName = "";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorWhiteSpaceName() {
		Company testCompany = new Company("Test Company");
		String emptyName = " ";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorNullName() {
		Company testCompany = new Company("Test Company");
		String nullName = null;
		Company nullCompanyName = new Company(nullName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullEquals() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = null; 

		testCompany.equals(testCompanyTwo);
	}

	@Test
	public void testEquals() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");
		Company copyCompany = testCompany;

		assertTrue(testCompany.equals(testCompanyTwo));
		assertTrue(testCompany.equals(copyCompany));
		assertFalse(testCompany.equals("Company"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullGetName() {
		Company company = new Company(null);
	}

	@Test
	public void testGetName() {
		Company company = new Company("Company");
		assertEquals("Company", company.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyGetName() {
		Company company = new Company("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWhiteSpaceGetName() {
		Company company = new Company("    ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWhiteSpaceStringCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification(" ");
	}

	@Test
	public void testCreateQualification() {
		Company testCompany = new Company("Test Company");
		Company testTwoCompany = new Company("Test Two Company");
		Qualification qualOne = testCompany.createQualification("Qual One");
		Qualification qualTwo = testTwoCompany.createQualification("Qual One");
		
		Set<Qualification> quals = new HashSet<>();
		quals.add(qualOne);

		assertEquals(qualOne, qualTwo);
		assertEquals(quals, testCompany.getQualifications());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullNameCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();
		testCompany.createWorker(null, quals, 10.0);
	}

	@Test
	public void testNullQualsCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = null;
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	@Test
	public void testEmptyQualsCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	@Test
	public void testNonCompanyQualCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();

		testCompany.createQualification("Qual One");
		quals.add(new Qualification("Qual Two"));
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	@Test
	public void testCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();

		testCompany.createQualification("Qual One");
		quals.add(new Qualification("Qual One"));
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNotNull(w);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateProjNameNull(){
		Company createProjCompanyNull = new Company("Used for testing createProject");
		String nullName = null;
		Set<Qualification> testQuals = new HashSet<Qualification>();
		ProjectSize size = ProjectSize.SMALL;

		createProjCompanyNull.createProject(nullName, testQuals, size);
	}

	@Test
	public void testCreatProjValid(){
		Company createProjCompanyValid = new Company("Use to test non-null proj name");
		String projName = "Sample Project";
		Set<Qualification> testQuals = new HashSet<Qualification>();
		ProjectSize size = ProjectSize.SMALL;
		createProjCompanyValid.createProject(projName, testQuals, size);
		String expectedOutput = "[Sample Project:0:PLANNED]";
		String givenOutput = createProjCompanyValid.getProjects().toString();
		assertEquals(givenOutput, expectedOutput);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatProjNameEmpty(){
		Company createProjCompanyEmptyName = new Company("Company");
		Qualification qual = createProjCompanyEmptyName.createQualification("Dancer");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		createProjCompanyEmptyName.createProject("", quals, ProjectSize.BIG);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateProjNameEmptyString() {
		Company createProjCompanyEmptyName = new Company("Company");
		Qualification qual = createProjCompanyEmptyName.createQualification("Dancer");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		createProjCompanyEmptyName.createProject("  ", quals, ProjectSize.BIG);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateProjNullQual(){
		Company createProjCompanyNullQual = new Company("This company has a null qual set.");
		String projName = "Null Qualification Project";
		Set<Qualification> nullSet = null;
		ProjectSize size = ProjectSize.SMALL;
		createProjCompanyNullQual.createProject(projName, nullSet, size);
	}

	@Test
	public void testCreateProjValidQual(){
		Company createProjCompanyValidQual = new Company("This company has a valid qual set.");
		String projName = "Sample Project";
		Set<Qualification> validSet = new HashSet<Qualification>();
		ProjectSize size = ProjectSize.SMALL;
		createProjCompanyValidQual.createProject(projName, validSet, size);
		assertEquals(validSet.size(), createProjCompanyValidQual.getQualifications().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateProjNullSize(){
		Company createProjCompanyNullSize = new Company("This company has a null project size");
		String projName = "Sample Project";
		Set<Qualification> testQuals = new HashSet<Qualification>();
		ProjectSize nullSize = null;
		createProjCompanyNullSize.createProject(projName, testQuals, nullSize);
	}

	@Test
	public void testHashcodeDifferentforDifferentNames() {
		Company testCompany = new Company("Test Company");
		Company testCompanyWithDifferentName = new Company("Not The Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyWithDifferentName.hashCode();

		assertFalse(hashcodeOne == hashcodeTwo);

	}

	@Test
	public void testHashcodeSameForIdenticalNames() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyTwo.hashCode();

		assertEquals(hashcodeOne, hashcodeTwo);
	}

	@Test
	public void testGetProjectEmpty() {
		Company company = new Company("Company");
		assertTrue(company.getProjects() != null);
		assertTrue(company.getProjects().isEmpty());
	}

	@Test
	public void testGetProjectNotEmpty() {
	Company company = new Company("Company");
	Qualification qual = new Qualification("Engineer");
	Set<Qualification> quals = new HashSet<>();
	quals.add(qual);
	Project project = company.createProject("Project", quals, ProjectSize.SMALL);

	Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
	Set<Project> expectedProjects = new HashSet<>();
	expectedProjects.add(expectedProject);

	assertTrue(company.getProjects() != null);
	assertEquals(expectedProjects, company.getProjects());
	}

	@Test
	public void testGetProjectTwoProjects() {
	Company company = new Company("Company");
	Qualification qual = new Qualification("Engineer");
	Set<Qualification> quals = new HashSet<>();
	quals.add(qual);
	Project project = company.createProject("Project", quals, ProjectSize.SMALL);
	Project projectTwo = company.createProject("Project Two", quals, ProjectSize.SMALL);

	Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
	Project expectedProjectTwo = new Project("Project Two", quals, ProjectSize.SMALL);
	Set<Project> expectedProjects = new HashSet<>();
	expectedProjects.add(expectedProject);
	expectedProjects.add(expectedProjectTwo);

	assertTrue(company.getProjects() != null);
	assertEquals(expectedProjects, company.getProjects());
	}

	@Test
	public void testGetQualEmpty(){
		Company emptyQualCompany = new Company("Empty Qualification Company");
		assertTrue(emptyQualCompany.getQualifications().isEmpty());
	}

	@Test
	public void testGetQualSingle(){
		Company singleQualCompany = new Company("Single Qualification Company");
		singleQualCompany.createQualification("This is a single qualification");
		assertFalse(singleQualCompany.getQualifications().isEmpty());
		assertTrue(singleQualCompany.getQualifications().size() == 1);
	}

	@Test
	public void testGetQualMany(){
		Company multiQualCompany = new Company("Multiple Qualification Company");
		multiQualCompany.createQualification("This is one qualification");
		multiQualCompany.createQualification("This is a second qualification");
		assertFalse(multiQualCompany.getQualifications().isEmpty());
		assertTrue(multiQualCompany.getQualifications().size() == 2);
	}


	private Set<Worker> buildExpectedWorkerSetThreeWorkers() {
		Set<Worker> expectedSet = new HashSet<>();

		Set<Qualification> qualifications = new HashSet<>();
		Qualification qualification = new Qualification("Dummy Qualification");
		qualifications.add(qualification);

		Worker workerOne = new Worker("Worker One", qualifications, 0.0);
		Worker workerTwo = new Worker("Worker Two", qualifications, 0.0);
		Worker workerThree = new Worker("Worker Three", qualifications, 0.0);

		expectedSet.add(workerOne);
		expectedSet.add(workerTwo);
		expectedSet.add(workerThree);

		return expectedSet;
	}
	
	@Test
	public void testGetEmployedWorkersBase() {
		Company multiWorkerCompany = new Company("More than 1 employee incorporated");
		Qualification qualification = new Qualification("Dummy Qualification");
		Set<Qualification> qualifications = new HashSet<>();
		qualifications.add(qualification);

		multiWorkerCompany.createQualification("Dummy Qualification");
		multiWorkerCompany.createWorker("Worker One", qualifications, 0.0);
		multiWorkerCompany.createWorker("Worker Two", qualifications, 0.0);
		multiWorkerCompany.createWorker("Worker Three", qualifications, 0.0);

		Set<Worker> expectedSet = buildExpectedWorkerSetThreeWorkers();
		Set<Worker> actualSet = multiWorkerCompany.getEmployedWorkers();

		assertEquals(expectedSet, actualSet);
	}

	@Test 
	public void testGetEmployedWorkersOneWorker() {
		Company oneWorkerCompany = new Company("It's just me incorporated");
		String qualificationDescription = "Dummy Qualificaiton";
		Qualification qualification = new Qualification(qualificationDescription);
		Set<Qualification> qualifications = new HashSet<>();
		qualifications.add(qualification);

		Worker loneWorker = new Worker("only Worker", qualifications, 0.0);
		Set<Worker> expectedWorker = new HashSet<>();
		expectedWorker.add(loneWorker);

		oneWorkerCompany.createQualification(qualificationDescription);
		oneWorkerCompany.createWorker("only Worker", qualifications, 0.0);

		Set<Worker> actualSet = oneWorkerCompany.getEmployedWorkers();

		assertEquals(expectedWorker, actualSet);
	}

	@Test
	public void testGetEmployedWorkersEmpty() {
		Company noWorkerCompany = new Company("Definately not a front incoporated");

		Set<Worker> expectedSet = new HashSet<>();
		Set<Worker> actualSet = noWorkerCompany.getEmployedWorkers();

		assertEquals(expectedSet, actualSet);
	}

	@Test
    public void testPlannedAndSuspendedStart() {
        Company testCompany = new Company ("Test Company");
        Set<Qualification> testQualifications = new HashSet<Qualification>();
        Qualification qualOne = testCompany.createQualification("Qual One");
        Qualification qualTwo = testCompany.createQualification("Qual Two");
        Qualification otherQualOne = new Qualification("Qual One");
        Qualification otherQualTwo = new Qualification("Qual Two");
        testQualifications.add(otherQualOne);
        testQualifications.add(otherQualTwo);
        Project testProject = new Project ("Test", testQualifications, ProjectSize.SMALL);
        testCompany.start(testProject);
        assertEquals(testProject.getStatus(), ProjectStatus.ACTIVE);

        testProject.setStatus(ProjectStatus.SUSPENDED);
        testCompany.start(testProject);
        assertEquals(testProject.getStatus(), ProjectStatus.ACTIVE);

        testProject.setStatus(ProjectStatus.FINISHED);
        testCompany.start(testProject);
        assertEquals(testProject.getStatus(), ProjectStatus.FINISHED);
    }

    @Test
    public void testMissingQualsStart() {
        Company testCompany = new Company ("Test Company");
        Set<Qualification> testQualifications = new HashSet<Qualification>();
        Qualification qualOne = testCompany.createQualification("Qual One");
        Qualification otherQualOne = new Qualification("Qual One");
        Qualification otherQualTwo = new Qualification("Qual Two");
        testQualifications.add(otherQualOne);
        testQualifications.add(otherQualTwo);
        Project testProject = new Project ("Test", testQualifications, ProjectSize.SMALL);
        testCompany.start(testProject);

        assertNotEquals(testProject.getStatus(), ProjectStatus.ACTIVE);
    }

	@Test
	public void testGetAvailibleWokersBase() {
		Company testCompany = new Company("Test Company");
		
		Qualification testQualification = testCompany.createQualification("Test Qualificaiton");
		Set<Qualification> testQualSet = new HashSet<>();
		testQualSet.add(testQualification);

		Worker WorkerOne = testCompany.createWorker("Worker One", testQualSet, 0);
		Worker WorkerTwo = testCompany.createWorker("Worker Two", testQualSet, 0);
		Worker WorkerThree = testCompany.createWorker("Worker Three", testQualSet, 0);

		Set<Worker> expectedWorkerSet = new HashSet<>();
		expectedWorkerSet.add(WorkerOne);
		expectedWorkerSet.add(WorkerTwo);
		expectedWorkerSet.add(WorkerThree);

		Set<Worker> actualSet = new HashSet<>();
		actualSet = testCompany.getAvailableWorkers();

		assertEquals(expectedWorkerSet, actualSet);
	} 

	@Test
	public void testGetAvilibleWorkersEmpty() {
		Company testCompany = new Company("Test Company");

		Set<Worker> actualSet = testCompany.getAvailableWorkers();

		assertTrue(actualSet.isEmpty());

	}
	
	@Test
	public void testToStringBase() {
		Company testCompany = new Company("Test Company");

		Qualification testQualification = testCompany.createQualification("test qualification");
		Set<Qualification> testQualSet = new HashSet<>();
		testQualSet.add(testQualification);

		testCompany.createWorker("Worker One", testQualSet, 0);
		testCompany.createWorker("Worker Two", testQualSet, 0);
		testCompany.createWorker("Worker Three", testQualSet, 0);

		testCompany.createProject("Test Project", testQualSet, ProjectSize.SMALL);

		String expectedString = "Test Company:3:1";

		String actualString = testCompany.toString();

		assertEquals(expectedString, actualString);
	}

	@Test
 	public void testToStringEmptyWorkers() {
		Company testCompany = new Company("Test Company");

		Qualification testQualification = testCompany.createQualification("test qualification");
		Set<Qualification> testQualSet = new HashSet<>();
		testQualSet.add(testQualification);

		testCompany.createProject("Test Project", testQualSet, ProjectSize.SMALL);

		String expectedString = "Test Company:0:1";

		String actualString = testCompany.toString();

		assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testToStringEmptyProjects() {
		Company testCompany = new Company("Test Company");

		Qualification testQualification = testCompany.createQualification("test qualification");
		Set<Qualification> testQualSet = new HashSet<>();
		testQualSet.add(testQualification);

		testCompany.createWorker("Worker One", testQualSet, 0);
		testCompany.createWorker("Worker Two", testQualSet, 0);
		testCompany.createWorker("Worker Three", testQualSet, 0);

		String expectedString = "Test Company:3:0";

		String actualString = testCompany.toString();

		assertEquals(expectedString, actualString);
		
	}

	@Test
	public void assignBaseWorker() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
		assertTrue(worker.getWorkload() == 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignNullWorker() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);

		company.assign(null, project);
	}

	@Test
	public void assignTestWorkerAvailibility() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project projectOne = company.createProject("Project One", quals, ProjectSize.BIG);
		Project projectTwo = company.createProject("Project Two", quals, ProjectSize.BIG);
		Project projectThree = company.createProject("Project Three", quals, ProjectSize.BIG);
		Project projectFour = company.createProject("Project Four", quals, ProjectSize.BIG);

		company.assign(worker, projectOne);
		company.assign(worker, projectTwo);
		company.assign(worker, projectThree);
		company.assign(worker, projectFour);

		assertTrue(worker.getWorkload() == 12);
		assertFalse(worker.isAvailable());
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignWillOverloadWorker() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project projectOne = company.createProject("Project One", quals, ProjectSize.BIG);
		Project projectTwo = company.createProject("Project Two", quals, ProjectSize.BIG);
		Project projectThree = company.createProject("Project Three", quals, ProjectSize.BIG);
		Project projectFour = company.createProject("Project Four", quals, ProjectSize.MEDIUM);
		Project projectAttempted = company.createProject("Project Attempted", quals, ProjectSize.BIG);

		company.assign(worker, projectOne);
		company.assign(worker, projectTwo);
		company.assign(worker, projectThree);
		company.assign(worker, projectFour);
		assertTrue(worker.isAvailable());

		assertTrue(worker.willOverload(projectAttempted));
		
		company.assign(worker, projectAttempted);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignWorkerNotHelpful() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Qualification badQual = company.createQualification("Bad Qual");
		Set<Qualification> badQuals = new HashSet<>();
		badQuals.add(badQual);

		Worker worker = company.createWorker("Worker", badQuals, 100.0);
		Project project = company.createProject("Project One", quals, ProjectSize.BIG);
	
		company.assign(worker, project);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignNullProject() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		
		company.assign(worker, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignWorkerAlreadyInProject() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
		company.assign(worker, project);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignProjectStatusActive() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);
		project.setStatus(ProjectStatus.ACTIVE);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assignProjectStatusFinished() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);
		project.setStatus(ProjectStatus.FINISHED);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
	}

	@Test
	public void assignProjectStatusPlanned() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);
		project.setStatus(ProjectStatus.PLANNED);


		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
		assertTrue(worker.getWorkload() == 1);
	}

	@Test
	public void assignWorkerAlreadyInAssigned() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
		assertTrue(worker.getWorkload() == 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void assignWorkerNotInAvailable() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = new Worker("Worker", quals, 100.0);
		Project project = company.createProject("Project", quals, ProjectSize.SMALL);

		Worker expectedWorker = new Worker("Worker", quals, 100.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.SMALL);
		expectedProject.addWorker(expectedWorker);

		company.assign(worker, project);
		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
		assertTrue(worker.getWorkload() == 1);
	} 
	
	@Test
	public void testGetAssignedWorkers() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 10.0);
		Project project = company.createProject("Project", quals, ProjectSize.BIG);
		
		assertTrue(company.getAssignedWorkers().isEmpty());

		company.assign(worker, project);

		Worker expectedWorker = new Worker("Worker", quals, 10.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.BIG);
		
		expectedProject.addWorker(expectedWorker);
		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
	}
	
	@Test
	public void testGetAssignedWorkersEmpty() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 10.0);
		Project project = company.createProject("Project", quals, ProjectSize.BIG);
		
		assertTrue(company.getAssignedWorkers().isEmpty());
	
	}
	
	@Test
	public void testGetAssignedWorkersMany() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker worker = company.createWorker("Worker", quals, 10.0);
		Worker workerTwo = company.createWorker("Worker Two", quals, 10.0);
		Project project = company.createProject("Project", quals, ProjectSize.BIG);

		assertTrue(company.getAssignedWorkers().isEmpty());

		company.assign(worker, project);
		company.assign(workerTwo, project);

		Worker expectedWorker = new Worker("Worker", quals, 10.0);

		Worker expectedWorkerTwo = new Worker("Worker Two", quals, 10.0);
		Project expectedProject = new Project("Project", quals, ProjectSize.BIG);
		
		expectedProject.addWorker(expectedWorker);
		expectedProject.addWorker(expectedWorkerTwo);

		assertEquals(expectedProject.getWorkers(), company.getAssignedWorkers());
	}

	@Test
    public void testUnavailableWorkers() {

        // Create company and add qualifications/projects
        Company testCompany = new Company("Test Company");
        Qualification qual1 = testCompany.createQualification("Qual1");
        Qualification qual2 = testCompany.createQualification("Qual2");
        Qualification qual3 = testCompany.createQualification("Qual3");
        Qualification qual4 = testCompany.createQualification("Qual4");
        Qualification qual5 = testCompany.createQualification("Qual5");
        Set<Qualification> quals = new HashSet<>();
        quals.add(qual1);
        quals.add(qual2);
        quals.add(qual3);
        quals.add(qual4);
        quals.add(qual5);
        Project project1 = testCompany.createProject("Project1", quals, ProjectSize.BIG);
        Project project2 = testCompany.createProject("Project2", quals, ProjectSize.BIG);
        Project project3 = testCompany.createProject("Project3", quals, ProjectSize.BIG);
        Project project4 = testCompany.createProject("Project4", quals, ProjectSize.BIG);

        // Create and assign workers
        Set<Qualification> worker1Quals = new HashSet<>();
        Set<Qualification> worker2Quals = new HashSet<>();
        Set<Qualification> worker3Quals = new HashSet<>();
        worker1Quals.add(qual1);
        worker2Quals.add(qual2);
        worker3Quals.add(qual3);
        Worker worker1 = testCompany.createWorker("Worker1", worker1Quals, 100.0);
        Worker worker2 = testCompany.createWorker("Worker2", worker2Quals, 100.0);
        Worker worker3 = testCompany.createWorker("Worker3", worker3Quals, 100.0);

        testCompany.assign(worker1, project1);
        testCompany.assign(worker1, project2);
        testCompany.assign(worker1, project3);

        testCompany.assign(worker2, project1);
        testCompany.assign(worker2, project2);
        testCompany.assign(worker2, project3);

        testCompany.assign(worker3, project1);
        testCompany.assign(worker3, project2);
        testCompany.assign(worker3, project3);

        // Test empty set
        Set<Worker> unAvailableWorkers = new HashSet<Worker>();
        assertEquals(unAvailableWorkers, testCompany.getUnavailableWorkers());

        // Test method returns unavailable worker set
        testCompany.assign(worker1, project4);
        testCompany.assign(worker2, project4);
        unAvailableWorkers.add(worker1);
        unAvailableWorkers.add(worker2);
        assertEquals(unAvailableWorkers, testCompany.getUnavailableWorkers());

        testCompany.assign(worker3, project4);
        unAvailableWorkers.add(worker3);
        assertEquals(unAvailableWorkers, testCompany.getUnavailableWorkers());
    }

	@Test
	public void testGetUnassignedWorkersMany() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker workerOne = company.createWorker("Worker One", quals, 100.0);
		Worker workerTwo = company.createWorker("Worker Two", quals, 100.0);
		Worker workerThree = company.createWorker("Worker Three", quals, 100.0);
		Worker workerFour = company.createWorker("Worker Four", quals, 100.0);

		Set<Worker> expectedUnassignedWorkers = new HashSet<>();
		expectedUnassignedWorkers.add(workerOne);
		expectedUnassignedWorkers.add(workerTwo);

		Project project = company.createProject("Project", quals, ProjectSize.BIG);
		
		company.assign(workerThree, project);
		company.assign(workerFour, project);

		assertEquals(expectedUnassignedWorkers, company.getUnassignedWorkers());
	}

	@Test
	public void testGetUnassignedWorkersEmpty() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker workerOne = company.createWorker("Worker One", quals, 100.0);
		Worker workerTwo = company.createWorker("Worker Two", quals, 100.0);
		Worker workerThree = company.createWorker("Worker Three", quals, 100.0);
		Worker workerFour = company.createWorker("Worker Four", quals, 100.0);

		Set<Worker> expectedUnassignedWorkers = new HashSet<>();
		Project project = company.createProject("Project", quals, ProjectSize.BIG);
		
		company.assign(workerOne, project);
		company.assign(workerTwo, project);
		company.assign(workerThree, project);
		company.assign(workerFour, project);

		assertEquals(expectedUnassignedWorkers, company.getUnassignedWorkers());
	}

	@Test
	public void testGetUnassignedWorkers() {
		Company company = new Company("Company");

		Qualification qual = company.createQualification("Qual");
		Set<Qualification> quals = new HashSet<>();
		quals.add(qual);

		Worker workerOne = company.createWorker("Worker One", quals, 100.0);
		Worker workerTwo = company.createWorker("Worker Two", quals, 100.0);

		Set<Worker> expectedUnassignedWorkers = new HashSet<>();
		expectedUnassignedWorkers.add(workerTwo);
		Project project = company.createProject("Project", quals, ProjectSize.BIG);
		
		company.assign(workerOne, project);

		assertEquals(expectedUnassignedWorkers, company.getUnassignedWorkers());
	}

}
