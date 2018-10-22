//Billy Kelly
//SpriteAnimator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class SpriteAnimator extends JFrame implements KeyListener, ActionListener
{
	private Sprite s;
	Container c;
	private long startTime = System.nanoTime();
	private long elapsedTime;
	private long totalTime;
	private int delay = 17;
	private int count = 0;
	Timer t;

	//-------------------------------------------<CONSTRUCTOR>-----------------------

	public SpriteAnimator(BufferedImage sheet, int rows, int cols)
	{
		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setSize(900, 900);
		this.setVisible(true);

		s = new Sprite(sheet, rows, cols, 0, 0, sheet.getWidth() / cols, sheet.getHeight() / rows);
		t = new Timer(delay, this);

		t.start();

		addKeyListener(this);
		setFocusable(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		count++;

		if (count % 20 == 0)
			s.animate();
		repaint();
	}

	//----------------------------------------------<DRAW>-----------------------------------------

	public class DrawingPanel extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			s.draw(g);
		}
	}

	//-------------------------------------------<KEYLISTENER>------------------------------------------

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			if (s.getSpritesheet().getRow() > 0)
			{
				s.switchBackAnimation();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if (s.getSpritesheet().getRow() < s.getSpritesheet().getRows())
				s.switchAnimation();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{delay += 100;}

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{delay -= 100;}
	}

	public void keyReleased(KeyEvent e)
	{}

	public void keyTyped(KeyEvent e)
	{}
}