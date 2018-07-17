package main.ie.murph.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import main.ie.murph.algorithm.randomnumber.RandomNumberGenerator;

public class UnorganizedFitness
{
    private static final Logger LOGGER = Logger.getLogger(UnorganizedFitness.class);
    private Map<String, Integer> unorganizedFitnessMap;
    private RandomNumberGenerator randomNumberGenerator;

    public UnorganizedFitness(RandomNumberGenerator randonNumberGenerator)
    {
	this.randomNumberGenerator = randonNumberGenerator;
    }

    // Creating unorganized fitness
    public void putRandomNumbersIntoUnOrganizedMap()
    {
	LOGGER.debug("++putRandomNumbersIntoUnOrganizedMap()\n");
	this.unorganizedFitnessMap = new TreeMap<String, Integer>();
	this.unorganizedFitnessMap = putArrayDataToMap(this.randomNumberGenerator.getRandomWholeNumbers());
	LOGGER.debug("--putRandomNumbersIntoUnOrganizedMap()\n");
    }

    // Put the random numbers in the array into a map tree
    public static Map<String, Integer> putArrayDataToMap(Integer[] allFitnessFromArray)
    {
	LOGGER.debug("++putArrayDataToMap()\n");
	Map<String, Integer> treemapFitness = new TreeMap<String, Integer>();
	int populationCount = 1;
	for (int fitnessX : allFitnessFromArray)
	{
	    treemapFitness.put("Tree Key: " + populationCount, fitnessX);
	    populationCount++;
	}
	LOGGER.debug("+++putArrayDataToMap()\n");
	return treemapFitness;
    }

    public Map<String, Integer> getUnorganizedFitnessMap()
    {
	LOGGER.debug("++getUnorganizedFitnessMap()\n");
	return this.unorganizedFitnessMap;
    }

    public Collection<Integer> getUnorganizedFitnessTreeMapValues()
    {
	LOGGER.debug("++getUnorganizedFitnessTreeMapValues()\n");
	return this.unorganizedFitnessMap.values();
    }

    public Set<String> getUnorganizedFitnessMapKey()
    {
	LOGGER.debug("++getUnorganizedFitnessMapKey()\n");
	return this.unorganizedFitnessMap.keySet();
    }

    public void emptyFitnessMap()
    {
	LOGGER.debug("++emptyFitnessMap()\n");
	this.unorganizedFitnessMap.clear();
	LOGGER.debug("--emptyFitnessMap()\n");
    }

    public void printUnorganizedMap()
    {
	LOGGER.debug("++printUnorganizedMap()\n");
	displayGenericTypes(this.unorganizedFitnessMap.values());
	displayGenericTypes(this.unorganizedFitnessMap.keySet());
	LOGGER.debug("--printUnorganizedMap()\n");
    }

    public RandomNumberGenerator getRandomNumberGenerator()
    {
	LOGGER.debug("++getRandomNumberGenerator()\n");
	return this.randomNumberGenerator;
    }

    // Method just for printing out the elements of the generic collections.
    public void displayGenericTypes(Collection<?> data)
    {
	LOGGER.debug("++displayGenericTypes()\n");
	Iterator<?> iterator = data.iterator();
	while (iterator.hasNext())
	{
	    Object object = iterator.next();
	    System.out.println(object + " ");
	}
	LOGGER.debug("--displayGenericTypes()\n");
    }
}
