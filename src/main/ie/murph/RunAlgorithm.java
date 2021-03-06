package main.ie.murph;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import main.ie.murph.algorithm.GeneticAlgorithm;
import main.ie.murph.algorithm.fitness.*;
import main.ie.murph.algorithm.math.*;
import main.ie.murph.algorithm.randomnumber.*;
import main.ie.murph.interfaces.*;

public class RunAlgorithm
{
	private static final Scanner READ_IN_USER_INPUT = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(RunAlgorithm.class);

	public static void main(String[] args)
	{
		LOGGER.debug("++main(String[] args)\n");
		RunAlgorithm runAlgorithm = new RunAlgorithm();
		runAlgorithm.configureLoggingToRun();
		runAlgorithm.runGeneticAlgorithm();
		LOGGER.debug("++main(String[] args)\n");
	}

	private void configureLoggingToRun()
	{
		// Use BasicConfigurator to help run configure Log4j properly - will
		// give error without it.
		// //http://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
		BasicConfigurator.configure();
	}

	// Method used to start the fitness generations flow...
	private void runGeneticAlgorithm()
	{
		LOGGER.debug("++runGeneticAlgorithm()\n");
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
		// Asking user to input the amount of generations of fitness offspring
		// they want to view
		System.out.println(ConsoleMessage.ASK_HOW_MANY_HUMAN_GENERATIONS_USER_WANTS_TO_CLACULATE);
		int userInputChoosePopulationSize = READ_IN_USER_INPUT.nextInt() + 1;

		for (int generationX = 1; generationX < userInputChoosePopulationSize; generationX++)
		{
			System.out.println(
					ConsoleMessage.NEXT_LINE + ConsoleMessage.GENERATION + generationX + ConsoleMessage.NEXT_LINE);
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
		LOGGER.debug("--runGeneticAlgorithm()\n");
	}

	private static void askUserToContinueWithGeneticAlgorithm()
	{
		LOGGER.debug("++askUserToContinueWithGeneticAlgorithm()\n");
		System.out.println(ConsoleMessage.QUESTION_DO_YOU_WANT_TO_RUN_ALGORITHM_AGAIN);

		String s_continue = READ_IN_USER_INPUT.nextLine();
		if (s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
		{
			resetMainThreadToRunGeneticAlgorithmAgain();
		}
		else
			if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
			{
				exitGeneticAlgorithmApp();
			}
			else
				askUserToContinueWithGeneticAlgorithm();
		LOGGER.debug("--askUserToContinueWithGeneticAlgorithm()\n");
	}

	private static void resetMainThreadToRunGeneticAlgorithmAgain()
	{
		LOGGER.debug("++resetMainThreadToRunGeneticAlgorithmAgain()\n");
		main(new String[0]);
		LOGGER.debug("--resetMainThreadToRunGeneticAlgorithmAgain()\n");
	}

	private static void exitGeneticAlgorithmApp()
	{
		LOGGER.debug("++exitGeneticAlgorithmApp()\n");
		System.out.println(ConsoleMessage.GOOD_BYE);
		printToDoList();
		System.exit(0);
		LOGGER.debug("--exitGeneticAlgorithmApp()\n");
	}

	private static void printToDoList()
	{
		LOGGER.debug("++printToDoList()\n");
		for (String todoMessage : ConsoleMessage.TODO_LIST)
		{
			System.out.println(ConsoleMessage.NEXT_LINE + todoMessage);
		}
		LOGGER.debug("--printToDoList()\n");
	}
}
