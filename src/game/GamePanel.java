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
	public Ball ball = new Ball(256, 30, 10);
	public Brick brick = new Brick(256, 256, 50, 100, Color.pink);
	
	public Brick testBrick = new Brick(300, 200, 100, 50, Color.green);
	public CircleCollider testBall = new CircleCollider(100, 100, 5, 5, 40);
	
	public Timer t;
	
	public GamePanel() {
		addKeyListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
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
		
		testBrick.draw(g);
		testBall.draw(g);
		
		testBall.drawDebugCollisionInfo(testBrick, g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				platform.pos.x += 10;
				if (ball.speedX  == 0) {
					ball.x += 10;
				}
				break;
			case KeyEvent.VK_LEFT:
				platform.pos.x -= 10;
				if (ball.speedX == 0) {
					ball.x -= 10;
				}
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
		
		if(testBall.collide(testBrick)) {
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
