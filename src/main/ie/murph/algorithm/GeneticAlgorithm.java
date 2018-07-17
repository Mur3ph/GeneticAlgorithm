package main.ie.murph.algorithm;

import main.ie.murph.algorithm.math.*;
import main.ie.murph.interfaces.ConsoleMessage;
import main.ie.murph.util.*;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class GeneticAlgorithm
{
    // Constant variables and data interface structures used throughout the
    // algorithm
    private static final Logger LOGGER = Logger.getLogger(GeneticAlgorithm.class);
    private CumulativeFrequency cumulativeFrequency;
    private Crossover crossover;

    private Integer[] thePositionOfTheTwoValuesChoosenUsingRandomValues;
    private int firstNewFitness;
    private int secondNewFitness;
    private static Integer[] nextGenerationFitness;

    public GeneticAlgorithm(CumulativeFrequency cumulativeFrequency, Crossover crossover)
    {
	this.cumulativeFrequency = cumulativeFrequency;
	this.crossover = crossover;
    }

    // Generating the five random fitness to begin with..
    public void generatePopulationFitness()
    {
	LOGGER.debug("++generatePopulationFitness()\n");
	System.out.println(ConsoleMessage.STARTING_GENETIC_ALGORITHM);

	this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness()
		.getRandomNumberGenerator().setRandomNumberbetween(1, 10);
	this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness()
		.getRandomNumberGenerator().populateArrayWithRandomWholeNumbersOfLength(5);

	PrintUtil.displayArray(this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness()
		.getRandomNumberGenerator().getRandomWholeNumbers());
	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--generatePopulationFitness()\n");
    }// END OF.

    // Placing the random numbers generated from the array to a TreeMap -
    // Unorganized fitness
    public void generateUnOrganizedFitnessValuesPhaseOne()
    {
	LOGGER.debug("++generateUnOrganizedFitnessValuesPhaseOne()\n");
	System.out.println(ConsoleMessage.GENERATE_UNORGANISED_FITNESS_VALUES_PHASE_ONE);

	this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness()
		.putRandomNumbersIntoUnOrganizedMap();
	this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().printUnorganizedMap();

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--generateUnOrganizedFitnessValuesPhaseOne()\n");
    }// END OF..

    // Placing the random numbers from Unorganized TreeMap into an Organized
    // TreeMap - Organized fitness through a Comparator interface
    public void generateOrganizedFitnessValuesPhaseTwo()
    {
	LOGGER.debug("++generateOrganizedFitnessValuesPhaseTwo()\n");
	System.out.println(ConsoleMessage.GENERATE_ORGANISED_FITNESS_VALUES_PHASE_TWO);

	this.cumulativeFrequency.getNormalization().getOrganizedFitness().organiseUnorderedMapFitness();
	this.cumulativeFrequency.getNormalization().getOrganizedFitness().createOrganisedMapWithFitness();
	this.cumulativeFrequency.getNormalization().getOrganizedFitness().putOrganizedFitnessIntoNewMap();
	this.cumulativeFrequency.getNormalization().getOrganizedFitness().printOrganizedMap();

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--generateOrganizedFitnessValuesPhaseTwo()\n");
    }// END OF..

    // Calculating the total sum of all the fitness
    public void calculatingTotalSumOfFitnessValuePhaseThree()
    {
	LOGGER.debug("++calculatingTotalSumOfFitnessValuePhaseThree()\n");
	System.out.println(ConsoleMessage.CALCULATING_TOTAL_FITNESS_VALUE_PHASE_THREE);

	this.cumulativeFrequency.getNormalization().getSumFitness().populateListWithFitnessValues();
	this.cumulativeFrequency.getNormalization().getSumFitness().calculatingTotalSumOfFitness();
	System.out.println(
		"Total: " + this.cumulativeFrequency.getNormalization().getSumFitness().getTotalSumOfFitness());

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--calculatingTotalSumOfFitnessValuePhaseThree()\n");
    }// END OF.

    // Dividing each fitness value by the sum of all fitness
    public void dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData()
    {
	LOGGER.debug("++dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData()\n");
	System.out.println(ConsoleMessage.CALCULATING_NORMALIZED_FITNESS_VALUE_PHASE_FOUR);

	// Normalized data for each fitness is calculated by finding the sum of
	// all the fitness and then dividing the sum against each individual
	// fitness
	this.cumulativeFrequency.getNormalization().createNormalizedStructure();
	this.cumulativeFrequency.getNormalization().calculateNormalizedData();

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData()\n");
    }

    // Cumulative frequency - The total of a frequency and all frequencies so
    // far in a frequency distribution
    public void addingNormalizedDataToCalculateCumulaiveFreguency()
    {
	LOGGER.debug("++addingNormalizedDataToCalculateCumulaiveFreguency()\n");
	System.out.println(ConsoleMessage.CALCULATING_CUMULATIVE_FREQUENCY_VALUE_PHASE_FIVE);

	this.cumulativeFrequency.createFrequencyStructure();
	this.cumulativeFrequency.calculateFrequency();

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--addingNormalizedDataToCalculateCumulaiveFreguency()\n");
    }

    // Comparing the two random numbers generated, against the Cumulative
    // frequency
    public void compareEachRandonDoubleAgainstCumulativeFrequency()
    {
	LOGGER.debug("++compareEachRandonDoubleAgainstCumulativeFrequency()\n");
	System.out.println(
		ConsoleMessage.COMPARE_RANDOM_NUMBERS_BETWEEN_ONE_AND_ZERO_PHASE_SIX_AGAINST_CUMULATIVE_FREQUENCY_PHASE_SEVEN);
	// Two values to compare against the cumulative frequency.
	// When we come across a number larger than the random number, choose
	// the corresponding number in [P] column (i.e. TreeMap Key)
	// Gives back the position (i.e. location in the Map) of the values to
	// choose
	// TODO I should be using value [p] (i.e. The Tree Map Key, instead I am
	// using fitness [P] Tree Map value )
	this.cumulativeFrequency.setFitness(this.cumulativeFrequency.getCumulativeFrequencyArray());
	this.thePositionOfTheTwoValuesChoosenUsingRandomValues = this.cumulativeFrequency.getPositionOfFitness();
	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--compareEachRandonDoubleAgainstCumulativeFrequency()\n");
    }

    // Here we are using the two random number positions to choose the new elite
    // or best possible candidates of the population
    // We then take those two new candidates and get the binary number
    // equivalent of those number values chosen at random
    public void choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8()
    {
	LOGGER.debug("++choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8()\n");
	System.out.println(ConsoleMessage.GET_INTERGER_VALUE_P_REPRESENTATION_PHASE_EIGHT);
	int randomPositionValueX = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[0];
	int randomPositionValueY = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[1];

	int eliteFitnessValueChosen_1 = this.cumulativeFrequency.getNormalization().getSumFitness()
		.getFitnessValuesList().get(randomPositionValueX);
	int eliteFitnessValueChosen_2 = this.cumulativeFrequency.getNormalization().getSumFitness()
		.getFitnessValuesList().get(randomPositionValueY);

	this.crossover.setBinaryValue_1(BinaryUtil.convertIntegerToBinaryString(eliteFitnessValueChosen_1));
	this.crossover.setBinaryValue_2(BinaryUtil.convertIntegerToBinaryString(eliteFitnessValueChosen_2));

	System.out.println(
		"The 2 binary values: BINARY of: " + eliteFitnessValueChosen_1 + " = " + crossover.getBinaryValue_1()
			+ " BINARY of: " + eliteFitnessValueChosen_2 + " = " + crossover.getBinaryValue_2());
	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8()\n");
    }

    // The crossover is a merging of both binary strings (i.e. genes in
    // genetics) to create one better fitter child/offspring
    // Example: Binary 1 - 00000 and Binary 2 - 11111 --> Would produce an
    // off-spring of: 00011 using single point crossover at position 3
    public void crossoverOfTwoBinaryStringAtRandomPositions()
    {
	// TODO Can only chose one offspring per pair of elite candidates AND
	// generate more random parents
	LOGGER.debug("++crossoverOfTwoBinaryStringAtRandomPositions()\n");
	System.out.println(ConsoleMessage.CROSSOVER_OF_TWO_BINARY_STRINGS_PHASE_NINE);

	this.crossover.setFirstNewOffspring();
	this.crossover.setSecondNewOffspring();

	System.out.println("Offspring crossover : " + this.crossover.printCrossover());

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--crossoverOfTwoBinaryStringAtRandomPositions()\n");
    }

    // Here I are changing bit(s) (e.g. If bit is 0, then change it to 1 and
    // vice-versa)
    public void changeOneOfTheBitsInTheBinaryString()
    {
	LOGGER.debug("++changeOneOfTheBitsInTheBinaryString()\n");
	System.out.println(ConsoleMessage.MUTATION_OF_OFFSPRING_STRING_PHASE_TEN);

	System.out.println("\n Removed this step in with next step, in one line of code, clean code \n");

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--changeOneOfTheBitsInTheBinaryString()\n");
    }

    // Changing the binary string back to a real number or integer
    public void convertBinaryStringToInteger()
    {
	LOGGER.debug("++convertBinaryStringToInteger()\n");
	System.out.println(ConsoleMessage.CONVERT_OFFSPRING_BACK_TO_INTEGER_PHASE_ELEVEN);

	String mutatedOffspringStr_1 = getMutatedOffspring(0);
	String mutatedOffspringStr_2 = getMutatedOffspring(1);

	this.firstNewFitness = BinaryUtil.convertBinaryToInteger(mutatedOffspringStr_1);
	this.secondNewFitness = BinaryUtil.convertBinaryToInteger(mutatedOffspringStr_2);

	System.out.println("The 1st new offspring (i.e. Mutated binary string) conveted to integer fitness form: "
		+ mutatedOffspringStr_1 + " = " + this.firstNewFitness);
	System.out.println("The 2nd new offspring (i.e. Mutated binary string) conveted to integer fitness form: "
		+ mutatedOffspringStr_2 + " = " + this.secondNewFitness);

	System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	LOGGER.debug("--convertBinaryStringToInteger()\n");
    }

    private String getMutatedOffspring(int indexPosition)
    {
	LOGGER.debug("++getMutatedOffspring()\n");
	return BinaryUtil.getMutatedBinaryStrings(this.crossover.getFirstNewOffspring(),
		this.crossover.getSecondNewOffspring(), this.cumulativeFrequency)[indexPosition].toString();
    }

    // Choose the two best/fittest/highest numbers along with more random
    // numbers to fill the group to five and begin the process again..
    // ..until only the fittest survive (i.e. All numbers are at there highest
    // possible and with a 6 bit binary that is 64)
    public void createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation()
    {
	LOGGER.debug("++createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation()\n");
	System.out.println(ConsoleMessage.SEND_NEW_FITNESS_TO_RANDOM_GENERATOR_TO_CREATE_NEXT_GENERATION_PHASE_TWELVE);

	Integer[] arrayOfFitterNextGenerationIntegers = new Integer[5];

	putNewFitnessNextGenerationFitness();
	arrayOfFitterNextGenerationIntegers = getNextGenerationFitness();

	PrintUtil.displayArray(arrayOfFitterNextGenerationIntegers);

	copyArrayToAnotherArrayForNextGenerationToBegin(arrayOfFitterNextGenerationIntegers);
	LOGGER.debug("--createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation()\n");
	// TODO Clearing the fitness to begin again with new better population,
	// I think I am adding the previous total with the new total were I
	// should be clearing the previous total and starting with fresh data
    }

    private Integer[] fitness()
    {
	LOGGER.debug("++fitness()\n");
	return this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness()
		.getRandomNumberGenerator().getRandomWholeNumbers();
    }

    // Method to get 3 random integers from the getRandomNumbers() and replace 2
    // with the new fitness
    private void putNewFitnessNextGenerationFitness()
    {
	LOGGER.debug("++putNewFitnessNextGenerationFitness()\n");
	int toFirstPositionInArrary = 0, toSecondPositionInArrary = 1;

	setNextGenerationFitness();
	replaceLowestNextGenerationFitness(this.firstNewFitness, toFirstPositionInArrary);
	replaceLowestNextGenerationFitness(this.secondNewFitness, toSecondPositionInArrary);
	LOGGER.debug("--putNewFitnessNextGenerationFitness()");
    }

    private void setNextGenerationFitness()
    {
	LOGGER.debug("++setNextGenerationFitness()\n");
	nextGenerationFitness = fitness();
	LOGGER.debug("--setNextGenerationFitness()\n");
    }

    private void replaceLowestNextGenerationFitness(int newFitness, int positionInArrary)
    {
	LOGGER.debug("++replaceLowestNextGenerationFitness()\n");
	sortNextGenerationFitness();
	nextGenerationFitness[positionInArrary] = newFitness;
	sortNextGenerationFitness();
	LOGGER.debug("--replaceLowestNextGenerationFitness()\n");
    }

    private void sortNextGenerationFitness()
    {
	LOGGER.debug("++sortNextGenerationFitness()\n");
	Arrays.sort(nextGenerationFitness);
	LOGGER.debug("--sortNextGenerationFitness()\n");
    }

    private Integer[] getNextGenerationFitness()
    {
	LOGGER.debug("++getNextGenerationFitness()\n");
	return nextGenerationFitness;
    }

    private void copyArrayToAnotherArrayForNextGenerationToBegin(Integer[] arrayOfFitterNextGenerationIntegers)
    {
	LOGGER.debug("++copyArrayToAnotherArrayForNextGenerationToBegin()\n");
	System.arraycopy(arrayOfFitterNextGenerationIntegers, 0, this.cumulativeFrequency.getNormalization()
		.getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getRandomWholeNumbers(), 0,
		5);
	LOGGER.debug("--copyArrayToAnotherArrayForNextGenerationToBegin()\n");
    }

}
