package xptoolkit.cactus;

import org.apache.commons.cactus.*;
import junit.framework.*;

public class SessionMapperTest extends ServletTestCase{
 
   
    
    public SessionMapperTest(String name){
        super(name);
    }
   
    public void beginMapRequestToSession(ServletTestRequest request){
        request.addParameter("Test--101", "I love Cactus!");
    }
    
    public void testMapRequestToSession(){
        SessionMapper.mapRequestToSession(request);
        String value = (String)session.getAttribute("Test--101");
        assertEquals("parameter found in session", "I love Cactus!", value);
    }
    
    public static TestSuite suite(){
        TestSuite suite = new TestSuite(SessionMapperTest.class);
        return suite;
    }
    
    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }
}