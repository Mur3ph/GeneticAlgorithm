package ie.murph.java.algorithm;

import ie.murph.java.algorithm.math.CumulativeFrequency;
import ie.murph.java.interfaces.ConsoleMessage;
import ie.murph.java.util.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class GeneticAlgorithm 
{
	//Constant variables and data interface structures used throughout the algorithm
	private CumulativeFrequency cumulativeFrequency;
	
	private Integer[] thePositionOfTheTwoValuesChoosenUsingRandomValues;
	private String binaryValue_1;
	private String binaryValue_2;
	private String offspring_Child_1;
	private String offspring_Child_2;
	private StringBuilder[] twoMutatedBinaryStringBuilderObj;
	private int newFitnessInt_1;
	private int newFitnessInt_2;
	
	public GeneticAlgorithm(CumulativeFrequency cumulativeFrequency)
	{
		this.cumulativeFrequency = cumulativeFrequency;
	}
		
	//Generating the five random fitness to begin with..
	public void generatePopulationFitness()
	{
		System.out.println(ConsoleMessage.STARTING_GENETIC_ALGORITHM);
		
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().setRandomNumberbetween(1, 10);
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().populateArrayWithRandomWholeNumbersOfLength(5);
		
		PrintUtil.displayArray(this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getRandomWholeNumbers());
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF.
	
	//Placing the random numbers generated from the array to a TreeMap - Unorganized fitness
	public void generateUnOrganizedFitnessValuesPhaseOne()
	{
		System.out.println(ConsoleMessage.GENERATE_UNORGANISED_FITNESS_VALUES_PHASE_ONE);
		
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().putRandomNumbersIntoUnOrganizedMap();
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().printUnorganizedMap();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF..
	
	//Placing the random numbers from Unorganized TreeMap into an Organized TreeMap - Organized fitness through a Comparator interface
	public void generateOrganizedFitnessValuesPhaseTwo()
	{
		System.out.println(ConsoleMessage.GENERATE_ORGANISED_FITNESS_VALUES_PHASE_TWO);
		
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().organiseUnorderedMapFitness();
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().createOrganisedMapWithFitness();
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().putOrganizedFitnessIntoNewMap();
		this.cumulativeFrequency.getNormalization().getOrganizedFitness().printOrganizedMap();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF..
	
	//Calculating the total sum of all the fitness
	public void calculatingTotalSumOfFitnessValuePhaseThree()
	{
		System.out.println(ConsoleMessage.CALCULATING_TOTAL_FITNESS_VALUE_PHASE_THREE);
		
		this.cumulativeFrequency.getNormalization().getSumFitness().populateListWithFitnessValues();
		this.cumulativeFrequency.getNormalization().getSumFitness().calculatingTotalSumOfFitness();
		System.out.println("Total: " + this.cumulativeFrequency.getNormalization().getSumFitness().getTotalSumOfFitness());
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF.
	
	//Dividing each fitness value by the sum of all fitness
	public void dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData() 
	{
		System.out.println(ConsoleMessage.CALCULATING_NORMALIZED_FITNESS_VALUE_PHASE_FOUR);
		
		// Normalized data for each fitness is calculated by finding the sum of all the fitness and then dividing the sum against each individual fitness
		this.cumulativeFrequency.getNormalization().createNormalizedStructure();
		this.cumulativeFrequency.getNormalization().calculateNormalizedData();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}

	//Cumulative frequency - The total of a frequency and all frequencies so far in a frequency distribution
	public void addingNormalizedDataToCalculateCumulaiveFreguency() 
	{
		System.out.println(ConsoleMessage.CALCULATING_CUMULATIVE_FREQUENCY_VALUE_PHASE_FIVE);
		
		this.cumulativeFrequency.createFrequencyStructure();
		this.cumulativeFrequency.calculateFrequency();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Comparing the two random numbers generated, against the Cumulative frequency
	public void compareEachRandonDoubleAgainstCumulativeFrequency() 
	{
		System.out.println(ConsoleMessage.COMPARE_RANDOM_NUMBERS_BETWEEN_ONE_AND_ZERO_PHASE_SIX_AGAINST_CUMULATIVE_FREQUENCY_PHASE_SEVEN);
		//Two values to compare against the cumulative frequency. 
		//When we come across a number larger than the random number, choose the corresponding number in [P] column (i.e. TreeMap Key)
		//Gives back the position (i.e. location in the Map) of the values to choose
		//TODO I should be using value [p] (i.e. The Tree Map Key, instead I am using fitness [P] Tree Map value )
		this.cumulativeFrequency.setFitness(this.cumulativeFrequency.getCumulativeFrequencyArray());
		this.thePositionOfTheTwoValuesChoosenUsingRandomValues = this.cumulativeFrequency.getPositionOfFitness();
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Here we are using the two random number positions to choose the new elite or best possible candidates of the population
	//We then take those two new candidates and get the binary number equivalent of those number values chosen at random
	public void choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8() 
	{
		System.out.println(ConsoleMessage.GET_INTERGER_VALUE_P_REPRESENTATION_PHASE_EIGHT);
		int randomPositionValueX = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[0];
		int randomPositionValueY = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[1];
		
		int eliteFitnessValueChosen_1 = this.cumulativeFrequency.getNormalization().getSumFitness().getFitnessValuesList().get(randomPositionValueX);
		int eliteFitnessValueChosen_2 = this.cumulativeFrequency.getNormalization().getSumFitness().getFitnessValuesList().get(randomPositionValueY);
		
//		find the (6 bit) binary equivalent of an integer
		int lengthOfBinaryString = 6;
		this.binaryValue_1 = BinaryUtil.convertIntegerToBinaryString(eliteFitnessValueChosen_1, lengthOfBinaryString);
		this.binaryValue_2 = BinaryUtil.convertIntegerToBinaryString(eliteFitnessValueChosen_2, lengthOfBinaryString);
		System.out.println("The 2 binary values: BINARY of: " + eliteFitnessValueChosen_1 + " = " + this.binaryValue_1 + " BINARY of: " + eliteFitnessValueChosen_2 + " = " + this.binaryValue_2);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//The crossover is a merging of both binary strings (i.e. genes in genetics) to create one better fitter child/offspring
	//Example: Binary 1 - 00000 and Binary 2 - 11111 --> Would produce an off-spring of: 00011 using single point crossover at position 3
	public void crossoverOfTwoBinaryStringAtRandomPositions() 
	{
		//TODO Can only chose one offspring per pair of elite candidates AND generate more random parents
		System.out.println(ConsoleMessage.CROSSOVER_OF_TWO_BINARY_STRINGS_PHASE_NINE);
		String firstHalfOfBinaryGene_1 = this.binaryValue_1.substring(0, 3);
		String secondHalfOfBinaryGene_1 = this.binaryValue_2.substring(3, 6);
		
		String firstHalfOfBinaryGene_2 = this.binaryValue_2.substring(0, 3);
		String secondHalfOfBinaryGene_2 = this.binaryValue_1.substring(3, 6);
		
		this.offspring_Child_1 = firstHalfOfBinaryGene_1 + secondHalfOfBinaryGene_1;
		this.offspring_Child_2 = firstHalfOfBinaryGene_2 + secondHalfOfBinaryGene_2;
		System.out.println("Offspring1: " + firstHalfOfBinaryGene_1 + secondHalfOfBinaryGene_1);
		System.out.println("Offspring2: " + firstHalfOfBinaryGene_2 + secondHalfOfBinaryGene_2);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Here I are changing bit(s) (e.g. If bit is 0, then change it to 1 and vice-versa)
	public void changeOneOfTheBitsInTheBinaryString() 
	{
		System.out.println(ConsoleMessage.MUTATION_OF_OFFSPRING_STRING_PHASE_TEN);
		this.twoMutatedBinaryStringBuilderObj = new StringBuilder[2];
		this.twoMutatedBinaryStringBuilderObj = BinaryUtil.mutateBinaryStrings(this.offspring_Child_1, this.offspring_Child_2, this.cumulativeFrequency);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Changing the binary string back to a real number or integer
	public void convertBinaryStringToInteger() 
	{
		System.out.println(ConsoleMessage.CONVERT_OFFSPRING_BACK_TO_INTEGER_PHASE_ELEVEN);
		StringBuilder mutatedOffspringBuilderObj_1;
		StringBuilder mutatedOffspringBuilderObj_2;
		mutatedOffspringBuilderObj_1 = this.twoMutatedBinaryStringBuilderObj[0];
		mutatedOffspringBuilderObj_2 = this.twoMutatedBinaryStringBuilderObj[1];
		String mutatedOffspringStr_1 = mutatedOffspringBuilderObj_1.toString();
		String mutatedOffspringStr_2 = mutatedOffspringBuilderObj_2.toString();
		this.newFitnessInt_1 = BinaryUtil.convertBinaryToInteger(mutatedOffspringStr_1);
		this.newFitnessInt_2 = BinaryUtil.convertBinaryToInteger(mutatedOffspringStr_2);
		System.out.println("The new offspring 1 in integer fitness form: " + mutatedOffspringStr_1 + " = " + this.newFitnessInt_1);
		System.out.println("The new offspring 2 in integer fitness form: " + mutatedOffspringStr_2 + " = " + this.newFitnessInt_2);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Choose the two best/fittest/highest numbers along with more random numbers to fill the group to five and begin the process again..
	//..until only the fittest survive (i.e. All numbers are at there highest possible and with a 6 bit binary that is 64)
	public void createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation() 
	{
		System.out.println(ConsoleMessage.SEND_NEW_FITNESS_TO_RANDOM_GENERATOR_TO_CREATE_NEXT_GENERATION_PHASE_TWELVE);
		Integer[] arrayOfFitterNextGenerationIntegers = new Integer[5];
		arrayOfFitterNextGenerationIntegers = getNextGeneration(this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getRandomWholeNumbers(), this.newFitnessInt_1, this.newFitnessInt_2);
		PrintUtil.displayArray(arrayOfFitterNextGenerationIntegers);
		System.arraycopy(arrayOfFitterNextGenerationIntegers, 0, this.cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getRandomWholeNumbers(), 0, 5);
//		TODO Clearing the fitness to begin again with new better population, I think I am adding the previous total with the new total were I should be clearing the previous total and starting with fresh data
//		m_fitnessValuesFromOrderedTreemap.clear();
	}
	
	// Method to get 3 random integers from the getRandomNumbers() and replace 2 with the new fitness
	public static Integer[] getNextGeneration(Integer[] originalFitness, int firstNewFitness, int secondNewFitness)
	{
		Arrays.sort(originalFitness);
		originalFitness[0] = firstNewFitness;
		originalFitness[1] = secondNewFitness;
		Arrays.sort(originalFitness);
		return originalFitness;
	}// END OF..
	
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
	}// END OF..
	
	
}//END OF CLASS..
