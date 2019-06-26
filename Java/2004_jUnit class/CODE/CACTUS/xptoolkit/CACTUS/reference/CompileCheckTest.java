/*
 * CompileCheckTest.java
 *
 * Created on August 8, 2001, 8:13 PM
 */

package src.xptoolkit.cactus.reference;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspWriter;
import java.util.*;
import org.apache.commons.cactus.*;
import org.apache.commons.cactus.util.*;
/**
 *
 * @author  nick
 * @version 
 */
public class CompileCheckTest extends JspTestCase{

    /** Creates new CompileCheckTest */
    public CompileCheckTest(String name) {
        super(name);
    }

    public void testPrintPageContext (){
      CustomJspDebugger.printPageContext(this.out, this.pageContext);
    }

    public void beginGoOnVisionQuest(ServletTestRequest request){
      //http://nationalparks.org/organ-pipe-monument/long_walk.do
      request.setURL("nationalparks.org",
                     "/organ-pipe-monument",
                     null,
                     "/long_walk.do",
                     null);

      /*multiple values for same key*/
      request.addParameter("SPIRIT_GUIDES", "Coyote");
      request.addParameter("SPIRIT_GUIDES", "Snake");

      request.addCookie("PREPARED", "true");

    }


    
    public void endSomeTestMethod(java.net.HttpURLConnection conn) throws Exception{
      /*cookie assertions*/
      Hashtable allCookies = AssertUtils.getCookies(conn);

      List chocolateChipCookies = (List)allCookies.get("C_CHIP");
      assertEquals("only one chocolate chip cookie set",
                    1, chocolateChipCookies.size());

      ClientCookie cookie = (ClientCookie)chocolateChipCookies.get(0);
      assertTrue(cookie.getMaxAge() < this.FRESHNESS_DATE);

      /*response assertions*/
      String allResponseText = AssertUtils.getResponseAsString(conn);
      assertTrue("contains descriptive text",
                  allResponseText.indexOf("Cookies 4 U") > -1);

      String[] allTextArray = AssertUtils.getResponseAsStringArray(conn);
      int last = allTextArray.length;
      assertTrue("html tag closed",
                  allTextArray[last].endsWith("</html>"));
    }  
    private int FRESHNESS_DATE = 1500;
    
    public static void main2(String[] args){
  
        /*bogus*/
        ServletTestCase test =
              new CompileCheckTest("testAccessTheImplicitObjects");

        test.run();//would yeild a NullPointerException trying to access one
             //of the fields
    }

}

class CustomJspDebugger{
    static void printPageContext(JspWriter out, PageContext pageCtx){}
}
