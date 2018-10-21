//Billy Kelly
//Grid Driver
//9.12.2018

import java.util.Scanner;

public class GridDriver
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int rows = scan.nextInt();
		System.out.println("\nEnter number of columns");
		int cols = scan.nextInt();
		Grid g = new Grid(rows, cols);
	}
}
