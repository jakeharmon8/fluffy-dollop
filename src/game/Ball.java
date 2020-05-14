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
		this.x = x; 
		this.y = y;
		this.radius = radius;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red.darker());
		g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		g.setColor(Color.red);
		g.fillOval(x -radius + 2, y - radius + 2, 2 * radius - 5, 2 * radius - 5);
		g.setColor(Color.white);
		g.fillOval(x - radius + 5, y - radius + 5, 3, 3);
	}

}
