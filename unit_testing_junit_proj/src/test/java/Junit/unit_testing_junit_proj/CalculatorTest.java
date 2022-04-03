package Junit.unit_testing_junit_proj;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator cal=new Calculator();
	
	@Test
	public void squaretest_for_positive_number()
	{
		System.out.println("test1");
		assertEquals(25, cal.square(5));
		
		assertEquals(true,true);
		assertTrue(true);
		assertFalse(false);
		assertNotNull(cal);
		assertNull(null);
		assertArrayEquals(new int[] {1}, new int[] {1});
		assertSame(cal, cal);
		assertNotSame(cal, new Calculator());
		
	}
	
	@Test
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test
	public void test3()
	{
		System.out.println("test3");
	}

	@Before
	public void beforeeverytest()
	{
		System.out.println("Before test");
	}
	
	@After
	public void aftereverytest()
	{
		System.out.println("after test");
	}
	
	@BeforeClass
	public static void beforeclass()
	{
		System.out.println("before class");
	}
	
	@AfterClass
	public static void afterclass()
	{
		System.out.println("after class");
	}
}
