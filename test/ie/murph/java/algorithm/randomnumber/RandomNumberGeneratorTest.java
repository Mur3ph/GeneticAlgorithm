package ie.murph.java.algorithm.randomnumber;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomNumberGeneratorTest {

	RandomNumberGenerator randomNumberGenerator;
	
	@Before
    public void setUp() {
		randomNumberGenerator = new RandomNumberGenerator();
		randomNumberGenerator.setRandomNumberbetween(1, 10);
		randomNumberGenerator.populateArrayWithRandomWholeNumbersOfLength(10);
    }
	
    @After
    public void tearDown() {
    	randomNumberGenerator.clearArray();
    }
	
	@Test
	public void test() {
		RandomNumberGenerator expected = new RandomNumberGenerator();
		expected.setRandomNumberbetween(1, 10);
		expected.populateArrayWithRandomWholeNumbersOfLength(10);
		
		Assert.assertNotEquals( expected, randomNumberGenerator );
	}

}
