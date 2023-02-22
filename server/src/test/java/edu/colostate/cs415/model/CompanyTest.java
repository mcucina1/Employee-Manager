package edu.colostate.cs415.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

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

	@Test(expected = IllegalArgumentException.class)
	public void testNullCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWhiteSpaceStringCreateQualification() {
		Company testCompany = new Company("Test Company");
		testCompany.createQualification(" ");
	}

	@Test
	public void testCreateQualification() {
		Company testCompany = new Company("Test Company");
		Company testTwoCompany = new Company("Test Two Company");
		Qualification qualOne = testCompany.createQualification("Qual One");
		Qualification qualTwo = testTwoCompany.createQualification("Qual One");

		// NEED TO INSERT TESTS WITH GetQualifications Once Implemented.
		assertEquals(qualOne, qualTwo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullNameCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();
		testCompany.createWorker(null, quals, 10.0);
	}

	@Test
	public void testNullQualsCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = null;
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	public void testEmptyQualsCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	public void testNonCompanyQualCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();

		testCompany.createQualification("Qual One");
		quals.add(new Qualification("Qual Two"));
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNull(w);
	}

	public void testCreateWorker() {
		Company testCompany = new Company("Test Company");
		Set<Qualification> quals = new HashSet<Qualification>();

		testCompany.createQualification("Qual One");
		quals.add(new Qualification("Qual One"));
		Worker w = testCompany.createWorker("Test Worker", quals, 10.0);
		assertNotNull(w);
	}

	@Test
	public void testHashcodeDifferentforDifferentNames() {
		Company testCompany = new Company("Test Company");
		Company testCompanyWithDifferentName = new Company("Not The Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyWithDifferentName.hashCode();

		assertFalse(hashcodeOne == hashcodeTwo);

	}

	@Test
	public void testHashcodeSameForIdenticalNames() {
		Company testCompany = new Company("Test Company");
		Company testCompanyTwo = new Company("Test Company");

		int hashcodeOne = testCompany.hashCode();
		int hashcodeTwo = testCompanyTwo.hashCode();

		assertEquals(hashcodeOne, hashcodeTwo);
	}

	@Test
	public void testGetProjectEmpty() {
		Company company = new Company("Company");
		assertTrue(company.getProjects() != null);
		assertTrue(company.getProjects().isEmpty());
	}

	@Test
	public void testGetQualEmpty(){
		Company emptyQualCompany = new Company("Empty Qualification Company");
		assertTrue(emptyQualCompany.getQualifications().isEmpty());
	}

	@Test
	public void testGetQualSingle(){
		Company singleQualCompany = new Company("Single Qualification Company");
		singleQualCompany.createQualification("This is a single qualification");
		assertFalse(singleQualCompany.getQualifications().isEmpty());
		assertTrue(singleQualCompany.getQualifications().size() == 1);
	}

	@Test
	public void testGetQualMany(){
		Company multiQualCompany = new Company("Multiple Qualification Company");
		multiQualCompany.createQualification("This is one qualification");
		multiQualCompany.createQualification("This is a second qualification");
		assertFalse(multiQualCompany.getQualifications().isEmpty());
		assertTrue(multiQualCompany.getQualifications().size() == 2);
	}

	// @Test
	// public void testGetProjectNotEmpty() {
	// Company company new Company("Company");

	// }
}
