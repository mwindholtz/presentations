package xptoolkit.cactus;
import org.apache.commons.cactus.*;
import junit.framework.*;
import java.util.Map;

public class MapperTest extends ServletTestCase{

    public MapperTest(String name) {
        super(name);
    }

    public void beginSessionMapper(ServletTestRequest req){
        req.addParameter("xp", "rules!");
        
    }
    public void testSessionMapper(){
        Map map = SessionMapper.mapRequestToSession(request);
        String val = (String)session.getAttribute("xp");        
        assertEquals("rules!", val);
        val = (String)map.get("xp");
        assertEquals("rules!", val);
    }
    
   public static TestSuite suite(){
        TestSuite suite = new TestSuite(MapperTest.class);
        return suite;
    }
    
    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }
}
