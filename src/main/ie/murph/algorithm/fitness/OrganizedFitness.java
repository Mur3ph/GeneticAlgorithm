package main.ie.murph.algorithm.fitness;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import main.ie.murph.interfaces.MapValueComparator;

public class OrganizedFitness
{
    private static final Logger LOGGER = Logger.getLogger(OrganizedFitness.class);
    private Map<String, Integer> organinizedMapValuesFitness;
    private MapValueComparator orderedMapValueComparator;
    private UnorganizedFitness unorganizedMapFitness;

    public OrganizedFitness(UnorganizedFitness unorganizedMapFitness)
    {
	this.unorganizedMapFitness = unorganizedMapFitness;
    }

    public void organiseUnorderedMapFitness()
    {
	// Maps always order according to the key, so I had to use a comparator
	// interface to order the values the way I wanted instead (Best/Highest
	// fitness first in list)
	LOGGER.debug("++organiseUnorderedMapFitness()\n");
	orderedMapValueComparator = new MapValueComparator(this.unorganizedMapFitness.getUnorganizedFitnessMap());
	LOGGER.debug("--organiseUnorderedMapFitness()\n");
    }

    public void createOrganisedMapWithFitness()
    {
	// Maps always order according to the key, so I had to use a comparator
	// to order the values the way I wanted instead (Best/Highest fitness
	// first in list)
	LOGGER.debug("++createOrganisedMapWithFitness()\n");
	this.organinizedMapValuesFitness = new TreeMap<String, Integer>(orderedMapValueComparator);
	LOGGER.debug("--createOrganisedMapWithFitness()\n");
    }

    public void putOrganizedFitnessIntoNewMap()
    {
	LOGGER.debug("++putOrganizedFitnessIntoNewMap()\n");
	this.organinizedMapValuesFitness.putAll(this.unorganizedMapFitness.getUnorganizedFitnessMap());
	LOGGER.debug("--putOrganizedFitnessIntoNewMap()\n");
    }

    public Map<String, Integer> getOrganizedMapValuesFitness()
    {
	LOGGER.debug("++getOrganizedMapValuesFitness()\n");
	return organinizedMapValuesFitness;
    }

    public Collection<Integer> getOrderedFitnessValues()
    {
	LOGGER.debug("++getOrderedFitnessValues()\n");
	return organinizedMapValuesFitness.values();
    }

    public int getSizeOfMap()
    {
	LOGGER.debug("++getSizeOfMap()\n");
	return organinizedMapValuesFitness.size();
    }

    public void printOrganizedMap()
    {
	LOGGER.debug("++printOrganizedMap()\n");
	displayGenericTypes(this.organinizedMapValuesFitness.values());
	displayGenericTypes(this.organinizedMapValuesFitness.keySet());
	LOGGER.debug("--printOrganizedMap()\n");
    }

    public UnorganizedFitness getUnorganizedFitness()
    {
	LOGGER.debug("++getUnorganizedFitness()\n");
	return this.unorganizedMapFitness;
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
