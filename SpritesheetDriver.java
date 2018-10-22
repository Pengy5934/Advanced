//Billy Kelly
//SpriteSheet Driver

import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;

public class SpritesheetDriver
{
	static SpriteAnimator sa;

	public static void main(String[] args)
	{
		try {
			sa = new SpriteAnimator(ImageIO.read(new File("VampireSprite.png")), 4, 4);
		} catch (Exception e){e.printStackTrace();}

	}
}