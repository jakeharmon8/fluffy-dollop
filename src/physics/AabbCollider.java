package physics;

import java.awt.Color;
import java.awt.Graphics;

public class AabbCollider {
	public Vector2D pos;
	public double width, height;
	
	public static final Color debugColor = new Color(50, 205, 50); // lime green
	
	public AabbCollider(double x, double y, double w, double h) {
		this.pos = new Vector2D(x, y);
		this.width = w;
		this.height = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(debugColor);
		g.drawRect((int)(pos.x-width/2), (int)(pos.y-height/2), (int) width, (int) height);
	}
}
