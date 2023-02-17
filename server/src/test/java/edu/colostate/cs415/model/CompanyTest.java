package edu.colostate.cs415.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class CompanyTest {

	@Test
	public void testConstructorIsValid() {
		Company testCompany = new Company("Test Company");
		assertTrue(testCompany != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorEmptyName() {
		Company testCompany = new Company("Test Company");
		String emptyName = "";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorWhiteSpaceName() {
		Company testCompany = new Company("Test Company");
		String emptyName = " ";
		Company emptyCompanyName = new Company(emptyName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompanyConstructorNullName() {
		Company testCompany = new Company("Test Company");
		String nullName = null;
		Company nullCompanyName = new Company(nullName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullEquals() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company(null);

		assertTrue(testCompany.equals(testCompanyTwo));
	}

	@Test
	public void testEquals() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");
		Company copyCompany = testCompany;

		assertTrue(testCompany.equals(testCompanyTwo));
		assertTrue(testCompany.equals(copyCompany));
		assertFalse(testCompany.equals("Company"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullGetName() {
		Company company = new Company(null);
	}

	@Test
	public void testGetName() {
		Company company = new Company("Company");
		assertEquals("Company", company.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyGetName() {
		Company company = new Company("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWhiteSpaceGetName() {
		Company company = new Company("    ");
	}

	@Test
	public void test() {
		assert (true);
	}
}
