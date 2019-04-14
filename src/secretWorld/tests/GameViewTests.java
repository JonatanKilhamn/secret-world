package secretWorld.tests;

import org.junit.jupiter.api.Test;

import secretWorld.GameView;
import secretWorld.model.GameModel;

class GameViewTests {

	@Test
	void test() {
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView(gameModel);
		gameView.createMainWindow(null);
		gameView.update();
		assert(true);
	}

	@Test
	void updateWithoutCreateMainWindowFailureTest() {
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView(gameModel);
		boolean caughtNullPointerException = false;
		try
		{
			gameView.update();
		}
		catch (NullPointerException e)
		{
			caughtNullPointerException = true;
		}
		assert(caughtNullPointerException);
	}

}
