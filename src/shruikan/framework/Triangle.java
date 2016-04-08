package shruikan.framework;

import java.awt.Polygon;
import java.awt.Rectangle;
import shruikan.framework.Collision;



public class Triangle {

	public int[] x = new int[3];
	public int[] y = new int[3];
	
	public Polygon triangle; 
	
	public Collision collision = new Collision();
	
	
	
	public Triangle(int px0, int py0, int px1, int py1, int px2, int py2) {
		
		x[0] = px0;		y[0] = py0;
		x[1] = px1;		y[1] = py1;
		x[2] = px2;		y[2] = py2;
		
		triangle = new Polygon(x, y, 3);
	}
	
	
	
	public boolean intersects(Rectangle rectangle){
		
		if(collision.line_rectangle(x[0], y[0], x[1], y[1], rectangle.x, rectangle.y, rectangle.width, rectangle.height))
			return true;
		else if(collision.line_rectangle(x[1], y[1], x[2], y[2], rectangle.x, rectangle.y, rectangle.width, rectangle.height))
			return true;
		else if(collision.line_rectangle(x[2], y[2], x[0], y[0], rectangle.x, rectangle.y, rectangle.width, rectangle.height))
			return true;
		else 
			return false;
	}
	
	
	
	//--------------------GETTERS--------------------
	public int[] getX() {
		return x;
	}



	public int[] getY() {
		return y;
	}



	public Polygon getTriangle() {
		return triangle;
	}



	//--------------------SETTERS--------------------
	public void setX(int[] x) {
		this.x = x;
	}



	public void setY(int[] y) {
		this.y = y;
	}



	public void setTriangle(Polygon triangle) {
		this.triangle = triangle;
	}
		
}
