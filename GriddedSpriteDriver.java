//Billy Kelly
//Gridded Sprite Driver

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.*;

public class GriddedSpriteDriver
{
	public static void main(String[] args)
	{
		try {
			GriddedSpriteFrame gsf = new GriddedSpriteFrame(ImageIO.read(new File("VampireSprite.png")), 4, 4);
		} catch (Exception ex)
		{ex.printStackTrace();}
	}
}