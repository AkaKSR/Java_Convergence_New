import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyFunction {
	public static int add(int a, int b) {
		return a + b;
	}

	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}

	@Test
	public void addTest() {
		assertEquals(MyFunction.add(4, 6), 10);
	}
}
