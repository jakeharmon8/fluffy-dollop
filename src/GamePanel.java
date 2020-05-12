import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import physics.AabbCollider;
import physics.CircleCollider;


public class GamePanel extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	public static int S_WIDTH = 512;
	public static int S_HEIGHT = 512;
	
	public Platform platform = new Platform(); 
	public int ballRadius = 10;
	public Ball ball = new Ball(platform.x + platform.size/2, 
			S_HEIGHT - platform.height - ballRadius, ballRadius);
	public Brick brick = new Brick(256, 256, 50, 100, Color.pink);
	
	public AabbCollider testBrick = new AabbCollider(300, 200, 150, 70);
	public CircleCollider testBall = new CircleCollider(100, 100, 5, 5, 20);
	
	public Timer t;
	
	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		t = new Timer(50, this);
		t.start();
		
		setFocusable(true);
		requestFocus();
		
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

//		platform.draw(g);
//		ball.draw(g);
//		brick.draw(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
		
		testBrick.draw(g);
		testBall.draw(g);
		
		testBall.drawDebugCollisionInfo(testBrick, g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				platform.x += 10;
				if (ball.speedX  == 0) {
					ball.x += 10;
				}
				break;
			case KeyEvent.VK_LEFT:
				platform.x -= 10;
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
		ball.x += ball.speedX;
		if (ball.x > S_WIDTH - ball.radius) {
			ball.x = 2 * (S_WIDTH - ball.radius) - ball.x;
			ball.speedX *= -1;
		} else if (ball.x < ball.radius) {
			ball.x += ball.x;
			ball.speedX *= -1;
		}
		
		ball.y += ball.speedY;
		if (ball.y > S_HEIGHT - platform.height - ball.radius) {
			ball.y = 2 * (S_HEIGHT - platform.height - ball.radius) - ball.y; 
			ball.speedY *= -1; 
		} else if (ball.y < ball.radius) {
			ball.y += ball.radius; 
			ball.speedY *= -1;
		}
		repaint();
		
		testBall.pos = testBall.pos.add(testBall.vel);
	}
	
}
