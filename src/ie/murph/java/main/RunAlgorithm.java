package ie.murph.java.main;

import java.util.Scanner;

import ie.murph.java.main.algorithm.GeneticAlgorithm;
import ie.murph.java.main.algorithm.fitness.OrganizedFitness;
import ie.murph.java.main.algorithm.fitness.SumFitness;
import ie.murph.java.main.algorithm.fitness.UnorganizedFitness;
import ie.murph.java.main.algorithm.math.Crossover;
import ie.murph.java.main.algorithm.math.CumulativeFrequency;
import ie.murph.java.main.algorithm.math.Normalization;
import ie.murph.java.main.algorithm.randomnumber.RandomNumber;
import ie.murph.java.main.algorithm.randomnumber.RandomNumberGenerator;
import ie.murph.java.main.interfaces.ConsoleMessage;

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
			Normalization normalization = new Normalization(organizedFitness, sumFitness);
			CumulativeFrequency cumulativeFrequency = new CumulativeFrequency(normalization);
			Crossover crossover = new Crossover();
			GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(cumulativeFrequency, crossover);
			
			geneticAlgorithm.generatePopulationFitness();
			//Asking user to input the amount of generations of fitness offspring they want to view
			System.out.println(ConsoleMessage.ASK_HOW_MANY_HUMAN_GENERATIONS_USER_WANTS_TO_CLACULATE);
			int userInputChoosePopulationSize = READ_IN_USER_INPUT.nextInt()+1;
			
			for(int generationX = 1; generationX < userInputChoosePopulationSize; generationX++)
			{
				System.out.println("\nGENERATION: " + generationX + "\n");
				geneticAlgorithm.generateUnOrganizedFitnessValuesPhaseOne();
				geneticAlgorithm.generateOrganizedFitnessValuesPhaseTwo();
				geneticAlgorithm.calculatingTotalSumOfFitnessValuePhaseThree();
				geneticAlgorithm.dividingSumOfFitnessAgainstEachIndividualFitnessToCalculateNormalizedData();
				geneticAlgorithm.addingNormalizedDataToCalculateCumulaiveFreguency();
				geneticAlgorithm.compareEachRandonDoubleAgainstCumulativeFrequency();
				geneticAlgorithm.choosePopulationMemberFromCumulativeFrequenceyChosenInPhase8();
				geneticAlgorithm.crossoverOfTwoBinaryStringAtRandomPositions();
				geneticAlgorithm.changeOneOfTheBitsInTheBinaryString();
				geneticAlgorithm.convertBinaryStringToInteger();
				geneticAlgorithm.createANewPopulationWithTheTwoFittestAndThreeMoreRandomFromThePopulation();
				
			}
			
			askUserToContinueWithGeneticAlgorithm();
		}
			
		private static void askUserToContinueWithGeneticAlgorithm()
		{
			System.out.println("Do you want to run it again: (y/n)");
			
			String s_continue = READ_IN_USER_INPUT.nextLine();
			if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
			{
				resetMainThreadToRunGeneticAlgorithmAgain();
			}
			else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
			{
				exitGeneticAlgorithmApp();
			}
			else
				askUserToContinueWithGeneticAlgorithm();
		}
		
		private static void resetMainThreadToRunGeneticAlgorithmAgain()
		{
			main(new String[0]);
		}
		
		private static void exitGeneticAlgorithmApp()
		{
			System.out.println("Good bye!");
			printToDoList();
			System.exit(0);
		}
		
		private static void printToDoList()
		{
			for(String todoMessage : ConsoleMessage.TODO_LIST)
			{
				System.out.println("\n" + todoMessage);
			}
		}
}
