//Billy Kelly
//MazeReader
//10.22.2018

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MazeReader
{
	private static Scanner scan;
	private static FileReader reader;


	public static int[][] getIntMap(String paramString)
	{
		int[][] intMap = new int[0][0];

		try
		{
			reader = new FileReader(paramString);
			scan = new Scanner(reader);

			ArrayList<String> linesWithCommas = new ArrayList<String>();
			ArrayList<String> digits = new ArrayList<String>();

			while (scan.hasNext())
			{
				String str = scan.next();
				linesWithCommas.add(str);
			}

			for (String s : linesWithCommas)
			{
				scan = new Scanner(s);
				scan.useDelimiter(",");

				while (scan.hasNext())
				{
					String digit = scan.next();
					digits.add(digit);
				}
			}

			intMap = new int[linesWithCommas.size()][digits.size() / linesWithCommas.size()];
			int index = 0;

			for (int i = 0; i < intMap.length; i++)
			{
				for (int j = 0; j < intMap[0].length; j++)
				{
					intMap[i][j] = Integer.parseInt(digits.get(index++));
				}
			}
		}
		catch (Exception ex)
		{ex.printStackTrace();}

		return intMap;
	}

	public static int[][] getIntMap(File f, int rows, int cols)
	{
		int[][] intMap = new int[rows][cols];

		try {
			FileReader fr = new FileReader(f);
			scan = new Scanner(fr);
			scan.useDelimiter(",");

			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
				{
					String s = scan.next();
					switch(s)
					{
						case "0":
							intMap[i][j] = 0;
						case "1":
							intMap[i][j] = 1;
							break;
						case "2":
							intMap[i][j] = 2;
							break;
						case "3":
							intMap[i][j] = 3;
					}
				}
		}
		catch(Exception ex)
		{ex.printStackTrace();}

		return intMap;
	}
}