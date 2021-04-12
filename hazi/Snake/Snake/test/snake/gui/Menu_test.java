package snake.gui;

import org.junit.Assert;
import org.junit.Test;

public class Menu_test {
	
	@Test
	public void testthroughwall() {
		Menu seged = new Menu(true, false);
		Assert.assertEquals("siker", seged.getthroughwall(), true);
	}
	
	@Test
	public void testpointsplus() {
		Menu seged = new Menu(true, false);
		Assert.assertEquals("siker", seged.getpointsplus(), false);
	}
}
