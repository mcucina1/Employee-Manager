package edu.colostate.cs415.model;

import java.util.HashSet;
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
		this.status = ProjectStatus.PLANNED;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (!(other instanceof Project)) {
			return false;
		}

		Project testProject = (Project) other;

		return name.equals(testProject.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return this.name + ':' + this.workers.size() + ":" + this.status;
	}

	public String getName() {
		return name;
	}

	public ProjectSize getSize() {
		return size;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public void setSize(ProjectSize size) {
		this.size = size;
	}

	public void addWorker(Worker worker) {
		if (workers == null) {
			workers = new HashSet<Worker>();
		}
		this.workers.add(worker);
	}

	public void removeWorker(Worker worker) {
		this.workers.remove(worker);
	}

	public Set<Worker> getWorkers() {
		return this.workers;
	}

	public void removeAllWorkers() {
		this.workers.clear();
	}

	public Set<Qualification> getRequiredQualifications() {
		return qualifications;
	}

	public void addQualification(Qualification qualification) {
		if (qualifications == null) {
			qualifications = new HashSet<Qualification>();
		}
		this.qualifications.add(qualification);
	}

	public Set<Qualification> getMissingQualifications() {
		Set<Qualification> workersQuals = new HashSet<Qualification>();
		Set<Qualification> missingQuals = new HashSet<Qualification>();

		for (Worker qual: this.getWorkers()){
			workersQuals.addAll(qual.getQualifications());
		}

		for (Qualification element: this.getRequiredQualifications()){
			if (workersQuals.add(element)){
				missingQuals.add(element);
			}
		}

		return missingQuals;
	}

	public boolean isHelpful(Worker worker) {
		return false;
	}

	public ProjectDTO toDTO() {
		return null;
	}
}
