package ie.murph.java.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;

public class UnorganizedFitness 
{
	private Map<String, Integer> unorganizedFitnessMap;
	private RandomNumberGenerator randomNumberGenerator;
	
	public UnorganizedFitness(RandomNumberGenerator randonNumberGenerator)
	{
		this.randomNumberGenerator = randonNumberGenerator;
	}
	
	// Creating unorganized fitness
	public void putRandomNumbersIntoUnOrganizedMap()
	{
		this.unorganizedFitnessMap = new TreeMap<String, Integer>();
		this.unorganizedFitnessMap = putArrayDataToMap(this.randomNumberGenerator.getRandomWholeNumbers());
	}
	
	// Put the random numbers in the array into a map tree
	public static Map<String, Integer> putArrayDataToMap(Integer[] allFitnessFromArray)
	{
		Map<String, Integer> treemapFitness = new TreeMap<String, Integer>();
		int populationCount = 1;
		for(int fitnessX : allFitnessFromArray)
		{
			treemapFitness.put("Tree Key: " + populationCount, fitnessX);
			populationCount++;
		}
		return treemapFitness;
	}
	
	public Map<String, Integer> getUnorganizedFitnessMap()
	{
		return this.unorganizedFitnessMap;
	}
	
	public Collection<Integer> getUnorganizedFitnessTreeMapValues()
	{
		return this.unorganizedFitnessMap.values();
	}
	
	public Set<String> getUnorganizedFitnessMapKey()
	{
		return this.unorganizedFitnessMap.keySet();
	}
	
	public void emptyFitnessMap()
	{
		this.unorganizedFitnessMap.clear();
	}

	public void printUnorganizedMap()
	{
		displayGenericTypes(this.unorganizedFitnessMap.values());
		displayGenericTypes(this.unorganizedFitnessMap.keySet());
	}
	
	public RandomNumberGenerator getRandomNumberGenerator()
	{
		return this.randomNumberGenerator;
	}
	
	// Method just for printing out the elements of the generic collections.
	public void displayGenericTypes(Collection<?> data)
	{
		Iterator<?> iterator = data.iterator();
		while(iterator.hasNext())
		{
			Object object = iterator.next();
 			System.out.println(object + " ");
		}
	}
}
