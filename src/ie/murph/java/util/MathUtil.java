package ie.murph.java.util;

public class MathUtil 
{
	//Rounding them numbers to 3 decimal places
	public static double roundToThreeDecimalPlaces(double randomDouble) 
	{
		return (double) Math.round(randomDouble * 1000) / 1000;
	}
	
	public static double roundNumberUp(double number) 
	{
		return Math.ceil(number);
	}
	
	public static Double roundNumberDown(double number) 
	{
		return Math.floor(number);
	}
}
