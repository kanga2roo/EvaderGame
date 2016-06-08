package evaderGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Backgrounds {
	
	private Image image;
	
	public Backgrounds()
	{
	}
	
	public void setImage(){
		
		try{
			image = ImageIO.read(new File("src/evaderGame/BACK1.png"));
		}
		catch(Exception e){}
	}


	public void draw( Graphics window )
	{
		window.drawImage(image,0,0,800,600,null);
	}

	public String toString()
	{
		return super.toString();
	}
}