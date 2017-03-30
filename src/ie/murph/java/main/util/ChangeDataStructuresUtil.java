package ie.murph.java.main.util;

import java.util.Map;
import java.util.TreeMap;

public class ChangeDataStructuresUtil 
{
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
}
