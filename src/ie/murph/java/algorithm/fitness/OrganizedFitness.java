package ie.murph.java.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import ie.murph.java.interfaces.MapValueComparator;

public class OrganizedFitness 
{
	private Map<String, Integer> sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface;
	private MapValueComparator orderedValuesAccordingToComparatorInterface;
	private UnorganizedFitness unorganizedMapFitness;

	public OrganizedFitness(UnorganizedFitness unorganizedMapFitness)
	{
		this.unorganizedMapFitness = unorganizedMapFitness;
	}
	
	public void organiseUnorderedTreeMapFitnessUsingComparator()
	{
		//This is an interface  I created to order the Map according to my specification
		orderedValuesAccordingToComparatorInterface = new MapValueComparator(this.unorganizedMapFitness.getUnorganizedFitnessTreeMap());
	}
	
	public void createOrganisedTreeMapWithFitness()
	{
		// Constructs a new empty tree map, ordered according to the given comparator (orderedValuesAccordingToComparatorInterface)
		// Maps always order according to the key, so I had to use a comparator to order the values the was I wanted instead (Best/Highest fitness first in list)
		this.sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface = new TreeMap<String, Integer>(orderedValuesAccordingToComparatorInterface);
	}
	
	public void putOrganizedFitnessIntoNewMap()
	{
		this.sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface.putAll(this.unorganizedMapFitness.getUnorganizedFitnessTreeMap());
	}
	
	public Map<String, Integer> getSortedTreeMapWithOrderedFitnessAccordingToComparatorInterface()
	{
		return sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface;
	}
	
	public Collection<Integer> getOrderedFitnessValues()
	{
		return sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface.values();
	}
	
	public int getSizeOfMap()
	{
		return sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface.size();
	}
	
	public void printOrganizedTreeMap()
	{
		displayGenericTypes(this.sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface.values());
		displayGenericTypes(this.sortedTreeMapWithOrderedFitnessAccordingToComparatorInterface.keySet());
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
