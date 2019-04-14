package secretWorld;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import secretWorld.Controller.KeyHandler;
import secretWorld.model.GameModel;

public class GameView {
	private GameModel gameModel;
	private JFrame frame;
	
	public GameView(GameModel gameModel)
	{
		this.gameModel = gameModel;
	}
	
	private Container generateView()
	{
		Container container = new JPanel();
		
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        container.add(label);

        container.setBackground(this.gameModel.isFlag() ? Color.gray : Color.cyan);
        
        return container;
	}
	
	public void update()
	{
		frame.setContentPane(generateView());
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	public void createMainWindow(KeyHandler keyHandler)
	{
        //Create and set up the window.
        frame = new JFrame("a secret world");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("a secret world");

        //Display the window.
        frame.setVisible(true);
        frame.addKeyListener(keyHandler);
        update();
	}
}
