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
		return this.name + ':' + this.workers.size() + ":" + this.status;
	}

	public String getName() {
		return name;
	}

	public ProjectSize getSize() {
		return size;
	}

	public ProjectStatus getStatus() {
		try{
			return status;
		}
		catch(NullPointerException e){
			return null;
		}
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public void addWorker(Worker worker) {
		if(workers == null) {
			workers = new HashSet<Worker>();
		}
		this.workers.add(worker);
	}

	public void removeWorker(Worker worker) {
	}

	public Set<Worker> getWorkers() {
		return this.workers;
	}

	public void removeAllWorkers() {
	}

	public Set<Qualification> getRequiredQualifications() {
		return qualifications;
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
