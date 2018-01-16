/*
 * RedirectorTest.java
 *
 * Created on August 12, 2001, 9:09 PM
 */

package xptoolkit.cactus;
import com.meterware.httpunit.*;

/**
 *
 * @author  nick
 * @version 
 */
public class RedirectorTest {

    /** Creates new RedirectorTest */
    public RedirectorTest() {
    }

    public static void main(String[] args)throws Exception{
        WebConversation wc= new WebConversation();
        wc.getResponse("http://localhost/cactus-tests/redirector.jsp");
        System.out.println("Success!");
        
    }
}
