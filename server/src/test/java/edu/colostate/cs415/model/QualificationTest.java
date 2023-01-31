package edu.colostate.cs415.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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

	public void assertDescriptionMatchesExpected(Qualification qualification, String expectedDescription) {
		assertEquals(qualification.toString(), expectedDescription);
	}
}
