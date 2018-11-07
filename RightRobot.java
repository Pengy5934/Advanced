//Billy Kelly
//RightRobot
//10.29.2018

public class RightRobot extends Roboto
{
	public RightRobot(String name, Spritesheet ss, Grid g, int row, int col)
	{
		super (name, ss, g, row, col);
	}

	public RightRobot(String name, Spritesheet ss, Grid g, StartPoint sp)
	{
		super (name, ss, g, sp.getRow(), sp.getCol());
	}

	public void move()
	{
		/*if (getDirection().equalsIgnoreCase("UP"))
		{
			if (!moveRobotRight())
				if (!moveRobotUp())
					if (!moveRobotLeft())
					{
						boolean b = moveRobotDown();
					}
		}
		else if (getDirection().equalsIgnoreCase("RIGHT"))
		{
			if (!moveRobotDown())
				if (!moveRobotRight())
					if (!moveRobotUp())
					{
						boolean b = moveRobotLeft();
					}
		}
		else if (getDirection().equalsIgnoreCase("DOWN"))
		{
			if (!moveRobotLeft())
				if (!moveRobotDown())
					if (!moveRobotRight())
					{
						boolean b = moveRobotUp();
					}
		}
		else if (getDirection().equalsIgnoreCase("LEFT"))
		{
			if (!moveRobotUp())
				if (!moveRobotLeft())
					if (!moveRobotDown())
					{
						boolean b = moveRobotRight();
					}
		}*/

		System.out.print(getDirection());
		switch (getDirection())
		{
			case "UP":
				if (!getRightBox().isNull())
				{
					moveRight();
					setDirection("RIGHT");
				}
				else if (!getUpBox().isNull())
				{
					System.out.println("UP IS FREE");
					moveUp();
				}
				else if (!getLeftBox().isNull())
				{
					moveLeft();
					setDirection("LEFT");
				}
				else if (!getDownBox().isNull())
				{
					moveDown();
					setDirection("DOWN");
				}
				System.out.println(" to " + getDirection());
				break;
			case "RIGHT":
				if (!getDownBox().isNull())
				{
					moveDown();
					setDirection("DOWN");
				}
				else if (!getRightBox().isNull())
				{
					moveRight();
				}
				else if (!getUpBox().isNull())
				{
					moveUp();
					setDirection("UP");
				}
				else if (!getLeftBox().isNull())
				{
					moveLeft();
					setDirection("LEFT");
				}
				System.out.println(" to " + getDirection());
				break;
			case "DOWN":
				if (!getLeftBox().isNull())
				{
					moveLeft();
					setDirection("LEFT");
				}
				else if (!getDownBox().isNull())
				{
					moveDown();
				}
				else if (!getRightBox().isNull())
				{
					moveRight();
					setDirection("RIGHT");
				}
				else if (!getUpBox().isNull())
				{
					moveUp();
					setDirection("Up");
				}
				System.out.println(" to " + getDirection());
				break;
			case "LEFT":
				if (!getUpBox().isNull())
				{
					moveUp();
					setDirection("Up");
				}
				else if (!getLeftBox().isNull())
				{
					moveLeft();
				}
				else if (!getDownBox().isNull())
				{
					moveDown();
					setDirection("DOWN");
				}
				else if (!getRightBox().isNull())
				{
					moveRight();
					setDirection("RIGHT");
				}
				System.out.println(" to " + getDirection());
		}
	}

	public boolean moveRobotLeft()
	{
		Box before = getGrid().getBoxArray()[getRow()][getCol()];
		moveLeft();
		Box after = getGrid().getBoxArray()[getRow()][getCol()];
		if (before.equals(after))
			return false;
		setDirection("LEFT");
		return true;
	}

	public Box getLeftBox()
	{
		Box[][] boxes = getGrid().getBoxArray();
		return boxes[getRow()][getCol() - 1];
	}

	public boolean moveRobotRight()
	{
		Box before = getGrid().getBoxArray()[getRow()][getCol()];
		moveRight();
		Box after = getGrid().getBoxArray()[getRow()][getCol()];
		if (before.equals(after))
			return false;
		setDirection("RIGHT");
		return true;
	}

	public Box getRightBox()
	{
		Box[][] boxes = getGrid().getBoxArray();
		return boxes[getRow()][getCol() + 1];
	}

	public boolean moveRobotUp()
	{
		Box before = getGrid().getBoxArray()[getRow()][getCol()];
		moveUp();
		Box after = getGrid().getBoxArray()[getRow()][getCol()];
		if (before.equals(after))
			return false;
		setDirection("UP");
		return true;
	}

	public Box getUpBox()
	{
		Box[][] boxes = getGrid().getBoxArray();
		return boxes[getRow() - 1][getCol()];
	}

	public boolean moveRobotDown()
	{
		Box before = getGrid().getBoxArray()[getRow()][getCol()];
		moveDown();
		Box after = getGrid().getBoxArray()[getRow()][getCol()];
		if (before.equals(after))
			return false;
		setDirection("DOWN");
		return true;
	}

	public Box getDownBox()
	{
		Box[][] boxes = getGrid().getBoxArray();
		return boxes[getRow() + 1][getCol()];
	}

	public int getRow()
	{return super.getRow();}

	public int getCol()
	{return super.getCol();}
}
