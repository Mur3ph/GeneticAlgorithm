package ie.murph.java.algorithm.randomnumber;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RandomNumberGeneratorTest {

	private RandomNumber randomNumber;
	private RandomNumberGenerator resultRrandomNumberGenerator;
	
	@Before
    public void setUp() 
	{
		randomNumber = new RandomNumber();
		resultRrandomNumberGenerator = new RandomNumberGenerator(randomNumber);
		resultRrandomNumberGenerator.setRandomNumberbetween(1, 10);
		resultRrandomNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(10);
    }
	
    @After
    public void tearDown() 
    {
    	resultRrandomNumberGenerator.clearArray();
    }
    
    @Test
	public void checkRandomNumberGeneratorObjectForNull()
	{
		assertNotNull(resultRrandomNumberGenerator);
	}
	
	@Test
	public void checkRandomNumberGeneratorObjectIsNull()
	{
		RandomNumberGenerator nullRrandomNumberGenerator = null;
		assertNull(nullRrandomNumberGenerator);
	}
	
	@Test
	public void checkBoundariesOfEachOfTheRandomWholeNumbersGeneratedIsInBoundsTest()
	{
		Integer[] onlyNumbersArrayShouldContain = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		boolean isContains = useArraysBinarySearch(onlyNumbersArrayShouldContain, resultRrandomNumberGenerator.getRandomWholeNumbers());
		assertTrue(isContains);
	}
	
	@Test
	public void checkBoundariesOfEachOfTheRandomWholeNumbersGeneratedIsNotInBoundsTest()
	{
		Integer[] someNumbersArrayShouldNotContain = {11, 12, 31, 41, 51, 116, 1117, 1800, -1, 0};
		boolean isContains = useArraysBinarySearch(someNumbersArrayShouldNotContain, resultRrandomNumberGenerator.getRandomWholeNumbers());
		assertFalse(isContains);
	}
	
	private static boolean useArraysBinarySearch(Integer[] listOfNumbersToCheckRandomNumbersAgainst, Integer[] randomNumbers) {	
		return Arrays.asList(listOfNumbersToCheckRandomNumbersAgainst).containsAll(Arrays.asList(randomNumbers));
	}
	
	@Ignore
	private static boolean useSetCheckForDuplicates(Integer[] arr) {
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		return set.contains(arr);
	}
	
	@Test
	public void checkLengthOfArrayIsExactlyTest()
	{
		boolean isExactly = resultRrandomNumberGenerator.getRandomWholeNumbers().length == 10;
		assertTrue(isExactly);
	}
	
	@Test
	public void checkLengthOfArrayIsInBoundsTest()
	{
		int index = 10;
		boolean isInBounds = (index >= 1) && (index <= resultRrandomNumberGenerator.getRandomWholeNumbers().length);
		assertTrue(isInBounds);
	}
	
	@Test
	public void checkLengthOfArrayIsNotBoundsTest()
	{
		int index = 10;
		boolean isInBounds = (index <= 1) && (index > resultRrandomNumberGenerator.getRandomWholeNumbers().length);
		assertFalse(isInBounds);
	}
	
	@Test
	public void checkDifferentRandomWholeNumberAreGeneratedEachTimeTest() {
		RandomNumberGenerator expectedRrandomNumberGenerator = new RandomNumberGenerator(randomNumber);
		expectedRrandomNumberGenerator.setRandomNumberbetween(1, 10);
		expectedRrandomNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(10);
		
		Assert.assertNotEquals(expectedRrandomNumberGenerator.getRandomWholeNumbers(), resultRrandomNumberGenerator.getRandomWholeNumbers() );
	}
	
	@Test
	public void checkDifferentRandomWholeNumberAreGeneratedEachTimePartDeuxTest() {
		RandomNumberGenerator expectedRrandomNumberGenerator = new RandomNumberGenerator(randomNumber);
		expectedRrandomNumberGenerator.setRandomNumberbetween(1, 10);
		expectedRrandomNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(10);
		
		assertTrue(!Arrays.equals(expectedRrandomNumberGenerator.getRandomWholeNumbers(), resultRrandomNumberGenerator.getRandomWholeNumbers()));
	}

}
