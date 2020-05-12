import javax.swing.JFrame;

import game.GamePanel;

public class GameFrame {

	public static void launchGame() {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Brick Breaker v1.0");
		GamePanel p = new GamePanel();
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
