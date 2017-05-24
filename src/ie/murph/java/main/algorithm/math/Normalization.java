package ie.murph.java.main.algorithm.math;

import org.apache.log4j.Logger;

import ie.murph.java.main.algorithm.fitness.OrganizedFitness;
import ie.murph.java.main.algorithm.fitness.SumFitness;

public class Normalization
{
    private static final Logger LOGGER = Logger.getLogger(CumulativeFrequency.class);
    private OrganizedFitness organizedFitness;
    private SumFitness sumFitness;
    private Double[] normalisedFitness;

    public Normalization(OrganizedFitness organizedFitness, SumFitness sumFitness)
    {
	this.organizedFitness = organizedFitness;
	this.sumFitness = sumFitness;
    }

    public void createNormalizedStructure()
    {
	LOGGER.debug("++createNormalizedStructure()\n");
	// Normalized data for each fitness is calculated by finding the sum of
	// all the fitness and then dividing the sum against each individual
	// fitness
	this.normalisedFitness = new Double[organizedFitness.getSizeOfMap()];
	LOGGER.debug("--createNormalizedStructure()\n");
    }

    public void calculateNormalizedData()
    {
	LOGGER.debug("++calculateNormalizedData()\n");
	for (int nextFitness = 0; nextFitness < organizedFitness.getSizeOfMap(); nextFitness++)
	{
	    this.normalisedFitness[nextFitness] = (double) (this.sumFitness.getFitnessValuesList().get(nextFitness)
		    / this.sumFitness.getTotalSumOfFitness());
	}
	displayArray(this.normalisedFitness);
	LOGGER.debug("--calculateNormalizedData()\n");
    }

    public static void displayArray(Object[] numbers)
    {
	LOGGER.debug("++displayArray()\n");
	for (int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
	{
	    System.out.println(numbers[atPositionX]);
	}
	System.out.println("");
	LOGGER.debug("--displayArray()\n");
    }

    public Double[] getNormalizedFitness()
    {
	LOGGER.debug("++getNormalizedFitness()\n");
	return this.normalisedFitness;
    }

    public OrganizedFitness getOrganizedFitness()
    {
	LOGGER.debug("++getOrganizedFitness()\n");
	return this.organizedFitness;
    }

    public SumFitness getSumFitness()
    {
	LOGGER.debug("++getSumFitness()\n");
	return this.sumFitness;
    }
}
