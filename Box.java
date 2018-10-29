//Billy Kelly
//9.7.2018
//Box Class

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.awt.geom.*;

public class Box
{
  //Variables for box
	private Color color = null;
	private int x;
	private int y;
	private int width;
	private int height;

	//Arrays of objects to draw
	private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	//Variables for scaling images
	private AffineTransform tx;
	private double scaleX = 1.0, scaleY = 1.0;

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
		images.add(img);

		tx = new AffineTransform();
		tx.scale(scaleX, scaleY);
	}

	//--------------------------------------------<DRAW>--------------------------------------

	public void draw(Graphics g)
	{
		if (color != null)
		{
			Color temp = g.getColor();
			g.setColor(color);
			g.fillRect(x, y, width, height);
			g.setColor(temp);
		}

    	Graphics2D g2d = (Graphics2D)g;

		for (Image i : images)
			g2d.drawImage(i, x, y, null);

		for (Shape s : shapes)
			g2d.draw(s);
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

	//---------------------------------<Adders for Images and Shapes>------------------------
	public void addImage(BufferedImage i)
	{images.add(i);}

	public void addShape(Shape s)
	{shapes.add(s);}

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

	public BufferedImage getImage(int index)
	{return images.get(index);}

}//end Class