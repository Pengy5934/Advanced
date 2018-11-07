//Billy Kelly
//Maze
//10.17.2018

import java.awt.*;
import java.util.Random;

public class Maze extends Grid
{
	public Maze(int rows, int cols, int frameWidth, int frameHeight)
	{
		super (rows, cols, 900, 900);
	}

	public void integrateIntMap(int[][] intMap)
	{
		for (int i = 0; i < intMap.length; i++)
			for (int j = 0; j < intMap[0].length; j++)
				if (intMap[i][j] == 1)
					super.setNull(i, j);
				else if (intMap[i][j] == 2)
				{
					Box[][] boxes = getBoxArray();
					Box b = boxes[i][j];
					b = new StartPoint(b.getX(), b.getY(), b.getWidth(), b.getHeight());
					b.setType("START");
					setBox(b, i, j);
				}
				else if (intMap[i][j] == 3)
				{
					Box b = super.getBoxArray()[i][j];
					b = new EndPoint(b.getX(), b.getY(), b.getWidth(), b.getHeight());
					b.setType("END");
					setBox(b, i, j);
				}
	}

	public void moveRobots()
	{
		for (Box[] row : getBoxArray())
			for (Box b : row)
				b.getBoxSprites().moveRobots();
	}

	public int findStartPointCol()
	{
		return findStartPoint()[1];
	}

	public int findStartPointRow()
	{
		return findStartPoint()[0];
	}

	public int[] findStartPoint()
	{
		Box[][] boxes = getBoxArray();
		for (int row = 0; row < boxes.length; row++)
			for (int col = 0; col < boxes[row].length; col++)
			{
				if (boxes[row][col].getType().equalsIgnoreCase("START"))
					return new int[]{row, col};
			}
		return findSpawnPoint();
	}

	public int[] findSpawnPoint()
	{
		Random r =  new Random();

		int row = r.nextInt(getRows());
		int col = r.nextInt(getCols());

		if (!getBoxArray()[row][col].isNull())
			return new int[]{row, col};
		return findSpawnPoint();
	}

}
