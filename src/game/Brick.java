package game;
import java.awt.Color;
import java.awt.Graphics;

import physics.Vector2D;

public class Brick {
	public Vector2D pos;
	public double height, width; 
	public Color c;
	
	public int hp = 1;
	public boolean invincible = false;
	public boolean isPlatform = false;

	public Brick(double x, double y, double width, double height, Color c) {
		this.pos = new Vector2D(x, y); 
		this.height = height; 
		this.width = width; 
		this.c = c;
	}
	
	public Brick(double x, double y, double width, double height, Color c, boolean invincible, boolean isPlatform) {
		this.pos = new Vector2D(x, y); 
		this.height = height; 
		this.width = width; 
		this.c = c;
		this.invincible = invincible;
		this.isPlatform = isPlatform;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect((int)(pos.x - width/2), (int)(pos.y - height/2), (int)width, (int)height);
		g.setColor(c);
		g.fillRect((int)(pos.x - width/2), (int)(pos.y - height/2), (int)width, (int)height);
		// shading
		g.setColor(c.darker());
		g.fillRect((int)(pos.x - width/2), (int)(pos.y-height/2), 5, (int)height);
		g.fillRect((int)(pos.x - width/2), (int)(pos.y-height/2), (int)width, 5);
		g.setColor(c.darker().darker());
		g.fillRect((int)(pos.x + width/2 - 7), (int)(pos.y - height/2), 7, (int)height);
		g.fillRect((int)(pos.x  - width/2),  (int)(pos.y + height/2 - 7), (int)width, 7);
		g.setColor(c.darker());
		g.fillPolygon(new int[] {(int)(pos.x+width/2-7), (int)(pos.x+width/2-7), (int)(pos.x+width/2)}, 
				new int[] {(int)(pos.y-height/2), (int)(pos.y-height/2+5), (int)(pos.y-height/2)}, 3);
		g.fillPolygon(new int[] {(int)(pos.x-width/2), (int)(pos.x-width/2), (int)(pos.x-width/2+5)}, 
				new int[] {(int)(pos.y+height/2), (int)(pos.y+height/2-7), (int)(pos.y+height/2-7)}, 3);
	}
	
	

}
