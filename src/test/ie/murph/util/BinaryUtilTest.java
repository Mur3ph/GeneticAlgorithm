package test.ie.murph.util;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import main.ie.murph.util.BinaryUtil;
import test.ie.murph.marker.interfaces.PerformanceTests;
import test.ie.murph.marker.interfaces.RegressionTests;

@Category({ PerformanceTests.class, RegressionTests.class })
public class BinaryUtilTest
{
	private String binaryEquivilentOfDigitFive = "000101";
	private String binaryEquivilentOfDigitFour = "000100";
	private int digitFive = 5;
	private int digitFour = 4;

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

		System.out.println("BinaryUtilTest: " + BinaryUtil.convertIntegerToBinaryString(digitFive));

		assertEqualsTest();
		assertSameTest();
		checkByteSizeTest();
		usingMatchersAPITest();

	}

	private void assertEqualsTest()
	{
		assertEquals("Failure, both should be equal", BinaryUtil.convertIntegerToBinaryString(digitFive),
				binaryEquivilentOfDigitFive);
		assertNotEquals("Failure, both should not be equal", BinaryUtil.convertIntegerToBinaryString(digitFive),
				binaryEquivilentOfDigitFour);
	}

	private void assertSameTest()
	{
		// Asserts that two objects do not refer to the same object.
		assertNotSame("Failure, both shouldn't be the same", BinaryUtil.convertIntegerToBinaryString(digitFive),
				binaryEquivilentOfDigitFive);
		assertSame("should be same", binaryEquivilentOfDigitFive, binaryEquivilentOfDigitFive);
	}

	private void checkByteSizeTest()
	{
		byte[] expectedByteSize = BinaryUtil.convertIntegerToBinaryString(digitFive).getBytes();
		byte[] actualByteSize = BinaryUtil.convertIntegerToBinaryString(digitFive).getBytes();
		assertArrayEquals("failure - byte arrays not same", expectedByteSize, actualByteSize);
	}

	private void usingMatchersAPITest()
	{
		// Matchers
		assertThat(BinaryUtil.convertIntegerToBinaryString(digitFive), allOf(equalTo("000101"), startsWith("0")));
		assertThat(BinaryUtil.convertIntegerToBinaryString(digitFive),
				not(allOf(equalTo("000100"), equalTo("000101"))));
		assertThat(BinaryUtil.convertIntegerToBinaryString(digitFive), anyOf(equalTo("000100"), equalTo("000101")));
		assertThat(BinaryUtil.convertIntegerToBinaryString(digitFive),
				not(sameInstance(BinaryUtil.convertIntegerToBinaryString(digitFive))));
	}

	@Test
	public void testConvertBinaryToInteger()
	{

		assertEquals("Failure, both should be equal", BinaryUtil.convertBinaryToInteger(binaryEquivilentOfDigitFive),
				digitFive);
		assertNotEquals("Failure, both should not be equal",
				BinaryUtil.convertBinaryToInteger(binaryEquivilentOfDigitFive), digitFour);

	}

	@Ignore
	public void testGetMutatedBinaryStrings()
	{
		fail("Not yet implemented");
	}

}
