package assignment5;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Polygon;


public class Car {
	
	protected Rectangle body;
	protected Ellipse2D.Double frontTire;
	protected Ellipse2D.Double rearTire;
	protected Polygon roof;
	protected int xpos;
	protected int ypos;
	protected int[] roofX;
	protected int[] roofY;
	
	public Car(int x, int y)
	{
		xpos = x;
		ypos = y;
		roofX = new int[] {xpos + 5, xpos + 10, xpos + 35, xpos + 40};
		roofY = new int[] {ypos, ypos - 10, ypos - 10, ypos};
		// create the car body
		body = new Rectangle(xpos, ypos, 60, 30);
		// create the car tires
		frontTire = new Ellipse2D.Double(xpos + 5, ypos + 30, 20, 20);
		rearTire = new Ellipse2D.Double(xpos + 35, ypos + 30, 20, 20);
	    roof = new Polygon(roofX, roofY, 4);
	}
	
	public void translate(int x, int y)
	{
		xpos += x;
		ypos += y;
		roofX = new int[] {xpos + 5, xpos + 10, xpos + 35, xpos + 40};
		roofY = new int[] {ypos, ypos - 10, ypos - 10, ypos};
		body = new Rectangle(xpos, ypos, 60, 30);
		frontTire = new Ellipse2D.Double(xpos + 5, ypos + 30, 20, 20);
		rearTire = new Ellipse2D.Double(xpos + 35, ypos + 30, 20, 20);
		roof = new Polygon(roofX, roofY, 4);
	}
}