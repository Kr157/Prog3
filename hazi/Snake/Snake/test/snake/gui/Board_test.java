package snake.gui;

import org.junit.Assert;
import org.junit.Test;

public class Board_test {
	
	@Test
	public void testthroughwall() {
		Board seged = new Board(true, false);
		Assert.assertEquals("siker", seged.getthroughwall(), true);
	}
	
	@Test
	public void testpointsplus() {
		Board seged = new Board(true, false);
		Assert.assertEquals("siker", seged.getpointsplus(), false);
	}
	
	@Test
	public void testdotsize() {
		Board seged = new Board(true, false);
		Assert.assertEquals("siker", seged.getDotSize(), 10);
	}
	
}
