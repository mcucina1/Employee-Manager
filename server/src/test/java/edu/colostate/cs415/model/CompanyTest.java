package edu.colostate.cs415.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class CompanyTest {

	Company testCompany;

	@Before
	public void setUp(){
		testCompany = new Company("Test Company");
	}

	@Test
	public void testConstructorIsValid() {
		assertTrue(testCompany!=null);
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

	@Test
	public void test() {
		assert (true);
	}
}
