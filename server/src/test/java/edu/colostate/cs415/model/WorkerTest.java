package edu.colostate.cs415.model;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs415.dto.WorkerDTO;

public class WorkerTest {
	double sampleSalary;
	String sampleName;
	Set<Qualification> sampleQualifications;
	Worker worker;

	@Before
	public void setUp() {
		sampleSalary = 10.0;
		sampleName = "Sample Name";
		Qualification sampleQualification = new Qualification("Sample Qualification");
		sampleQualifications = new HashSet<Qualification>();
		sampleQualifications.add(sampleQualification);
		worker = new Worker(sampleName, sampleQualifications, sampleSalary);
	}

	@Test
	public void test() {
		assert (true);
	}

	@Test
	public void testConstructor() {
		Worker expected = buildExpectedWorker();
		assertEquals(expected.getName(), worker.getName());
		assertEquals(expected.getSalary(), worker.getSalary(), 0.1);
		assertEquals(expected.getQualifications(), worker.getQualifications());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNameNonNull(){
		String nullString = null;
		Worker nullName = new Worker(nullString,sampleQualifications,90000.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNameIsEmpty(){
		String emptyString = "";
		Worker emptyName = new Worker(emptyString,sampleQualifications,90000.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWorkerNullQualificationSet(){
		String emptyString = null;
		Qualification emptyQual = new Qualification(emptyString);
		Set<Qualification> testQualification = new HashSet<Qualification>();
		testQualification.add(emptyQual);
		Worker nullQualifications = new Worker("John",testQualification,90000.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSalary(){
		double negativeSalary = -90000.00;
		Worker negativeSalWorker = new Worker("John", sampleQualifications, negativeSalary);
	}

	@Test
	public void testEmptyQualificationsConstructor() {
		Set<Qualification> emptyQualificaiton = new HashSet<Qualification>();
		Worker testWorker = new Worker("Bob", emptyQualificaiton, 90000.00);
		assertEquals(emptyQualificaiton, testWorker.getQualifications());

	}

	@Test
	public void testEquals() {
		Worker workerTwo = buildExpectedWorker();
		Worker workerThree = new Worker("Bobby", sampleQualifications, 200000);
		assertTrue(worker.equals(workerTwo));
		assertFalse(worker.equals(workerThree));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse(worker.equals(null));
	}

	@Test
	public void testEqualsWithNonWorker() {
		String nonWorker = "John";
		assertFalse(worker.equals(nonWorker));
	}

	@Test
	public void testEqualsWithTheSameObject() {
		assertTrue(worker.equals(worker));
	}

	@Test
	public void testGetName() {
		String expectedName = "Sample Name";
		assertEquals(expectedName, worker.getName());
	}

	@Test
	public void testGetSalary() {
		double expectedSalary = 10.0;
		assertEquals(expectedSalary, worker.getSalary(), 0.1);
	}

	@Test
	public void testGetQualifications() {
		Set<Qualification> expectedQualifications = new HashSet<Qualification>();
		Qualification qualification = new Qualification("Sample Qualification");
		expectedQualifications.add(qualification);
		assertEquals(expectedQualifications, worker.getQualifications());
	}

	@Test
	public void testAddQualification() {
		Worker testWorker = buildExpectedWorker();
		testWorker.addQualification(new Qualification("That Guy"));
		worker.addQualification(new Qualification("That Guy"));
		assertEquals(testWorker, worker);
	}

	@Test
	public void testAddQualToAnEmptySet() {
		Set<Qualification> testQualSet = new HashSet<>();
		Worker notQualifiedWorker = new Worker(sampleName, testQualSet, sampleSalary);

		Qualification newQualification = new Qualification("Sample Qualification");
		notQualifiedWorker.addQualification(newQualification);

		assertEquals(worker.getQualifications(), notQualifiedWorker.getQualifications());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddQualAddingNull() {
		worker.addQualification(null);
	}

	@Test
	public void testAddQualAddingPrexistingQual() {
		Set<Qualification> expectedQualificaitons = worker.getQualifications();
		
		Qualification prexistingQualification = new Qualification("Sample Qualification");
		worker.addQualification(prexistingQualification);

		assertEquals(expectedQualificaitons, worker.getQualifications());
	}

	@Test
	public void testToString() {
		String expectedString = "Sample Name:0:1:10";
		assertEquals(expectedString, worker.toString());

		Qualification newQualification = new Qualification("New Qualification");
		sampleQualifications.add(newQualification);
		Worker newWorker = new Worker(sampleName, sampleQualifications, sampleSalary);
		String newExpectedString = "Sample Name:0:2:10";
		assertEquals(newExpectedString, newWorker.toString());

		String format = ".*:\\d+:\\d+:\\d+.*";
		boolean correctFormat = newWorker.toString().matches(format);
		assertTrue(correctFormat);
	}

	@Test
	public void testSetSalary() {
		double expectedSalary = 123.0;
		assertNotEquals(expectedSalary, worker.getSalary());

		worker.setSalary(expectedSalary);
		double marginOfError = 0.1;
		assertEquals(expectedSalary, worker.getSalary(), marginOfError);
	}

	@Test
	public void testHashCodeIsTheSameForIdenticalWorkers() {
		int hashCode1 = worker.hashCode();
		Worker identicalWorker = worker;
		int hashCode2 = identicalWorker.hashCode();

		assertEquals(hashCode1, hashCode2);
	}

	@Test
	public void testHashCodeIsDifferentForDifferentWorkers() {
		int hashCode1 = worker.hashCode();

		String name = "This is not the same as the sample name.";
		Worker differentWorker = new Worker(name, sampleQualifications, sampleSalary);
		int hashCode2 = differentWorker.hashCode();

		assertNotEquals(hashCode1, hashCode2);
	}

	private Worker buildExpectedWorker() {
		double expectedSalary = 10.0;
		String expectedName = "Sample Name";
		Qualification expectedQualification = new Qualification("Sample Qualification");
		Set<Qualification> expectedQualifications = new HashSet<Qualification>();
		expectedQualifications.add(expectedQualification);

		Worker expectedWorker = new Worker(expectedName, expectedQualifications, expectedSalary);
		return expectedWorker;
	}

	@Test
	public void testGetProject() {
		assertFalse(worker == null);

		String firstDescription = "Qualified Engineer";

		Qualification firstQualification = new Qualification(firstDescription);
		Set<Qualification> testQualifications = new HashSet<Qualification>();
		testQualifications.add(firstQualification);

		Project proj = new Project("Test Project", sampleQualifications, ProjectSize.SMALL);
		Set<Project> setOfProjects = new HashSet<>();
		setOfProjects.add(proj);

		worker.addProject(proj);
		assertEquals(worker.getProjects(), setOfProjects);
	}

	@Test
	public void testGetWorkload() {
		Worker expectedWorker = buildExpectedWorker();
		int expected = expectedWorker.getWorkload();
		int actual = worker.getWorkload();

		assertEquals(expected, actual);
	}

	@Test
	public void testWillOverload() {
		Worker availableWorker = buildExpectedWorker();
		Project ProjectOne = new Project("projectOne", sampleQualifications, ProjectSize.BIG);
		Project ProjectTwo = new Project("projectTwo", sampleQualifications, ProjectSize.BIG);
		Project ProjectThree = new Project("projectThree", sampleQualifications, ProjectSize.BIG);
		Project ProjectFour = new Project("projectFour", sampleQualifications, ProjectSize.BIG);
		Project ProjectFive = new Project("projectFive", sampleQualifications, ProjectSize.SMALL);

		availableWorker.addProject(ProjectOne);
		availableWorker.addProject(ProjectTwo);
		availableWorker.addProject(ProjectThree);
		availableWorker.addProject(ProjectFour);

		assertFalse(availableWorker.willOverload(ProjectOne));
		assertTrue(availableWorker.willOverload(ProjectFive));
	}

	@Test
	public void testIsAvailable() {
		Worker availableWorker = buildExpectedWorker();
		Project projectOne = new Project("projectOne", sampleQualifications, ProjectSize.BIG);
		Project ProjectTwo = new Project("projectTwo", sampleQualifications, ProjectSize.BIG);
		Project ProjectThree = new Project("projectThree", sampleQualifications, ProjectSize.BIG);
		Project ProjectFour = new Project("projectFour", sampleQualifications, ProjectSize.BIG);
		Project ProjectFive = new Project("projectFive", sampleQualifications, ProjectSize.SMALL);

		availableWorker.addProject(projectOne);
		assertTrue(availableWorker.isAvailable());
		availableWorker.addProject(ProjectTwo);
		availableWorker.addProject(ProjectThree);
		availableWorker.addProject(ProjectFour);
		assertFalse(availableWorker.isAvailable());
		availableWorker.addProject(ProjectFive);
		assertFalse(availableWorker.isAvailable());

		availableWorker.removeProject(projectOne);
		assertTrue(availableWorker.isAvailable());

	}

	@Test
	public void testRemoveProject() {
		Worker expectedWorker = buildExpectedWorker();
		Qualification firstQualification = new Qualification("Description");
		Set<Qualification> testQualifications = new HashSet<Qualification>();
		testQualifications.add(firstQualification);

		Project testProject = new Project("Test Project", testQualifications, ProjectSize.SMALL);

		expectedWorker.addProject(testProject);
		Set<Project> expectedProject = new HashSet<>();
		expectedProject.add(testProject);

		assertEquals(expectedProject, expectedWorker.getProjects());

		expectedProject.remove(testProject);
		expectedWorker.removeProject(testProject);
		assertEquals(expectedProject, expectedWorker.getProjects());

	}

	@Test
	public void testRemoveProjectElementNotInSet() {
		Worker worker = buildExpectedWorker();
		Project projectInSet = new Project("ProjectInSet", worker.getQualifications(), ProjectSize.BIG);
		worker.addProject(projectInSet);
		Set<Project> expectedProjectSet= worker.getProjects();
		Project projectNotInSet = new Project("ProjectNotInSet", worker.getQualifications(), ProjectSize.BIG);

		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		assertEquals(expectedProjectSet, worker.getProjects());
	}

	@Test
	public void testRemoveProjectNullProject() {
		Worker worker = buildExpectedWorker();
		Project projectInSet = new Project("ProjectInSet", worker.getQualifications(), ProjectSize.BIG);
		worker.addProject(projectInSet);
		Set<Project> expectedProjectSet= worker.getProjects();
		Project nullProject = null;

		worker.removeProject(nullProject);
		worker.removeProject(nullProject);
		worker.removeProject(nullProject);
		worker.removeProject(nullProject);
		worker.removeProject(nullProject);
		assertEquals(expectedProjectSet, worker.getProjects());
	}

	@Test
	public void testRemoveProjectFromEmptySet() {
		Worker worker = buildExpectedWorker();
		// No Project set Initialized
		Project projectNotInSet = new Project("ProjectNotInSet", worker.getQualifications(), ProjectSize.BIG);

		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		worker.removeProject(projectNotInSet);
		assertTrue(worker.getProjects().size() == 0);
	}


	@Test
	public void testToDTO() {
		Worker expected = buildExpectedWorker();
		WorkerDTO expectedDTO = expected.toDTO();
		WorkerDTO actualDTO = worker.toDTO();

		assertEquals(expectedDTO, actualDTO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNullProject() {
		worker.addProject(null);
	}

	@Test
	public void testAddProject() {
		Set<Project> expected = buildExpectedProjects();
		
		Project projectOne = new Project("Project One", sampleQualifications, ProjectSize.SMALL);
		Project projectTwo = new Project("Project Two", sampleQualifications, ProjectSize.MEDIUM);
		Project projectThree = new Project("Project Three", sampleQualifications, ProjectSize.BIG);

		worker.addProject(projectOne);
		worker.addProject(projectTwo);
		worker.addProject(projectThree);

		assertEquals(expected, worker.getProjects());
	}

	@Test
	public void testAddToUninitializedProjects() {
		Set<Project> expected = new HashSet<>();
		Project projectOne = new Project("Project One", sampleQualifications, ProjectSize.SMALL);
		expected.add(projectOne);

		worker.addProject(projectOne);

		assertEquals(expected, worker.getProjects());
	}

	private Set<Project> buildExpectedProjects() {
		Set<Project> expected = new HashSet<>();

		Project projectOne = new Project("Project One", sampleQualifications, ProjectSize.SMALL);
		Project projectTwo = new Project("Project Two", sampleQualifications, ProjectSize.MEDIUM);
		Project projectThree = new Project("Project Three", sampleQualifications, ProjectSize.BIG);

		expected.add(projectOne);
		expected.add(projectTwo);
		expected.add(projectThree);

		return expected;
	}
}
