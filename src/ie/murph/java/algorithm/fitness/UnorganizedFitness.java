package ie.murph.java.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;

public class UnorganizedFitness 
{
	private Map<String, Integer> unorganizedFitnessTreeMap;
	private RandomNumberGenerator randonNumberGenerator;
	
	public UnorganizedFitness(RandomNumberGenerator randonNumberGenerator)
	{
		this.randonNumberGenerator = randonNumberGenerator;
	}
	
	// Creating unorganized fitness
	public void putRandomNumbersIntoUnOrganizedTreeMap()
	{
		this.unorganizedFitnessTreeMap = new TreeMap<String, Integer>();
		this.unorganizedFitnessTreeMap = putArrayDataToMap(this.randonNumberGenerator.getRandomWholeNumbers());
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
	
	public Map<String, Integer> getUnorganizedFitnessTreeMap()
	{
		return this.unorganizedFitnessTreeMap;
	}
	
	public Collection<Integer> getUnorganizedFitnessTreeMapValues()
	{
		return this.unorganizedFitnessTreeMap.values();
	}
	
	public Set<String> getUnorganizedFitnessTreeMapKey()
	{
		return this.unorganizedFitnessTreeMap.keySet();
	}
	
	public void emptyFitnessTreeMap()
	{
		this.unorganizedFitnessTreeMap.clear();
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
