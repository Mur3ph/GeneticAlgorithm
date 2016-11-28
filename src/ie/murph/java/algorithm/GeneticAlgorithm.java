package ie.murph.java.algorithm;

import ie.murph.java.algorithm.fitness.Normalization;
import ie.murph.java.algorithm.fitness.UnorganizedFitness;
import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;
import ie.murph.java.interfaces.ConsoleMessage;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class GeneticAlgorithm 
{
	//Constant variables and data interface structures used throughout the algorithm
	private RandomNumberGenerator randonNumberGenerator;
	private UnorganizedFitness unorganizedMapFitness;
	private Normalization normalization;
	
	private Double[] cumulativefrequencyData;
	private Integer[] thePositionOfTheTwoValuesChoosenUsingRandomValues;
	private double continuesRandonNumberBetweenZeroAndOne_1;
	private double continuesRandonNumberBetweenZeroAndOne_2;
	private String binaryValue_1;
	private String binaryValue_2;
	private String offspring_Child_1;
	private String offspring_Child_2;
	private StringBuilder[] twoMutatedBinaryStringBuilderObj;
	private int newFitnessInt_1;
	private int newFitnessInt_2;
	
//	TODO: This is getting ridiculous. Should have no more than three parameters. One parameter, if possible
	public GeneticAlgorithm(RandomNumberGenerator randomNumberGenerator, UnorganizedFitness unorganizedMapFitness, Normalization normalization)
	{
		this.randonNumberGenerator = randomNumberGenerator;
		this.unorganizedMapFitness = unorganizedMapFitness;
		this.normalization = normalization;
	}
		
	//Generating the five random fitness to begin with..
	public void generatePopulationFitness()
	{
		System.out.println(ConsoleMessage.STARTING_GENETIC_ALGORITHM);
		
		randonNumberGenerator.setRandomNumberbetween(1, 10);
		randonNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(5);
		
		displayArray(randonNumberGenerator.getRandomWholeNumbers());
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF.
	
	//Placing the random numbers generated from the array to a TreeMap - Unorganized fitness
	public void generateUnOrganizedFitnessValuesPhaseOne()
	{
		System.out.println(ConsoleMessage.GENERATE_UNORGANISED_FITNESS_VALUES_PHASE_ONE);
		
		this.unorganizedMapFitness.putRandomNumbersIntoUnOrganizedMap();
		this.unorganizedMapFitness.printUnorganizedMap();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF..
	
	//Placing the random numbers from Unorganized TreeMap into an Organized TreeMap - Organized fitness through a Comparator interface
	public void generateOrganizedFitnessValuesPhaseTwo()
	{
		System.out.println(ConsoleMessage.GENERATE_ORGANISED_FITNESS_VALUES_PHASE_TWO);
		
		this.normalization.getOrganizedFitness().organiseUnorderedMapFitness();
		this.normalization.getOrganizedFitness().createOrganisedMapWithFitness();
		this.normalization.getOrganizedFitness().putOrganizedFitnessIntoNewMap();
		this.normalization.getOrganizedFitness().printOrganizedMap();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF..
	
	//Calculating the total sum of all the fitness
	public void calculatingTotalSumOfFitnessValuePhaseThree()
	{
		System.out.println(ConsoleMessage.CALCULATING_TOTAL_FITNESS_VALUE_PHASE_THREE);
		
		this.normalization.getSumFitness().populateListWithFitnessValues();
		this.normalization.getSumFitness().calculatingTotalSumOfFitness();
		System.out.println("Total: " + this.normalization.getSumFitness().getTotalSumOfFitness());
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF.
	
	//Dividing each fitness value by the sum of all fitness
	public void dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData() 
	{
		System.out.println(ConsoleMessage.CALCULATING_NORMALIZED_FITNESS_VALUE_PHASE_FOUR);
		
		// Normalized data for each fitness is calculated by finding the sum of all the fitness and then dividing the sum against each individual fitness
		this.normalization.createNormalizedStructure();
		this.normalization.calculateNormalizedData();
		
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}

	//Cumulative frequency - The total of a frequency and all frequencies so far in a frequency distribution
	public void addingNormalizedDataToCalculateCumulaiveFreguency() 
	{
		System.out.println(ConsoleMessage.CALCULATING_CUMULATIVE_FREQUENCY_VALUE_PHASE_FIVE);
		double previousCumulativeNumber = 0;
		//Cumulative frequency Data for each of the fitness is calculated by adding each of the normalized data types one after the other finally adding to one
		// (e.g. Normalized data: 0.267, 0.267, 0.233, 0.233 --> Cumulative data: 0.267, 0.534, 0.767, 1)
		this.cumulativefrequencyData = new Double[this.normalization.getOrganizedFitness().getSizeOfMap()];
		for(int atPostionX = 0; atPostionX < this.normalization.getOrganizedFitness().getSizeOfMap(); atPostionX++)
		{
			//Rounding the data to 3 decimal places.
			this.cumulativefrequencyData[atPostionX] = (double) Math.round((previousCumulativeNumber + this.normalization.getNormalizedFitness()[atPostionX]) * 1000) / 1000;
			previousCumulativeNumber = this.cumulativefrequencyData[atPostionX];
		}
		//Checking or catching any potential errors in the data, as the last cumulative fitness should always be one
		if(this.cumulativefrequencyData[4] == 0.999 || this.cumulativefrequencyData[4] == 0.998)
		{
			this.cumulativefrequencyData[4] = 1.0;
		}
		displayArray(this.cumulativefrequencyData);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	// Choose a random double between zero and one to compare against the cumulative frequency - Generating two random numbers between 1 and 0
	public void generateTheTwoContinuesRandomNumbersBetween0and1()
	{
		System.out.println(ConsoleMessage.CHOOSE_RANDOM_NUMBER_BETWEEN_ONE_AND_ZERO_PHASE_SIX);
		//Using random doubles to make sure they are between zero and one
		this.continuesRandonNumberBetweenZeroAndOne_1 = randonNumberGenerator.getARandomDecimalNumberBetweenZeroAndOne();
		this.continuesRandonNumberBetweenZeroAndOne_2 = randonNumberGenerator.getARandomDecimalNumberBetweenZeroAndOne();
		//Rounding them numbers to 3 decimal places
		double continuesRandomNumberToThreeDecimalPlaces_1 = (double) Math.round(this.continuesRandonNumberBetweenZeroAndOne_1 * 1000) / 1000;
		double continuesRandomNumberToThreeDecimalPlaces_2 = (double) Math.round(this.continuesRandonNumberBetweenZeroAndOne_2 * 1000) / 1000;
		System.out.println("Random Double 1: " + this.continuesRandonNumberBetweenZeroAndOne_1 + " and rounded: " + continuesRandomNumberToThreeDecimalPlaces_1);
		System.out.println("Random Double 2: " + this.continuesRandonNumberBetweenZeroAndOne_2 + " and rounded: " + continuesRandomNumberToThreeDecimalPlaces_2);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}// END OF..
	
	//Comparing the two random numbers generated, against the Cumulative frequency
	public void compareEachRandonDoubleAgainstCumulativeFrequency() 
	{
		System.out.println(ConsoleMessage.COMPARE_RANDOM_NUMBERS_BETWEEN_ONE_AND_ZERO_PHASE_SIX_AGAINST_CUMULATIVE_FREQUENCY_PHASE_SEVEN);
		//Two values to compare against the cumulative frequency. 
		//When we come across a number larger than the random number, choose the corresponding number in [P] column (i.e. TreeMap Key)
		//Gives back the position (i.e. location in the Map) of the values to choose
		//TODO I should be using value [p] (i.e. The Tree Map Key, instead I am using fitness [P] Tree Map value )
		this.thePositionOfTheTwoValuesChoosenUsingRandomValues = findThePositionOfTheTwoFitnessNumbersUsingTheTwoRandomNumbers(cumulativefrequencyData);
		System.out.println(ConsoleMessage.BREAK_DIVIDER_TO_SEPERATE_EACH_PHASE);
	}
	
	//Here we are using the two random number positions to choose the new elite or best possible candidates of the population
	//We then take those two new candidates and get the binary number equivalent of those number values chosen at random
	public void choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8() 
	{
		System.out.println(ConsoleMessage.GET_INTERGER_VALUE_P_REPRESENTATION_PHASE_EIGHT);
		int randomPositionValueX = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[0];
		int randomPositionValueY = this.thePositionOfTheTwoValuesChoosenUsingRandomValues[1];
		
		int eliteFitnessValueChosen_1 = this.normalization.getSumFitness().getFitnessValuesList().get(randomPositionValueX);
		int eliteFitnessValueChosen_2 = this.normalization.getSumFitness().getFitnessValuesList().get(randomPositionValueY);
		
//		find the (6 bit) binary equivalent of an integer
		int lengthOfBinaryString = 6;
		this.binaryValue_1 = convertIntegerToBinaryString(eliteFitnessValueChosen_1, lengthOfBinaryString);
		this.binaryValue_2 = convertIntegerToBinaryString(eliteFitnessValueChosen_2, lengthOfBinaryString);
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
		this.twoMutatedBinaryStringBuilderObj = mutateBinaryStrings(this.offspring_Child_1, this.offspring_Child_2);
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
		this.newFitnessInt_1 = convertBinaryToInteger(mutatedOffspringStr_1);
		this.newFitnessInt_2 = convertBinaryToInteger(mutatedOffspringStr_2);
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
		arrayOfFitterNextGenerationIntegers = getNextGeneration(randonNumberGenerator.getRandomWholeNumbers(), this.newFitnessInt_1, this.newFitnessInt_2);
		displayArray(arrayOfFitterNextGenerationIntegers);
		System.arraycopy(arrayOfFitterNextGenerationIntegers, 0, randonNumberGenerator.getRandomWholeNumbers(), 0, 5);
//		TODO Clearing the fitness to begin again with new better population, I think I am adding the previous total with the new total were I should be clearing the previous total and starting with fresh data
//		m_fitnessValuesFromOrderedTreemap.clear();
	}
	
	// Method just for printing out the elements of the generic collections.
	public static void displayGenericTypes(Collection<?> data)
	{
		Iterator<?> itr = data.iterator();
		while(itr.hasNext())
		{
			Object str = itr.next();
 			System.out.println(str + " ");
		}
	}// END OF..
	
	// Method just for printing out the elements of the array.
	public static void displayArray(Object[] numbers)
	{
		for(int atPositionX = 0; atPositionX < numbers.length; atPositionX++)
		{
			System.out.println(numbers[atPositionX]);
		}
		System.out.println("");
	}// END OF..
	
	// Method to find the (6 bit) binary equivalent of an integer - or change the length of loops to whatever size bit you need
	private static String convertIntegerToBinaryString(int numValue, int lengthOfBinaryString) 
	{
		String binary = "";
		for(int x = 0; x < lengthOfBinaryString; x++)
		{
			//If the value has a remainder use the '1' binary bit
			if(numValue % 2 == 1)
			{
				binary = "1" + binary;
			}
			if(numValue % 2 == 0)
			{
				binary = "0" + binary;
			}
			numValue = numValue/2;
		}
		return binary;
	}// END OF..
	
	//Converting my binary bits back to Integer
	public static int convertBinaryToInteger(String binary)
	{
//			int x = 128; // for 8 bit we use 128      (i.e. 7 bit = 128)
		int bit32 = 32; // for 6 bit we use 32 etc.   (i.e. 5 bit = 32)
//			int a = 16; // for 5 bit we use 32 etc.   (i.e. 4 bit = 32)
		int result = 0;
		for(int atPositionX = 0; atPositionX < 6; atPositionX++)
		{
			char character = binary.charAt(atPositionX);
			// Single quotations needed when using 'char'
			if(character == '1')
			{
				//Only if the binary bit is a one do we calculate sum below
				result = result + (bit32*1);
			}
			//We are working from the left of the binary string to the right, so we start at 32, then half for 16, next 8, and so on
			bit32=bit32/2;
		}
		return result;
	}// END OF..
	
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
	
	//This method is used to find the position in the TreeMap of the two numbers, using the input of the two random numbers chosen in above method - (generateTheTwoContinuesRandomNumbersBetween0and1)
	public Integer[] findThePositionOfTheTwoFitnessNumbersUsingTheTwoRandomNumbers(Double[] cumulativeFitnessArray)
	{
		System.out.println("********************************************************** ");
		Integer[] positionOfBothValues = new Integer[2];
		
		double correspondingCumulativeFitness = 0;
		int atPositionX = 0;
		Double[] bothContinuesRandonNumberBetweenZeroAndOne = new Double[]{this.continuesRandonNumberBetweenZeroAndOne_1, this.continuesRandonNumberBetweenZeroAndOne_2};
		
		//Looping threw the data set to find out when cumulative frequency is larger than the first random double between 1 & 0 
		//Then selecting that particular cumulative number for manipulation
		for(int atPositionY = 0; atPositionY < positionOfBothValues.length; atPositionY++)
		{
			for(atPositionX = 0; atPositionX < cumulativeFitnessArray.length; atPositionX++)
			{
				if(cumulativeFitnessArray[atPositionX] >= bothContinuesRandonNumberBetweenZeroAndOne[atPositionY]) 
				{
					correspondingCumulativeFitness = cumulativeFitnessArray[atPositionX];
					positionOfBothValues[atPositionY] = atPositionX;
					System.out.println("Fittest 1: " + correspondingCumulativeFitness + " PositionX= " + atPositionX);
					//When found break, because no need to search anymore
					break;
				}
			}
		}
		return positionOfBothValues;
	}// END OF..
	
	// Altering one of the bits in the binary string using the StringBuilder Object
	public StringBuilder[] mutateBinaryStrings(String offspringBinaryStr_1, String offspringBinaryStr_2)
	{
		//Converting the string to string builder object because easy to alter or manipulate binary bits
		StringBuilder offspringBinaryBuilder_1 = new StringBuilder(offspringBinaryStr_1);
		StringBuilder offspringBinaryBuilder_2 = new StringBuilder(offspringBinaryStr_2);
		StringBuilder[] bothOffspringBinaryBuilderStringsToBeAlteredArray = new StringBuilder[]{offspringBinaryBuilder_1, offspringBinaryBuilder_2};
		StringBuilder[] strBuilderArrayWithBothAlteredBinaryCodes = new StringBuilder[2];
		
		//Choosing the bit in each binary string to be altered at random each time
		randonNumberGenerator.setRandomNumberbetween(1, 5);
		int randomPositionOfBinaryBitToBeAltered_1 = randonNumberGenerator.getARandomWholeNumber();
		int randomPositionOfBinaryBitToBeAltered_2 = randonNumberGenerator.getARandomWholeNumber();
		Integer[] bothrandomNumbersOfPositionsOfBinaryBitToBeAltered = new Integer[]{randomPositionOfBinaryBitToBeAltered_1, randomPositionOfBinaryBitToBeAltered_2};
		
		// Getting that bit in the random position
		char binaryBitOfOffspring_1 = offspringBinaryStr_1.charAt(randomPositionOfBinaryBitToBeAltered_1);
		char binaryBitOfOffspring_2 = offspringBinaryStr_2.charAt(randomPositionOfBinaryBitToBeAltered_2);
		char[] bothbinaryBitsOfOffspringStringToBeAltered = new char[]{binaryBitOfOffspring_1, binaryBitOfOffspring_2};
		char changeBinaryBitTo;
		
		//If it is a zero binary bit change to a one and so on..
		for(int atPositionX = 0; atPositionX < bothOffspringBinaryBuilderStringsToBeAlteredArray.length; atPositionX++)
		{
			if(bothbinaryBitsOfOffspringStringToBeAltered[atPositionX] == '0')
			{
				changeBinaryBitTo = '1';
//					newOffspring = offspring.substring(0, 5) + newbit + offspring.substring(position);
				bothOffspringBinaryBuilderStringsToBeAlteredArray[atPositionX].setCharAt(bothrandomNumbersOfPositionsOfBinaryBitToBeAltered[atPositionX], changeBinaryBitTo);
				strBuilderArrayWithBothAlteredBinaryCodes[atPositionX] = bothOffspringBinaryBuilderStringsToBeAlteredArray[atPositionX];
			}
			else
			{
				changeBinaryBitTo = '0';
				bothOffspringBinaryBuilderStringsToBeAlteredArray[atPositionX].setCharAt(bothrandomNumbersOfPositionsOfBinaryBitToBeAltered[atPositionX], changeBinaryBitTo);
				strBuilderArrayWithBothAlteredBinaryCodes[atPositionX] = bothOffspringBinaryBuilderStringsToBeAlteredArray[atPositionX];
			}
		}
		
		System.out.println("Mutated offspring 1: " + offspringBinaryBuilder_1 + " Bit at positon " + randomPositionOfBinaryBitToBeAltered_1);
		System.out.println("Mutated offspring 2: " + offspringBinaryBuilder_2 + " Bit at positon " + randomPositionOfBinaryBitToBeAltered_2);
		return strBuilderArrayWithBothAlteredBinaryCodes;
	}// END OF..
	
}//END OF CLASS..
