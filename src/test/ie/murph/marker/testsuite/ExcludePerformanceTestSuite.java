package test.ie.murph.marker.testsuite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ie.murph.marker.interfaces.PerformanceTests;
import test.ie.murph.util.BinaryUtilTest;

@RunWith(Categories.class)
@Categories.ExcludeCategory(PerformanceTests.class)
@Suite.SuiteClasses({BinaryUtilTest.class})
public class ExcludePerformanceTestSuite
{

}
