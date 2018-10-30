//Billy Kelly
//EndPoint
//10.29.2018

import java.awt.*;
import java.util.ArrayList;

public class EndPoint extends Box
{
	public EndPoint(int x, int y, int width, int height, int row, int col)
	{
		super (x, y, width, height, row, col);
	}

	public void update(Graphics g, Grid gr)
	{
		drawn(g);
		if (getBoxSprites().getSpriteList().size() != 0)
			action(gr);
	}

	private void drawn(Graphics g)
	{
		super.draw(g);
		Color temp = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(temp);
	}

	private void action(Grid gr) //Remove Sprite
	{
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Sprite> sprs = getBoxSprites().getSpriteList();

		for (Sprite s : sprs)
			names.add(s.getName());

		for (String n : names)
			removeSprite(n);
	}
}
