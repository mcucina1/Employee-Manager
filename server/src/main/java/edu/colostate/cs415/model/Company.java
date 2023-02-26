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
		String outputString = this.name; 

		outputString = outputString.concat(":");
		String workerCount = String.valueOf(available.size());
		outputString = outputString.concat(workerCount);

		outputString = outputString.concat(":");
		String projectCount = String.valueOf(projects.size());
		outputString = outputString.concat(projectCount);

		return outputString;
	}

	public String getName() {
		return name;
	}

	public Set<Worker> getEmployedWorkers() {
		return this.employees;
	}

	public Set<Worker> getAvailableWorkers() {
		return this.available;
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
		if(name == null || name == "" || name.trim().isEmpty() || qualifications == null || size == null){
			throw new IllegalArgumentException("{Company.java} No constructor fields may be null.");
		}

		Project newProject = new Project(name, qualifications, size);
		projects.add(newProject);

		return newProject;
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
		// if(worker == null || project == null) {
		// 	throw new IllegalArgumentException("Worker and Project Arguments may not be null");
		// }
		// // 1.) Only workers from the pool of available workers can be assigned as long
		// // as they are not already assigned to the same project.
		// if(!available.contains(worker) || project.getWorkers().contains(worker)) {
		// 	throw new IllegalArgumentException("Worker must be available and not already assigned to Project");
		// }
		// // 2.) The project must not be in the ACTIVE or FINISHED state.
		// if((project.getStatus() == ProjectStatus.ACTIVE) || (project.getStatus() == ProjectStatus.FINISHED)) {
		// 	throw new IllegalArgumentException("Project Status must not be ACTIVE or FINISHED");
		// }
		// // 3.) The worker should not get overloaded by adding to this project.
		// if(worker.willOverload(project)) {
		// 	throw new IllegalArgumentException("Assigning worker to Project will Overload Worker");
		// }
		// // 4.) The worker can be added only if the worker is helpful to the project
		// // (i.e., meets at least one missing qualifications).
		// if(!project.isHelpful(worker)) {
		// 	throw new IllegalArgumentException("Worker does not meet project qualifications");
		// }
		// // 5.) If 1-4 are satisfied the assigned worker is added to the pool of assigned
		// // workers UNLESS they were already present in that pool,
		// if(!(assigned.contains(worker))){
		// 	assigned.add(worker);
		// }
		// // and (2) the worker is also added to the project.
		// project.addWorker(worker);
		// worker.addProject(project);
		// // Check if the worker should
		// // be moved out of the available pool.
		// if(!worker.isAvailable()) {
		// 	available.remove(worker);
		// }
	}

	public void unassign(Worker worker, Project project) {
	}

	public void unassignAll(Worker worker) {
	}
}
