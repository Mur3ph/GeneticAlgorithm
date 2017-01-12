package ie.murph.java.util;

import ie.murph.java.algorithm.math.CumulativeFrequency;

public class BinaryUtil 
{
//	final static int bit128 = 128; 		// for 8 bit we use 128      (i.e. 7 bit = 128)
	final static int bit32 = 32; 		// for 6 bit we use 32 etc.  (i.e. 5 bit = 32)
//	final static int bit16 = 16; 		// for 5 bit we use 16 etc.  (i.e. 4 bit = 16)
	
	final static int lengthOf128BitBinary = 8;
	final static int lengthOf32BitBinary = 6;
	final static int lengthOf16BitBinary = 5;
	
	final static char negativeBinaryBit = '0';
	final static char positiveBinaryBit = '1';
	
	static StringBuilder[] arrayOfOffspringBinary;
	static Integer[] randomNumbersToGetBinaryBitPositionsToBeAltered;
	static char[] offspringBinaryBitsToBeAltered;
	
	// Method to find the (6 bit) binary equivalent of an integer - or change the length of loops to whatever size bit you need
	public static String convertIntegerToBinaryString(int integerValue) 
	{
		String binary = "";
		for(int x = 0; x < lengthOf32BitBinary; x++)
		{
			//If the value has a remainder use the '1' binary bit
			if(hasRemainder(integerValue))
			{
				binary = appendPositiveBinaryBit(binary);
			}
			if(hasNoRemainder(integerValue))
			{
				binary = appendNegativeBinaryBit(binary);
			}
			integerValue = half(integerValue);
		}
		return binary;
	}
	
	private static boolean hasRemainder(int integerValue) 
	{
		return integerValue % 2 == 1;
	}

	private static String appendPositiveBinaryBit(String binary)
	{
		return "1" + binary;
	}
	
	private static boolean hasNoRemainder(int integerValue) 
	{
		return integerValue % 2 == 0;
	}
	
	private static String appendNegativeBinaryBit(String binary)
	{
		return "0" + binary;
	}
	
	private static int half(int integerValue) 
	{
		return integerValue/2;
	}
	
	//Converting my binary bits back to Integer
	public static int convertBinaryToInteger(String binary)
	{
		int integer = 0;
		int binaryBitIntegerValue = bit32;
		
		for(int indexPosition = 0; indexPosition < binary.length(); indexPosition++)
		{
			char binaryBit = binary.charAt(indexPosition);
			// Single quotations needed when using 'char'
			if(binaryBit == positiveBinaryBit)
			{
				//Only if the binary bit is a one do we calculate sum below
				integer = integer + (binaryBitIntegerValue*1);
			}
			//We are working from the left of the binary string to the right, so we start at 32, then half for 16, next 8, and so on
			binaryBitIntegerValue=binaryBitIntegerValue/2;
		}
		return integer;
	}
	
	// Altering one of the bits in both binary strings, using the StringBuilder Object
	public static StringBuilder[] getMutatedBinaryStrings(String offspringBinary_1, String offspringBinary_2, CumulativeFrequency cumulativeFrequency)
	{
		//Converting the string to string builder object because easy to alter or manipulate binary bits
		setArrayOfOffspringBinary(offspringBinary_1, offspringBinary_2);
			
		randomNumbersToGetBinaryBitPositionsToBeAltered = getPositionsOfBothBinaryBitsToBeMutated(cumulativeFrequency);
		offspringBinaryBitsToBeAltered = getBothBinaryBits(offspringBinary_1, offspringBinary_2);
		
		StringBuilder[] arrayWithBothAlteredBinaryCodes = getAlteredBinaryStrings();
		
//		printBinaryAndPositionToBeMutated(offspringBinary_1, offspringBinary_2);
		
		return arrayWithBothAlteredBinaryCodes;
	}
	
	private static void setArrayOfOffspringBinary(String offspringBinary_1, String offspringBinary_2)
	{
		arrayOfOffspringBinary = new StringBuilder[]{offspringBinaryByte(offspringBinary_1), offspringBinaryByte(offspringBinary_2)};
	}
	
	private static StringBuilder offspringBinaryByte(String offspringBinary)
	{
		return new StringBuilder(offspringBinary);
	}
	
	private static Integer[] getPositionsOfBothBinaryBitsToBeMutated(CumulativeFrequency cumulativeFrequency)
	{
		//Choosing the bit in each binary string to be altered at random each time
		return new Integer[]{getRandomNumber(cumulativeFrequency), getRandomNumber(cumulativeFrequency)};
	}
	
	//Choosing the bit in each binary string to be altered at random each time
	private static int getRandomNumber(CumulativeFrequency cumulativeFrequency)
	{
		//TODO: Change setRandomNumberbetween(0, 5) as First bit never gets mutated
		cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().setRandomNumberbetween(0, 5);
		return cumulativeFrequency.getNormalization().getOrganizedFitness().getUnorganizedFitness().getRandomNumberGenerator().getARandomWholeNumber();
	}
	
	private static char[] getBothBinaryBits(String offspringBinaryStr_1, String offspringBinaryStr_2)
	{
		// Getting that bit in the random position
		return new char[]{offspringBinaryStr_1.charAt(randomNumbersToGetBinaryBitPositionsToBeAltered[0]), offspringBinaryStr_1.charAt(randomNumbersToGetBinaryBitPositionsToBeAltered[1])};
	}
	
	private static StringBuilder[] getAlteredBinaryStrings() 
	{
		StringBuilder[] arrayWithBothAlteredBinaryCodes = new StringBuilder[2];
		//If it is a zero binary bit change to a one and so on..
		for(int binaryIndex = 0; binaryIndex < lengthOfArrayBinaryOffspring(); binaryIndex++)
		{
			if(offspringBinaryBitsToBeAltered[binaryIndex] == negativeBinaryBit)
			{
				getArrayOfOffspringBinary()[binaryIndex].setCharAt(randomNumbersToGetBinaryBitPositionsToBeAltered[binaryIndex], positiveBinaryBit);
				arrayWithBothAlteredBinaryCodes[binaryIndex] = getArrayOfOffspringBinary()[binaryIndex];
			}
			else
			{
				getArrayOfOffspringBinary()[binaryIndex].setCharAt(randomNumbersToGetBinaryBitPositionsToBeAltered[binaryIndex], negativeBinaryBit);
				arrayWithBothAlteredBinaryCodes[binaryIndex] = getArrayOfOffspringBinary()[binaryIndex];
			}
		}
		return arrayWithBothAlteredBinaryCodes;
	}
	
	private static int lengthOfArrayBinaryOffspring()
	{
		return arrayOfOffspringBinary.length;
	}
	
	private static StringBuilder[] getArrayOfOffspringBinary()
	{
		return arrayOfOffspringBinary;
	}
	
	public static void printBinaryAndPositionToBeMutated(String offspringBinaryStr_1, String offspringBinaryStr_2) 
	{
		System.out.println("Mutated offspring 1: " + offspringBinaryByte(offspringBinaryStr_1) + " Bit at positon " + randomNumbersToGetBinaryBitPositionsToBeAltered[0]);
		System.out.println("Mutated offspring 2: " + offspringBinaryByte(offspringBinaryStr_2) + " Bit at positon " + randomNumbersToGetBinaryBitPositionsToBeAltered[1]);
	}

	
}
