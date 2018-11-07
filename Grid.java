//Billy Kelly
//Grid
//10.17.2018

import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class Grid
{

	//GLOBAL VARIABLES
	private Box[][] boxes;
	private int screenWidth, screenHeight;
	private int rows, cols;

	//----------------------------------------------<CONSTRUCTORS>----------------------------------------
	public Grid(int rows, int cols, int frameWidth, int frameHeight)
	{
		boxes = new Box[rows][cols];

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = frameWidth;
		screenHeight = frameHeight;

		int boxWidth = screenWidth / cols;
		int boxHeight = screenHeight / rows;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				boxes[i][j] = new Box(j * boxWidth, i * boxHeight, boxWidth, boxHeight);
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

		if (coords != null)
		{
			int row = coords[0];
			int col = coords[1];

			Box b = boxes[row][col];

			Sprite s = b.getSprite(spriteName);

			if (s instanceof GriddedSprite)
			{
				GriddedSprite gs = (GriddedSprite) s;
				gs.moveRight();
			}
		}
	}

	public void moveLeft(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		if (coords != null)
		{
			int row = coords[0];
			int col = coords[1];

			Box b = boxes[row][col];

			Sprite s = b.getSprite(spriteName);

			if (s instanceof GriddedSprite)
			{
				GriddedSprite gs = (GriddedSprite) s;
				gs.moveLeft();
			}
		}
	}

	public void moveUp(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		if (coords != null)
		{
			int row = coords[0];
			int col = coords[1];

			Box b = boxes[row][col];

			Sprite s = b.getSprite(spriteName);

			if (s instanceof GriddedSprite)
			{
				GriddedSprite gs = (GriddedSprite) s;
				gs.moveUp();
			}
		}
	}

	public void  moveDown(String spriteName)
	{
		int[] coords = findSpriteBox(spriteName);

		if (coords != null)
		{
			int row = coords[0];
			int col = coords[1];

			Box b = boxes[row][col];

			Sprite s = b.getSprite(spriteName);

			if (s instanceof GriddedSprite)
			{
				GriddedSprite gs = (GriddedSprite) s;
				gs.moveDown();
			}
		}
	}

	public void moveAll()
	{
		for (Box[] row : boxes)
		{
			for (Box b : row)
			{
				ArrayList<Sprite> spr = b.getBoxSprites().getSpriteList();
			}
		}
	}

	//---------------------------------------<BOX & BOX IMAGE EDITING>-----------------------------------------
	public void setBox(Box b, int row, int col)
	{
		boxes[row][col] = b;
	}

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

	public void totalDelete(String spriteName)
	{
		for (Box[] row : boxes)
			for (Box b : row)
				if (b.hasSprite(spriteName))
					b.removeSprite(spriteName);
	}

	public void resize(int width, int height)
	{
		Box[][] newBoxes = new Box[rows][cols];
		if (cols != 0 && rows != 0)
		{
			int xInterval = width / cols;
			int yInterval = height / rows;

			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
				{
					newBoxes[i][j] = new Box(j * xInterval, i * yInterval, xInterval, yInterval);
					newBoxes[i][j].setBoxImages(boxes[i][j].getBoxImages());
					newBoxes[i][j].setBoxSprites(boxes[i][j].getBoxSprites());
				}
			boxes = newBoxes;
		}
	}

	//-----------------------------------------------------<GETTERS>---------------------------------------
	public Box getBox(int row, int col)
	{return boxes[row][col];}

	public Box[][] getBoxArray()
	{return boxes;}

	public int getRows()
	{return boxes.length;}

	public int getCols()
	{return boxes[0].length;}

	public int getWidth()
	{return cols * boxes[0][0].getWidth();}

	public int getHeight()
	{return rows * boxes[0][0].getHeight();}
}
