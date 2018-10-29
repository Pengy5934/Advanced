//Billy Kelly
//9.7.2018
//Grid Class

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Grid
{
	//---------------------------------------------<GLOBAL VARIABLES>------------------------------------------------------

	//Constants
	private int SCREEN_WIDTH = 900;
	private int SCREEN_HEIGHT = 900;
	private int ROWS = 10;
	private int COLS = 10;
	private int BUFFER = 5;
    private int X_INTERVAL = SCREEN_WIDTH / COLS;
    private int Y_INTERVAL = SCREEN_HEIGHT / ROWS;
	private int BOX_WIDTH = (SCREEN_WIDTH - (BUFFER * COLS)) / COLS;
	private int BOX_HEIGHT = (SCREEN_HEIGHT - (BUFFER * ROWS)) / ROWS;
	private final Color BOX_COLOR = Color.WHITE;

	Box[][] grid = new Box[COLS][ROWS];

	//----------------------------------------------<CONSTRUCTORS>-----------------------------------------------------------

	public Grid()
	{
		for (int i = 0; i < COLS; i++)
			for (int j = 0; j < ROWS; j++)
			{
				grid[i][j] = new Box((j * X_INTERVAL) + BUFFER, (i * Y_INTERVAL) + BUFFER, BOX_WIDTH, BOX_HEIGHT, BOX_COLOR);
			}
		grid[0][0] = new Box(5, 5, BOX_WIDTH, BOX_HEIGHT, BOX_COLOR);
	}

	public Grid(int rows, int cols)
	{
		ROWS = rows;
		COLS = cols;
		BOX_WIDTH = (SCREEN_WIDTH - (BUFFER * COLS)) / COLS;
		BOX_HEIGHT = (SCREEN_HEIGHT - (BUFFER * ROWS)) / ROWS;
		X_INTERVAL = SCREEN_WIDTH / COLS;
		Y_INTERVAL = SCREEN_HEIGHT / ROWS;
		grid = new Box[COLS][ROWS];

		for (int i = 0; i < COLS; i++)
			for (int j = 0; j < ROWS; j++)
			{
				grid[i][j] = new Box((j * X_INTERVAL) + BUFFER, (i * Y_INTERVAL) + BUFFER, BOX_WIDTH, BOX_HEIGHT, BOX_COLOR);
			}
	}

	//-------------------------------------------------<DRAWING>--------------------------------------------------

	public void draw(Graphics g)
	{
		for (int i = 0; i < COLS; i++)
			for (int j = 0; j < ROWS; j++)
				grid[i][j].draw(g);
	}
	//---------------------------------------------<GET ROWS AND COLS>-----------------------------------------------

	public int getBoxX(int c)
	{return grid[0][c].getX();}

	public int getBoxY(int c)
	{return grid[c][0].getY();}

	public Box getBox(int row, int col)
	{return grid[row][col];}

	public Grid getGrid()
	{return this;}

	public int getRows()
	{return ROWS;}

	public int getCols()
	{return COLS;}

	public int getXInterval()
	{return X_INTERVAL;}

	public int getYInterval()
	{return Y_INTERVAL;}

	public int getBoxWidth()
	{return BOX_WIDTH;}

	public int getBoxHeight()
	{return BOX_HEIGHT;}

	//---------------------------------------------<SET ROWS AND COLS>-----------------------------------------------

	public void setRows(int r)
	{
		ROWS = r;
		grid = new Box[COLS][ROWS];
	}

	public void setCols(int c)
	{
		COLS = c;
		grid = new Box[COLS][ROWS];
	}

	public void setBoxWidth(int w)
	{
		BOX_WIDTH = w;
		for (Box[] b : grid)
			for (Box box : b)
				box.setWidth(w);
	}

	public void setBoxHeight(int h)
	{
		BOX_HEIGHT = h;
		for (Box[] b : grid)
			for (Box box : b)
				box.setHeight(h);
	}

	public void addBoxImage(BufferedImage i, int row, int col)
	{
		grid[row][col].addImage(i);
	}

}//end class
