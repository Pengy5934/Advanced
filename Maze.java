//Billy Kelly
//Maze
//10.17.2018

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
	}
}
