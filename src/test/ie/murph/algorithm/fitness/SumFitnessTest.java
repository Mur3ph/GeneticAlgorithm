package test.ie.murph.algorithm.fitness;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.ie.murph.algorithm.fitness.OrganizedFitness;
import main.ie.murph.algorithm.fitness.SumFitness;
import main.ie.murph.algorithm.fitness.UnorganizedFitness;
import main.ie.murph.algorithm.randomnumber.RandomNumberGenerator;

public class SumFitnessTest
{
	private SumFitness sumFitness;
	private List<Integer> fitnessValuesFromOrderedTreemap;
	private OrganizedFitness organizedFitness;
	private UnorganizedFitness unorganizedFitness;
    private RandomNumberGenerator randonNumberGenerator;

	@Before
	public void setUp() throws Exception
	{
		randonNumberGenerator = new RandomNumberGenerator();
		unorganizedFitness = new UnorganizedFitness(randonNumberGenerator);
		organizedFitness = new OrganizedFitness(unorganizedFitness);
		sumFitness = new SumFitness(organizedFitness);
	}

	@Test
	public void populateListWithFitnessValuesTest()
	{
		this.fitnessValuesFromOrderedTreemap = new ArrayList<Integer>(this.organizedFitness.getOrderedFitnessValues());
		
		// Ensure Correct order
//        assertThat(this.fitnessValuesFromOrderedTreemap, );
        
        // Number is in range (min <= mynum && mynum <= max)
        assertTrue(1 <= this.fitnessValuesFromOrderedTreemap.indexOf(0) && this.fitnessValuesFromOrderedTreemap.indexOf(this.fitnessValuesFromOrderedTreemap.size()-1) <= 10);
	}

}
