package edu.colostate.cs415.model;

import java.util.Set;

import edu.colostate.cs415.dto.QualificationDTO;

public class Qualification {

	private String description;
	private Set<Worker> workers;

	public String getDescription() {
		return description;
	}

	public Qualification(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (!(other instanceof Qualification)) {
			return false;
		}

		Qualification qual = (Qualification) other;

		return description.equals(qual.description);
	}

	@Override
	public int hashCode() {
		int hashCode = description.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return description;
	}

	public Set<Worker> getWorkers() {
		return null;
	}

	public void addWorker(Worker worker) {
	}

	public void removeWorker(Worker worker) {
	}

	public QualificationDTO toDTO() {
		return null;
	}
}
