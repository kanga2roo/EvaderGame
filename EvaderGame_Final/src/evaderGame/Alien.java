package evaderGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/unit17_starFighter/alien.JPG"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
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

	public void draw( Graphics window )
	{
		int x = 0;
		int y = 0;
		
		int rand = (int)(2*(Math.random()));
		if(rand == 0){
			x = (int)(400*Math.random());
			y = 0;	
		}
		else{
			x = 0;
			y = (int)(400*Math.random());
		}
		
		window.drawImage(image,getX(),getY(),x,y,null);
	}

	public String toString()
	{
		return "";
	}

	
}
