package edu.colostate.cs415.model;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs415.dto.QualificationDTO;

public class Qualification {

	private String description;
	private Set<Worker> workers;

	public Qualification(String description) {
		if(description == null || description == "" || description.trim().isEmpty()){
			throw new IllegalArgumentException("Description must not be null.");
		}
		this.description = description;

		workers = new HashSet<>();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			throw new IllegalArgumentException("[Qualification.java] equals(): Cannot compare to null");
		}

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
		return workers;
	}

	public void addWorker(Worker worker) {
		if (worker == null) {
			throw new IllegalArgumentException("Cannot add a null worker.");
		}
		
		workers.add(worker);
	}

	public void removeWorker(Worker worker) {		
		if(!(worker == null)) {
			workers.remove(worker);
		}
	}

	public QualificationDTO toDTO() {
		// This work is under the assumption that the DTO just wants the names of the workers in the String array.
		String[] workerNames = new String[workers.size()];
		int index = 0;
		for (Worker w : workers) {
			workerNames[index] = w.getName();
			index++;
		}
		QualificationDTO qualDTO = new QualificationDTO(description, workerNames);

		return qualDTO;
	}
}
