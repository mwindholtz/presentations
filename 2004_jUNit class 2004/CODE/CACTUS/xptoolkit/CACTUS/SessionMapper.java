/*
 * SessionMapper.java
 *
 * Created on August 1, 2001, 8:11 PM
 */

package xptoolkit.cactus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.IOException;

/**
 *
 * @author  nick
 * @version 
 */
public class SessionMapper {

    /** Maps all of the parameters in the request to Attributes of the session
     * associated with that request. Useful for setting session attributes quickly.
     * @param request The servlet request to map the parameters of
     */    
    public static Map mapRequestToSession(HttpServletRequest request){
        /*comment?*/
        HttpSession session = request.getSession();
        Map paramsMap = new HashMap();
        for(Enumeration e = request.getParameterNames(); e.hasMoreElements();){
            String paramName = (String)e.nextElement();
            String paramValue = request.getParameter(paramName);
            session.setAttribute(paramName, paramValue);
            paramsMap.put(paramName, paramValue);
        }
        return paramsMap;
    }
    
}
