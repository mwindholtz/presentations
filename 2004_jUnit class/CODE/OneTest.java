import junit.framework.*;
import junit.textui.*;

public class OneTest extends TestCase
{
	public OneTest(String name)
	{ super(name);
	}

	public static void main(String[] args) {
		new TestRunner().run(OneTest.class);
	}


	public void testFail()
	{ fail("failure");
	}

	public void testError()
	{  String n=null;
	   n.length();
	}

	public void testPass()
	{
	}

}
