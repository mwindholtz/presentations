package xptoolkit.cactus.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import junit.framework.*;
import org.apache.commons.cactus.JspTestCase;
import org.apache.commons.cactus.ServletTestRequest;
import org.apache.commons.cactus.util.AssertUtils;
import java.net.HttpURLConnection;

public class ExampleTagTest extends JspTestCase {
    private ExampleTag tag;
    
    public ExampleTagTest(java.lang.String testName) {
        super(testName);
    }
    //
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(ExampleTagTest.class);
        
        return suite;
    }
    
    public void setUp(){
        tag = new ExampleTag();
        tag.setPageContext(this.pageContext);
        tag.setParent(null);
    }
    
    
    /** Test of doStartTag method, of class xptoolkit.ExampleTag. */
    public void testDoStartTag() {
        System.out.println("testDoStartTag");
        int result = tag.doStartTag();
        assertEquals(tag.SKIP_BODY, result);
    }
    
    public void endDoStartTag(HttpURLConnection conn) throws Exception{
        String response = AssertUtils.getResponseAsString(conn);
        boolean containsText = response.indexOf("simple tag") > -1;
        assert(containsText);
    }
}
