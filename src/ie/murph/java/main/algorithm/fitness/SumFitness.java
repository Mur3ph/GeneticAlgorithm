package ie.murph.java.main.algorithm.fitness;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SumFitness
{
    private static final Logger LOGGER = Logger.getLogger(SumFitness.class);
    private List<Integer> fitnessValuesFromOrderedTreemap;
    private OrganizedFitness organizedFitness;
    private double totalSumOfFitness = 0;

    public SumFitness(OrganizedFitness organizedFitness)
    {
	this.organizedFitness = organizedFitness;
    }

    public void populateListWithFitnessValues()
    {
	LOGGER.debug("++populateListWithFitnessValues()\n");
	this.fitnessValuesFromOrderedTreemap = new ArrayList<Integer>(this.organizedFitness.getOrderedFitnessValues());
	LOGGER.debug("--populateListWithFitnessValues()\n");
    }

    public List<Integer> getFitnessValuesList()
    {
	LOGGER.debug("++getFitnessValuesList()\n");
	return this.fitnessValuesFromOrderedTreemap;
    }

    public void calculatingTotalSumOfFitness()
    {
	LOGGER.debug("++calculatingTotalSumOfFitness()\n");
	double totalSumOfFitness = 0;
	for (int nextFitness = 0; nextFitness < this.organizedFitness.getSizeOfMap(); nextFitness++)
	{
	    totalSumOfFitness += this.fitnessValuesFromOrderedTreemap.get(nextFitness);
	}
	setTotalSumOfFitness(totalSumOfFitness);
	LOGGER.debug("--calculatingTotalSumOfFitness()\n");
    }

    private void setTotalSumOfFitness(double totalSumOfFitness)
    {
	LOGGER.debug("++setTotalSumOfFitness()\n");
	this.totalSumOfFitness = totalSumOfFitness;
	LOGGER.debug("--setTotalSumOfFitness()\n");
    }

    public double getTotalSumOfFitness()
    {
	LOGGER.debug("++getTotalSumOfFitness()\n");
	return this.totalSumOfFitness;
    }
}
