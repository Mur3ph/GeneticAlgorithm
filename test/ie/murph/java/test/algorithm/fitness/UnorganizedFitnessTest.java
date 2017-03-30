package ie.murph.java.test.algorithm.fitness;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ie.murph.java.main.algorithm.fitness.UnorganizedFitness;
import ie.murph.java.main.algorithm.randomnumber.RandomNumber;
import ie.murph.java.main.algorithm.randomnumber.RandomNumberGenerator;

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
	
	@After
    public void tearDown() 
    {
		unorganizedFitness.emptyFitnessMap();
    }
	
	@Test
	public void sizeOfUnOrganizedTreeMapTest() 
	{
		unorganizedFitness.putRandomNumbersIntoUnOrganizedMap();
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
	
	@Test
	public void isNotEmptyUnOrganizedTreeMapTest() 
	{
		unorganizedFitness.putRandomNumbersIntoUnOrganizedMap();
		assertFalse(unorganizedFitness.getUnorganizedFitnessMap().isEmpty());
	}
	
	@Test
	public void isEmptyUnOrganizedTreeMapTest() 
	{
		unorganizedFitness.putRandomNumbersIntoUnOrganizedMap();
		unorganizedFitness.emptyFitnessMap();
		assertTrue(unorganizedFitness.getUnorganizedFitnessMap().isEmpty());
	}
	
	@Ignore
	public void isNullUnOrganizedTreeMapTest() 
	{
		assertNull(unorganizedFitness.getUnorganizedFitnessMap());
	}
	
	@Ignore
	public void isNotNullUnOrganizedTreeMapTest() 
	{
		unorganizedFitness.putRandomNumbersIntoUnOrganizedMap();
		assertNotNull(unorganizedFitness.getUnorganizedFitnessTreeMapValues().isEmpty());
	}

}
