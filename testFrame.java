//testFrame

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class testFrame extends JFrame implements ActionListener, KeyListener
{
	Maze m = new Maze(20, 20, 900, 900);
	BufferedImage wall, path;
	Container c;
	Timer t;
	String intMap = "";;

	Color color;
	int r = 1, gr = 5, b = 30;

	ArrayList<String> names = new ArrayList<String>();

	public testFrame()
	{
		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setVisible(true);
		this.setSize(900, 900);

		color = new Color(r, gr, b);

		try
		{
			Sprite s = new Sprite("main", new Spritesheet(ImageIO.read(new File("VampireSprite.png")), 4, 4));
			names.add("main");
			m.addSprite(s, 2, 3);
			wall = ImageIO.read(new File("StoneWall.JPEG"));
			path = ImageIO.read(new File("DirtBlock.JPEG"));

			m.integrateIntMap(MazeReader.getIntMap("Maze.txt"));
		}
		catch (Exception ex)
		{ex.printStackTrace();}

		for (int i = 0; i < m.getBoxArray().length; i++)
		{
			for (int j = 0; j < m.getBoxArray()[i].length; j++)
			{
				if (m.getBoxArray()[i][j].isNull())
					m.getBoxArray()[i][j].setNullImage(wall);
				else
					m.getBoxArray()[i][j].addImage(path);
			}
		}

		t = new Timer(60, this);
		t.start();


		setFocusable(true);
		addKeyListener(this);

		repaint();
	}

	public class DrawingPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			m.draw(g);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{m.moveRight("main");}

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{m.moveLeft("main");}

		if (e.getKeyCode() == KeyEvent.VK_UP)
		{m.moveUp("main");}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{m.moveDown("main");}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}
}