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
	
	//Placing the random numbers generated from the array to a TreeMap - Unorganized fitness
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
		Map<String, Integer> Tmap2 = new TreeMap<String, Integer>();
		int individualPopulation = 1;
		for(int fitnessX : allFitnessFromArray)
		{
			Tmap2.put("Tree Key"+individualPopulation, fitnessX);
			individualPopulation++;
		}
		return Tmap2;
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
		Iterator<?> itr = data.iterator();
		while(itr.hasNext())
		{
			Object str = itr.next();
 			System.out.println(str + " ");
		}
	}
}
