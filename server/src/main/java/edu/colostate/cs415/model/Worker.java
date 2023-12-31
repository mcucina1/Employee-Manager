package edu.colostate.cs415.model;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs415.dto.WorkerDTO;

public class Worker {

	public static final int MAX_WORKLOAD = 12;

	private String name;
	private double salary;
	private Set<Project> projects;
	private Set<Qualification> qualifications;

	public Worker(String name, Set<Qualification> qualifications, double salary) {
		if(name == null || name == "" || name.trim().isEmpty()){
			throw new IllegalArgumentException("Name must not be empty or null.");
		}

		if(qualifications == null || qualifications.isEmpty()){
			throw new IllegalArgumentException("Qualifications must not be null or empty.");
		}

		if(salary < 0){
			throw new IllegalArgumentException("Salary must not be negative.");
		}
		
		this.name = name;
		this.qualifications = qualifications;
		this.salary = salary;
		this.projects = new HashSet<Project>();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			throw new IllegalArgumentException("[Worker.java] equals(): Cannot compare to null.");
		}

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
		int salaryTruncated = (int) salary;

		numberOfProjects = projects.size();
		numberOfQualificaitons = qualifications.size();

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
		if(salary < 0){
			throw new IllegalArgumentException("Salary must not be negative.");
		}
		this.salary = salary;
	}

	public Set<Qualification> getQualifications() {
		return this.qualifications;
	}

	public void addQualification(Qualification qualification) {
		if (qualification == null) {
			throw new IllegalArgumentException("Cannot add a null qualification.");
		}

		if (!(qualifications.contains(qualification))) {
			this.qualifications.add(qualification);
		}
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		if (project == null) {
			throw new IllegalArgumentException("Cannot add a null project.");
		}

		projects.add(project);
	}

	public void removeProject(Project project) {
		this.projects.remove(project);
	}

	public int getWorkload() {
		int bigProjects = 0;
		int mediumProjects = 0;
		int smallProjects = 0;

		if (projects.size() == 0) {
			return 0;
		}

		for (Project p : projects) {

			if (p.getStatus() == ProjectStatus.FINISHED) {
				continue;
			} 
			if (p.getSize().getValue() == 3) {
				bigProjects += 1;
			} 
			if (p.getSize().getValue() == 2) {
				mediumProjects += 1;
			} 
			if (p.getSize().getValue() == 1) {
				smallProjects += 1;
			}
		}

		return 3 * bigProjects + 2 * mediumProjects + smallProjects;
	}

	public boolean willOverload(Project project) {
		if (this.projects.contains(project)) {
			return false;
		}

		int currentWorkload = this.getWorkload();
		if (currentWorkload > 12) {
			return true;
		}

		if (currentWorkload + project.getSize().getValue() > 12) {
			return true;
		}

		return false;
	}

	public boolean isAvailable() {
		if (this.getWorkload() < 12) {
			return true;
		}
		return false;
	}

	public WorkerDTO toDTO() {
		String[] workerQualifications = new String[this.qualifications.size()];
		String[] workersProjects = new String[this.projects.size()];
		int index = 0;

		for (Qualification q : this.qualifications) {
			workerQualifications[index] = q.toString();
			index++;
		}

		index = 0;

		for (Project p : this.projects) {
			workersProjects[index] = p.getName();
			index++;
		}

		WorkerDTO retDTO = new WorkerDTO(this.name, this.salary, this.getWorkload(), workersProjects,
				workerQualifications);

		return retDTO;
	}
}
