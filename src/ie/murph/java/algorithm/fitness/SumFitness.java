package ie.murph.java.algorithm.fitness;

import java.util.ArrayList;
import java.util.List;

public class SumFitness 
{
	private List<Integer> fitnessValuesFromOrderedTreemap;
	private OrganizedFitness organizedFitness;
	private double totalSumOfFitness;
	
	public SumFitness(OrganizedFitness organizedFitness)
	{
		this.organizedFitness = organizedFitness;
		this.fitnessValuesFromOrderedTreemap = new ArrayList<Integer>(this.organizedFitness.getOrderedFitnessValues());
	}
	
	public List<Integer> getFitnessValuesFromOrderedTreemap()
	{
		return this.fitnessValuesFromOrderedTreemap;
	}
	
	public void calculatingTotalSumOfFitness()
	{
		for(int nextFitness = 0; nextFitness < this.organizedFitness.getSizeOfMap(); nextFitness++)
		{
			totalSumOfFitness += this.fitnessValuesFromOrderedTreemap.get(nextFitness);
		}
		System.out.println("Total: " + totalSumOfFitness);
	}
	
	public double getTotalSumOfFitness()
	{
		return this.totalSumOfFitness;
	}
}
