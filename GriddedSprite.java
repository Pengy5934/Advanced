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
		Box[][] boxes = gr.getBoxArray();
		boxes[row][col].removeSprite(super.getName());
		boxes[row--][col].addSprite(this);
	}
	
	public void moveRight()
	{
		Box[][] boxes = gr.getBoxArray();
		boxes[row][col].removeSprite(super.getName());
		boxes[row][col++].addSprite(this);
	}
	
	public void moveLeft()
	{
		Box[][] boxes = gr.getBoxArray();
		boxes[row][col].removeSprite(super.getName());
		boxes[row][col--].addSprite(this);
	}
	
	public void moveDown()
	{
		Box[][] boxes = gr.getBoxArray();
		boxes[row][col].removeSprite(super.getName());
		boxes[row++][col].addSprite(this);
	}
    
}
