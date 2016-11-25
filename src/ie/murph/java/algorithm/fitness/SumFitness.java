package ie.murph.java.algorithm.fitness;

import java.util.ArrayList;
import java.util.List;

public class SumFitness 
{
	private List<Integer> fitnessValuesFromOrderedTreemap;
	private OrganizedFitness organizedFitness;
	private double totalSumOfFitness = 0;
	
	public SumFitness(OrganizedFitness organizedFitness)
	{
		this.organizedFitness = organizedFitness;
	}
	
	public void populateListWithFitnessValues()
	{
		this.fitnessValuesFromOrderedTreemap = new ArrayList<Integer>(this.organizedFitness.getOrderedFitnessValues());
	}
	
	public List<Integer> getFitnessValuesList()
	{
		return this.fitnessValuesFromOrderedTreemap;
	}
	
	public void calculatingTotalSumOfFitness()
	{
		double totalSumOfFitness = 0;
		for(int nextFitness = 0; nextFitness < this.organizedFitness.getSizeOfMap(); nextFitness++)
		{
			totalSumOfFitness += this.fitnessValuesFromOrderedTreemap.get(nextFitness);
		}
		setTotalSumOfFitness(totalSumOfFitness);
	}
	
	private void setTotalSumOfFitness(double totalSumOfFitness)
	{
		this.totalSumOfFitness = totalSumOfFitness;
	}
	
	public double getTotalSumOfFitness()
	{
		return this.totalSumOfFitness;
	}
}
