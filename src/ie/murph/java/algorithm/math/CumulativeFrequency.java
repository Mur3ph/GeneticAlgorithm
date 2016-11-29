package ie.murph.java.algorithm.math;

public class CumulativeFrequency 
{
	private Normalization normalization;
	private Double[] cumulativefrequencyData;
	
	public CumulativeFrequency(Normalization normalization)
	{
		this.normalization = normalization;
	}
	
	public void createFrequencyStructure()
	{
		// Cumulative frequency Data for each of the fitness is calculated by adding each of the normalized 
		// data types one after the other finally adding to one. NB: Must be one
		// (e.g. Normalized data: 0.267, 0.267, 0.233, 0.233 --> Cumulative data: 0.267, 0.534, 0.767, 1)
		this.cumulativefrequencyData = new Double[this.normalization.getOrganizedFitness().getSizeOfMap()];
	}
	
	public void calculateFrequency()
	{
		double previousCumulativeNumber = 0;
		for(int atPostionX = 0; atPostionX < this.normalization.getOrganizedFitness().getSizeOfMap(); atPostionX++)
		{
			//Rounding the data to 3 decimal places.
			this.cumulativefrequencyData[atPostionX] = (double) Math.round((previousCumulativeNumber + this.normalization.getNormalizedFitness()[atPostionX]) * 1000) / 1000;
			previousCumulativeNumber = this.cumulativefrequencyData[atPostionX];
		}
	}
	
	//Cumulative frequency - The total of a frequency and all frequencies so far in a frequency distribution
	public void isCumulaiveFreguency() 
	{
		//Checking or catching any potential errors in the data, as the last cumulative fitness should always be one
		if(this.cumulativefrequencyData[4] == 0.999 || this.cumulativefrequencyData[4] == 0.998)
		{
			this.cumulativefrequencyData[4] = 1.0;
		}
	}
	
	public void printFrequency()
	{
		displayArray(this.cumulativefrequencyData);
	}
	
	// Method just for printing out the elements of the array.
	public static void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}// END OF..
}
