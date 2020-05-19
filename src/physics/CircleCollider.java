package physics;

import java.awt.Color;
import java.awt.Graphics;

import game.Brick;

public class CircleCollider {
	public Vector2D pos, vel;
	public double r;
	
//	public static final Color debugColor = Color.ORANGE; // lime green
	
	public CircleCollider(double x, double y, double dx, double dy, double r) {
		this.pos = new Vector2D(x, y);
		this.vel = new Vector2D(dx, dy);
		this.r = r;
	}
	
	public boolean collide(Brick aabb) {
		Vector2D pointOfIntersection = getPointOfIntersection(aabb).add(aabb.pos);
		
		if(pos.sub(pointOfIntersection).magnitude() >= r) {
			return false;
		}
		
		Vector2D rVec = getRadialIntersection(aabb);
		pos = pos.add(rVec.mult(-2));
		vel = getNewVelocity(rVec);
		
		return true;
	}
	
	public void drawDebugCollisionInfo(Brick aabb, Graphics g) {
		getPointOfIntersection(aabb).draw(aabb.pos, g, Color.red);
//		System.out.println("P: " + getPointOfIntersection(aabb));
		getCenterToCollision(aabb).draw(pos, g, Color.magenta);
//		System.out.println("D: " + getCenterToCollision(aabb));
		getRadialIntersection(aabb).draw(getPointOfIntersection(aabb).add(aabb.pos), g, Color.blue);
//		System.out.println("R: " + getRadialIntersection(aabb));
	}
	
	private Vector2D getPointOfIntersection(Brick aabb) {
		return pos.sub(aabb.pos).clamp(aabb.width/2, aabb.height/2);
	}
	
	private Vector2D getCenterToCollision(Brick aabb) {
		Vector2D p = getPointOfIntersection(aabb);
		return p.add(aabb.pos).sub(pos);
	}
	
	private Vector2D getRadialIntersection(Brick aabb) {
		Vector2D d = getCenterToCollision(aabb);
		return d.scaleTo(r - d.magnitude());
	}
	
	private Vector2D getNewVelocity(Vector2D rVec) {
		Vector2D rVecP = new Vector2D(rVec.y, -rVec.x);
		
		double det = rVec.x*rVecP.y-rVec.y*rVecP.x;
		
		return new Vector2D(
				(-vel.x*rVec.x*rVecP.y-vel.x*rVec.y*rVecP.x-2*vel.y*rVecP.x*rVecP.y)/det,
				(2*vel.x*rVec.x*rVec.y+vel.y*rVecP.x*rVec.y+vel.y*rVecP.y*rVec.x)/det
		);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red.darker());
		g.fillOval((int)(pos.x-r), (int)(pos.y-r), (int)(2*r), (int)(2*r));
		g.setColor(Color.red);
		g.fillOval((int)(pos.x -r + 2), (int)(pos.y - r + 2), (int)(2 * r - 5), (int)(2 * r - 5));
		g.setColor(Color.white);
		g.fillOval((int)(pos.x - r + 5), (int)(pos.y - r + 5), 3, 3);
	}
}
