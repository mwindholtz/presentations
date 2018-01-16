package xptoolkit.cactus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;
import junit.framework.*;
import org.apache.commons.cactus.ServletTestCase;
import com.meterware.httpunit.*;
import java.net.HttpURLConnection;

public class HappyServletTest extends ServletTestCase {
    private HappyServlet servlet;
    
    public HappyServletTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(HappyServletTest.class);
        
        return suite;
    }
    
    public void setUp()throws Exception{
        servlet = new HappyServlet();
        servlet.init(config);   
    }
    
    /** Test of doGet method, of class xptoolkit.cactus.HappyServlet. */
    public void testDoGet()throws Exception{
        System.out.println("testDoGet");
        servlet.doGet(request, response);
    }
    
    public void endDoGet(HttpURLConnection conn)throws Exception{
        WebResponse resp = WebResponse.newResponse(conn);
        WebLink link = resp.getLinkWith("I'm so happy!");
        assertNotNull(link);
        System.out.println(resp.getText());
        org.w3c.dom.Node node= resp.getDOM();
    }
}
