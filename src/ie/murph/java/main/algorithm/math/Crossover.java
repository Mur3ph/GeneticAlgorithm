package ie.murph.java.main.algorithm.math;


public class Crossover
{
	private String binaryValue_1;
	private String binaryValue_2;
	
	private String firstHalfOfBinaryGene;
	private String secondHalfOfBinaryGene;
	
	private String offspringChild;
	private String firstNewOffspringChild;
	private String secondNewOffspringChild;
	
	private final int startOfBinary = 0, centerOfBinary=3, endOfBinary=6;
	
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
	
	public void setFirstNewOffspring() 
	{
		setFirstHalfOfBinaryGene(getSubstringOfFirstBinaryValue(startOfBinary, centerOfBinary));
		setSecondHalfOfBinaryGene(getSubstringOfSecondBinaryValue(centerOfBinary, endOfBinary));
		
		setOffspringChild(getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene());
		this.firstNewOffspringChild = getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene();
	}

	public void setSecondNewOffspring() 
	{
		setFirstHalfOfBinaryGene(getSubstringOfSecondBinaryValue(startOfBinary, centerOfBinary));
		setSecondHalfOfBinaryGene(getSubstringOfFirstBinaryValue(centerOfBinary, endOfBinary));
		
		setOffspringChild(getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene());
		this.secondNewOffspringChild = getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene();
	}
	
	private String getSubstringOfFirstBinaryValue(int startPosition, int endPosition) 
	{
		return getBinaryValue_1().substring(startPosition, endPosition);
	}
	
	private String getSubstringOfSecondBinaryValue(int startPosition, int endPosition) 
	{
		return getBinaryValue_2().substring(startPosition, endPosition);
	}
	
	public String getFirstNewOffspring()
	{
		return this.firstNewOffspringChild;
	}
	
	public String getSecondNewOffspring()
	{
		return this.secondNewOffspringChild;
	}

	public String printCrossover()
	{
		return 	"\n" + 
				"New Offspring crossover 1: " + getFirstNewOffspring() + "\n" +
				"New Offspring crossover 2: " + getSecondNewOffspring() + "\n";
	}
}
