//Billy Kelly
//RightRobot
//10.29.2018

public class RightRobot extends Robot
{
	public RightRobot(String name, Spritesheet ss, Grid g, int row, int col)
	{
		super (name, ss, g, row, col);
	}
	
	public void move()
	{
		Box[][] boxes = super.getGrid().getBoxArray();
		int row = super.getRow();
		int col = super.getCol();
		
		switch (super.getDirection())
		{
			case "UP":
				if (!boxes[row][col + 1].isNull())
				{
					super.moveRight();
					setDirection("RIGHT");
				}
				else if (!boxes[row - 1][col].isNull())
				{
					super.moveUp();
				}
				else if (!boxes[row][col - 1].isNull())
				{
					super.moveLeft();
					setDirection("LEFT");
				}
				else
				{
					super.moveDown();
					setDirection("DOWN");
				}
				break;
			case "RIGHT":
				if (!boxes[row + 1][col].isNull())
				{
					super.moveDown();
					setDirection("DOWN");
				}
				else if (!boxes[row][col + 1].isNull())
				{
					super.moveRight();
				}
				else if (!boxes[row - 1][col].isNull())
				{
					super.moveUp();
					setDirection("UP");
				}
				else
				{
					super.moveLeft();
					setDirection("LEFT");
				}
				break;
			case "DOWN":
				if (!boxes[row][col - 1].isNull())
				{
					super.moveLeft();
					setDirection("LEFT");
				}
				else if (!boxes[row + 1][col].isNull())
				{
					super.moveDown();
				}
				else if (!boxes[row][col + 1].isNull())
				{
					super.moveRight();
					setDirection("RIGHT");
				}
				else
				{
					super.moveUp();
					setDirection("Up");
				}
				break;
			case "LEFT":
				if (!boxes[row + 1][col].isNull())
				{
					super.moveDown();
					setDirection("DOWN");
				}
				else if (!boxes[row][col + 1].isNull())
				{
					super.moveRight();
				}
				else if (!boxes[row - 1][col].isNull())
				{
					super.moveUp();
					setDirection("UP");
				}
				else
				{
					super.moveDown();
					setDirection("LEFT");
				}
		}
	}
}
