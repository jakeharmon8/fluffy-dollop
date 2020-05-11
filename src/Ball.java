import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	int x; 
	int y;
	int size;
	int speedX = 0; 
	int speedY = 0;

	public Ball(int x, int y, int size) {
		// TODO Auto-generated constructor stub
		this.x = x; 
		this.y = y;
		this.size = size;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, size, size);
	}

}
