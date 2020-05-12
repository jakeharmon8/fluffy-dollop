package game;
import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	// note that x, y is the center of the ball
	public int x; 
	public int y;
	public int radius;
	public int speedX = 0; 
	public int speedY = 0;

	public Ball(int x, int y, int radius) {
		// TODO Auto-generated constructor stub
		this.x = x; 
		this.y = y;
		this.radius = radius;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}

}
