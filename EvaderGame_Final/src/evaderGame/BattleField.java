package evaderGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Time;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class BattleField extends Canvas implements KeyListener, Runnable
{
	
	private Hero hero;

	private Backgrounds backed;
	
	private boolean[] keys;
	private BufferedImage back;

	public BattleField()
	{
		
		setBackground(Color.BLACK);

		keys = new boolean[5];

		backed = new Backgrounds();
		
		hero = new Hero();
		hero.setPos(400, 300);
		hero.setSpeed(2);
		hero.setDrawn(3);


		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	

	public void update(Graphics window)
	{
		paint(window);

		
	}

	public void paint( Graphics window )
	{
		backed.setImage();
		backed.draw(window);
		
		hero.setImage();
		hero.draw(window);
		
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
			back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.YELLOW);
		graphToBack.drawString("EVADE THE ENEMIES ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		if(keys[0] == true)
		{
			//int delX = hero.getX();
			//int delY = hero.getY();
			/*Rectangle recFill = new Rectangle();
			recFill.setBounds(delX, delY, 20, 25);*/
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("LEFT");
			hero.setDrawn(0);
			hero.setImage();
			hero.draw(window);
		}

		//add code to move stuff
		else if(keys[1] == true)
		{
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("RIGHT");
			hero.setDrawn(1);
			hero.setImage();
			hero.draw(window);
		}
		else if(keys[2] == true)
		{
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("UP");
			hero.setDrawn(2);
			hero.setImage();
			hero.draw(window);
		}
		else if(keys[3] == true)
		{
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("DOWN");
			hero.setDrawn(3);
			hero.setImage();
			hero.draw(window);
		}
		if(keys[4] == true)
		{
			
		}
		
		
		//add in collision detection with wall

		if(hero.getX()<0){
			hero.setPos(0, hero.getY());
		}
		else if(hero.getX()>(800-40)){
			hero.setPos((800-40), hero.getY());
		}
		else if(hero.getY()<0){
			hero.setPos(hero.getX(), 0);
		}
		else if(hero.getY()>(600-70)){
			hero.setPos(hero.getX(), (600-70));
		}
		//twoDGraph.drawImage(back, null, 0, 0);
				
		
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(5);
				repaint();
			}
		}catch(Exception e)
		{
		}
	}
}

