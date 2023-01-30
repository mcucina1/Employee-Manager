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

		testProject = new Project(testProjectName, testQualifications, ProjectSize.SMALL);
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
}
