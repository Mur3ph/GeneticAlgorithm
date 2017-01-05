package ie.murph.java.algorithm.math;


public class Crossover
{
	private String binaryValue_1;
	private String binaryValue_2;
	
	private String firstHalfOfBinaryGene;
	private String secondHalfOfBinaryGene;
	
	private String offspringChild;
	
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
	
	public void setFirstHalfOfBinaryGene(String firstHalfOfBinaryGene)
	{
		this.firstHalfOfBinaryGene = firstHalfOfBinaryGene;
	}
	
	public String getFirstHalfOfBinaryGene()
	{
		return this.firstHalfOfBinaryGene;
	}
	
	public void setSecondHalfOfBinaryGene(String secondHalfOfBinaryGene)
	{
		this.secondHalfOfBinaryGene = secondHalfOfBinaryGene;
	}
	
	public String getSecondHalfOfBinaryGene()
	{
		return this.secondHalfOfBinaryGene;
	}
	
	public void setOffspringChild(String offspringChild)
	{
		this.offspringChild = offspringChild;
	}
	
	public String getOffspringChild()
	{
		return this.offspringChild;
	}
	
	//The crossover is a merging of both binary strings (i.e. genes in genetics) to create one better fitter child/offspring
	//Example: Binary 1 - 00000 and Binary 2 - 11111 --> Would produce an off-spring of: 00011 using single point crossover at position 3
	public void crossoverOfTwoBinaryStringAtRandomPositions() 
	{
		//TODO Can only chose one offspring per pair of elite candidates AND generate more random parents
		setFirstHalfOfBinaryGene(this.getBinaryValue_1().substring(0, 3));
		setSecondHalfOfBinaryGene(this.getBinaryValue_2().substring(3, 6));
		
		setOffspringChild(getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene());
	}
	
	public String printCrossover()
	{
		return "Offspring crossover: " + getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene();
	}
}
