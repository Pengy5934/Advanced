//Billy Kelly
//EndPoint
//10.29.2018

import java.awt.*;
import java.util.ArrayList;

public class EndPoint extends Box
{
	public EndPoint(int x, int y, int width, int height)
	{
		super (x, y, width, height);
	}

	public void update(Graphics g, Grid gr)
	{
		drawn(g);
	}

	private void drawn(Graphics g)
	{
		Color temp = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(temp);
		super.draw(g);
	}
}
