package Snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Snake {

	List<Point> snakePoints;
	int xDir, yDir;
	boolean isMoving, inc;
	final int STARTSIZE = 20, STARTX = 150, STARTY = 150;
	
	public Snake(){
		snakePoints = new ArrayList<Point>();
		xDir = 0;
		yDir = 0;
		isMoving = false;
		inc = false;
		snakePoints.add(new Point(STARTX, STARTY));
		for(int k = 1; k < STARTSIZE; k++){
			snakePoints.add(new Point(STARTX - k * 4, STARTY));
		}
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		for(Point p : snakePoints){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
	
	public void move(){
		if(isMoving){
			Point temp = snakePoints.get(0);
			Point last = snakePoints.get(snakePoints.size() - 1);
			Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
			for(int k = snakePoints.size() - 1; k >= 1; k--){
				snakePoints.set(k, snakePoints.get(k - 1));
			}
			snakePoints.set(0, newStart);
			if(inc){
				snakePoints.add(last);
				inc = false;
			}
		}
	}
	
	public boolean snakeCollision(){
		int x = this.getX();
		int y = this.getY();
		for(int k = 1; k < snakePoints.size(); k++){
			if(snakePoints.get(k).getX() == x && snakePoints.get(k).getY() == y)
				return true;
		}
		return false;
	}
	
	public boolean isMoving(){
		return isMoving;
	}
	
	public void setIsMoving(boolean b){
		isMoving = b;
	}
	
	public int getXDir(){
		return xDir;
	}
	
	public int getYDir(){
		return yDir;
	}
	
	public void setXDir(int x){
		xDir = x;
	}
	
	public void setYDir(int y){
		yDir = y;
	}
	
	public int getX(){
		return snakePoints.get(0).getX();
	}
	
	public int getY(){
		return snakePoints.get(0).getY();
	}
	
	public void setInc(boolean b){
		inc = b;
	}
}
