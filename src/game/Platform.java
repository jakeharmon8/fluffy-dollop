package game;
import java.awt.Color;
import java.awt.Graphics;

public class Platform extends Brick {
	
	public Platform(double x, double y, double width, double height, Color c) {
		super(x, y, width, height, c);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)(pos.x - width/2), (int)(pos.y - height/2), (int)width, (int)height);
	}

}
