package snake.core;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

public class Snake_test {
	
	@Test
	public void testmove() {
		Snake kigyo = new Snake(false, false);
		kigyo.downDirection = true;
		for(int z = 0; z < (kigyo.getdots()); z++) {
			Point seged = new Point(50 -(z*10) ,50);
			kigyo.dcordinate.add(seged);
		}
		kigyo.move(10, 300, 300);
		Point lepes = new Point(50,60);
		kigyo.dcordinate.get(0);
		Assert.assertEquals("siker", lepes, kigyo.dcordinate.get(0));
	}
	
	@Test
	public void testwall() {
		Snake kigyo = new Snake(true, false);
		Assert.assertEquals("siker", kigyo.getthroughwall(), true);
	}
	
	@Test
	public void testpluspoint() {
		Snake kigyo = new Snake(true, false);
		Assert.assertEquals("siker", kigyo.getpointsplus(), false);
	}
	
	@Test
	public void testdot() {
		Snake kigyo = new Snake(true, false);
		kigyo.setdots(15);
		Assert.assertEquals("siker", kigyo.getdots(), 18);
	}
	
	@Test
	public void testpoint() {
		Snake kigyo = new Snake(true, false);
		kigyo.setpoint(8);
		Assert.assertEquals("siker", kigyo.getpoint(), 8);
	}
	
}
