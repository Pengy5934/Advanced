//Billy Kelly
//9.7.2018
//Box Class

import java.awt.*;
import java.awt.image.BufferedImage;

public class Box
{
	private Color color = null;
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage img = null;

	public Box(int x, int y, int width, int height, Color c)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = c;
	}

	public Box(int x, int y, int width, int height, BufferedImage img)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = img;
	}

	public void draw(Graphics g)
	{
		if (color != null)
		{
			Color temp = g.getColor();
			g.setColor(color);
			g.fillRect(x, y, width, height);
			g.setColor(temp);
		}
		else if (img != null)
		{
			g.drawImage(img, x, y, null);
		}
	}//end draw

	public boolean checkInBounds(int x, int y)
	{
		boolean horizontal = false;
		boolean vertical = false;

		if (this.x <= x && x <= this.x + width)
			horizontal = true;

		if (this.y <= y && this.y + height >= y)
			vertical = true;

		if (horizontal && vertical)
			return true;
		return false;
	}

	//--------------------------<Setters for x, y, width, height, and color>-------------------------------
	public void setX(int x)
	{this.x = x;}

	public void setY(int y)
	{this.y = y;}

	public void setWidth(int w)
	{width = w;}

	public void setHeight(int h)
	{height = h;}

	public void setColor(Color c)
	{color = c;}

	public void setImage(BufferedImage img)
	{this.img = img;}

	//---------------------------<Getters for x, y, width, height, and color>----------------------------------
	public int getX()
	{return x;}

	public int getY()
	{return y;}

	public int getWidth()
	{return width;}

	public int getHeight()
	{return height;}

	public Color getColor()
	{return color;}

	public BufferedImage getImage()
	{return img;}

}//end Class