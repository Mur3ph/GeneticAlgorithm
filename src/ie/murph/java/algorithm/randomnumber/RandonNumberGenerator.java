package ie.murph.java.algorithm.randomnumber;

import java.security.SecureRandom;
import java.util.Random;

public class RandonNumberGenerator 
{
	private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();
	private int randomNumber;
	private int[] randomNumbers;
	
	public RandonNumberGenerator()
	{
		
	}
	
	public void generateARandomWholeNumber(int maxRangeOfRandomNumber) 
    {
		final int minRangeOfRandomNumber = 1;
		final int one = 1;
		randomNumber = RANDOM_NUMBER_GENERATOR.nextInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + one) + minRangeOfRandomNumber;
	}
	
	public void populateWithRandomWholeNumbers(int lenghtOfArray)
	{
		randomNumbers = new int[lenghtOfArray];
		for(int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
		{
			randomNumbers[atPositionX] = randomNumber;
		}
	}
		
	// Method to get random integers for the fitness
	public int[] getRandomWholeNumbers()
	{
		return randomNumbers;
	}
	
	public double getRandomDecimalNumberBetweenZeroAndOne() 
    {
		return RANDOM_NUMBER_GENERATOR.nextDouble();
	}
	
}
