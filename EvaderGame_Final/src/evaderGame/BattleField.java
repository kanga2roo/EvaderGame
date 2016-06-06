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
	private Enemy one;
	private Backgrounds backed;

	private ArrayList <Ball> balls = new ArrayList<Ball>();

	private int x;
	private int y;
	private int x1;
	private int y1;

	private int enemybuffer;

	private boolean[] keys;
	private BufferedImage back;

	private int instruction;

	private int score;

	public BattleField()
	{
		score = 0;

		setBackground(Color.BLACK);

		keys = new boolean[5];

		backed = new Backgrounds();

		instruction = 50;

		one = new Enemy();
		one.setSpeed(1);
		one.setDrawn(0);

		hero = new Hero();
		hero.setPos(400, 300);
		hero.setSpeed(2);
		hero.setDrawn(3);

		enemybuffer = 100;

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}


	public void update(Graphics window)
	{
		paint(window);

		for(int i = 0; i<balls.size(); i++){
			balls.get(i).moveAndDraw(window);
			balls.get(i).draw(window);

			if(hero.getX()>=balls.get(i).getX()
					&& hero.getX()+20<=balls.get(i).getX()+50){
				score = 0;
			}
		}
		scorePaint(window);
	}

	public void paint( Graphics window )
	{
		final Ball ball = new Ball();

		if(enemybuffer==0){
			int rand = (int)(2*(Math.random()));
			if(rand == 0){
				x = (int)(800*Math.random());
				y = 0;	
				x1 = 4;
				y1 = 8;
			}
			else{
				x = 0;
				y = (int)(600*Math.random());
				x1 = 8;
				y1 = 4;
			}	
			ball.setPos(x, y);
			ball.setHeight(50);
			ball.setWidth(50);
			ball.setXSpeed(x1);
			ball.setYSpeed(y1);
			balls.add(ball);
			ball.moveAndDraw(window);
			score ++;
			enemybuffer = 200;
		}


		backed.setImage();
		backed.draw(window);

		hero.setImage();
		hero.draw(window);

		ball.moveAndDraw(window);


		while(instruction>0){
			window.setColor(Color.CYAN);
			window.drawString("Dodge the Enemies!", 400, 300);
			instruction--;
		}


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
		if(keys[1] == true)
		{
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("RIGHT");
			hero.setDrawn(1);
			hero.setImage();
			hero.draw(window);
		}
		if(keys[2] == true)
		{
			hero.setDrawn(4);
			hero.setImage();
			hero.draw(window);
			hero.move("UP");
			hero.setDrawn(2);
			hero.setImage();
			hero.draw(window);
		}
		if(keys[3] == true)
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


		//see if the ball hits the left or right wall 
		if(!(ball.getX()>=0 && ball.getX()<=800))
		{ 
			ball.setXSpeed(-ball.getXSpeed());
		}

		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=0 && ball.getY()<=600))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}




		enemybuffer--;

		//drawing enemies
		/*	int countdown = 6;


		one.setDrawn(1);	
		one.draw(window);

			if(one.x>one.y && enemybuffer == 1000){
				one.setDrawn(1);
				one.draw(window);
				one.setDrawn(0);
				one.move("DOWN");
				enemybuffer-=10;
			}
			if(one.y>one.x && enemybuffer == 0){
				one.move("RIGHT");
				enemybuffer+=10;
			}
			countdown--;
		 */

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
		//repaint();
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
		//repaint();
	}

	public void scorePaint(Graphics window){

		String str = new String();
		str = "Survival Score == "+score;
		window.drawString(str, 100, 100);
		
	}
	
	public void keyTyped(KeyEvent e){}

	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(10);
				repaint();
			}
		}catch(Exception e)
		{
		}


	}	
}

