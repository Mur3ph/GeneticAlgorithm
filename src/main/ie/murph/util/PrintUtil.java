package main.ie.murph.util;

import java.util.Collection;
import java.util.Iterator;

public class PrintUtil 
{
	// Method just for printing out the elements of the generic collections.
	public static void displayGenericTypes(Collection<?> data)
	{
		Iterator<?> itr = data.iterator();
		while(itr.hasNext())
		{
			Object str = itr.next();
 			System.out.println(str + " ");
		}
	}// END OF..
	
	// Method just for printing out the elements of the array.
	public static void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}// END OF..
}

