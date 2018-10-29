//Billy Kelly
//Grid
//10.17.2018

import java.awt.*;
import java.awt.image.*;

public class Grid
{

	//GLOBAL VARIABLES
	private Box[][] boxes;
	private int screenWidth, screenHeight;
	private int boxWidth, boxHeight;
	private int rows, cols;

	//----------------------------------------------<CONSTRUCTORS>----------------------------------------
	public Grid(int rows, int cols, int frameWidth, int frameHeight)
	{
		boxes = new Box[rows][cols];

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = frameWidth;
		screenHeight = frameHeight;

		boxWidth = screenWidth / cols;
		boxHeight = screenHeight / rows;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				boxes[i][j] = new Box(j * boxWidth, i * boxHeight, boxWidth, boxHeight, i, j);
	}

	public void draw(Graphics g)
	{
		for (Box[] row : boxes)
			for (Box b : row)
				b.draw(g);
	}

	//--------------------------------------------<MOVEMENT>------------------------------------------------
	public void moveRight(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		int row = coords[0];
		int col = coords[1];

		if (coords != null && !boxes[row][col + 1].isNull())
		{
			if (col > 0 && col < boxes[row].length)
			{
				Sprite s = boxes[row][col].getSprite(spriteName);
				boxes[row][col].removeSprite(s.getName());
				boxes[row][col + 1].addSprite(s);
			}
		}
	}

	public void moveLeft(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		int row = coords[0];
		int col = coords[1];

		if (coords != null && !boxes[row][col - 1].isNull())
		{
			if (col > 0 && col < boxes[row].length)
			{
				Sprite s = boxes[row][col].getSprite(spriteName);
				boxes[row][col].removeSprite(s.getName());
				boxes[row][col - 1].addSprite(s);
			}
		}
	}

	public void moveUp(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		int row = coords[0];
		int col = coords[1];

		if (coords != null && !boxes[row - 1][col].isNull())
		{
			if (row > 0 && row < boxes.length)
			{
				Sprite s = boxes[row][col].getSprite(spriteName);
				boxes[row][col].removeSprite(s.getName());
				boxes[row - 1][col].addSprite(s);
			}
		}
	}

	public void  moveDown(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		int row = coords[0];
		int col = coords[1];

		if (coords != null && !boxes[row + 1][col].isNull())
		{
			if (row > 0 && row < boxes.length)
			{
				Sprite s = boxes[row][col].getSprite(spriteName);
				boxes[row][col].removeSprite(s.getName());
				boxes[row + 1][col].addSprite(s);
			}
		}
	}

	//---------------------------------------<BOX & BOX IMAGE EDITING>-----------------------------------------

	public void setImages(BufferedImage b)
	{
		for (Box[] row : boxes)
			for (Box box : row)
				box.addImage(b);
	}

	public void setNull(int row, int col)
	{
		boxes[row][col].setNull(true);
	}

	public void setNullImages(BufferedImage b)
	{
		for (Box[] row : boxes)
			for (Box box : row)
				box.setNullImage(b);
	}

	public void setNullImage(BufferedImage bi, int row, int col)
	{
		boxes[row][col].setNullImage(bi);
	}

	//Method always return an array of length 2: first element is the row, second is the column
	public int[] findSpriteBox(String name)
	{
		for (Box[] row : boxes)
			for (Box b : row)
				if (b.hasSprite(name))
					return new int[]{b.getRow(), b.getCol()};
		return null;
	}

	public void addSprite(Sprite s, int row, int col)
	{
		boxes[row][col].addSprite(s);
	}

	//-----------------------------------------------------<GETTERS>---------------------------------------
	public Box getBox(int row, int col)
	{return boxes[row][col];}

	public Box[][] getBoxArray()
	{return boxes;}
}
