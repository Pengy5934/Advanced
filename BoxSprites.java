//Billy Kelly
//boxSprites
//10.17.2018

import java.awt.*;
import java.util.ArrayList;

public class BoxSprites
{
    private ArrayList<Sprite> sprs = new ArrayList<Sprite>();
    private Box b;

	public BoxSprites(Box bx)
	{
        b = bx;
	}

	//Update method calls draw and moveRobots.
	//Those methods are no longer callable from the outside.
	public void update(Graphics g)
	{
		draw(g);
		moveRobots();
	}

    private void draw(Graphics g)
    {
        for (Sprite s : sprs)
        {
			s.setX(b.getX());
			s.setY(b.getY());
            s.draw(g, b.getWidth(), b.getHeight());
		}
    }

    private void moveRobots()
    {
		for (Sprite r : sprs)
		{
			if (r instanceof RandomRobot)
			{
				r.move();
			}
		}
	}

	//-------------------------------------------<SETTERS>----------------------------------------------
    public void setSpriteX(int x, int index)
    {sprs.get(index).setX(x);}

    public void setSpriteY(int y, int index)
    {sprs.get(index).setY(y);}

	//-------------------------------------<ADDERS, MOVERS, & REMOVERS>-----------------------------------------
    public void addSprite(Sprite s)
    {sprs.add(s);}

    public void removeSprite(int index)
    {sprs.remove(index);}

    public void removeSprite(Sprite s)
    {sprs.remove(s);}

    public void removeSprite(String name)
    {
		int index = findSprite(name);
		if (index != -1)
			sprs.remove(index);
	}

	public int findSprite(String name)
	{
		for (int i = 0; i < sprs.size(); i++)
			if (sprs.get(i).getName().equalsIgnoreCase(name))
				return i;
		return -1;
	}

    //--------------------------------------------<GETTERS>----------------------------------------------
    public Sprite getSprite(int index)
    {return sprs.get(index);}

    public Sprite getSprite()
    {
		if (sprs.size() > 0)
			return sprs.get(0);
		return null;
	}

	public ArrayList<Sprite> getSpriteList()
	{return sprs;}
}
