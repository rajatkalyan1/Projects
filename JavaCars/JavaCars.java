package assignment5;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class JavaCars extends Applet{
	
	Car one;
	Car two;
	Car three;
	Car four;
	Car five;
	int randX1;
	int randX2;
	int randX3;
	int randX4;
	int randX5;
	StopWatch timer;
	
	public void init()
	{
		one = new Car(100, 110);
		two = new Car(100, 210);
		three = new Car(100, 310);
		four = new Car(100, 410);
		five = new Car(100, 510);
		while(true)
		{
			randX1 = (int)(Math.random() * 10 + 1);
			randX2 = (int)(Math.random() * 10 + 1);
			randX3 = (int)(Math.random() * 10 + 1);
			randX4 = (int)(Math.random() * 10 + 1);
			randX5 = (int)(Math.random() * 10 + 1);
			if(!(randX1 == randX2 || randX1 == randX3 || randX1 == randX4 || randX1 == randX5 || randX2 == randX3 
					|| randX2 == randX4 || randX2 == randX5 || randX3 == randX4 || randX3 == randX5 || randX4 == randX5))
				break;
		}
		timer = new StopWatch();
		timer.start();
	}
	
	public void draw(Graphics2D g, Car c, int num)
	{
		Color burntOrange = new Color(207, 83, 0);
		g.setColor(burntOrange);
		
		g.draw(c.body);
		g.draw(c.frontTire);
		g.draw(c.rearTire);
		g.fill(c.body);
		g.draw(c.roof);
		g.fill(c.roof);
		
		//color tires
		g.setColor(Color.black);
		g.fill(c.frontTire);
		g.fill(c.rearTire);
		
		//draw a number on the car
		Font f = new Font("Serif", Font.BOLD, 20);
		g.setFont(f);
		g.drawString("" + num, c.xpos + 27, c.ypos + 20);
	}
	
	public void paint(Graphics g)
	{
		//create the finish line
		g.setColor(Color.yellow);
		Graphics2D g2 = (Graphics2D)g;
		Rectangle finish = new Rectangle(1700, 0, 30, 1000);
	    g2.draw(finish);
		
		g2.fill(finish);
		
		draw(g2, one, 1);
		draw(g2, two, 2);
		draw(g2, three, 3);
		draw(g2, four, 4);
		draw(g2, five, 5);
		
	
		
		try
		{
			Thread.sleep(25);
		}
		catch(InterruptedException e)
		{
		}
		
		one.translate(randX1, 0);
		two.translate(randX2, 0);
		three.translate(randX3, 0);
		four.translate(randX4, 0);
		five.translate(randX5, 0);
		
		if(one.xpos + 55 >= 1700)
		{
			timer.stop();
			g.setColor(Color.blue);
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(f);
			g.drawString("WINNER: CAR 1", 750, 400);
			g.setColor(Color.red);
			g.drawString("CONGRATULATIONS!! :)", 650, 550);
			g.setColor(Color.green);
			f = new Font(Font.SERIF, Font.PLAIN, 30);
			g.setFont(f);
			g.drawString("(Elapsed time: " + timer.getElapsedTime() + " milliseconds)", 750, 650);
		}
		else if(two.xpos + 55 >= 1700)
		{
			timer.stop();
			g.setColor(Color.blue);
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(f);
			g.drawString("WINNER: CAR 2", 750, 400);
			g.setColor(Color.red);
			g.drawString("CONGRATULATIONS!! :)", 650, 550);
			g.setColor(Color.green);
			f = new Font(Font.SERIF, Font.PLAIN, 30);
			g.setFont(f);
			g.drawString("(Elapsed time: " + timer.getElapsedTime() + " milliseconds)", 750, 650);
		}
		else if(three.xpos + 55 >= 1700)
		{
			timer.stop();
			g.setColor(Color.blue);
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(f);
			g.drawString("WINNER: CAR 3", 750, 400);
			g.setColor(Color.red);
			g.drawString("CONGRATULATIONS!! :)", 650, 550);
			g.setColor(Color.green);
			f = new Font(Font.SERIF, Font.PLAIN, 30);
			g.setFont(f);
			g.drawString("(Elapsed time: " + timer.getElapsedTime() + " milliseconds)", 750, 650);
		}
		else if(four.xpos + 55 >= 1700)
		{
			timer.stop();
			g.setColor(Color.blue);
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(f);
			g.drawString("WINNER: CAR 4", 750, 400);
			g.setColor(Color.red);
			g.drawString("CONGRATULATIONS!! :)", 650, 550);
			g.setColor(Color.green);
			f = new Font(Font.SERIF, Font.PLAIN, 30);
			g.setFont(f);
			g.drawString("(Elapsed time: " + timer.getElapsedTime() + " milliseconds)", 750, 650);
		}
		else if(five.xpos + 55 >= 1700)
		{
			timer.stop();
			g.setColor(Color.blue);
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(f);
			g.drawString("WINNER: CAR 5", 750, 400);
			g.setColor(Color.red);
			g.drawString("CONGRATULATIONS!! :)", 650, 550);
			g.setColor(Color.green);
			f = new Font(Font.SERIF, Font.PLAIN, 30);
			g.setFont(f);
			g.drawString("(Elapsed time: " + timer.getElapsedTime() + " milliseconds)", 750, 650);
		}
		else
			repaint();
		
	}
}
