package xptoolkit.cactus;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

public class MapperServlet extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException{
        
        
        Map paramMap =  SessionMapper.mapRequestToSession(request);
        PrintWriter writer = response.getWriter();
        
        Set mapEntries = paramMap.entrySet();
        Map.Entry e = null;
        for(Iterator iter = mapEntries.iterator(); iter.hasNext();){
            Map.Entry entry = (Map.Entry)iter.next();
            String entryStr = entry.getKey() + "=" + entry.getValue();
            if(useAllCaps()){
                entryStr = entryStr.toUpperCase();
            }
            writer.println(entryStr);
        }
    }
    
    public boolean useAllCaps(){
        String useAllCapsStr = getServletConfig().getInitParameter("ALL_CAPS");
        return useAllCapsStr.equalsIgnoreCase("true");
    }
}
