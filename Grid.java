//Billy Kelly
//9.7.2018
//Grid Class

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Grid extends JFrame implements MouseMotionListener
{
	//---------------------------------------------<GLOBAL VARIABLES>------------------------------------------------------

	Container c;

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

	//-----------------------------------------------<CONSTRUCTOR>-----------------------------------------------------------

	public Grid()
	{
		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setSize(new Dimension(SCREEN_WIDTH + 15, SCREEN_HEIGHT + 25));
		this.setVisible(true);

		for (int i = 0; i < COLS; i++)
			for (int j = 0; j < ROWS; j++)
			{
				grid[i][j] = new Box((j * X_INTERVAL) + BUFFER, (i * Y_INTERVAL) + BUFFER, BOX_WIDTH, BOX_HEIGHT, BOX_COLOR);
			}
		grid[0][0] = new Box(5, 5, BOX_WIDTH, BOX_HEIGHT, BOX_COLOR);

		addMouseMotionListener(this);
		repaint();
	}

	public Grid(int rows, int cols)
	{
		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setSize(new Dimension(SCREEN_WIDTH + 15, SCREEN_HEIGHT + 25));
		this.setVisible(true);

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

		addMouseMotionListener(this);
		repaint();
	}

	//-------------------------------------------------<DRAWING>--------------------------------------------------

	public class DrawingPanel extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.BLACK);
			g.fillRect(-100, -100, 1000, 1000);

			for (int i = 0; i < COLS; i++)
				for (int j = 0; j < ROWS; j++)
					grid[i][j].draw(g);
		}//end paint Component
	}//end drawingPanel

	//----------------------------------------------<MOUSE MOTION>------------------------------------------------------

	public void mouseMoved(MouseEvent e)
	{
		for (int i = 0; i < COLS; i++)
			for (int j = 0; j < ROWS; j++)
				if (grid[i][j].checkInBounds(e.getX(), e.getY()))
				{
					grid[i][j].setColor(Color.GREEN);
					System.out.println("Box: " + i + ", " + j + " |||| " + e.getX() + ", " + e.getY() + " ||\n|| " + grid[i][j].getX() + " -- " + grid[i][j].getWidth() + " |||| " + grid[i][j].getY() + " -- " + grid[i][j].getHeight());
				}
				else
					grid[i][j].setColor(BOX_COLOR);
		repaint();
	}

	public void mouseDragged(MouseEvent e)
	{}

	//---------------------------------------------<GET ROWS AND COLS>-----------------------------------------------

	public int getRows()
	{return ROWS;}

	public int getCols()
	{return COLS;}

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

}//end class
