package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JTest1 {

	@Before
	public void m1() {
		System.out.println("executes before each @Test case");
	}
	@BeforeClass
	public static void m2()
	{
		System.out.println("Executes only one time and first");
	}
	@Test
	public void m3()
	{
		System.out.println("test case1");
	}
	@After
	public void m4()
	{
		System.out.println("executes after each @Test case");
	}
	@AfterClass
	public static void m5()
	{
		System.out.println("Executes only one time and last");
	}
}
