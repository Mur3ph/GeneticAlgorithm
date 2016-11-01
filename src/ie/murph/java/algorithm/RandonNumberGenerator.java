package ie.murph.java.algorithm;

import java.security.SecureRandom;
import java.util.Random;

public class RandonNumberGenerator 
{
	private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();
	
	public Integer getARandomNumber(int maxRangeOfRandomNumber) 
    {
		final int minRangeOfRandomNumber = 1;
		final int one = 1;
		return RANDOM_NUMBER_GENERATOR.nextInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + one) + minRangeOfRandomNumber;
	}
	
	// Method to get 5 random integers for the fitness
	// I put it in a method to get consistent and the same random numbers for all each time the algorithm is run.
	public Integer[] getFiveRandomNumbersBetweenOneAndTen()
	{
		final int lenghtOfArray = 5;
		Integer[] fiveRandomNumbers = new Integer[lenghtOfArray];
		final int maxRangeOfRandomNumber = 10;
		for(int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
		{
			fiveRandomNumbers[atPositionX] = getARandomNumber(maxRangeOfRandomNumber);
		}
		return fiveRandomNumbers;
	}
}
