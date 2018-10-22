//Billy Kelly
//Sprite

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite
{
	private Spritesheet ss;
	private int x, y;
	private int width, height;

	public Sprite(BufferedImage b, int rows, int cols, int x, int y, int width, int height)
	{
		ss = new Spritesheet(b, rows, cols);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Sprite(Spritesheet s, int x, int y, int width, int height)
	{
		ss = s;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g)
	{
		g.drawImage(ss.getCurrentImage(), x, y, null);
	}

	public void animate()
	{ss.animate();}

	public void switchAnimation(int row)
	{ss.setRow(row);}

	public void switchAnimation()
	{ss.setRow(ss.getRow() + 1);}

	public void switchBackAnimation()
	{ss.setRow(ss.getRow() - 1);}

	//---------------------------------------------<GETTERS>-----------------------------------------
	public Spritesheet getSpritesheet()
	{return ss;}

	public int getX()
	{return x;}

	public int getY()
	{return y;}

	public int getWidth()
	{return width;}

	public int getHeight()
	{return height;}

	//---------------------------------------------<SETTERS>-------------------------------------------
	public void setX(int newX)
	{x = newX;}

	public void setY(int newY)
	{y = newY;}

	//public void setWidth(int newWidth)
	//{
}