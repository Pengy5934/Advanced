//Billy Kelly
//Robot Frame
//10.29.2018

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class RobotFrame extends JFrame implements ActionListener, KeyListener
{
	int frameWidth = 900, frameHeight = 900;
	Maze m = new Maze(20, 20, frameWidth, frameHeight);
	BufferedImage wall, path;
	Container c;
	Timer t;
	int counter = 0;
	String intMap = "";

	ArrayList<String> names = new ArrayList<String>();

	public RobotFrame()
	{
		setContentPane(new DrawingPanel());
		c = getContentPane();
		this.setVisible(true);
		this.setSize(frameWidth, frameHeight);

		try
		{
			m.integrateIntMap(MazeReader.getIntMap("Maze.txt"));
			wall = ImageIO.read(new File("MossStoneWall.png"));
			path = ImageIO.read(new File("NoGrassDirtPath.jpg"));

			GriddedSprite s = new GriddedSprite("main", new Spritesheet(ImageIO.read(new File("VampireSprite.png")), 4, 4), m, m.findStartPointRow(), m.findStartPointCol());
			RandomRobot rand = new RandomRobot("random", new Spritesheet(ImageIO.read(new File("redVampire.png")), 4, 4), m, m.findStartPointRow(), m.findStartPointCol());
			RightRobot right = new RightRobot("right", new Spritesheet(ImageIO.read(new File("blueVampire.png")), 4, 4), m, m.findStartPointRow(), m.findStartPointCol());

			names.add("main");
			names.add(rand.getName());
			names.add(right.getName());

			m.addSprite(rand, m.findStartPointRow(), m.findStartPointCol());
			m.addSprite(right, m.findStartPointRow(), m.findStartPointCol());
			m.addSprite(s, m.findStartPointRow(), m.findStartPointCol());
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
		resizeMaze();
		if (counter % 6 == 0)
			m.moveRobots();
		if (counter > 10000)
			counter = 0;
		counter++;
		repaint();

	}

	public void resizeMaze()
	{
		int w = this.getWidth();
		int h = this.getHeight();
		if (m.getHeight() != h || m.getWidth() != h)
			m.resize(this.getWidth(), this.getHeight());
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
