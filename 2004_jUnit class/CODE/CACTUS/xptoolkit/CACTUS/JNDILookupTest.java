package xptoolkit.cactus;
import java.net.HttpURLConnection;
import org.apache.commons.cactus.*;
import org.apache.commons.cactus.util.AssertUtils;
import junit.framework.*;

public class JNDILookupTest extends ServletTestCase{
    
    public JNDILookupTest(String name) {
        super(name);
    }

    public void testJNDILookup()throws Exception{
        javax.sql.XAConnection conn = JNDILookup.connectionLookup();
        assertNotNull(conn);
    }
    
    public static TestSuite suite(){
        TestSuite suite = new TestSuite(JNDILookupTest.class);
        return suite;
    }
    
    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }
}
