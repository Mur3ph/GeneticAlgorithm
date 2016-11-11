package ie.murph.java.algorithm.fitness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.murph.java.algorithm.randomnumber.RandomNumber;
import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;

public class UnorganizedFitnessTest 
{
	private final int lengthOfArray = 11;
	private RandomNumber randomNumber;
	private RandomNumberGenerator resultRrandomNumberGenerator;
	private UnorganizedFitness unorganizedFitness;
	
	@Before
    public void setUp() 
	{
		randomNumber = new RandomNumber();
		resultRrandomNumberGenerator = new RandomNumberGenerator(randomNumber);
		resultRrandomNumberGenerator.setRandomNumberbetween(1, 10);
		resultRrandomNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(lengthOfArray);
		unorganizedFitness = new UnorganizedFitness(resultRrandomNumberGenerator);
    }
	
	@Test
	public void placeRandomNumbersIntoUnOrganizedTreeMapTest() 
	{
		unorganizedFitness.putRandomNumbersIntoUnOrganizedTreeMap();
		unorganizedFitness.displayGenericTypes(unorganizedFitness.getUnorganizedFitnessTreeMapValues());
		assertTrue(isLengthSame(unorganizedFitness.getUnorganizedFitnessTreeMapValues().size()));
	}
	
	private boolean isLengthSame(final int amountOfValuesInCollection) 
	{
		if(amountOfValuesInCollection == lengthOfArray)
		{
			return true;
		}
		return false;
	}

}
