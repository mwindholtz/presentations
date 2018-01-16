package banker;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite =
			new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		suite.addTest(TestBanker.suite());
		//$JUnit-END$
		return suite;
	}
}
