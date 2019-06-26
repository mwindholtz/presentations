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

public class NumberedLinksTagTest extends JspTestCase {
    private BodyContent contentOfTag;
    private NumberedLinksTag tag;
    public NumberedLinksTagTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(NumberedLinksTagTest.class);
        
        return suite;
    }
    
    public void setUp(){
        request.setAttribute("total","3");
        tag =new NumberedLinksTag();
        tag.setPageContext(this.pageContext);
        contentOfTag = pageContext.pushBody();
        tag.setBodyContent(contentOfTag);
    }
    
    public void tearDown(){
        pageContext.popBody();
    }
    
    /** Test of doInitBody method, of class xptoolkit.cactus.tags.NumberedLinksTag. */
    public void testDoInitBody() throws Exception{
        request.removeAttribute("total");
        boolean noCatch =true;
        try{
            tag.doInitBody();
        }catch(JspTagException e){
            noCatch = false ;
        }
        if(noCatch){
            fail("should error if total attribute not in any scope");
        }
    }
    
    /** Test of doAfterBody method, of class xptoolkit.cactus.tags.NumberedLinksTag. */
    public void testDoAfterBody() throws Exception{
        System.out.println("testDoAfterBody");
        
        tag.doInitBody();
        int totalReps = 0;
        do{
            totalReps++;
            out.write("Content written here:");
        }
        while(tag.doAfterBody() == tag.EVAL_BODY_TAG);
        /*test number of repetitions*/
        assertEquals(3, totalReps);
        
    }
    
    public void endDoAfterBody(java.net.HttpURLConnection conn)throws Exception{
        WebResponse resp = WebResponse.newResponse(conn);
        WebLink[] links = resp.getLinks();
        assertEquals(3, links.length);
    }
}
