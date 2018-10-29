//Billy Kelly
//Sprite

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.*;

public class Sprite
{
	private Spritesheet ss;
	private int x, y;
	private int width, height;

	private AffineTransform tx;
	private double scaleX, scaleY;

	//-----------------------------------------<CONSTRUCTORS>-----------------------------------
	public Sprite(BufferedImage b, int rows, int cols, int x, int y, int width, int height)
	{
		ss = new Spritesheet(b, rows, cols);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		scaleX = (double)width / (double)ss.getCurrentImage().getWidth();
		scaleY = (double)height / (double)ss.getCurrentImage().getHeight();

		tx = new AffineTransform();
		tx.scale(scaleX, scaleY);
	}

	public Sprite(Spritesheet s, int x, int y, int width, int height)
	{
		ss = s;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		scaleX = (double)width / (double)ss.getCurrentImage().getWidth();
		scaleY = (double)height / (double)ss.getCurrentImage().getHeight();

		tx = new AffineTransform();
		tx.scale(scaleX, scaleY);
	}

	public Sprite(Spritesheet s, Box b)
	{
		ss = s;
		x = b.getX();
		y = b.getY();
		width = b.getWidth();
		height = b.getHeight();

		scaleX = (double)width / (double)ss.getCurrentImage().getWidth();
		scaleY = (double)height / (double)ss.getCurrentImage().getHeight();

		tx = new AffineTransform();
		tx.scale(scaleX, scaleY);
	}

	//-----------------------------------------<DRAW AND ANIMATE>---------------------------------------
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.transform(tx);
		g2d.drawImage(ss.getCurrentImage(), x, y, null);
		System.out.println(x + ", " + y);
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