package xptoolkit.cactus.reference;
import org.apache.commons.cactus.*;
import org.apache.commons.cactus.util.*;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;
import junit.framework.*;

public class InsulterTest extends ServletTestCase{
  private InsultGenerator generator;
  private User user;
  
  public InsulterTest(String name){
      super(name);
  }
  /*
   * Methods are placed in the order of execution.
   */
  
  /*client side*/
  public void beginDemonize(ServletTestRequest request){
    request.addParameter("INSULT_STRENGTH", "5");      
  }
  
  /*server side*/
  public void setUp(){
    /*instantiate the User and put it into the session*/
    user = new User("TestUserName");
    user.setSelfEsteem(10);
    this.session.setAttribute("USER_KEY", user);
    
    /*instantiate the InsultGenerator*/
    generator = new InsultGenerator("pederast");  
  }
  
  /*server side*/
  public void testDemonize()throws Exception{
    /*call the method under test*/
    Insulter.demonize(this.request, this.response, this.generator);
    
    /*test that self esteem equals inital value minus insult strength*/
    assertEquals("self esteem correct", 5, user.getSelfEsteem());
  }
  
  /*server side*/
  public void tearDown(){
    generator = null;
  }
  
  /*client side*/
  public void endDemonize(HttpURLConnection conn) throws Exception{
      
      //assertTrue(user.isCrying());--would throw a NullPointerException,
      //                              because user was never instantiated 
      //                              on the client side.
      
      String clientResponse = AssertUtils.getResponseAsString(conn);
      
      assertTrue("insult strength in response",
                 clientResponse.indexOf("5") > -1);
      
      assertTrue("insult in response",
                 clientResponse.indexOf("pederast") > -1);
  }
  
    public static TestSuite suite(){
        TestSuite suite = new TestSuite(InsulterTestCase.class);
        return suite;
    }
    
    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }
}