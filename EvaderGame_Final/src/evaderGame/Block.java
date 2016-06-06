package evaderGame;

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
 
	private Color color;

	public Block(){
		this(0,0,0,0, Color.BLACK);
	}

	public Block(int x, int y) {
		this(x,y,0,0,Color.BLACK);	
	}

	public Block(int x, int y, int wid, int ht) {
		this(x,y,wid,ht, Color.BLACK);	
	}

	public Block(int x, int y, int wid, int ht, Color col) {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
	}

	//add other Block constructors - x , y , width, height, color
	//add the other set methods

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public void setPos(int xPos, int yPos){
		setX(xPos);
		setY(yPos);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color col){
		this.color=col;
	}

	public void draw(Graphics window)
	{
		//uncomment after you write the set and get methods
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col)
	{
		color = col;
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj)
	{
		Block other= (Block) obj;
		if(xPos == other.xPos 
				&& yPos == other.yPos
				&& width == other.width
				&& height == other.height
				&& color == other.color){
			return true;
		}

		else return false;
	}

	@Override
	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color;
	}   
}