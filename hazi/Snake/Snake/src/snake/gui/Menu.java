package snake.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import snake.core.Snake;



@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JButton new_gameb, loadb, helpb, settingsb;
	private JPanel new_gamep, loadp, helpp, settingsp;
	private static Start Scf;
	private static GridLayout lm;
	private boolean throughwall;
	private boolean pointsplus;
	
	public Menu(boolean throughwall1, boolean pointsplus1) {
		this.throughwall = throughwall1;
		this.pointsplus = pointsplus1;
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		this.setSize(300, 300);
		lm=new GridLayout();
		lm.setRows(4);
		lm.setColumns(1);
		this.setLayout(lm);
		
		new_gamep = new JPanel();
		add(new_gamep);
		new_gameb=new JButton();
		new_gameb.setText("New Game");
		setVisible(true);
		new_gameb.addActionListener(new NGButtonActionListener());
		new_gamep.add(new_gameb);
		
		loadp = new JPanel();
		add(loadp);
		loadb=new JButton();
		loadb.setText("Load Game");
		setVisible(true);
		loadb.addActionListener(new LGButtonActionListener());
		loadp.add(loadb);
		
		helpp = new JPanel();
		add(helpp);
		helpb=new JButton();
		helpb.setText("Help");
		setVisible(true);
		helpb.addActionListener(new HButtonActionListener());
		helpp.add(helpb);
		
		settingsp = new JPanel();
		add(settingsp);
		settingsb=new JButton();
		settingsb.setText("Settings");
		setVisible(true);
		settingsb.addActionListener(new SButtonActionListener());
		settingsp.add(settingsb);
	}
	
	private class NGButtonActionListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent ae) {
			setCf(new Start(throughwall, pointsplus));
			setVisible(false);
		}
	}
	private class LGButtonActionListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent ae) {
			try {
				loadgame();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	private class HButtonActionListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent ae) {
		help();
		}

	}
	private class SButtonActionListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent ae) {
				settings();
		}
	}
	
	private class WButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
			if(throughwall == false) {
				throughwall = true;
			} else {
				throughwall = false;
			}
			setVisible(false);
			JFrame ex1 = new Menu(throughwall, pointsplus);
			ex1.setVisible(true);
			ex1.setLocationRelativeTo(null);
		}
	}
	
private class PButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
			if(pointsplus == false) {
				pointsplus = true;
			} else {
				pointsplus = false;
			}
			setVisible(false);
			JFrame ex1 = new Menu(throughwall, pointsplus);
			ex1.setVisible(true);
			ex1.setLocationRelativeTo(null);
	}
}
	
	private void settings() {
		remove(new_gamep);
		remove(loadp);
		remove(settingsp);
		remove(helpp);
		JPanel wallp = new JPanel();
		JButton wallb = new JButton();
		wallb.setText("Wall" +" " + throughwall);
		wallb.addActionListener(new WButtonActionListener());
		wallp.add(wallb);
		JPanel pointsp = new JPanel();
		JButton pointsb = new JButton();
		pointsp.add(pointsb);
		pointsb.setText("Points" +" " + pointsplus);
		pointsb.addActionListener(new PButtonActionListener());
		add (wallp);
		add(pointsp);
		addKeyListener(new KAdapter());
		setVisible(true);
		repaint();
	}
	
	private void help() {
		remove(new_gamep);
		remove(loadp);
		remove(settingsp);
		remove(helpp);
		lm.setRows(1);
		lm.setColumns(1);
		JPanel word = new JPanel();
		addKeyListener(new KAdapter());
		JTextArea f1 = new JTextArea("Minél több pontot kell szerezni. Ezt a kis almák megevésével érhetjük el."
				+ "De ez növeli a kigyó méretét, kivéve, ha a bizonyos idõközönként megjelenõ "
				+ "jutalomfalat, mely míg nem ettük meg a normál almát addig látszódik, de csak kis ideig ad többletpontot."
				+ "Ha kimennénk a pályáról(kivéve ha ez megengedett, de akkor másik oldalon térünk vissza)"
				+ "vagy magunknak mennénk, akkor vesztünk. Irányítani a nyilakkal lehet, s játékot menteni, "
				+ "ha megnyomjuk közben az s betüt, de csak egy mentés lehet, ezáltal az elõzõt felülírjuk.");
		f1.setSize(250, 250);
		
		f1.setLineWrap(true);
		word.add(f1);
		add(word);
		setVisible(true);
		repaint();
		System.out.println(f1.getPreferredSize());
	}
	
	private class KAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				setVisible(false);
				JFrame ex1 = new Menu(throughwall, pointsplus);
				ex1.setVisible(true);
				ex1.setLocationRelativeTo(null);
			}
		}
	} 
		
	public static Start getCF() {
		return Scf;
	}
	
	public static void setCf(Start cf) {
		System.out.println("Ajjaj!");
	}
	
	private void loadgame() throws FileNotFoundException, IOException, ClassNotFoundException {
		Snake seged = new Snake(throughwall, pointsplus);
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("users.txt"));
		seged=(Snake)is.readObject();
		is.close();
		new Start(seged);
	}
	
	public boolean getthroughwall() {
		return this.throughwall;
	}
	
	public boolean getpointsplus() {
		return this.pointsplus;
	}
	
}
