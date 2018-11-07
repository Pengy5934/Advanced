//Billy Kelly
//StartPoint
//10.29.2018

import java.awt.*;

public class StartPoint extends Box
{
	public StartPoint(int x, int y, int width, int height)
	{
		super (x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		Color temp = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(temp);
		super.draw(g);
	}

}
