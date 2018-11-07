//Billy Kelly
//GriddedSprite
//10.17.2018

import java.awt.*;

public class GriddedSprite extends Sprite
{
    private Grid gr;
    private int row, col;

	public GriddedSprite(String name, Spritesheet ss, Grid g, int row, int col)
    {
		super(name, ss);
		gr = g;
		this.row = row;
		this.col = col;
    }

    //----------------------------------------------<MOVEMENT>-----------------------------------------------
    public void moveUp()
    {
		Box nextBox = gr.getBoxArray()[row - 1][col];

		if (!nextBox.isNull())
		{
			gr.totalDelete(getName());
			if (!nextBox.getType().equalsIgnoreCase("END"))
				nextBox.addSprite(this);

			row--;
		}
	}

	public void moveRight()
	{
		Box nextBox = gr.getBoxArray()[row][col + 1];

		if (!nextBox.isNull())
		{
			gr.totalDelete(getName());
			if (!nextBox.getType().equalsIgnoreCase("END"))
				nextBox.addSprite(this);

			col++;
		}
	}

	public void moveLeft()
	{
		Box nextBox = gr.getBoxArray()[row][col - 1];

		if (!nextBox.isNull())
		{
			gr.totalDelete(getName());
			if (!nextBox.getType().equalsIgnoreCase("END"))
				nextBox.addSprite(this);

			col--;
		}
	}

	public void moveDown()
	{
		Box nextBox = gr.getBoxArray()[row + 1][col];

		if (!nextBox.isNull())
		{
			gr.totalDelete(getName());
			if (!nextBox.getType().equalsIgnoreCase("END"))
				nextBox.addSprite(this);

			row++;
		}
	}

    //------------------------------------------------------<GETTERS>----------------------------------------
    public int getRow()
    {return row;}

    public int getCol()
    {return col;}

    public Grid getGrid()
    {return gr;}

    //----------------------------------------------------<SETTERS>--------------------------------------------
    public void setRow(int r)
    {row = r;}

    public void setCol(int c)
    {
		if (c > 0 && c < gr.getCols())
			col = c;
	}
}
