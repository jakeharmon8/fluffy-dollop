package physics;

import java.awt.Color;
import java.awt.Graphics;

public class CircleCollider {
	public Vector2D pos, vel;
	public double r;
	
	public static final Color debugColor = Color.ORANGE; // lime green
	
	public CircleCollider(double x, double y, double dx, double dy, double r) {
		this.pos = new Vector2D(x, y);
		this.vel = new Vector2D(dx, dy);
		this.r = r;
	}
	
	public boolean collide(AabbCollider aabb) {
		Vector2D pointOfIntersection = getPointOfIntersection(aabb);
		
		if(pos.sub(pointOfIntersection).magnitude() > r) {
			return false;
		}
		
		return true;
	}
	
	public void drawDebugCollisionInfo(AabbCollider aabb, Graphics g) {
		getPointOfIntersection(aabb).Draw(aabb.pos, g);
	}
	
	private Vector2D getPointOfIntersection(AabbCollider aabb) {
		return pos.sub(aabb.pos).clamp(aabb.width/2, aabb.height/2);
	}
	
	public void draw(Graphics g) {
		g.setColor(debugColor);
		g.drawOval((int) (pos.x - r), (int) (pos.y - r), (int) (r*2), (int) (r*2));
	}
}
