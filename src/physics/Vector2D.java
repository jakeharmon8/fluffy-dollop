package physics;

import java.awt.Color;
import java.awt.Graphics;

public class Vector2D {
	public double x;
	public double y;
	
	public Vector2D(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	
	public Vector2D sub(Vector2D v) {
		return new Vector2D(x - v.x, y - v.y);
	}
	
	public Vector2D add(Vector2D v) {
		return new Vector2D(x + v.x, y + v.y);
	}
	
	public Vector2D mult(double s) {
		return new Vector2D(x * s, y * s);
	}
	
	public Vector2D clamp(double maxX, double maxY) {
		double clampX = Math.signum(x) * Math.min(Math.abs(x), maxX);
		double clampY = Math.signum(y) * Math.min(Math.abs(y), maxY);
		
		return new Vector2D(clampX, clampY);
	}
	
	public Vector2D scaleTo(double s) {
		double m = magnitude();
		
		return new Vector2D(x * s/m, y * s/m);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public void draw(Vector2D start, Graphics g) {
		draw(start, g, Color.black);
	}
	
	public void draw(Vector2D start, Graphics g, Color c) {
		g.setColor(c);
		g.drawLine((int) start.x, (int) start.y, (int) (start.x + x), (int) (start.y + y)); 
		g.drawOval((int) (start.x + x - 4), (int) (start.y + y - 4), 8, 8);
	}
	
	@Override
	public String toString() {
		return "<" + String.format("%.2f", x) + "," + String.format("%.2f",  y) + ">"; 
	}
}
