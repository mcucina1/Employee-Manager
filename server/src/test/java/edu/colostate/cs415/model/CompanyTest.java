package edu.colostate.cs415.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class CompanyTest {

	Company testCompany;

	@Before
	public void setUp() {
		testCompany = new Company("Test Company");
	}

	@Test
	public void testConstructorIsValid() {
		assertTrue(testCompany != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorEmptyName() {
		String emptyName = "";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorWhiteSpaceName() {
		String emptyName = " ";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorNullName() {
		String nullName = null;
		Company nullCompanyName = new Company(nullName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullEquals() {
		testCompany = new Company(null);
		Company testCompanyTwo = new Company(null);

		assertTrue(testCompany.equals(testCompanyTwo));
	}

	@Test
	public void testEquals() {
		testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");
		Company copyCompany = this.testCompany;

		assertTrue(testCompany.equals(testCompanyTwo));
		assertTrue(testCompany.equals(copyCompany));
		assertFalse(testCompany.equals("Company"));
	}

	@Test
	public void testHashcodeDifferentforDifferentNames() {
		testCompany = new Company("Test Company");
		Company testCompanyWithDifferentName = new Company("Not The Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyWithDifferentName.hashCode();

		assertFalse(hashcodeOne == hashcodeTwo);

	}

	@Test
	public void testHashcodeSameForIdenticalNames() {
		testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyTwo.hashCode();

		assertEquals(hashcodeOne, hashcodeTwo);
	}	
}
