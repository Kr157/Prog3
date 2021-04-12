package snake.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import snake.core.Snake;
@SuppressWarnings("serial")
public class Start extends JFrame {

	public Start(boolean throughwall1, boolean pointsplus1) {
		Board jatek = new Board(throughwall1, pointsplus1);
		add(jatek);
		setVisible(true);
		setResizable(false);
		pack();
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	public Start(Snake seged) {
		Board jatek = new Board(seged);
		add(jatek);
		setVisible(true);
		setResizable(false);
		pack();
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					JFrame ex = new Menu(false, false);
					ex.setVisible(true);
					ex.setLocationRelativeTo(null);
				}
			});
		}
		

	
}
