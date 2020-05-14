package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import physics.CircleCollider;
import physics.Vector2D;


public class GamePanel extends JPanel implements KeyListener, ActionListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	public static int S_WIDTH = 512;
	public static int S_HEIGHT = 512;
	
	public Platform platform = new Platform(S_WIDTH/2, S_HEIGHT * 0.95, 75.0, 10.0, Color.black); 
	public int ballRadius = 10;
	
	public ArrayList<Brick> bricks = new ArrayList<>();
//	public Brick testBrick = new Brick(300, 200, 100, 50, Color.green);
	public CircleCollider testBall = new CircleCollider(S_WIDTH/2, S_HEIGHT*.8, 10, -10, 16);
	
	public Timer t;
	
	public GamePanel() {
		addKeyListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		bricks.add(new Brick(S_WIDTH/2, 0, S_WIDTH, S_HEIGHT/32, Color.black, true));
		bricks.add(new Brick(S_WIDTH/2, S_HEIGHT, S_WIDTH, S_HEIGHT/32, Color.black, true));
		bricks.add(new Brick(0, S_HEIGHT/2, S_WIDTH/32, S_HEIGHT, Color.black, true));
		bricks.add(new Brick(S_WIDTH, S_HEIGHT/2, S_WIDTH/32, S_HEIGHT, Color.black, true));
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				bricks.add(new Brick(i * 100 + 150, j * 50 + 100, 90, 45, Color.green));
			}
		}
//		bricks.add(new Brick(300, 200, 100, 50, Color.green));
//		bricks.add(new Brick(100, 400, 100, 50, Color.green));
//		bricks.add(new Brick(400, 40, 100, 50, Color.green));
		
		t = new Timer(50, this);
		t.start();
		
		setFocusable(true);
		requestFocus();
		
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, S_WIDTH, S_HEIGHT);

//		ball.draw(g);
//		brick.draw(g);
		
		platform.draw(g);
		
		for(Brick b : bricks) {
			b.draw(g);
		}
		testBall.draw(g);
		
//		testBall.drawDebugCollisionInfo(testBrick, g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				platform.pos.x += 10;
				break;
			case KeyEvent.VK_LEFT:
				platform.pos.x -= 10;
				break;
			case KeyEvent.VK_S:
				break;
			case KeyEvent.VK_D:
				break;
			case KeyEvent.VK_E:
				break;
			case KeyEvent.VK_Q:
				break;
			case KeyEvent.VK_SPACE:
				t.stop();
				actionPerformed(null);
				break;
			case KeyEvent.VK_ENTER:
				t.start();
				break;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		testBall.pos = testBall.pos.add(testBall.vel);
		
		ArrayList<Brick> toRemove = new ArrayList<>();
		for(Brick b : bricks) {
			if(testBall.collide(b)) {
				System.out.println("Collide!");
				if(!b.invincible) {
					b.hp--;
					if(b.hp == 0) {
						toRemove.add(b);
					}
				}
			}
		}
		bricks.removeAll(toRemove);
		
		if(testBall.collide(platform)) {
			System.out.println("Collide!");
		}
		
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		testBall.pos = new Vector2D(e.getX(), e.getY());
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
