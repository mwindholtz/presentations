// TestBanker -- Test Case forBanker

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

public class TestBanker
    extends TestCase
{
    // JUnit Framework -----------------------------------------------

    public TestBanker (String name) { super (name); }

    public static Test suite () {
        TestSuite suite = new TestSuite (TestBanker.class);
        return suite;
    }

    private void remove(int p) {
	for (int i=0; i<Banker.available.length; i++) {
	    Banker.available[i] += Banker.assign[p][i];
	    Banker.executed[p] = true;
	}
    }

    // Tests ---------------------------------------------------------

    public void testFindNextProcess() {
	assertEquals(6, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(6);
	assertEquals(3, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(3);
	assertEquals(2, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(2);
	assertEquals(0, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(0);
	assertEquals(1, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(1);
	assertEquals(4, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(4);
	assertEquals(5, Banker.next(Banker.claim, Banker.assign, Banker.available));
	remove(5);
	assertEquals(-1, Banker.next(Banker.claim, Banker.assign, Banker.available));
    }

//     public void testCanRun() {
// 	assertFalse(Banker.canRun(Banker.claim[0], Banker.assign[0], Banker.available));
// 	assertFalse(Banker.canRun(Banker.claim[4], Banker.assign[4], Banker.available));
// 	assertFalse(Banker.canRun(Banker.claim[5], Banker.assign[5], Banker.available));
// 	assertTrue (Banker.canRun(Banker.claim[6], Banker.assign[6], Banker.available));
//     }

//     public void testDeallocateProcess() {
// 	int[] ass    = {1, 2, 3, 0, 3, 2, 1, 0};
// 	int[] avail  = {1, 2, 3, 4, 5, 6, 7, 6};
// 	int[] expect = {2, 4, 6, 4, 8, 8, 8, 6};
// 	Banker.deallocateProcess(ass, avail);
// 	for (int i=0; i<Banker.MAXR; i++) {
// 	    assertEquals("I=" + i, expect[i], avail[i]);
// 	}
//     }
}

