package xptoolkit.cactus;
import java.net.HttpURLConnection;
import org.apache.commons.cactus.*;
import org.apache.commons.cactus.util.AssertUtils;
import junit.framework.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

public class MapperServletTest extends ServletTestCase{

    private MapperServlet servlet;
    
    public MapperServletTest(String name) {
        super(name);
    }

    public void beginDoGet(ServletTestRequest request){
        request.addParameter("foo","manchu");
    }

    public void setUp()throws Exception{
        this.config.setInitParameter("ALL_CAPS","true");
        servlet = new MapperServlet();
        servlet.init(config);
    }
    
    public void testDoGet() throws Exception{
        servlet.doGet(request, response);
        String value = (String)session.getAttribute("foo");
        assertEquals("request param mapped into session", "manchu", value);
    }
    
    public void tearDown(){
        /*no significant server resources to release*/
    }
    
    public void testUseAllCaps(){
        assertTrue("servlet set to use all caps",servlet.useAllCaps());
    }
    
    public void endDoGet(HttpURLConnection conn) throws Exception{
        String responseString = AssertUtils.getResponseAsString(conn);
        boolean paramInResponse = responseString.indexOf("FOO=MANCHU") > -1;
        assertTrue("param not found in response", paramInResponse);
    }
    
    
    public static TestSuite suite(){
        TestSuite suite = new TestSuite(MapperServletTest.class);
        return suite;
    }
    
    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }
}