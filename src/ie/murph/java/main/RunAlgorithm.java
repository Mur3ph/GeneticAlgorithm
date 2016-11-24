package ie.murph.java.main;

import java.util.Scanner;

import ie.murph.java.algorithm.GeneticAlgorithm;
import ie.murph.java.algorithm.fitness.OrganizedFitness;
import ie.murph.java.algorithm.fitness.SumFitness;
import ie.murph.java.algorithm.fitness.UnorganizedFitness;
import ie.murph.java.algorithm.randomnumber.RandomNumber;
import ie.murph.java.algorithm.randomnumber.RandomNumberGenerator;
import ie.murph.java.interfaces.ConsoleMessage;

public class RunAlgorithm 
{
	private static final Scanner READ_IN_USER_INPUT = new Scanner(System.in);
	public static void main(String[] args)
	{
		runGeneticAlgorithm();
	}
	
		// Method used to start the fitness generations flow...
		private static void runGeneticAlgorithm()
		{
			RandomNumber randomNumber = new RandomNumber();
			RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(randomNumber);
			UnorganizedFitness unorganizedMapFitness = new UnorganizedFitness(randomNumberGenerator);
			OrganizedFitness organizedFitness = new OrganizedFitness(unorganizedMapFitness);
			SumFitness sumFitness = new SumFitness(organizedFitness);
			GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(randomNumberGenerator, unorganizedMapFitness, organizedFitness, sumFitness);
			
			geneticAlgorithm.generateRandonNumbersForFitness();
			//Asking user to input the amount of generations of fitness offspring they want to view
			System.out.println(ConsoleMessage.ASK_HOW_MANY_HUMAN_GENERATIONS_USER_WANTS_TO_CLACULATE);
			int generation = READ_IN_USER_INPUT.nextInt()+1;
			
			for(int generationX = 1; generationX < generation; generationX++)
			{
				System.out.println("\nGENERATION: " + generationX + "\n");
				geneticAlgorithm.placeArrayIntoUnOrganizedTreeMap();
				geneticAlgorithm.placeUnOrganizedTreeMapIntoOrganizedTreeMap();
				geneticAlgorithm.calculatingTheSumOfFitness();
				geneticAlgorithm.dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData();
				geneticAlgorithm.addingNormalizedDataToCalculateCumulaiveFreguency();
				geneticAlgorithm.generateTheTwoContinuesRandomNumbersBetween0and1();
				geneticAlgorithm.compareEachRandonDoubleAgainstCumulativeFrequency();
				geneticAlgorithm.choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8();
				geneticAlgorithm.crossoverOfTwoBinaryStringAtRandomPositions();
				geneticAlgorithm.changeOneOfTheBitsInTheBinaryString();
				geneticAlgorithm.convertBinaryStringToInteger();
				geneticAlgorithm.createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation();
				
			} // END OF FOR LOOP..
			
			askUserToContinueWithGeneticAlgorithm();
		}// END OF..
			
			private static void askUserToContinueWithGeneticAlgorithm()
			{
				System.out.println("Do you want to run it again: (y/n)");
				
				String s_continue = READ_IN_USER_INPUT.nextLine();
				if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
				{
					resetThreadToRunGeneticAlgorithmAgain();
				}
				else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
				{
					exitGeneticAlgorithmApp();
				}
				else
					askUserToContinueWithGeneticAlgorithm();
			}// END OF.
			
			private static void resetThreadToRunGeneticAlgorithmAgain()
			{
				main(new String[0]);
			}
			
			private static void exitGeneticAlgorithmApp()
			{
				System.out.println("Good bye!");
				System.exit(0);
			}
			
}
