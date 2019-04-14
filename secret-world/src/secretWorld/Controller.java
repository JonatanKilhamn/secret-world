package secretWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import secretWorld.model.GameModel;

public class Controller {
	
	GameModel gameModel;
	GameView gameView;
	
    public Controller() {
    	// Create game model
    	this.gameModel = new GameModel();
    	this.gameView = new GameView(this.gameModel);
    }

    private void startGame() {
    	gameModel.startNewGame();
    	KeyHandler keyHandler = new KeyHandler();
    	gameView.createMainWindow(keyHandler);
    }

    public static void main(String[] args) {
    	Controller controller = new Controller();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	controller.startGame();
            }
        });
    }
    
    class KeyHandler implements KeyListener
    {
		@Override
		public void keyTyped(KeyEvent e) {
			// Do nothing
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				gameModel.stepTime();
			}
			gameView.update();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Do nothing
		}
    }
}