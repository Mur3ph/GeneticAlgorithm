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
	
	public void populate()
	{
		this.fitnessValuesFromOrderedTreemap = new ArrayList<Integer>(this.organizedFitness.getOrderedFitnessValues());
	}
	
	public List<Integer> getFitnessValuesFromOrderedTreemap()
	{
		return this.fitnessValuesFromOrderedTreemap;
	}
	
	public void calculatingTotalSumOfFitness()
	{
		double totalOfAllTheFitness = 0;
		for(int nextFitness = 0; nextFitness < this.organizedFitness.getSizeOfMap(); nextFitness++)
		{
			totalOfAllTheFitness = totalOfAllTheFitness + this.fitnessValuesFromOrderedTreemap.get(nextFitness);
		}
		setTotalSumOfFitness(totalOfAllTheFitness);
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
