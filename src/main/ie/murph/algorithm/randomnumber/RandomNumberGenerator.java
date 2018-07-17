package main.ie.murph.algorithm.randomnumber;

import org.apache.log4j.Logger;

public class RandomNumberGenerator
{
    private static final Logger LOGGER = Logger.getLogger(RandomNumberGenerator.class);
    // Look into breaking up Integer, Double into different classes:
    // https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
    private RandomNumber randomNumber;
    private int minRangeOfRandomNumber, maxRangeOfRandomNumber;
    private Integer[] randomNumbers;

    public RandomNumberGenerator()
    {
    }

    public RandomNumberGenerator(RandomNumber randomNumber)
    {
	this.randomNumber = randomNumber;
    }

    public void setRandomNumberbetween(int minRangeOfRandomNumber, int maxRangeOfRandomNumber)
    {
	LOGGER.debug("++setRandomNumberbetween()\n");
	this.minRangeOfRandomNumber = minRangeOfRandomNumber;
	this.maxRangeOfRandomNumber = maxRangeOfRandomNumber;
	LOGGER.debug("--setRandomNumberbetween()\n");
    }

    public void populateArrayWithRandomWholeNumbersOfLength(int lenghtOfArray)
    {
	LOGGER.debug("++populateArrayWithRandomWholeNumbersOfLength()\n");
	randomNumbers = new Integer[lenghtOfArray];
	for (int atPositionX = 0; atPositionX < lenghtOfArray; atPositionX++)
	{
	    randomNumbers[atPositionX] = getARandomWholeNumber();
	}
	LOGGER.debug("--populateArrayWithRandomWholeNumbersOfLength()\n");
    }

    public int getARandomWholeNumber()
    {
	LOGGER.debug("++getARandomWholeNumber()\n");
	return randomNumber.getInt(maxRangeOfRandomNumber - minRangeOfRandomNumber + 1) + minRangeOfRandomNumber;
    }

    // Method to get random integers for the fitness
    public Integer[] getRandomWholeNumbers()
    {
	LOGGER.debug("++getRandomWholeNumbers()\n");
	return randomNumbers;
    }

    public double getARandomDecimalNumberBetweenZeroAndOne()
    {
	LOGGER.debug("++getARandomDecimalNumberBetweenZeroAndOne()\n");
	return randomNumber.getDouble();
    }

    public void clearArray()
    {
	LOGGER.debug("++getInt()\n");
	randomNumbers = null;
	LOGGER.debug("++getInt()\n");
    }

}
