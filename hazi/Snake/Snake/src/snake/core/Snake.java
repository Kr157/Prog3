package snake.core;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Snake implements Serializable {
	
	private int toppoint1;
	private int toppoint2;
	private int toppoint3;
	public ArrayList<Point> dcordinate;
	private int dots;
	private int point;
	private boolean throughwall;
	private boolean pointsplus;
	public boolean leftDirection;
	public boolean rightDirection;
	public boolean upDirection;
	public boolean downDirection;
	
		public Snake(boolean throughwall1, boolean pointsplus1) {
		this.throughwall = throughwall1;
		this.pointsplus = pointsplus1;
		this.dots = 3;
		dcordinate = new ArrayList<Point>();
		this.point = 0;
		leftDirection = false;
		rightDirection = false;
		upDirection = false;
		downDirection = false;
	}
	
	public void move(int DotSize, int B_widht, int B_height) {
		for(int z = (dots-1); z > 0; z--) {
			dcordinate.set(z,dcordinate.get(z-1) );
		}
		if (leftDirection) {
			Point seged = new Point(dcordinate.get(0));
			if (throughwall == true && seged.getX() == 0) {
				seged.setLocation(B_widht - DotSize, seged.getY());
			} else {
				seged.setLocation((seged.getX()-DotSize), seged.getY());
			}
			dcordinate.set(0 , seged);
		}
		
		if (rightDirection) {
			Point seged = new Point(dcordinate.get(0));
			if (throughwall == true && seged.getX() == (B_widht - DotSize)) {
				seged.setLocation(0 + DotSize, seged.getY());
			} else {
				seged.setLocation((seged.getX()+DotSize), seged.getY());
			}
			dcordinate.set(0 , seged);
		}
		
		if (upDirection) {
			Point seged = new Point(dcordinate.get(0));
			if (throughwall == true && seged.getY() ==  0) {
				seged.setLocation(seged.getX(), B_height -DotSize);
			} else {
				seged.setLocation(seged.getX(), (seged.getY()-DotSize));
			}
			dcordinate.set(0 , seged);
		}
		
		if (downDirection) {
			Point seged = new Point(dcordinate.get(0));
			if (throughwall == true && seged.getY() == B_height - DotSize) {
				seged.setLocation(seged.getX(), 0);
			} else {
				seged.setLocation(seged.getX(), (seged.getY()+DotSize));
			}
			dcordinate.set(0 , seged);
		}
		
	}
	
	public int getdots() {
		return this.dots;
	}
	
	public int getpoint() {
		return this.point;
	}
	
	public int gettoppoint1() {
		return this.toppoint1;
	}
	
	public int gettoppoint2() {
		return this.toppoint2;
	}
	
	public int gettoppoint3() {
		return this.toppoint3;
	}
	
	public boolean getthroughwall() {
		return this.throughwall;
	}
	
	public boolean getpointsplus() {
		return this.pointsplus;
	}
	
	public void setdots(int i) {
		this.dots = this.dots+i;
	}
	
	public void setpoint (int i) {
		this.point = point+i;
	}
	
	public void settop () {
		if(this.point > this.toppoint1) {
			this.toppoint3 = this.toppoint2;
			this.toppoint2 = this.toppoint1;
			this.toppoint1 = this.point;
		} else if(this.point > this.toppoint2) {
			this.toppoint3 = this.toppoint2;
			this.toppoint2 = this.point;
		} else if(this.point > this.toppoint3) {
			this.toppoint3 = this.point;
		}
		
	}
	
	public void settoppoints() throws FileNotFoundException, IOException, ClassNotFoundException {
		Snake seged = new Snake(throughwall, pointsplus);
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("users.txt"));
		seged=(Snake)is.readObject();
		is.close();
		this.toppoint1 = seged.toppoint1;
		this.toppoint2 = seged.toppoint2;
		this.toppoint3 = seged.toppoint3;
	}
}
