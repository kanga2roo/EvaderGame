package evaderGame;

import javax.swing.JFrame;
import java.awt.Component;

public class EvaderGame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public EvaderGame()
	{
		super("Hero's Evasion Challenge");
		setSize(WIDTH,HEIGHT);

		BattleField theGame = new BattleField();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		
		
	}

	public static void main( String args[] )
	{
		EvaderGame run = new EvaderGame();
	}
}