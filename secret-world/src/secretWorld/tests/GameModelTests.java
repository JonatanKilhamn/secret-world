package secretWorld.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import secretWorld.model.GameModel;
import secretWorld.model.Project;

class GameModelTests {

	static GameModel gameModel;
	
	@BeforeEach
	void setup() {
		gameModel = new GameModel();
		gameModel.startNewGame();
	}
	
	@Test
	void startNewGameTest() {
		assert(gameModel.getProjects() != null);
		assert(gameModel.getFunds() == 0);
		
		// Remove this soon
		boolean flagBefore = gameModel.isFlag();
		gameModel.stepTime();
		boolean flagAfter = gameModel.isFlag();
		assert(flagBefore != flagAfter);
	}

	@Test
	void salaryTest() {
		Project work = new Project();
		gameModel.addProject(work);

		// No salary in default case
		int fundsBefore = gameModel.getFunds();
		gameModel.stepTime();
		int fundsAfter = gameModel.getFunds();
		assert(fundsBefore == fundsAfter);
		
		// Work on a project with 0 salary:
		work.setActive(true);
		gameModel.stepTime();
		assert(gameModel.getFunds() == fundsBefore);

		// Work on a project with non-zero salary:
		int testSalary = 4;
		work.setSalary(testSalary);
		gameModel.stepTime();
		assert(gameModel.getFunds() == (fundsBefore + testSalary));
	}
	
}
