import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	
	public int x, y, height, width; 
	public Color c;

	public Brick(int x, int y, int height, int width, Color c) {
		// TODO Auto-generated constructor stub
		this.x = x; 
		this.y = y; 
		this.height = height; 
		this.width = width; 
		this.c = c;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x - width/2, y - height/2, width, height);
		g.setColor(c);
		g.fillRect(x - width/2, y - height/2, width, height);
		// shading
		g.setColor(c.darker());
		g.fillRect(x + width/2 - 7, y - height/2, 7, height);
		g.fillRect(x  - width/2,  y + height/2 - 7, width, 7);
	}
	
	

}
