package evaderGame;

import java.util.ArrayList;

public class Balls {

	private ArrayList <Ball> balls = new ArrayList<Ball>();

	public Balls()
	{
		setBalls(0);
	}

	public Balls(int size)
	{
		balls = new ArrayList<Ball>(size);
	}
	
	public void setBalls(int size)
	{
		//size the array
		balls = new ArrayList<Ball>(size);
		
	}
	
	public void add(int spot, Ball m)
	{
		//put m in the Monster array at [spot]
		balls.add(spot, m);
	}
	
	public Ball get(int spot)
	{
		return balls.get(spot);
	}

	
	public String toString()
	{
		return "";
	}
}

