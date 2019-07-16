package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTest {
	@Test
	public void test1()
	{
		String obj1 = "junit";
		String obj2 = "junit";
		String obj3 = "test";
		String obj4 = "test";
		String obj5 = null;
		int var1 = 1;
		int var2 = 1;
		int[] arith1 = {1,2,3};
		int[] arith2 = {1,2,3};
		assertEquals(var1, var2);
		assertSame(obj3, obj4);
		assertNotSame(obj1,obj4);
		assertNotNull(obj1);
		assertNull(obj5);
		assertTrue(obj1.equals(obj2));
		assertFalse(obj1.equals(obj3));
		assertArrayEquals(arith1, arith2);
		
	}

}
