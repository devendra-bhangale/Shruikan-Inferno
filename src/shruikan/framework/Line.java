package shruikan.framework;

import java.awt.Polygon;
import java.awt.Rectangle;
import shruikan.framework.Collision;



public class Line {

	public int[] x1 = new int[2];
	public int[] y1 = new int[2];
	public int[] x2 = new int[2];
	public int[] y2 = new int[2];
	
	public Polygon line1, line2;
	
	public Collision collision = new Collision();
	
	
	
	public Line(int px0, int py0, int px1, int py1, int px2, int py2) {

		x1[0] = px0;		y1[0] = py0;
		x1[1] = px1;		y1[1] = py1;
		
		x2[0] = px1;		y2[0] = py1;
		x2[1] = px2;		y2[1] = py2;
		
		line1 = new Polygon(x1, y1, 2);
		line2 = new Polygon(x2, y2, 2);
	}


	public boolean intersects(Rectangle rectangle){
		
		if(collision.line_rectangle(x1[0], y1[0], x1[1], y1[1], rectangle.x, rectangle.y, rectangle.width, rectangle.height))
			return true;
		else if(collision.line_rectangle(x2[0], y2[0], x2[1], y2[1], rectangle.x, rectangle.y, rectangle.width, rectangle.height))
			return true;
		else 
			return false;
	}


	//--------------------GETTERS--------------------
	public int[] getX1() {
		return x1;
	}


	public int[] getY1() {
		return y1;
	}


	public int[] getX2() {
		return x2;
	}


	public int[] getY2() {
		return y2;
	}


	public Polygon getLine1() {
		return line1;
	}


	public Polygon getLine2() {
		return line2;
	}



	//--------------------SETTERS--------------------
	public void setX1(int[] x1) {
		this.x1 = x1;
	}


	public void setY1(int[] y1) {
		this.y1 = y1;
	}


	public void setX2(int[] x2) {
		this.x2 = x2;
	}


	public void setY2(int[] y2) {
		this.y2 = y2;
	}


	public void setLine1(Polygon line1) {
		this.line1 = line1;
	}


	public void setLine2(Polygon line2) {
		this.line2 = line2;
	}
	
}
