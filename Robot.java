//Billy Kelly
//Robot

public abstract class Robot extends GriddedSprite
{
	private String direction = "UP";
	
	public Robot(String name, Spritesheet s, Grid gr, int row, int col)
	{
		super (name, s, gr, row, col);
	}
	
	public abstract void move();
	
	//---------------------------------------------------------<SETTERS>----------------------------------------------------
	public void setDirection(String d)
	{
		if (d.equalsIgnoreCase("UP") || d.equalsIgnoreCase("RIGHT") || d.equalsIgnoreCase("DOWN") || d.equalsIgnoreCase("LEFT"))
			direction = d;
	}
	
	//---------------------------------------------------------<GETTERS>-----------------------------------------------------
	public String getDirection()
	{return direction;}
}
