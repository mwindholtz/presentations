package xptoolkit.cactus.tags;

import junit.framework.*;
import org.apache.commons.cactus.JspTestCase;
public class ShowBodyTagTest extends JspTestCase {
    
    private ShowBodyTag tag;
    
    public ShowBodyTagTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(ShowBodyTagTest.class);
        
        return suite;
    }
    
    public void setUp(){
        tag = new ShowBodyTag();
    }
    
    /** Test of doStartTag method, of class src.xptoolkit.cactus.tags.ShowBodyTag. */
    public void testDoStartTag() {
        System.out.println("testDoStartTag");
        tag.setCondition("true");
        int startEval = tag.doStartTag();
        assertEquals(tag.EVAL_BODY_INCLUDE, startEval);
        
        tag.setCondition("not true");
        startEval = tag.doStartTag();
        assertEquals(tag.SKIP_BODY, startEval);
    }
    
    
}
