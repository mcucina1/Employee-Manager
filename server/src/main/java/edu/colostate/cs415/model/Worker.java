package edu.colostate.cs415.model;

import java.util.Set;

import edu.colostate.cs415.dto.WorkerDTO;

public class Worker {

	public static final int MAX_WORKLOAD = 12;

	private String name;
	private double salary;
	private Set<Project> projects;
	private Set<Qualification> qualifications;

	public Worker(String name, Set<Qualification> qualifications, double salary) {
		this.name = name;
		this.qualifications = qualifications;
		this.salary = salary;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (!(other instanceof Worker)) {
			return false;
		}

		Worker testWorker = (Worker) other;

		return name.equals(testWorker.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		int numberOfProjects = 0;
		int numberOfQualificaitons = 0;
		int salaryTruncated = (int)salary;

		if(this.projects != null) {
			numberOfProjects = projects.size();
		}

		if(this.qualifications != null) {
			numberOfQualificaitons = qualifications.size();
		}

		String workerString = this.name + ":" + numberOfProjects + ":" + numberOfQualificaitons + ":" + salaryTruncated;
		return workerString;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Qualification> getQualifications() {
		return this.qualifications;
	}

	public void addQualification(Qualification qualification) {
	}

	public Set<Project> getProjects() {
		return null;
	}

	public void addProject(Project project) {
	}

	public void removeProject(Project project) {
	}

	public int getWorkload() {
		return 0;
	}

	public boolean willOverload(Project project) {
		return false;
	}

	public boolean isAvailable() {
		return false;
	}

	public WorkerDTO toDTO() {
		return null;
	}
}
