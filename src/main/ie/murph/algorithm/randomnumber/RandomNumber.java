package main.ie.murph.algorithm.randomnumber;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.log4j.Logger;

//Created Class to remove third party APIs from domain logic
public class RandomNumber
{
    private static final Logger LOGGER = Logger.getLogger(RandomNumber.class);
    private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();

    public int getInt(int i)
    {
	LOGGER.debug("++getInt()\n");
	return RANDOM_NUMBER_GENERATOR.nextInt(i);
    }

    public double getDouble()
    {
	LOGGER.debug("++getDouble()\n");
	return RANDOM_NUMBER_GENERATOR.nextDouble();
    }
}
