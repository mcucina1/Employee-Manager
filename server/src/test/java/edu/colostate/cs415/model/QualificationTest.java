package edu.colostate.cs415.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import junit.extensions.TestDecorator;

public class QualificationTest {
	String sampleDescription;
	Qualification qualification;
	
	@Before
	public void setUp(){
		sampleDescription = "This is the qualification's description."; 
		qualification = new Qualification(sampleDescription);
	}
	
	@Test
	public void test() {
		assert (true);
	}

	@Test
	public void testQualificationConstructor() {
		assertDescriptionMatchesExpected(qualification, sampleDescription);
	}

	@Test
	public void testGetDescription() {
		assertDescriptionMatchesExpected(qualification, sampleDescription);
	}

	@Test
	public void testHashCodeIsDifferentForDifferentObjects() {
		String description = "This description is different from the sample description";
		Qualification differentQualification = new Qualification(description);

		int originalHashCode = qualification.hashCode();
		int differentHashCode = differentQualification.hashCode();

		assertNotEquals(originalHashCode, differentHashCode);
	}

	@Test 
	public void testHashCodeIsTheSameForIdenticalObjects() {
		Qualification identicalQualification = qualification;

		int originalHashCode = qualification.hashCode();
		int identicalHashcode = identicalQualification.hashCode();
		
		assertEquals(originalHashCode, identicalHashcode);
	}	
	
	@Test
	public void testToString() {
		assertDescriptionMatchesExpected(qualification, sampleDescription);
	}
	
	@Test
	public void testEquals() {
		qualification = new Qualification("This is a test.");
		Qualification qualTwo = new Qualification("This is a test.");
		Qualification qualThree = new Qualification("This is a Test!!!");
		assertTrue(qualification.equals(qualTwo));
		assertFalse(qualification.equals(qualThree));
	}

	@Test
	public void testGetWorkersWithEmptyWorkers() {
		Set<Worker> expectedWorkers = new HashSet<>();
		assertEquals(expectedWorkers, qualification.getWorkers());
	}

	@Test
	public void testGetWorkers() {
		Set<Worker> expectedWorkers = createExpectedWorkers();

		Set<Qualification> workerQualifications = new HashSet<>();
		Worker firstExpectedWorker = new Worker ("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker ("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker ("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstExpectedWorker);
		qualification.addWorker(secondExpectedWorker);
		qualification.addWorker(thirdExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());
	}

	@Test
	public void testAddWorker() {
		Set<Worker> expectedWorkers = createExpectedWorkers();

		Set<Qualification> workerQualifications = new HashSet<>();
		Worker firstExpectedWorker = new Worker ("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker ("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker ("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstExpectedWorker);
		qualification.addWorker(secondExpectedWorker);
		qualification.addWorker(thirdExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());
	}

	public void assertDescriptionMatchesExpected(Qualification qualification, String expectedDescription) {
		assertEquals(qualification.toString(), expectedDescription);
	}

	public Set<Worker> createExpectedWorkers() {
		Set<Worker> expectedWorkers = new HashSet<>();
		Set<Qualification> workerQualifications = new HashSet<>();
		
		Worker firstExpectedWorker = new Worker ("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker ("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker ("Chris Rorland", workerQualifications, 50.0);

		expectedWorkers.add(firstExpectedWorker);
		expectedWorkers.add(secondExpectedWorker);
		expectedWorkers.add(thirdExpectedWorker);

		return expectedWorkers;
	}

	@Test
	public void testRemoveWorkers() {
		Set<Worker> expectedWorkers = createExpectedWorkers();

		Set<Qualification> workerQualifications = new HashSet<>();
		Worker firstExpectedWorker = new Worker ("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker ("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker ("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstExpectedWorker);
		qualification.addWorker(secondExpectedWorker);
		qualification.addWorker(thirdExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());

		qualification.removeWorker(firstExpectedWorker);
		expectedWorkers.remove(firstExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());

		qualification.removeWorker(secondExpectedWorker);
		expectedWorkers.remove(secondExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());

		qualification.removeWorker(secondExpectedWorker);
		expectedWorkers.remove(secondExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());
		
	}
}
