package com.app.todo;

public class CountOfEvenNumbers {
	
	NumbersGenerator ng;
	
	public CountOfEvenNumbers(NumbersGenerator ng)
	{
		
		this.ng=ng;
		
	}
	
	public int findTheCount()
	{
		int c=0;
		int[] arr=ng.generatenumbers();
		for(int x:arr)
		{
			if(x%2==0)
				c++;
		}
		return c;
	}
	

}
