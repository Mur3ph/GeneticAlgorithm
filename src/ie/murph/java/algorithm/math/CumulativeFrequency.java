package ie.murph.java.algorithm.math;


public class CumulativeFrequency 
{
	private Normalization normalization;
	private Double[] cumulativefrequencyArray;
	private Integer[] fitnessPositionNumbers;
	
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
	
	//Rounding them numbers to 3 decimal places
	public double roundDouble(double randomDouble) 
	{
		return (double) Math.round(randomDouble * 1000) / 1000;
	}
	
	public double getRandomDouble()
	{
		return this.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getARandomDecimalNumberBetweenZeroAndOne();
	}
	
	//This method is used to find the position in the TreeMap of the two numbers, using the input of the two random numbers chosen in above method - (generateTheTwoContinuesRandomNumbersBetween0and1)
	public void setPositionOfFitness(Double[] cumulativeFitnessArray, double continuesRandonNumberBetweenZeroAndOne_1, double continuesRandonNumberBetweenZeroAndOne_2)
	{
		fitnessPositionNumbers = new Integer[2];
		
		//Looping threw the data set to find out when cumulative frequency is larger than the first random double between 1 & 0 
		//Then selecting that particular cumulative number for manipulation
		for(int fitnessNumber = 0; fitnessNumber < fitnessPositionNumbers.length; fitnessNumber++)
		{
			setPositionOfFitnessDeux(cumulativeFitnessArray, fitnessNumber, continuesRandonNumberBetweenZeroAndOne_1, continuesRandonNumberBetweenZeroAndOne_2);
		}
	}
	
	public void setPositionOfFitnessDeux(Double[] cumulativeFitnessArray, int fitnessNumber, double continuesRandonNumberBetweenZeroAndOne_1, double continuesRandonNumberBetweenZeroAndOne_2)
	{
		double correspondingCumulativeFitness = 0;
		Double[] bothContinuesRandonNumberBetweenZeroAndOne = new Double[]{continuesRandonNumberBetweenZeroAndOne_1, continuesRandonNumberBetweenZeroAndOne_2};
		
		for(int frequencyNumber = 0; frequencyNumber < cumulativeFitnessArray.length; frequencyNumber++)
		{
			if(cumulativeFitnessArray[frequencyNumber] >= bothContinuesRandonNumberBetweenZeroAndOne[fitnessNumber]) 
			{
				correspondingCumulativeFitness = cumulativeFitnessArray[frequencyNumber];
				fitnessPositionNumbers[fitnessNumber] = frequencyNumber;
				System.out.println("Fittest 1: " + correspondingCumulativeFitness + " PositionX= " + frequencyNumber);
				//When found break, because no need to search anymore
				break;
			}
		}
	}
	
	public Integer[] getPositionOfFitness()
	{
		return fitnessPositionNumbers;
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
