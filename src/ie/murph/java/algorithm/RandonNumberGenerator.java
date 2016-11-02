package ie.murph.java.algorithm;

import java.security.SecureRandom;
import java.util.Random;

public class RandonNumberGenerator 
{
	private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();
	private Integer randomNumber;
	private Integer[] randomNumbers;
	
	public RandonNumberGenerator()
	{
		
	}
	
	public void generateARandomNumber(int maxRangeOfRandomNumber) 
    {
		final int minRangeOfRandomNumber = 1;
		final int one = 1;
		randomNumber = RANDOM_NUMBER_GENERATOR.nextInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + one) + minRangeOfRandomNumber;
	}
	
	public void populateWithRandomNumbers(int lenghtOfArray)
	{
		randomNumbers = new Integer[lenghtOfArray];
		for(int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
		{
			randomNumbers[atPositionX] = randomNumber;
		}
	}
		
	// Method to get random integers for the fitness
	public Integer[] getRandomNumers()
	{
		return randomNumbers;
	}
	
	
	
}
