package ie.murph.java.algorithm.randomnumber;

import java.security.SecureRandom;
import java.util.Random;

//Created Class to remove third party APIs from domain logic

public class RandomNumber 
{
	private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();

	public int getInt(int i) 
	{
		return RANDOM_NUMBER_GENERATOR.nextInt(i);
	}

	public double getDouble() 
	{
		return RANDOM_NUMBER_GENERATOR.nextDouble();
	}
}
