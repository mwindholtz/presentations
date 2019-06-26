package xptoolkit.cactus.tags;

import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspTagException;
import junit.framework.*;
import org.apache.commons.cactus.JspTestCase;
import org.apache.commons.cactus.ServletTestRequest;
import org.apache.commons.cactus.util.AssertUtils;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebLink;

public class VarTest extends JspTestCase {

    public VarTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(VarTest.class);
        
        return suite;
    }
    
    public void testVarCreate() throws Exception{
        System.out.println("IT CAN'T BE!");
        System.out.println("No changE@!");
        pageContext.include("/var_create.jsp");      
    }

}
