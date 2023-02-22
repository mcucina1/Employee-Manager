package edu.colostate.cs415.model;

import java.util.HashSet;
import java.util.Set;

public class Company {

	private String name;
	private Set<Worker> employees;
	private Set<Worker> available;
	private Set<Worker> assigned;
	private Set<Project> projects;
	private Set<Qualification> qualifications;

	public Company(String name) {
		if (name == null || name == "" || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name must not be null or empty.");
		}
		this.name = name;
		this.employees = new HashSet<Worker>();
		this.available = new HashSet<Worker>();
		this.assigned = new HashSet<Worker>();
		this.projects = new HashSet<Project>();
		this.qualifications = new HashSet<Qualification>();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			throw new IllegalArgumentException("[Comapny.java] equals(): Cannot compare to null.");
		}

		if (other == this) {
			return true;
		}

		if (!(other instanceof Company)) {
			return false;
		}

		Company testCompany = (Company) other;

		return name.equals(testCompany.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return null;
	}

	public String getName() {
		return name;
	}

	public Set<Worker> getEmployedWorkers() {
		return this.employees;
	}

	public Set<Worker> getAvailableWorkers() {
		return null;
	}

	public Set<Worker> getUnavailableWorkers() {
		return null;
	}

	public Set<Worker> getAssignedWorkers() {
		return null;
	}

	public Set<Worker> getUnassignedWorkers() {
		return null;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public Set<Qualification> getQualifications() {
		return this.qualifications;
	}

	public Worker createWorker(String name, Set<Qualification> qualifications, double salary) {
		if (name == null || name == "" || name.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"{Company.java} Name when creating a Worker must not be null or empty.");
		}

		if (qualifications == null) {
			return null;
		}

		if (qualifications.isEmpty()) {
			return null;
		}

		Set<Qualification> workerQuals = new HashSet<Qualification>();

		for (Qualification q : qualifications) {
			if (this.qualifications.contains(q)) {
				workerQuals.add(q);
			}
		}

		if (workerQuals.isEmpty()) {
			return null;
		}

		Worker newWorker = new Worker(name, workerQuals, salary);

		this.employees.add(newWorker);
		this.available.add(newWorker);

		for (Qualification q : workerQuals) {
			q.addWorker(newWorker);
		}

		return newWorker;
	}

	public Qualification createQualification(String description) {
		if (description == null || description == "" || description.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"{Company.java} Description when creating a Qualification must not be null or empty.");
		}

		Qualification newQualification = new Qualification(description);

		if (!(this.qualifications.contains(newQualification))) {
			this.qualifications.add(newQualification);
		}

		return newQualification;
	}

	public Project createProject(String name, Set<Qualification> qualifications, ProjectSize size) {
		return null;
	}

	public void start(Project project) {
        if (getQualifications().containsAll(project.getRequiredQualifications())
        && (project.getStatus() == ProjectStatus.PLANNED || project.getStatus() == ProjectStatus.SUSPENDED))
            project.setStatus(ProjectStatus.ACTIVE);
        else
            return;
    }

	public void finish(Project project) {
	}

	public void assign(Worker worker, Project project) {
	}

	public void unassign(Worker worker, Project project) {
	}

	public void unassignAll(Worker worker) {
	}
}
