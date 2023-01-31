package edu.colostate.cs415.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

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

		workers  = new HashSet<Worker>();
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
	public void testProjectConstructor() {
		assert(true);
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
	public void testToString() {
		String expectedOutput = testProject.getName() + ':' + testProject.getWorkers().size() + ':' + testProject.getStatus();
		String actualOutput = testProject.toString();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testSetAndGetStatus() {
		testProject.setStatus(ProjectStatus.ACTIVE);
		assertEquals(testProject.getStatus(),ProjectStatus.ACTIVE);
	}
}
