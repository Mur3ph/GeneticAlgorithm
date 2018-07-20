package test.ie.murph.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.ie.murph.util.BinaryUtil;

public class BinaryUtilTest
{
	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testConvertIntegerToBinaryString()
	{
		int digitFive = 5;
		String binaryEquivilentOfDigitFive = "000101";
		String binaryEquivilentOfDigitFour = "000100";
		
		System.out.println("BinaryUtilTest: " + BinaryUtil.convertIntegerToBinaryString(digitFive));
		
		assertEquals("Both are true, this will succeed", BinaryUtil.convertIntegerToBinaryString(digitFive), binaryEquivilentOfDigitFive);
		assertNotEquals("Both are true, this will succeed", BinaryUtil.convertIntegerToBinaryString(digitFive), binaryEquivilentOfDigitFour);
		
//		Asserts that two objects do not refer to the same object.
		assertNotSame(BinaryUtil.convertIntegerToBinaryString(digitFive), binaryEquivilentOfDigitFive);	
	}

	@Ignore
	public void testConvertBinaryToInteger()
	{
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetMutatedBinaryStrings()
	{
		fail("Not yet implemented");
	}

}
