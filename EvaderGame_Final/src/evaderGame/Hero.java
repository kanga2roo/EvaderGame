package evaderGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Hero extends MovingThing
{
	private int speed;
	private Image image;

	private int drawn;
	
	public Hero()
	{
		this(0,0,0);
	}

	public Hero(int x, int y)
	{
		this(x,y,0);
	}

	public Hero(int x, int y, int s)
	{
		super(x, y);
		speed=s;
	}
	
	public void setImage(){
		if(drawn == 0){
			try{
				image = ImageIO.read(new File("src/evaderGame/LinkLEFT.gif"));
			}
			catch(Exception e){}
		}
		else if(drawn == 1){
			try{
				image = ImageIO.read(new File("src/evaderGame/LinkRIGHT.gif"));
			}
			catch(Exception e){}
		}
		else if(drawn == 2){
			try{
				image = ImageIO.read(new File("src/evaderGame/LinkUP.gif"));
			}
			catch(Exception e){}
		}
		else if(drawn == 3){
			try{
				image = ImageIO.read(new File("src/evaderGame/LinkDOWN.gif"));
			}
			catch(Exception e){}
		}
		else if(drawn == 4){
			try{
				image = ImageIO.read(new File("src/evaderGame/BACK.gif"));
			}
			catch(Exception e){}
		}
	}
	
	public void setDrawn(int d){
		drawn = d;
	}


	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),20,25,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
