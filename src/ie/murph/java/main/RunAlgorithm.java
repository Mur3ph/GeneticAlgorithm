package ie.murph.java.main;

import java.util.Scanner;

import ie.murph.java.algorithm.GeneticAlgorithm;
import ie.murph.java.interfaces.ConsoleTextVariables;

public class RunAlgorithm 
{
	private static final Scanner m_SCANNER = new Scanner(System.in);
	public static void main(String[] args)
	{
		run();
	}// END OF..
	
	// Method used to start the fitness generations flow...
		public static void run()
		{
			GeneticAlgorithm algorithm = new GeneticAlgorithm();
			algorithm.generateRandonNumbersAndPlcaeIntoArray();
			//Asking user to input the amount of generations of fitness offspring they want to view
			System.out.println(ConsoleTextVariables.QUESTION);
			int generation = m_SCANNER.nextInt();
			
			for(int generationX = 1; generationX < generation; generationX++)
			{
				algorithm.placeArrayIntoUnOrganizedTreeMap();
				algorithm.placeUnOrganizedTreeMapIntoOrganizedTreeMap();
				double totalOfAllTheFitness = algorithm.calculatingTheSumOfFitness();
				algorithm.dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData(totalOfAllTheFitness);
				algorithm.addingNormalizedDataToCalculateCumulaiveFreguency();
				algorithm.generateTheTwoContinuesRandomNumbersBetween0and1();
				algorithm.compareEachRandonDoubleAgainstCumulativeFrequency();
				algorithm.choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8();
				algorithm.crossoverOfTwoBinaryStringAtRandomPositions();
				algorithm.changeOneOfTheBitsInTheBinaryString();
				algorithm.convertBinaryStringToInteger();
				algorithm.createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation();
				
			} // END OF FOR LOOP..
			
			askToContinue();
		}// END OF..
			
			// Method to ask the user if they want to try again.
			public static void askToContinue()
			{
				System.out.println("Do you want to run it again: (y/n)");
				
				String s_continue = m_SCANNER.nextLine();
				if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
				{
					// Reseting and Starting again..
					main(new String[0]);
				}
				else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
				{
					System.out.println("Good bye!");
					System.exit(0);
				}
				else
					askToContinue();
			}// END OF.
}
