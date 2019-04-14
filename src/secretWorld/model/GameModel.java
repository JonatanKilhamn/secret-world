package secretWorld.model;

import java.util.HashSet;
import java.util.Set;

public class GameModel {
	
	private boolean flag;
	private int funds;
	private Set<Project> projects;
	
	public boolean isFlag() {
		return flag;
	}

	public void stepTime() {
		this.flag = !this.flag;
		for (Project p : this.projects) {
			if (p.isActive()) {
				// Same salary for all projects
				this.funds += p.getSalary();
			}
		}
	}
	
	public void startNewGame() {
		setProjects(new HashSet<Project>());
	}

	public int getFunds() {
		return funds;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project) {
		this.projects.add(project);
	}

}
