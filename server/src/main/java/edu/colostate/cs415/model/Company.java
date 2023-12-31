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
        Set<Worker> workerSet = new HashSet<Worker>();
        
        for (Worker w : this.employees){
            if (!(w.isAvailable())){
                workerSet.add(w);
            }
        }
        
        return workerSet;
    }

	public Set<Worker> getAssignedWorkers() {
		return assigned;
	}

	public Set<Worker> getUnassignedWorkers() {
		Set<Worker> unassigned = new HashSet<>(employees);
		unassigned.removeAll(assigned);

		return unassigned;
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

		this.qualifications.add(newQualification);

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
        if(!(projects.contains(project))) {
			throw new IllegalArgumentException("{Company.java} Cannot start a project that isn't in the company.");
		}
		
		if (getQualifications().containsAll(project.getRequiredQualifications())
        && (project.getStatus() == ProjectStatus.PLANNED || project.getStatus() == ProjectStatus.SUSPENDED))
            project.setStatus(ProjectStatus.ACTIVE);
        else
            return;
    }

	public void finish(Project project) {
		if(project == null) {
			throw new IllegalArgumentException("Project may not be null");
		}

		if (!(project.getStatus() == ProjectStatus.ACTIVE)){
			return;
		}

		Set<Worker> projectWorkers = new HashSet<Worker>(project.getWorkers());

		for (Worker w : projectWorkers){
			unassign(w, project);
		}

		project.setStatus(ProjectStatus.FINISHED);
	}

	public void assign(Worker worker, Project project) {
		if(worker == null || project == null) {
			throw new IllegalArgumentException("Worker and Project Arguments may not be null");
		}

		if(!(employees.contains(worker)) || !(projects.contains(project))){
			throw new IllegalArgumentException("Worker must be employed and project must be in company");
		}

		if(!available.contains(worker) || project.getWorkers().contains(worker)) {
			throw new IllegalArgumentException("Worker must be available and not already assigned to Project");
		}
		
		if(project.getStatus() == ProjectStatus.ACTIVE || project.getStatus() == ProjectStatus.FINISHED) {
			throw new IllegalArgumentException("Project Status must not be ACTIVE or FINISHED");
		}

		if(worker.willOverload(project)) {
			throw new IllegalArgumentException("Assigning worker to Project will Overload Worker");
		}

		if(!project.isHelpful(worker)) {
			throw new IllegalArgumentException("Worker does not meet project qualifications");
		}
		
		if(!(assigned.contains(worker))){
			assigned.add(worker);
		}
		
		project.addWorker(worker);
		worker.addProject(project);
	
		if(!worker.isAvailable()) {
			available.remove(worker);
		}
	}

	public void unassign(Worker worker, Project project) {
		Boolean isAvailable = true;

		if (worker == null || project == null) {
			throw new IllegalArgumentException("Worker and Project Arguments may not be null");
		}

		// Checking to see if the worker is actually assigned to this project
		if (!(project.getWorkers().contains(worker)) && !(worker.getProjects().contains(project))) {
			throw new IllegalArgumentException(
					"{Comapny.java} Cannot unassign a worker from a project they are not assigned to");
		}

		// If worker is not in companies avaiable pool, set false.
		if (!(this.available.contains(worker))) {
			isAvailable = false;
		}

		// If worker was assigned to the project, we remove them.
		worker.removeProject(project);
		project.removeWorker(worker);

		// If they are not in the comapnies avaiable pool, add them.
		if (isAvailable == false) {
			this.available.add(worker);
		}

		// If worker is no longer assigned to any projects, remove from assigned set.
		if (worker.getProjects().isEmpty()) {
			this.assigned.remove(worker);
		}

		// If we are missing Qualifications after removing worker, set status suspended.
		if (project.getStatus() == ProjectStatus.ACTIVE && !(project.getMissingQualifications().isEmpty())) {
			project.setStatus(ProjectStatus.SUSPENDED);
		}
	}

	public void unassignAll(Worker worker) {
		if (worker == null) {
			throw new IllegalArgumentException("Worker and Project Arguments may not be null");
		}
		
		Set<Project> projects = new HashSet<>(worker.getProjects());

		for (Project p : projects) {
			unassign(worker, p);
		}
	}
}
