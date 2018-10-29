//Billy Kelly
//Gridded Sprite

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.*;

public class GriddedSprite extends Sprite
{
	//---------<Global Variable for Movement>--------
	private Grid gr;
	private int currentBoxCol, currentBoxRow;
	private AffineTransform tx;

	public GriddedSprite(Spritesheet s, Grid gr, int currentBoxRow, int currentBoxCol)
	{
		super (s, gr.getBox(0, 0));

		this.gr = gr;
		this.currentBoxRow = currentBoxRow;
		this.currentBoxCol = currentBoxCol;

		move(currentBoxRow, currentBoxCol);
	}

	//--------------------------------------<MOVEMENT>-----------------------------------------
	public void move(int boxRow, int boxCol)
	{
		super.setX(gr.getBoxX(boxCol));
		super.setY(gr.getBoxY(boxRow));
	}

	public void moveUp()
	{
		if (currentBoxRow > 0)
			super.setY(gr.getBoxY(--currentBoxRow));
	}

	public void moveDown()
	{
		if (currentBoxRow < gr.getRows() - 1)
			super.setY(gr.getBoxY(++currentBoxRow));
	}

	public void moveLeft()
	{
		if (currentBoxCol > 0)
			super.setX(gr.getBoxX(--currentBoxCol));
	}

	public void moveRight()
	{
		if (currentBoxCol < gr.getCols() - 1)
			super.setX(gr.getBoxX(++currentBoxCol));
	}
}