package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import snake.core.Snake;
import snake.core.Food;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	private boolean inGame = true;
	private boolean throughwall;
	private boolean pointsplus;
	
	private int B_widht = 300;
	private int B_height = 300;
	private int DotSize = 10;
	private int Rand_Pos = 29;
	private int Delay = 140;
	private int time = 12;
	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	private Image apple2;
	
	Snake kigyo;
	Food alma = new Food();
	Food zoldalma = new Food();
	
	public Board(boolean throughwall1, boolean pointsplus1) {
		this.throughwall = throughwall1;
		this.pointsplus = pointsplus1;
		
		kigyo = new Snake(throughwall, pointsplus);
		try {
			kigyo.settoppoints();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_widht, B_height));
        loadImages();
        initGame();
	}
	
	public Board(Snake seged) {
		kigyo = seged;
		addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_widht, B_height));
        loadImages();
        initGame();
	}
	
	private void loadImages() {
		ImageIcon iid = new ImageIcon(getClass().getResource("/picture/dot.png"));
		ball = iid.getImage();
		
		ImageIcon iia = new ImageIcon(getClass().getResource("/picture/apple.png"));
		apple = iia.getImage();
		
		ImageIcon iih = new ImageIcon(getClass().getResource("/picture/head.png"));
		head = iih.getImage();
		
		ImageIcon iia2 = new ImageIcon(getClass().getResource("/picture/apple2.png"));
		apple2 = iia2.getImage();
	}
	
	private void initGame() {
		//kigyo.hcordinate.setLocation(50, 50);
		
		for(int z = 0; z < (kigyo.getdots()); z++) {
			Point seged = new Point(50 -(z*DotSize) ,50);
			kigyo.dcordinate.add(seged);
		}
		
		alma.locateApple(Rand_Pos, DotSize);
		
		timer = new Timer(Delay, this);
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D gui = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, B_widht, B_height);
        gui.setPaint(Color.BLACK);
        gui.fill(rectangle);
		doDrawing(g);
	}
	
	private void doDrawing(Graphics g) {
		if (inGame) {
			g.drawImage(apple, alma.getx(), alma.gety(), this);
			if (kigyo.getdots()%5 == 0 && time > 0) {
				time--;
				g.drawImage(apple2, zoldalma.getx(), zoldalma.gety(), this);
			}
			for (int z = 0; z < (kigyo.getdots()-1); z++) {
				if (z == 0) {
					g.drawImage(head, kigyo.dcordinate.get(z).x, kigyo.dcordinate.get(z).y, this);
				} else {
					g.drawImage(ball, kigyo.dcordinate.get(z).x, kigyo.dcordinate.get(z).y, this);
				}
			}
			
			Toolkit.getDefaultToolkit().sync();
		} else {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font ("Helvetico", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);;
		g.drawString(msg, (B_widht - metr.stringWidth(msg)) /2, B_height / 2);
		System.out.println(kigyo.gettoppoint1());
		System.out.println(kigyo.gettoppoint2());
		System.out.println(kigyo.gettoppoint3());
		
	}
	
	private void checkzoldApple(int pont) {
		if ((kigyo.dcordinate.get(0).x == zoldalma.getx()) && (kigyo.dcordinate.get(0).y == zoldalma.gety())) {
			kigyo.setpoint(pont);
			zoldalma.locateApple(Rand_Pos, DotSize);
			System.out.println(kigyo.getpoint());
		}
		if (time == 12) {
			pont = 4096;
		}
		pont = (int) Math.sqrt(pont);
	}
	
	private void checkApple() {
		if ((kigyo.dcordinate.get(0).x == alma.getx()) && (kigyo.dcordinate.get(0).y == alma.gety())) {
			kigyo.setdots(1);
			kigyo.setpoint(8);
			alma.locateApple(Rand_Pos, DotSize);
			kigyo.dcordinate.add(null);
			System.out.println(kigyo.getpoint());
		}
	}
		
		private void checkCollision() {
			for(int z = (kigyo.getdots()-2); z > 0; z--) {
				if (z > 4) {
					 if ( (kigyo.dcordinate.get(0).x == kigyo.dcordinate.get(z).x) && (kigyo.dcordinate.get(0).y == kigyo.dcordinate.get(z).y)) {
						 inGame = false;
					 }
				}
			}
			
			if (kigyo.dcordinate.get(0).y >= B_height) {
				inGame = false;
			}
			
			if (kigyo.dcordinate.get(0).y < 0) {
				inGame = false;
			}
			
			if (kigyo.dcordinate.get(0).x >= B_widht) {
				inGame = false;
			}
			
			if (kigyo.dcordinate.get(0).x < 0) {
				inGame = false;
			}
			
			if (!inGame) {
				timer.stop();
			}
		
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			kigyo.settop();
			checkApple();
			checkCollision();
			kigyo.move(DotSize, B_widht, B_height);
			if (pointsplus == true) {
				if (kigyo.getdots()%5 == 0 && time == 0) {
					time = 12;
				}
				if (kigyo.getdots()%5 == 0 || time > 0) {
					int pont = 0;
					checkzoldApple(pont);
				}
			}
		}
		//repaint();
		//this.removeAll();
		repaint();
	}
	
	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT && !kigyo.rightDirection) {
				kigyo.leftDirection = true;
				kigyo.upDirection = false;
				kigyo.downDirection = false;
			}
			
			if (key == KeyEvent.VK_RIGHT && !kigyo.leftDirection) {
				kigyo.rightDirection = true;
				kigyo.upDirection = false;
				kigyo.downDirection = false;
			}
			
			if (key == KeyEvent.VK_UP && !kigyo.downDirection) {
				kigyo.leftDirection = false;
				kigyo.upDirection = true;
				kigyo.rightDirection = false;
			}
			
			if (key == KeyEvent.VK_DOWN && !kigyo.upDirection) {
				kigyo.leftDirection = false;
				kigyo.rightDirection = false;
				kigyo.downDirection = true;
			}
			
			if(key == KeyEvent.VK_ESCAPE) {
				setVisible(false);
				JFrame ex1 = new Menu(throughwall, pointsplus);
				ex1.setVisible(true);
				ex1.setLocationRelativeTo(null);
			}
			
			if(key == KeyEvent.VK_S) {
				System.out.println("Save");
				save();
			}
			
			
			
		}
	}
	
	public void save() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("users.txt"));
			os.writeObject(kigyo);
			System.out.println("Sikeres");
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean getthroughwall() {
		return this.throughwall;
	}
	
	public boolean getpointsplus() {
		return this.pointsplus;
	}
	
	public int getDotSize() {
		return this.DotSize;
	}
	
}