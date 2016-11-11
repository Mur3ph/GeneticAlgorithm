package ie.murph.java.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;
import ie.murph.java.interfaces.ConsoleMessage;

public class UnorganizedFitness 
{
	private Map<String, Integer> unorganizedFitnessTreeMap;
	private RandomNumberGenerator randonNumberGenerator;
	
	public UnorganizedFitness(RandomNumberGenerator randonNumberGenerator)
	{
		this.randonNumberGenerator = randonNumberGenerator;
	}
	
	// Creating unorganized fitness
	public void placeRandomNumbersIntoUnOrganizedTreeMap()
	{
		System.out.println(ConsoleMessage.GENERATE_UNORGANISED_FITNESS_VALUES_PHASE_ONE);
		this.unorganizedFitnessTreeMap = new TreeMap<String, Integer>();
		this.unorganizedFitnessTreeMap = putArrayDataToMap(this.randonNumberGenerator.getRandomWholeNumbers());
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
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

	// Method just for printing out the elements of the generic collections.
	public static void displayGenericTypes(Collection<?> data)
	{
		Iterator<?> iterator = data.iterator();
		while(iterator.hasNext())
		{
			Object object = iterator.next();
 			System.out.println(object + " ");
		}
	}
}
