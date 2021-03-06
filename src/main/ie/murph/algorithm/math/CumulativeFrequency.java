package main.ie.murph.algorithm.math;

import org.apache.log4j.Logger;

import main.ie.murph.util.*;

public class CumulativeFrequency
{
    private static final Logger LOGGER = Logger.getLogger(CumulativeFrequency.class);
    private Normalization normalization;
    private Double[] cumulativefrequencyArrayOfDoubles;
    private Integer[] fitnessPositionNumbers;
    private double randomDouble1;
    private double randomDouble2;
    private Double[] continuesRandonDoubles;

    public CumulativeFrequency(Normalization normalization)
    {
	this.normalization = normalization;
    }

    public void createFrequencyStructure()
    {
	LOGGER.debug("++createFrequencyStructure()\n");
	// Cumulative frequency Data for each of the fitness is calculated by
	// adding each of the normalized
	// data types one after the other finally adding to one. NB: Must be one
	// (e.g. Normalized data: 0.267, 0.267, 0.233, 0.233 --> Cumulative
	// data: 0.267, 0.534, 0.767, 1)
	this.cumulativefrequencyArrayOfDoubles = new Double[this.normalization.getOrganizedFitness().getSizeOfMap()];
	LOGGER.debug("--createFrequencyStructure()\n");
    }

    public void calculateFrequency()
    {
	LOGGER.debug("++calculateFrequency()\n");
	double previousCumulativeNumber = 0;
	for (int atPostionX = 0; atPostionX < this.normalization.getOrganizedFitness().getSizeOfMap(); atPostionX++)
	{
	    // Rounding the data to 3 decimal places.
	    this.cumulativefrequencyArrayOfDoubles[atPostionX] = (double) Math
		    .round((previousCumulativeNumber + this.normalization.getNormalizedFitness()[atPostionX]) * 1000)
		    / 1000;
	    previousCumulativeNumber = this.cumulativefrequencyArrayOfDoubles[atPostionX];
	}
	isCumulaiveFreguencyOk();
	printFrequency();
	LOGGER.debug("--calculateFrequency()\n");
    }

    // Cumulative frequency - The total of a frequency and all frequencies so
    // far in a frequency distribution
    private void isCumulaiveFreguencyOk()
    {
	LOGGER.debug("++isCumulaiveFreguencyOk()\n");
	// Checking or catching any potential errors in the data, as the last
	// cumulative fitness should always be one
	if (this.cumulativefrequencyArrayOfDoubles[frequencyLength()] < 1.0)
	{
	    this.cumulativefrequencyArrayOfDoubles[frequencyLength()] = MathUtil
		    .roundNumberUp(this.cumulativefrequencyArrayOfDoubles[frequencyLength()]);
	} else
	{
	    this.cumulativefrequencyArrayOfDoubles[frequencyLength()] = MathUtil
		    .roundNumberDown(this.cumulativefrequencyArrayOfDoubles[frequencyLength()]);
	}
	LOGGER.debug("--isCumulaiveFreguencyOk()\n");
    }

    private int frequencyLength()
    {
	LOGGER.debug("++frequencyLength()\n");
	return cumulativefrequencyArrayOfDoubles.length - 1;
    }

    private void printFrequency()
    {
	LOGGER.debug("++printFrequency()\n");
	PrintUtil.displayArray(this.cumulativefrequencyArrayOfDoubles);
	LOGGER.debug("--printFrequency()\n");
    }

    public Double[] getCumulativeFrequencyArray()
    {
	LOGGER.debug("++getCumulativeFrequencyArray()\n");
	return this.cumulativefrequencyArrayOfDoubles;
    }

    public Normalization getNormalization()
    {
	LOGGER.debug("++getNormalization()\n");
	return this.normalization;
    }

    // This method is used to find the position in the TreeMap of the two
    // numbers, using the input of the two random numbers chosen in above method
    // - (generateTheTwoContinuesRandomNumbersBetween0and1)
    // Phase 6: Choose a random double between zero and one to compare against
    // the cumulative frequency - Generating two random numbers between 1 and 0
    public void setFitness(Double[] cumulativeFitnessArray)
    {
	LOGGER.debug("++cumulativeFitnessArray()\n");
	setDataStructuresForRandomNumbers();
	fitnessPositionNumbers = new Integer[2];

	// Looping threw the data set to find out when cumulative frequency is
	// larger than the first random double between 1 & 0
	// Then selecting that particular cumulative number for manipulation
	for (int fitnessNumber = 0; fitnessNumber < fitnessPositionNumbers.length; fitnessNumber++)
	{
	    checkFrequecyAgainstFitness(cumulativeFitnessArray, fitnessNumber);
	}
	printTwoRandomeNumbers();
	LOGGER.debug("--cumulativeFitnessArray()\n");
    }

    private void setDataStructuresForRandomNumbers()
    {
	LOGGER.debug("++setDataStructuresForRandomNumbers()\n");
	randomDouble1 = this.getRandomDouble();
	randomDouble2 = this.getRandomDouble();
	continuesRandonDoubles = new Double[]
	{ randomDouble1, randomDouble2 };
	LOGGER.debug("--setDataStructuresForRandomNumbers()\n");
    }

    private double getRandomDouble()
    {
	LOGGER.debug("++getRandomDouble()\n");
	return this.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator()
		.getARandomDecimalNumberBetweenZeroAndOne();
    }

    private void checkFrequecyAgainstFitness(Double[] cumulativeFitnessArray, int fitnessNumber)
    {
	LOGGER.debug("++checkFrequecyAgainstFitness()\n");
	for (int frequencyNumber = 0; frequencyNumber < cumulativeFitnessArray.length; frequencyNumber++)
	{
	    if (cumulativeFitnessArray[frequencyNumber] >= continuesRandonDoubles[fitnessNumber])
	    {
		setFitnessPosition(frequencyNumber, fitnessNumber);
		int position = frequencyNumber + 1;
		System.out.println("Fittest 1: "
			+ assignFrequencyNumberToCorrespondingCumulativeFitness(cumulativeFitnessArray, frequencyNumber)
			+ " PositionX= " + position);
		LOGGER.debug("--checkFrequecyAgainstFitness()\n");
		// When found break, because no need to search anymore
		break;
	    }
	}
	LOGGER.debug("--checkFrequecyAgainstFitness()\n");
    }

    private Double assignFrequencyNumberToCorrespondingCumulativeFitness(Double[] cumulativeFitnessArray,
	    int frequencyNumber)
    {
	LOGGER.debug("++assignFrequencyNumberToCorrespondingCumulativeFitness()\n");
	return cumulativeFitnessArray[frequencyNumber];
    }

    private void setFitnessPosition(int frequencyNumber, int fitnessNumber)
    {
	LOGGER.debug("++setFitnessPosition()\n");
	fitnessPositionNumbers[fitnessNumber] = frequencyNumber;
	LOGGER.debug("--setFitnessPosition()\n");
    }

    // TODO: Delete when no longer needed for visual test
    private void printTwoRandomeNumbers()
    {
	LOGGER.debug("++printTwoRandomeNumbers()\n");
	System.out.println("Random Double 1: " + randomDouble1 + " and rounded: "
		+ MathUtil.roundToThreeDecimalPlaces(randomDouble1));
	System.out.println("Random Double 2: " + randomDouble2 + " and rounded: "
		+ MathUtil.roundToThreeDecimalPlaces(randomDouble2));
	LOGGER.debug("--printTwoRandomeNumbers()\n");
    }

    public Integer[] getPositionOfFitness()
    {
	LOGGER.debug("++getPositionOfFitness()\n");
	return fitnessPositionNumbers;
    }
}
