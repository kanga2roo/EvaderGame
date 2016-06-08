package evaderGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Enemy extends MovingThing
{
	private int speed;
	private Image image;
	public int x = 0;
	public int y = 0;

	private int enemyDraw;



	public Enemy()
	{
		if(enemyDraw == 0){
			try
			{
				image = ImageIO.read(new File("src/evaderGame/mush.png"));
			}
			catch(Exception e)
			{		}
		}
		else if(enemyDraw == 1){
			try{
				image = ImageIO.read(new File("src/evaderGame/BACK.gif"));
			}
			catch(Exception e){}
		}
	}

	public void setDrawn(int d){
		enemyDraw = d;
	}

	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void delete(Graphics window){
		window.drawRect(getX(), getY(), 80, 80);
	}

	public void coordinateSet(){
		int rand = (int)(2*(Math.random()));
		if(rand == 0){
			x = (int)(800*Math.random());
			y = 0;	
		}
		else{
			x = 0;
			y = (int)(600*Math.random());
		}
	}

	public void draw( Graphics window )
	{
		coordinateSet();
		window.drawImage(image,x,y,30,30,null);
	}

	public String toString()
	{
		return "";
	}


}
