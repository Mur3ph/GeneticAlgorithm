package ie.murph.java.algorithm.math;

import ie.murph.java.interfaces.ConsoleMessage;

public class Crossover
{
	private String binaryValue_1;
	private String binaryValue_2;
	private String offspring_Child_1;
	private String offspring_Child_2;
	
	public void setBinaryValue_1(String binaryValue_1)
	{
		this.binaryValue_1 = binaryValue_1;
	}
	
	public String getBinaryValue_1()
	{
		return this.binaryValue_1;
	}
	
	public void setBinaryValue_2(String binaryValue_2)
	{
		this.binaryValue_2 = binaryValue_2;
	}
	
	public String getBinaryValue_2()
	{
		return this.binaryValue_2;
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
}
