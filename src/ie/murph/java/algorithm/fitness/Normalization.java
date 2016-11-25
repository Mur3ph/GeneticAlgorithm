package ie.murph.java.algorithm.fitness;

public class Normalization 
{
	private OrganizedFitness organizedMapData;
	private SumFitness sumFitness;
	private Double[] normalisedFitness;
	
	public Normalization(OrganizedFitness organizedMapFitness, SumFitness sumFitness)
	{
		this.organizedMapData = organizedMapFitness;
		this.sumFitness = sumFitness;
	}
	
	public void createNormalizedStructure()
	{
		// Normalized data for each fitness is calculated by finding the sum of all the fitness and then dividing the sum against each individual fitness
		this.normalisedFitness = new Double[organizedMapData.getSizeOfMap()];
	}
	
	//Dividing each fitness value by the sum of all fitness
	public void calculateNormalizedData() 
	{
		for(int nextFitness = 0; nextFitness < organizedMapData.getSizeOfMap(); nextFitness++)
		{
			this.normalisedFitness[nextFitness] = (double) (this.sumFitness.getFitnessValuesList().get(nextFitness) / this.sumFitness.getTotalSumOfFitness());
		}
		displayArray(this.normalisedFitness);
	}
	
	public static void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}

	public Double[] getNormalizedFitness()
	{
		return this.normalisedFitness;
	}
}
