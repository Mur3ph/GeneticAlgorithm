package ie.murph.java.algorithm.fitness;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.murph.java.algorithm.randomnumber.RandomNumber;
import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;

public class UnorganizedMapFitnessTest {

	private RandomNumber randomNumber;
	private RandomNumberGenerator resultRrandomNumberGenerator;
	private UnorganizedFitness unorganizedFitness;
	
	@Before
    public void setUp() 
	{
		randomNumber = new RandomNumber();
		resultRrandomNumberGenerator = new RandomNumberGenerator(randomNumber);
		unorganizedFitness = new UnorganizedFitness(resultRrandomNumberGenerator);
    }
	
    @After
    public void tearDown() 
    {
    	
    }
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
