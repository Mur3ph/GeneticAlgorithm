package ie.murph.java.main.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import ie.murph.java.main.interfaces.MapValueComparator;

public class OrganizedFitness 
{
	private Map<String, Integer> organinizedMapValuesFitness;
	private MapValueComparator orderedMapValueComparator;
	private UnorganizedFitness unorganizedMapFitness;

	public OrganizedFitness(UnorganizedFitness unorganizedMapFitness)
	{
		this.unorganizedMapFitness = unorganizedMapFitness;
	}
	
	public void organiseUnorderedMapFitness()
	{
		// Maps always order according to the key, so I had to use a comparator interface to order the values the way I wanted instead (Best/Highest fitness first in list)
		orderedMapValueComparator = new MapValueComparator(this.unorganizedMapFitness.getUnorganizedFitnessMap());
	}
	
	public void createOrganisedMapWithFitness()
	{
		// Maps always order according to the key, so I had to use a comparator to order the values the way I wanted instead (Best/Highest fitness first in list)
		this.organinizedMapValuesFitness = new TreeMap<String, Integer>(orderedMapValueComparator);
	}
	
	public void putOrganizedFitnessIntoNewMap()
	{
		this.organinizedMapValuesFitness.putAll(this.unorganizedMapFitness.getUnorganizedFitnessMap());
	}
	
	public Map<String, Integer> getOrganizedMapValuesFitness()
	{
		return organinizedMapValuesFitness;
	}
	
	public Collection<Integer> getOrderedFitnessValues()
	{
		return organinizedMapValuesFitness.values();
	}
	
	public int getSizeOfMap()
	{
		return organinizedMapValuesFitness.size();
	}
	
	public void printOrganizedMap()
	{
		displayGenericTypes(this.organinizedMapValuesFitness.values());
		displayGenericTypes(this.organinizedMapValuesFitness.keySet());
	}
	
	public UnorganizedFitness getUnorganizedFitness()
	{
		return this.unorganizedMapFitness;
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
