package xptoolkit.cactus.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;


public class ExampleTag extends BodyTagSupport {
    
    /** Holds value of property showBody. */
    private String showBody;
    
  public int doStartTag() {
    try {
      JspWriter out = pageContext.getOut();
      out.print("simple tag");
    } catch(IOException ioe) {
      throw new RuntimeException(ioe.toString());
    }
    return(SKIP_BODY);
  }
}
