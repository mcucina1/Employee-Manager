package edu.colostate.cs415.model;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs415.dto.ProjectDTO;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.HashSet;

public class ProjectTest {
	String firstDescription;
	String secondDescription;
	String testProjectName;

	Qualification firstQualification;
	Qualification secondQualification;

	Worker workerOne;
	Worker workerTwo;

	Set<Worker> workers;
	Set<Qualification> qualifications;

	Project testProject;

	@Before
	public void setUp() {
		firstDescription = "Qualified Engineer";
		secondDescription = "Qualified Scientist";
		testProjectName = "Test Project";

		firstQualification = new Qualification(firstDescription);
		secondQualification = new Qualification(secondDescription);

		Set<Qualification> testQualifications = new HashSet<Qualification>();
		testQualifications.add(firstQualification);
		testQualifications.add(secondQualification);
		qualifications = testQualifications;

		workerOne = new Worker("Worker One", testQualifications, 96000.10);
		workerTwo = new Worker("Worker Two", testQualifications, 0.64);

		workers = new HashSet<Worker>();
		workers.add(workerOne);
		workers.add(workerTwo);

		testProject = new Project(testProjectName, testQualifications, ProjectSize.SMALL);

		testProject.addWorker(workerOne);
		testProject.addWorker(workerTwo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProjectConstructorEmptyName() {
		String projectName = "";
		Project Project = new Project(projectName, qualifications, ProjectSize.SMALL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProjectConstructorWhiteSpaceName() {
		String projectName = " ";
		Project Project = new Project(projectName, qualifications, ProjectSize.SMALL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProjectConstructorNullName() {
		String projectName = null;
		Project Project = new Project(projectName, qualifications, ProjectSize.SMALL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProjectConstructorQualNull() {
		Set<Qualification> testQuals = null;
		Project Project = new Project(testProjectName, testQuals, ProjectSize.SMALL);
	}

	public void testProjectConstructorQualEmpty() {
		Set<Qualification> testQuals = new HashSet<>();
		Project Project = new Project(testProjectName, testQuals, ProjectSize.SMALL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProjectConstructorSizeNull() {
		Project Project = new Project(testProjectName, qualifications, null);
	}

	@Test
	public void test() {
		assert (true);
	}

	@Test
	public void testEquals() {
		Project projTwo = buildExpectedProject();
		Project projThree = new Project("Boop", qualifications, ProjectSize.SMALL);
		assertTrue(testProject.equals(projTwo));
		assertFalse(testProject.equals(projThree));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsNull() {
		testProject.equals(null);
	}

	@Test
	public void testEqualsString() {
		assertNotEquals(testProject, secondDescription);
	}

	@Test
	public void testEqualsSelf() {
		assertEquals(testProject, testProject);
	}

	@Test
	public void testProjectConstructor() {
		assert (true);
	}

	@Test
	public void testGetName() {
		assertEquals(testProject.getName(), "Test Project");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullGetName() {
		Project nullProject = new Project(null, qualifications, ProjectSize.SMALL);
		String temp = nullProject.getName();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyGetName() {
		Project emptyNameProject = new Project("", qualifications, ProjectSize.SMALL);
		String temp = emptyNameProject.getName();
		assertEquals(temp, "");
	}

	@Test
	public void testGetSize() {
		assertEquals(testProject.getSize(), ProjectSize.SMALL);
	}

	@Test
	public void testProjectQualifications() {
		assertEquals(firstQualification, new Qualification(firstDescription));
		assertEquals(secondQualification, new Qualification(secondDescription));
	}

	@Test
	public void testAddWorker() {
		assertEquals(testProject.getWorkers(), workers);
	}

	@Test
	public void testAddWorkerNullValue() {
		testProject.addWorker(null);
		workers.add(null);
		assertEquals(testProject.getWorkers(), workers);
	}

	@Test
	public void testSetOfWorkersNull() {
		Project project = new Project("Project", qualifications, ProjectSize.SMALL);
		assertTrue(project.getWorkers() != null);
	}

	@Test
	public void testAddQualification() {
		Project testProj = buildExpectedProject();
		testProject.addQualification(new Qualification("That Guy"));
		testProj.addQualification(new Qualification("That Guy"));
		assertEquals(testProj, testProject);
	}

	@Test
	public void testAddDifferentQualifications() {
		Set<Qualification> quals = new HashSet<>();
		Project testAddQualsProject = new Project("testProjectName", quals, ProjectSize.SMALL);

		Qualification qualOne = new Qualification("That Guy");
		Qualification qualTwo = new Qualification("That");

		testAddQualsProject.addQualification(qualOne);
		testAddQualsProject.addQualification(qualTwo);
		
		assertEquals(2, testAddQualsProject.getRequiredQualifications().size());
	}

	@Test
	public void testAddQualificationSize() {
		Set<Qualification> quals = new HashSet<>();
		Project testAddQualsProject = new Project("testProjectName", quals, ProjectSize.SMALL);

		Qualification qualOne = new Qualification("That Guy");
		Qualification qualTwo = new Qualification("That Guy");

		testAddQualsProject.addQualification(qualOne);
		testAddQualsProject.addQualification(qualTwo);
		
		assertEquals(1, testAddQualsProject.getRequiredQualifications().size());
	}

	@Test
	public void testToDTO() {
		Project expected = buildExpectedProject();
		ProjectDTO expectedDTO = expected.toDTO();
		ProjectDTO actualDTO = testProject.toDTO();

		assertEquals(expectedDTO, actualDTO);
	}

	@Test
	public void testDTOEmptyWorkers() {
		Project emptyWorkersProject = new Project(testProjectName, qualifications, ProjectSize.BIG);
		ProjectDTO emptyWorkersDTO = emptyWorkersProject.toDTO();
		int DTOworkersLength = emptyWorkersDTO.getWorkers().length;

		assertEquals(0, DTOworkersLength);
	}

	@Test
	public void testDTOEmptyQualifications() {
		Set<Qualification> emptyQualSet = new HashSet<>();
		Project emptyQualProject = new Project(testProjectName, emptyQualSet, ProjectSize.MEDIUM);

		ProjectDTO emptyQualDTO = emptyQualProject.toDTO();
		int DTOQualLength = emptyQualDTO.getQualifications().length;

		assertEquals(0, DTOQualLength);
	}

	@Test
	public void testToString() {
		String expectedOutput = testProject.getName() + ':' + testProject.getWorkers().size() + ':'
				+ testProject.getStatus();
		String actualOutput = testProject.toString();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testToStringEmptyWorkers() {
		Set<Worker> emptyWorkers = new HashSet<>();

		String expectedOutput = testProject.getName() + ':' + emptyWorkers.size() + ':'
				+ testProject.getStatus();

		Project emptyWorkersProject = new Project(testProjectName, qualifications, testProject.getSize());
		String actualOutput = emptyWorkersProject.toString();

		assertEquals(expectedOutput, actualOutput);
	}

	private Project buildExpectedProject() {
		String firstTestDescription = "Qualified Engineer";
		String secondTestDescription = "Qualified Scientist";
		String testProjName = "Test Project";

		Qualification firstTestQualification = new Qualification(firstTestDescription);
		Qualification secondTestQualification = new Qualification(secondTestDescription);

		Set<Qualification> testQualifications = new HashSet<Qualification>();
		testQualifications.add(firstTestQualification);
		testQualifications.add(secondTestQualification);

		Worker testWorkerOne = new Worker("Worker One", testQualifications, 96000.10);
		Worker testWorkerTwo = new Worker("Worker Two", testQualifications, 0.64);

		HashSet<Worker> testWorkers = new HashSet<Worker>();
		testWorkers.add(testWorkerOne);
		testWorkers.add(testWorkerTwo);

		Project testProj = new Project(testProjName, testQualifications, ProjectSize.SMALL);

		testProj.addWorker(workerOne);
		testProj.addWorker(workerTwo);

		return testProj;
	}

	@Test
	public void testGetStatus() {
		assertEquals(testProject.getStatus(), ProjectStatus.PLANNED);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetStatusNull() {
		testProject.setStatus(null);
	}

	@Test
	public void testSetAndGetStatus() {
		testProject.setStatus(ProjectStatus.ACTIVE);
		assertEquals(testProject.getStatus(), ProjectStatus.ACTIVE);
	}

	@Test
	public void testRemoveAll() {
		String testFailureMessage = "[ProjectTest.java] testRemoveAll(): failed to remove all Workers from the Project.";

		testProject.removeAllWorkers();
		Set<Worker> workers = testProject.getWorkers();

		assertTrue(testFailureMessage, workers.isEmpty());
	}

	@Test
	public void testRemoveAllNullWorkers() {
		Project nullWorkersProject = new Project(testProjectName, qualifications, ProjectSize.SMALL);
		nullWorkersProject.removeAllWorkers();

		Set<Worker> expectedWorkers = new HashSet<>();

		assertEquals(expectedWorkers, nullWorkersProject.getWorkers());
	}

	@Test
	public void testRemoveAllWorkersFromEmptyWorkers() {
		testProject.removeAllWorkers();
		Set<Worker> expectedWorkers = new HashSet<>();

		assertEquals(expectedWorkers, testProject.getWorkers());

		testProject.removeAllWorkers();

		assertEquals(expectedWorkers, testProject.getWorkers());
	}

	@Test
	public void testRemoveWorker() {
		assertEquals(workers, testProject.getWorkers());
		testProject.removeWorker(workerOne);
		workers.remove(workerOne);
		assertEquals(workers, testProject.getWorkers());
	}

	@Test
	public void testRemoveWorkerNullValue() {
		assertEquals(workers, testProject.getWorkers());
		testProject.removeWorker(null);
		workers.remove(null);
		assertEquals(workers, testProject.getWorkers());
	}

	@Test
	public void testRemoveWorkerNotInSet() {
		assertEquals(workers, testProject.getWorkers());
		Worker workerNotInSet = new Worker("Human Alarm Clock", qualifications, 100000);
		testProject.removeWorker(workerNotInSet);
		assertEquals(workers, testProject.getWorkers());
	}

	@Test
	public void testHashcodeWithIdenticalProjects() {
		int projectHashcode = testProject.hashCode();

		Project identicalProject = testProject;
		int identicalHashcode = identicalProject.hashCode();

		assertEquals(projectHashcode, identicalHashcode);
	}

	@Test
	public void testHashCodeWithDifferentProjects() {
		int projectHashcode = testProject.hashCode();

		String differentProjectName = "Different project Name";
		Project differentProject = new Project(differentProjectName, qualifications, ProjectSize.SMALL);
		int differentHashcode = differentProject.hashCode();

		assertNotEquals(projectHashcode, differentHashcode);
	}

	@Test
	public void testHashCodeWithProjectsWithTheSameName() {
		int projectHashcode = testProject.hashCode();

		String qualificationDescription = "This Qualification is not in testProject";
		Qualification differentQualification = new Qualification(qualificationDescription);
		Set<Qualification> differentQualifications = new HashSet<Qualification>();
		differentQualifications.add(differentQualification);

		Project sameNameProject = new Project(testProjectName, differentQualifications, ProjectSize.BIG);
		int sameNameProjectHashcode = sameNameProject.hashCode();

		assertEquals(projectHashcode, sameNameProjectHashcode);
	}

	@Test
	public void testMissingQualificationsReturnsEmpty() {
		Project testProj = buildExpectedProject();
		Set<Qualification> testQuals = new HashSet<Qualification>();
		assertEquals(testQuals, testProj.getMissingQualifications());
	}

	// @Test
	// public void testMissingQualNullWorker(){
	// 	//Covered by Ctor
	// }

	@Test
	public void testMissingQualNonNullWorker(){
		Project missingQualNonNullWorkers = buildExpectedProject();
		Qualification missingQual = new Qualification("This one is missing!");
		missingQualNonNullWorkers.addQualification(missingQual);
		assertEquals(1, missingQualNonNullWorkers.getMissingQualifications().size());
	}

	@Test
	public void testMissingQualEmptyWorker(){
		Set<Worker> emptyWorkerSet = new HashSet<>();
		Project projWithEmptyWorkers = new Project("Empty workers", qualifications, ProjectSize.BIG);
		assertEquals(projWithEmptyWorkers.getMissingQualifications().size(), 2);
	}

	@Test
	public void testMissingQualOneWorker(){
		Set<Worker> oneWorkerSet = new HashSet<>();
		Worker soloWorker = new Worker("Solo Man", qualifications, 40000);
		Project projWithOneWorker = new Project("One worker", qualifications, ProjectSize.BIG);
		projWithOneWorker.addWorker(soloWorker);
		assertEquals(projWithOneWorker.getMissingQualifications().size(), 0);
	}

	@Test
	public void testMissingQualManyWorker(){
		Set<Worker> manyWorkerSet = new HashSet<>();
		Worker workerOne = new Worker("Worker1", qualifications, 40000);
		Worker workerTwo = new Worker("Worker2", qualifications, 40000);
		Worker workerThree = new Worker("Worker3", qualifications, 40000);
		Project projWithOneWorker = new Project("Many workers", qualifications, ProjectSize.BIG);
		projWithOneWorker.addWorker(workerOne);
		projWithOneWorker.addWorker(workerTwo);
		projWithOneWorker.addWorker(workerThree);
		assertEquals(projWithOneWorker.getMissingQualifications().size(), 0);
	}

	@Test
	public void testMissingQualEmptyQual(){
		Set<Worker> unqualifiedWorkers = new HashSet<>();
		Worker workerOne = new Worker("Worker1", qualifications, 40000);
		Worker workerTwo = new Worker("Worker2", qualifications, 40000);
		Worker workerThree = new Worker("Worker3", qualifications, 40000);
		Set<Qualification> noQualSet = new HashSet<>();
		Project projWithEmptyQuals = new Project("No Qualifications", noQualSet, ProjectSize.SMALL);
		assertEquals(projWithEmptyQuals.getRequiredQualifications().size(), 0);
	}

	@Test
	public void testMissingQualOneQual(){
		Set<Worker> unqualifiedWorkers = new HashSet<>();
		Worker workerOne = new Worker("Worker1", qualifications, 40000);
		Worker workerTwo = new Worker("Worker2", qualifications, 40000);
		Worker workerThree = new Worker("Worker3", qualifications, 40000);
		Set<Qualification> oneQualSet = new HashSet<>();
		Qualification singleQual = new Qualification("This is a single qualification");
		oneQualSet.add(singleQual);
		Project projWithEmptyQuals = new Project("No Qualifications", oneQualSet, ProjectSize.SMALL);
		assertEquals(projWithEmptyQuals.getRequiredQualifications().size(), 1);

	}

	@Test
	public void testMissingQualManyQual(){
		Set<Worker> unqualifiedWorkers = new HashSet<>();
		Worker workerOne = new Worker("Worker1", qualifications, 40000);
		Worker workerTwo = new Worker("Worker2", qualifications, 40000);
		Worker workerThree = new Worker("Worker3", qualifications, 40000);
		Set<Qualification> manyQualSet = new HashSet<>();
		Qualification manyQual1 = new Qualification("This is a qualification");
		Qualification manyQual2 = new Qualification("This is a another qualification");
		Qualification manyQual3 = new Qualification("This is yet another qualification");
		manyQualSet.add(manyQual1);
		manyQualSet.add(manyQual2);
		manyQualSet.add(manyQual3);
		Project projWithEmptyQuals = new Project("No Qualifications", manyQualSet, ProjectSize.SMALL);
		assertEquals(projWithEmptyQuals.getRequiredQualifications().size(), 3);

	}

	@Test
	public void testMissingQualificationsIsEqual() {
		Project testProj = buildExpectedProject();
		Set<Qualification> missingQualifications = new HashSet<Qualification>();
		String missingQual1 = "Missing Qualification #1";
		String missingQual2 = "Missing Qualification #2";
		Qualification firstMissingQualification = new Qualification(missingQual1);
		Qualification secondMissingQualification = new Qualification(missingQual2);
		missingQualifications.add(firstMissingQualification);
		missingQualifications.add(secondMissingQualification);
		testProj.addQualification(firstMissingQualification);
		testProj.addQualification(secondMissingQualification);

		assertEquals(missingQualifications, testProj.getMissingQualifications());
	}

	@Test
	public void testRequiredQualificationsReturnsEmpty() {
		Set<Qualification> testQuals = new HashSet<Qualification>();
		Project testProject = new Project("Testing Project", testQuals, ProjectSize.SMALL);
		assertEquals(testQuals, testProject.getRequiredQualifications());
	}

	@Test
	public void testGetRequiredQualificationsIsEqual() {
		Project testProj = buildExpectedProject();
		Set<Qualification> testQualifications = new HashSet<Qualification>();
		String testQual1 = "Qualified Engineer";
		String testQual2 = "Qualified Scientist";
		Qualification firstTestQualification = new Qualification(testQual1);
		Qualification secondTestQualification = new Qualification(testQual2);
		testQualifications.add(firstTestQualification);
		testQualifications.add(secondTestQualification);

		assertEquals(testQualifications, testProj.getRequiredQualifications());
	}

	@Test
	public void testIsHelpful() {
		// Project is initalized with Engineer and Scientist Qualifcations
		Project testProj = buildExpectedProject();
		Set<Qualification> testQualifications = new HashSet<Qualification>();

		String descriptionEngineer = "Qualified Engineer";
		String descriptionIT = "IT professional";

		Qualification engineerQualification = new Qualification(descriptionEngineer);
		Qualification itQualification = new Qualification(descriptionIT);
		testQualifications.add(itQualification);

		// Create worker with qualification not in project (IT professional)
		Worker testWorker = new Worker("Test Worker", testQualifications, 38.0);

		// Assert that this worker is not currently useful
		assertFalse(testProj.isHelpful(testWorker));
		// Add engineer qualification to make them useful
		testWorker.addQualification(engineerQualification);
		// Assert that the worker is now useful
		assertTrue(testProj.isHelpful(testWorker));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullIsHelpful() {
		Project testProj = buildExpectedProject();
		// Will Throw Error
		Boolean temp = testProj.isHelpful(null);
	}

	@Test
	public void testGetWorkers() {
		Set<Worker> expectedWorkers = new HashSet<>();
		Worker workerOne = new Worker("Worker One", qualifications, 96000.10);
		Worker workerTwo = new Worker("Worker Two", qualifications, 0.64);
		expectedWorkers.add(workerOne);
		expectedWorkers.add(workerTwo);

		assertEquals(expectedWorkers, testProject.getWorkers());
	}

	@Test
	public void testGetEmptyWorkers() {
		Project project = new Project(testProjectName, qualifications, ProjectSize.BIG);
		Set<Worker> emptySet = new HashSet<>();

		assertEquals(emptySet, project.getWorkers());
	}

}
