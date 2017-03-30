package ie.murph.java.main.algorithm.randomnumber;

public class RandomNumberGenerator
{
//	Look into breaking up Integer, Double into different classes: https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
	private RandomNumber randomNumber;
	private int minRangeOfRandomNumber, maxRangeOfRandomNumber;
	private Integer[] randomNumbers;
	
	public RandomNumberGenerator(){}
	
	public RandomNumberGenerator(RandomNumber randomNumber)
	{
		this.randomNumber = randomNumber;
	}
	
	public void setRandomNumberbetween(int minRangeOfRandomNumber, int maxRangeOfRandomNumber)
	{
		this.minRangeOfRandomNumber = minRangeOfRandomNumber;
		this.maxRangeOfRandomNumber = maxRangeOfRandomNumber;
	}
	
	public void populateArrayWithRandomWholeNumbersOfLength(int lenghtOfArray)
	{
		randomNumbers = new Integer[lenghtOfArray];
		for(int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
		{
			randomNumbers[atPositionX] = getARandomWholeNumber();
		}
	}
	
	public int getARandomWholeNumber() 
    {
		return randomNumber.getInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + 1) + minRangeOfRandomNumber;
	}
		
	// Method to get random integers for the fitness
	public Integer[] getRandomWholeNumbers()
	{
		return randomNumbers;
	}
	
	public double getARandomDecimalNumberBetweenZeroAndOne() 
    {
		return randomNumber.getDouble();
	}
	
	public void clearArray()
	{
		randomNumbers = null;
	}
	
}
