package snake.core;

public class Food {
	
	private int x, y;
	
	public void locateApple(int Rand_Pos, int DotSize) {
		int r = (int)(Math.random() * Rand_Pos);
		this.x = r * DotSize;
		
		r = (int)(Math.random() * Rand_Pos);
		this.y = r * DotSize;
	}
	
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
}
