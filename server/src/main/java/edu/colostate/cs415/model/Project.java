package edu.colostate.cs415.model;

import java.util.Collections;
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
		if(name == null || name == "" || name.trim().isEmpty() || qualifications == null || size == null){
			throw new IllegalArgumentException("No constructor fields may be null.");
		}
		this.name = name;
		this.qualifications = qualifications;
		this.size = size;
		this.status = ProjectStatus.PLANNED;
		this.workers = new HashSet<>();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			throw new IllegalArgumentException("[Project.java] equals(): Cannot compare to null.");
		}

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
		if (status == null)  {
			throw new IllegalArgumentException("Status cannot be set to null.");
		}

		this.status = status;
	}

	public void addWorker(Worker worker) {
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
		if (qualification == null)  {
			throw new IllegalArgumentException("Status cannot be set to null.");
		}

		this.qualifications.add(qualification);
	}

	public Set<Qualification> getMissingQualifications() {
		Set<Qualification> workersQuals = new HashSet<Qualification>();
		Set<Qualification> missingQuals = new HashSet<Qualification>();

		for (Worker qual : this.getWorkers()) {
			workersQuals.addAll(qual.getQualifications());
		}

		for (Qualification element : this.getRequiredQualifications()) {
			if (workersQuals.add(element)) {
				missingQuals.add(element);
			}
		}

		return missingQuals;
	}

	public boolean isHelpful(Worker worker) {
		if (worker == null) { 
			throw new IllegalArgumentException("[Project.java] isHelpful(): Argument cannot be null");
		}

		return !(Collections.disjoint(worker.getQualifications(), qualifications));
	}

	public ProjectDTO toDTO() {
		Set<Qualification> tempMissingQuals = getMissingQualifications();
		String[] missingQualifications = new String[tempMissingQuals.size()];
		String[] workerNames = new String[workers.size()];
		String[] projectQualifications = new String[qualifications.size()];
		int index = 0;

		for (Worker w : workers) {
			workerNames[index] = w.getName();
			index++;
		}

		index = 0;

		for (Qualification q : qualifications) {
			projectQualifications[index] = q.toString();
			index++;
		}

		index = 0;

		for (Qualification q : tempMissingQuals) {
			missingQualifications[index] = q.toString();
			index++;
		}

		ProjectDTO retDTO = new ProjectDTO(this.name, this.size, this.status, workerNames, projectQualifications,
				missingQualifications);
		return retDTO;
	}
}
