package edu.colostate.cs415.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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

	public void assertDescriptionMatchesExpected(Qualification qualification, String expectedDescription) {
		assertEquals(qualification.getDescription(), expectedDescription);
	}
}
