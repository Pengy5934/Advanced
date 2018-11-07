//Billy Kelly
//Random Robot
//10.29.2018

import java.util.Random;

public class RandomRobot extends Roboto
{
	private Random r = new Random();

	public RandomRobot(String name, Spritesheet ss, Grid g, int row, int col)
	{
		super (name, ss, g, row, col);
	}

	public void move()
	{
		int direction = r.nextInt(4);

		switch (direction)
		{
			case 0:
				super.setDirection("UP");
				super.moveUp();
				break;
			case 1:
				super.setDirection("RIGHT");
				super.moveRight();
				break;
			case 2:
				super.setDirection("DOWN");
				super.moveDown();
				break;
			case 3:
				super.setDirection("LEFT");
				super.moveLeft();
		}

	}
}
