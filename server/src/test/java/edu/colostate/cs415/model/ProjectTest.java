package edu.colostate.cs415.model;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs415.dto.ProjectDTO;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

		workerOne = new Worker("Worker One", testQualifications, 96000.10);
		workerTwo = new Worker("Worker Two", testQualifications, 0.64);

		workers = new HashSet<Worker>();
		workers.add(workerOne);
		workers.add(workerTwo);

		testProject = new Project(testProjectName, testQualifications, ProjectSize.SMALL);

		testProject.addWorker(workerOne);
		testProject.addWorker(workerTwo);
	}

	@Test
	public void test() {
		assert (true);
	}

	@Test
	public void testEquals() {
		Project projTwo = buildExpectedProject();
		Project projThree = new Project("Boop", qualifications, null);
		assertTrue(testProject.equals(projTwo));
		assertFalse(testProject.equals(projThree));
	}

	@Test
	public void testProjectConstructor() {
		assert (true);
	}

	@Test
	public void testGetName() {
		assertEquals(testProject.getName(), "Test Project");
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
	public void testAddQualification() {
		Project testProj = buildExpectedProject();
		testProject.addQualification(new Qualification("That Guy"));
		testProj.addQualification(new Qualification("That Guy"));
		assertEquals(testProj, testProject);
	}

	@Test
	public void testToDTO() {
		Project expected = buildExpectedProject();
		ProjectDTO expectedDTO = expected.toDTO();
		ProjectDTO actualDTO = testProject.toDTO();

		assertEquals(expectedDTO, actualDTO);
	}

	@Test
	public void testToString() {
		String expectedOutput = testProject.getName() + ':' + testProject.getWorkers().size() + ':'
				+ testProject.getStatus();
		String actualOutput = testProject.toString();
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
	public void testSetSize() {
		ProjectSize smallSize = ProjectSize.SMALL;
		ProjectSize mediumSize = ProjectSize.MEDIUM;
		ProjectSize bigSize = ProjectSize.BIG;

		assertEquals(smallSize, testProject.getSize());

		testProject.setSize(mediumSize);
		assertEquals(mediumSize, testProject.getSize());

		testProject.setSize(bigSize);
		assertEquals(bigSize, testProject.getSize());
	}

	@Test
	public void testRemoveWorker() {
		assertEquals(workers, testProject.getWorkers());
		testProject.removeWorker(workerOne);
		workers.remove(workerOne);
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
}
