package secretWorld.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import secretWorld.model.Project;

class ProjectTests {

	private static Project project;
	
	@BeforeEach
	void setup() {
		project = new Project();
	}
	
	@Test
	void constructorTest() {
		assert(!project.isActive());
		assert(project.getSalary() == 0);
	}

	@Test
	void salaryTest() {
		int testSalary = 17;
		project.setSalary(testSalary);
		assert(project.getSalary() == testSalary);		
	}
}
