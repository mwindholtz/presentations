import junit.framework.TestCase;

public class MatcherTest extends TestCase {
    public MatcherTest(String name) {super(name);}

    public void testMatch() {
        Matcher matcher = new Matcher();

        int[] expected = new int[] {10, 50, 30, 98};
        int clipLimit = 100;
        int delta = 5;

        int[] actual = new int[] {12, 55, 25, 110};

        assertTrue(matcher.match(expected, actual, clipLimit, delta));

        actual = new int[] {10, 60, 30, 98};
        assertTrue(!matcher.match(expected, actual, clipLimit, delta));

        actual = new int[] {10, 50, 30};
        assertTrue(!matcher.match(expected, actual, clipLimit, delta));
    }
}
