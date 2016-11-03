package ie.murph.java.algorithm.randomnumber;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator 
{
//	Look into breaking up Integer, Double into different classes: https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
	private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();
	private int minRangeOfRandomNumber, maxRangeOfRandomNumber;
	private Integer[] randomNumbers;
	
	public RandomNumberGenerator(){}
	
	public void randomNumberbetween(int minRangeOfRandomNumber, int maxRangeOfRandomNumber)
	{
		this.minRangeOfRandomNumber = minRangeOfRandomNumber;
		this.maxRangeOfRandomNumber = maxRangeOfRandomNumber;
	}
	
	public int generateARandomWholeNumber() 
    {
		return RANDOM_NUMBER_GENERATOR.nextInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + 1) + minRangeOfRandomNumber;
	}
	
	public void populateArrayWithRandomWholeNumbersOfLength(int lenghtOfArray)
	{
		randomNumbers = new Integer[lenghtOfArray];
		for(int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
		{
			randomNumbers[atPositionX] = generateARandomWholeNumber();
		}
	}
		
	// Method to get random integers for the fitness
	public Integer[] getRandomWholeNumbers()
	{
		return randomNumbers;
	}
	
	public int getARandomWholeNumber() 
    {
		return generateARandomWholeNumber();
	}
	
	public double getARandomDecimalNumberBetweenZeroAndOne() 
    {
		return RANDOM_NUMBER_GENERATOR.nextDouble();
	}
	
}
