package edu.colostate.cs415.model;

import java.util.Set;

import edu.colostate.cs415.dto.ProjectDTO;

public class Project {

	private String name;
	private ProjectSize size;
	private ProjectStatus status;
	private Set<Worker> workers;
	private Set<Qualification> qualifications;

	public Project(String name, Set<Qualification> qualifications, ProjectSize size) {
		this.name = name;
		this.qualifications = qualifications;
		this.size = size;
	}

	@Override
	public boolean equals(Object other) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}

	public String getName() {
		return name;
	}

	public ProjectSize getSize() {
		return null;
	}

	public ProjectStatus getStatus() {
		return null;
	}

	public void setStatus(ProjectStatus status) {
	}

	public void addWorker(Worker worker) {
	}

	public void removeWorker(Worker worker) {
	}

	public Set<Worker> getWorkers() {
		return null;
	}

	public void removeAllWorkers() {
	}

	public Set<Qualification> getRequiredQualifications() {
		return null;
	}

	public void addQualification(Qualification qualification) {
	}

	public Set<Qualification> getMissingQualifications() {
		return null;
	}

	public boolean isHelpful(Worker worker) {
		return false;
	}

	public ProjectDTO toDTO() {
		return null;
	}
}
