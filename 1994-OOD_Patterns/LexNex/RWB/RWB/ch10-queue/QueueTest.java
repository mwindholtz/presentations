
import junit.framework.TestCase;

public class QueueTest extends TestCase {
    public void testQ() {
	Queue q = new Queue();
	q.addRear("E1");
	q.addRear("E2");
	assertEquals("E1", q.removeFront());
	assertEquals("E2", q.removeFront());
	assertEquals(0, q.getSize());
    }

}