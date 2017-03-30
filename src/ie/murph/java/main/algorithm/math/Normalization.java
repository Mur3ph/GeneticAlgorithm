package ie.murph.java.main.algorithm.math;

import ie.murph.java.main.algorithm.fitness.OrganizedFitness;
import ie.murph.java.main.algorithm.fitness.SumFitness;

public class Normalization 
{
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
		// Normalized data for each fitness is calculated by finding the sum of all the fitness and then dividing the sum against each individual fitness
		this.normalisedFitness = new Double[organizedFitness.getSizeOfMap()];
	}
	
	public void calculateNormalizedData() 
	{
		for(int nextFitness = 0; nextFitness < organizedFitness.getSizeOfMap(); nextFitness++)
		{
			this.normalisedFitness[nextFitness] = (double) (this.sumFitness.getFitnessValuesList().get(nextFitness) / this.sumFitness.getTotalSumOfFitness());
		}
		displayArray(this.normalisedFitness);
	}
	
	public static void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}

	public Double[] getNormalizedFitness()
	{
		return this.normalisedFitness;
	}
	
	public OrganizedFitness getOrganizedFitness()
	{
		return this.organizedFitness;
	}
	
	public SumFitness getSumFitness()
	{
		return this.sumFitness;
	}
}
