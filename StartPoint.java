//Billy Kelly
//StartPoint
//10.29.2018

import java.awt.*;

public class StartPoint extends Box
{
	public StartPoint(int x, int y, int width, int height, int row, int col)
	{
		super (x, y, width, height, row, col);
	}

	public void update(Graphics g, Grid gr, Sprite s)
	{
		drawn(g);
		action(gr, s);
	}

	private void drawn(Graphics g)
	{
		super.draw(g);
		Color temp = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(temp);
	}

	private void action(Grid gr, Sprite s)
	{
		gr.getBoxArray()[getRow()][getCol()].addSprite(s);
	}
}
