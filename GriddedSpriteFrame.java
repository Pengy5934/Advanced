//Billy kelly
//Gridded Sprite Frame

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class GriddedSpriteFrame extends JFrame implements KeyListener, ActionListener
{
	private Container c;

	private int screenWidth = 900;
	private int screenHeight = 900;

	private Grid gr;
	private GriddedSprite gs;
	private Timer t;

	public GriddedSpriteFrame(BufferedImage b, int spriteRows, int spriteCols)
	{
		gr = new Grid();
		Spritesheet s = new Spritesheet(b, spriteRows, spriteCols);
		gs = new GriddedSprite(s, gr, 0, 0);
		t = new Timer(60, this);

		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setSize(new Dimension(screenWidth + 15, screenHeight + 25));
		this.setVisible(true);

		t.start();

		setFocusable(true);
		addKeyListener(this);
	}

	//------------------------------------------------<DRAWING>-----------------------------------------

	public class DrawingPanel extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.BLACK);
			g.fillRect(-100, -100, 1000, 1000);

			gr.draw(g);
			gs.draw(g);
		}
	}

	//---------------------------------------------<ACTIONLISTENER>--------------------------------------

	public void actionPerformed(ActionEvent e)
	{
		gs.animate();
		repaint();
	}

	//----------------------------------------------<KEY LISTENER>---------------------------------------

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			gs.moveUp();

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			gs.moveDown();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			gs.moveRight();

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			gs.moveLeft();
	}

	public void keyReleased(KeyEvent e)
	{}

	public void keyTyped(KeyEvent e)
	{}
}