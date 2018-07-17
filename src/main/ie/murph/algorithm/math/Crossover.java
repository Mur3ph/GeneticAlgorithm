package main.ie.murph.algorithm.math;

import org.apache.log4j.Logger;


public class Crossover
{
    private static final Logger LOGGER = Logger.getLogger(Crossover.class);
    private String binaryValue_1;
    private String binaryValue_2;

    private String firstHalfOfBinaryGene;
    private String secondHalfOfBinaryGene;

    private String offspringChild;
    private String firstNewOffspringChild;
    private String secondNewOffspringChild;

    private final int startOfBinary = 0, centerOfBinary = 3, endOfBinary = 6;

    public void setBinaryValue_1(String binaryValue_1)
    {
	LOGGER.debug("++setBinaryValue_1()\n");
	this.binaryValue_1 = binaryValue_1;
	LOGGER.debug("--setBinaryValue_1()\n");
    }

    public String getBinaryValue_1()
    {
	LOGGER.debug("++getBinaryValue_1()\n");
	return this.binaryValue_1;
    }

    public void setBinaryValue_2(String binaryValue_2)
    {
	LOGGER.debug("++setBinaryValue_2()\n");
	this.binaryValue_2 = binaryValue_2;
	LOGGER.debug("--setBinaryValue_2()\n");
    }

    public String getBinaryValue_2()
    {
	LOGGER.debug("++getBinaryValue_2()\n");
	return this.binaryValue_2;
    }

    public void setFirstHalfOfBinaryGene(String firstHalfOfBinaryGene)
    {
	LOGGER.debug("++setFirstHalfOfBinaryGene()\n");
	this.firstHalfOfBinaryGene = firstHalfOfBinaryGene;
	LOGGER.debug("--setFirstHalfOfBinaryGene()\n");
    }

    public String getFirstHalfOfBinaryGene()
    {
	LOGGER.debug("++getFirstHalfOfBinaryGene()\n");
	return this.firstHalfOfBinaryGene;
    }

    public void setSecondHalfOfBinaryGene(String secondHalfOfBinaryGene)
    {
	LOGGER.debug("++setSecondHalfOfBinaryGene()\n");
	this.secondHalfOfBinaryGene = secondHalfOfBinaryGene;
	LOGGER.debug("--setSecondHalfOfBinaryGene()\n");
    }

    public String getSecondHalfOfBinaryGene()
    {
	LOGGER.debug("++getSecondHalfOfBinaryGene()\n");
	return this.secondHalfOfBinaryGene;
    }

    public void setOffspringChild(String offspringChild)
    {
	LOGGER.debug("++setOffspringChild()\n");
	this.offspringChild = offspringChild;
	LOGGER.debug("--setOffspringChild()\n");
    }

    public String getOffspringChild()
    {
	LOGGER.debug("++getOffspringChild()\n");
	return this.offspringChild;
    }

    public void setFirstNewOffspring()
    {
	LOGGER.debug("++setFirstNewOffspring()\n");
	setFirstHalfOfBinaryGene(getSubstringOfFirstBinaryValue(startOfBinary, centerOfBinary));
	setSecondHalfOfBinaryGene(getSubstringOfSecondBinaryValue(centerOfBinary, endOfBinary));

	setOffspringChild(getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene());
	this.firstNewOffspringChild = getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene();
	LOGGER.debug("--setFirstNewOffspring()\n");
    }

    public void setSecondNewOffspring()
    {
	LOGGER.debug("++setSecondNewOffspring()\n");
	setFirstHalfOfBinaryGene(getSubstringOfSecondBinaryValue(startOfBinary, centerOfBinary));
	setSecondHalfOfBinaryGene(getSubstringOfFirstBinaryValue(centerOfBinary, endOfBinary));

	setOffspringChild(getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene());
	this.secondNewOffspringChild = getFirstHalfOfBinaryGene() + getSecondHalfOfBinaryGene();
	LOGGER.debug("--setSecondNewOffspring()\n");
    }

    private String getSubstringOfFirstBinaryValue(int startPosition, int endPosition)
    {
	LOGGER.debug("++getSubstringOfFirstBinaryValue()\n");
	return getBinaryValue_1().substring(startPosition, endPosition);
    }

    private String getSubstringOfSecondBinaryValue(int startPosition, int endPosition)
    {
	LOGGER.debug("++getSubstringOfSecondBinaryValue()\n");
	return getBinaryValue_2().substring(startPosition, endPosition);
    }

    public String getFirstNewOffspring()
    {
	LOGGER.debug("++getFirstNewOffspring()\n");
	return this.firstNewOffspringChild;
    }

    public String getSecondNewOffspring()
    {
	LOGGER.debug("++getSecondNewOffspring()\n");
	return this.secondNewOffspringChild;
    }

    public String printCrossover()
    {
	LOGGER.debug("++printCrossover()\n");
	return "\n" + "New Offspring crossover 1: " + getFirstNewOffspring() + "\n" + "New Offspring crossover 2: "
		+ getSecondNewOffspring() + "\n";
    }
}
