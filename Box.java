//Billy Kelly
//Boxes
//10.17.2018

import java.awt.*;
import java.awt.image.*;

public class Box
{
    //GLOBAL VARIABLES
	private BoxImages bi;
	private BoxSprites bs;
	private int row, col;
    private int x, y;
    private int width, height;

    //Deactivation: Allows a box to be deactivated in a maze
    private boolean isNull = false;
    private BufferedImage nullImage = null;

    //-----------------------------------------------<CONSTRUCTORS>-----------------------------------------
	public Box(int x, int y, int width, int height, int row, int col)
	{
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.row = row;
        this.col = col;
        isNull = false;

        bi = new BoxImages();
        bs = new BoxSprites(this);
	}

    //-------------------------------------------------<DRAWING>-------------------------------------
    public void draw(Graphics g)
    {
		if (!isNull)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
			g.setColor(Color.WHITE);
			g.fillRect(x + 2, y + 2, width - 4, height - 4);
			bi.draw(g, x, y, width, height);
			bs.draw(g, width, height);
		}
		else
		{
			if (nullImage == null)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x, y, width, height);
			}
			else
				g.drawImage(nullImage, x, y, width, height, null);
		}
	}

	public boolean hasSprite(String name)
	{
		if (bs.findSprite(name) != -1)
			return true;
		return false;
	}

    //---------------------------------------------<ADDERS && REMOVERS>-------------------------------------
    public void addImage(BufferedImage b)
    {bi.addImage(b);}

    public void addSprite(Sprite s)
    {bs.addSprite(s);}

    public void removeSprite(String name)
    {bs.removeSprite(name);}
    //-------------------------------------------------<SETTERS>-------------------------------------
	public void setNull(boolean n)
	{isNull = n;}

	public void setNullImage(BufferedImage b)
	{nullImage = b;}

    //-------------------------------------------------<GETTERS>-------------------------------------
    public int getX()
    {return x;}

    public int getY()
    {return y;}

    public int getWidth()
    {return width;}

    public int getHeight()
    {return height;}

    public BoxImages getBoxImages()
    {return bi;}

    public BoxSprites getBoxSprites()
    {return bs;}

    public Sprite getSprite(String spriteName)
    {return bs.getSprite(bs.findSprite(spriteName));}

    public int getRow()
    {return row;}

    public int getCol()
    {return col;}

    public Box getBox()
    {return this;}

    public boolean isNull()
    {return isNull;}

    public BufferedImage getNullImage()
    {return nullImage;}
}
