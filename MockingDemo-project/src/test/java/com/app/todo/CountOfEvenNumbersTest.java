package com.app.todo;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountOfEvenNumbersTest {
	
	@Mock
	NumbersGenerator ng;
	
	@Mock
	List lst;
	
	@Mock
	List<Integer> inlst;
	
	@InjectMocks
	CountOfEvenNumbers coe;

	@Test
	public void findTheCountTest() {
	CountOfEvenNumbers coe=new CountOfEvenNumbers(new NumbersGeneratorStub());
	int res=coe.findTheCount();
	assertEquals(3, res);
	}
	
	@Test
	public void NegativeNumbersTheCountTest() {
    when(ng.generatenumbers()).thenReturn(new int[] {-1,-4,-10,-5,-2});
    
	int res=coe.findTheCount();
	assertEquals(3, res);
	}
	
	@Test
	public void ZeroCountTest() {
		when(ng.generatenumbers()).thenReturn(new int[] {0});
		int res=coe.findTheCount();
		assertEquals(1, res);
	}
	
	
	//Mocking List Inteface
	
	@Test
	public void list_size_mocking()
	{
		when(lst.size()).thenReturn(2);
		assertEquals(2,lst.size());
	}
	
	@Test
	public void multiple_times_calling_samemethod()
	{
		List mockedlst=mock(List.class);
		when(mockedlst.size()).thenReturn(2).thenReturn(5);
		assertEquals(2,mockedlst.size());
		assertEquals(5,mockedlst.size());
	}
	
	@Test
	public void calling_specific_parameter_in_mock()
	{
		List mklst=mock(List.class);
		when(mklst.get(0)).thenReturn(20);
		assertEquals(20,mklst.get(0));
		assertNotEquals(30,mklst.get(2));
	}
	
	@Test
	public void calling_all_generic_type_in_mock()
	{
		when(inlst.get(Mockito.anyInt())).thenReturn(30);
		assertEquals(inlst.get(10), new Integer(30));
		assertEquals(inlst.get(0),new Integer(30));
		
	}
}
