package game;
import java.awt.Color;
import java.awt.Graphics;

import physics.Vector2D;

public class Brick {
	public Vector2D pos;
	public double height, width; 
	public Color c;
	
	public int hp = 1;

	public Brick(double x, double y, double width, double height, Color c) {
		// TODO Auto-generated constructor stub
		this.pos = new Vector2D(x, y); 
		this.height = height; 
		this.width = width; 
		this.c = c;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect((int)(pos.x - width/2), (int)(pos.y - height/2), (int)width, (int)height);
		g.setColor(c);
		g.fillRect((int)(pos.x - width/2), (int)(pos.y - height/2), (int)width, (int)height);
		// shading
		g.setColor(c.darker());
		g.fillRect((int)(pos.x + width/2 - 7), (int)(pos.y - height/2), 7, (int)height);
		g.fillRect((int)(pos.x  - width/2),  (int)(pos.y + height/2 - 7), (int)width, 7);
	}
	
	

}
