package ie.murph.java.algorithm.math;

public class CumulativeFrequency 
{
	private Normalization normalization;
	private Double[] cumulativefrequencyArray;
	
	public CumulativeFrequency(Normalization normalization)
	{
		this.normalization = normalization;
	}
	
	public void createFrequencyStructure()
	{
		// Cumulative frequency Data for each of the fitness is calculated by adding each of the normalized 
		// data types one after the other finally adding to one. NB: Must be one
		// (e.g. Normalized data: 0.267, 0.267, 0.233, 0.233 --> Cumulative data: 0.267, 0.534, 0.767, 1)
		this.cumulativefrequencyArray = new Double[this.normalization.getOrganizedFitness().getSizeOfMap()];
	}
	
	public void calculateFrequency()
	{
		double previousCumulativeNumber = 0;
		for(int atPostionX = 0; atPostionX < this.normalization.getOrganizedFitness().getSizeOfMap(); atPostionX++)
		{
			//Rounding the data to 3 decimal places.
			this.cumulativefrequencyArray[atPostionX] = (double) Math.round((previousCumulativeNumber + this.normalization.getNormalizedFitness()[atPostionX]) * 1000) / 1000;
			previousCumulativeNumber = this.cumulativefrequencyArray[atPostionX];
		}
		isCumulaiveFreguencyOk();
		printFrequency();
	}
	
	//Cumulative frequency - The total of a frequency and all frequencies so far in a frequency distribution
	private void isCumulaiveFreguencyOk() 
	{
		//Checking or catching any potential errors in the data, as the last cumulative fitness should always be one
		if(this.cumulativefrequencyArray[frequencyLength()] != 1.0)
		{
			this.cumulativefrequencyArray[frequencyLength()] = roundNumberUp() ;
		}
	}
	
	private int frequencyLength()
	{
		return cumulativefrequencyArray.length-1;
	}
	
	private double roundNumberUp() 
	{
		return 1.0;
	}

	private void printFrequency()
	{
		displayArray(this.cumulativefrequencyArray);
	}
	
	public Double[] getCumulativeFrequencyArray()
	{
		return this.cumulativefrequencyArray;
	}
	
	public Normalization getNormalization()
	{
		return this.normalization;
	}
	
	// Method just for printing out the elements of the array.
	private void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}// END OF..
}
