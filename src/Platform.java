import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	
	public int size = 100;
	public int x = GamePanel.S_WIDTH/2 - size/2; 
	public int height = 20;

	public Platform() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, GamePanel.S_HEIGHT - height, size, height/2);
	}

}
