package edu.colostate.cs415.model;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testEquals() {
		Worker workerTwo = buildExpectedWorker();
		Worker workerThree = new Worker("Bobby", sampleQualifications, 200000);
		assertTrue(worker.equals(workerTwo));
		assertFalse(worker.equals(workerThree));
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
	public void testToString() {
		String expectedString = "Sample Name:0:1:10";
		assertEquals(expectedString, worker.toString());

		Qualification newQualification = new Qualification("New Qualification");
		sampleQualifications.add(newQualification);
		Worker newWorker = new Worker(sampleName, sampleQualifications, sampleSalary);
		String newExpectedString = "Sample Name:0:2:10";
		assertEquals(newExpectedString, newWorker.toString());		
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
}
