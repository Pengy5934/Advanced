//Billy Kelly
//Box Images
//10.17.2018

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class BoxImages
{
    //GLOBAL VARIABLES
    private ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();

    //-----------------------------------------------------<DRAWING>---------------------------------------------
    public void draw(Graphics g, int x, int y, int width, int height)
    {
        for (BufferedImage bi : imgs)
            g.drawImage(bi, x, y, width, height, null);
    }

    //------------------------------------------------<ADDERS && REMOVERS>---------------------------------------
    public void addImage(BufferedImage b)
    {imgs.add(b);}

    public void removeImage(int index)
    {imgs.remove(index);}

    //public void removeImage(BufferedImage b)

    //----------------------------------------------------<SETTERS>-----------------------------------------------
    //----------------------------------------------------<GETTERS>-----------------------------------------------
    public ArrayList getImageArrayList()
    {return imgs;}
}
