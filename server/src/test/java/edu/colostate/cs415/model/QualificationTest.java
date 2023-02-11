package edu.colostate.cs415.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs415.dto.QualificationDTO;

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

	@Test(expected = IllegalArgumentException.class)
	public void testQualificationNull(){
		String nullString = null;
		Qualification nullQual = new Qualification(nullString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQualificationEmptyString(){
		String emptyString = "";
		Qualification emptyQual = new Qualification(emptyString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQualificationWhiteSpaceString(){
		String whiteSpaceString = "          ";
		Qualification emptyQual = new Qualification(whiteSpaceString);
	}

	@Test
	public void testQualificationPaddedString(){
		String whiteSpaceString = "    Dave     ";
		Qualification emptyQual = new Qualification(whiteSpaceString);
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
	public void testEqualsNonQual(){
		String nonQual = "Engineer";
		Qualification testQual = new Qualification("Engineer");
		assertFalse(testQual.equals(nonQual));
	}
	@Test
	public void testEqualsSameObj(){
		Qualification testQual = new Qualification("Engineer");
		assertTrue(testQual.equals(testQual));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse(qualification.equals(null));
	}

	@Test
	public void testEqualsWithTheSameObjects() {
		assertTrue(qualification.equals(qualification));
	}

	@Test
	public void testGetWorkersWithEmptyWorkers() {
		Set<Worker> expectedWorkers = new HashSet<>();
		assertEquals(expectedWorkers, qualification.getWorkers());
	}

	@Test
	public void testGetWorkersWithUnititalizedSet() {
		Set<Worker> expectedEmptySet = new HashSet<>();
		assertEquals(expectedEmptySet, qualification.getWorkers());
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
		Worker firstExpectedWorker = new Worker("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstExpectedWorker);
		qualification.addWorker(secondExpectedWorker);
		qualification.addWorker(thirdExpectedWorker);

		assertEquals(expectedWorkers, qualification.getWorkers());
	}
	
	@Test
	public void testToDTO() {
		Set<Qualification> workerQualifications = new HashSet<>();
		Worker firstExpectedWorker = new Worker("Jokim Broden", workerQualifications, 100.0);
		Worker secondExpectedWorker = new Worker("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdExpectedWorker = new Worker("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstExpectedWorker);
		qualification.addWorker(secondExpectedWorker);
		qualification.addWorker(thirdExpectedWorker);

		QualificationDTO expectedDTO = qualification.toDTO();

		String[] names = { "Jokim Broden", "Par Sundstrom", "Chris Rorland" };
		
		QualificationDTO actualDTO = new QualificationDTO(sampleDescription, names);

		assertEquals(expectedDTO, actualDTO);
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
	public void testRemoveWorker() {
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

	@Test
	public void testRemoveWorkerWhenGivenNull() {
		Worker nullWorker = null;
		Set<Qualification> workerQualifications = new HashSet<>();
		Worker worker = new Worker ("Jokim Broden", workerQualifications, 100.0);		
		qualification.addWorker(worker);

		Set<Worker> expectededWorkers = new HashSet<>();
		expectededWorkers.add(worker);

		qualification.removeWorker(nullWorker);
		assertEquals(expectededWorkers, qualification.getWorkers());
	}

	@Test 
	public void testRemoveWorkerWhenWorkerIsntPresent() {
		Set<Worker> expectedWorkers = createExpectedWorkers();

		Set<Qualification> workerQualifications = new HashSet<>();
		Worker firstWorker = new Worker ("Jokim Broden", workerQualifications, 100.0);
		Worker secondWorker = new Worker ("Par Sundstrom", workerQualifications, 51.0);
		Worker thirdWorker = new Worker ("Chris Rorland", workerQualifications, 50.0);

		qualification.addWorker(firstWorker);
		qualification.addWorker(secondWorker);
		qualification.addWorker(thirdWorker);

		Worker workerThatIsntPresent = new Worker("Not in the Set", workerQualifications, 0.0);

		qualification.removeWorker(workerThatIsntPresent);

		assertEquals(expectedWorkers, qualification.getWorkers());
	} 

	@Test
	public void testRemoveWorkerWhenTheSetIsNull() {
		Set<Qualification> workerQualifications = new HashSet<>();
		Worker workerToRemove = new Worker ("Jokim Broden", workerQualifications, 100.0);

		qualification.removeWorker(workerToRemove);

		assertNotEquals(null, qualification.getWorkers());
	}
}
