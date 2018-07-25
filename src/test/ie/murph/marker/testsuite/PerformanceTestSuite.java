package test.ie.murph.marker.testsuite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ie.murph.marker.interfaces.PerformanceTests;
import test.ie.murph.util.BinaryUtilTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(PerformanceTests.class)
//Include multiple categories
//@Categories.IncludeCategory({PerformanceTests.class, RegressionTests.class})
@Suite.SuiteClasses({BinaryUtilTest.class})
public class PerformanceTestSuite
{ 

}
