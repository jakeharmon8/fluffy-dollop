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
		getPointOfIntersection(aabb).draw(aabb.pos, g, Color.red);
		System.out.println("P: " + getPointOfIntersection(aabb));
		getCenterToCollision(aabb).draw(pos, g, Color.magenta);
		System.out.println("D: " + getCenterToCollision(aabb));
		getRadialIntersection(aabb).draw(getPointOfIntersection(aabb).add(aabb.pos), g, Color.blue);
		System.out.println("R: " + getRadialIntersection(aabb));
	}
	
	private Vector2D getPointOfIntersection(AabbCollider aabb) {
		return pos.sub(aabb.pos).clamp(aabb.width/2, aabb.height/2);
	}
	
	private Vector2D getCenterToCollision(AabbCollider aabb) {
		Vector2D p = getPointOfIntersection(aabb);
		return p.add(aabb.pos).sub(pos);
	}
	
	private Vector2D getRadialIntersection(AabbCollider aabb) {
		Vector2D d = getCenterToCollision(aabb);
		return d.scaleTo(r - d.magnitude());
	}
	
	public void draw(Graphics g) {
		g.setColor(debugColor);
		g.drawOval((int) (pos.x - r), (int) (pos.y - r), (int) (r*2), (int) (r*2));
	}
}
