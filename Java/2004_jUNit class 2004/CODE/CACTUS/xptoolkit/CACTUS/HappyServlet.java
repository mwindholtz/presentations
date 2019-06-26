/*
 * HappyServlet.java
 *
 * Created on August 7, 2001, 8:05 PM
 */

package xptoolkit.cactus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author  nick
 * @version 
 */
public class HappyServlet extends javax.servlet.http.HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<a href='http://www.dextrose.com/pika.html'>");
        writer.println("I'm so happy!</a>");                     
    }
}
