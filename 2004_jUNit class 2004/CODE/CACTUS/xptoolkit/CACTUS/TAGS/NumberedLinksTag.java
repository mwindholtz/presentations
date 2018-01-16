/*
 * CountTag.java
 *
 * Created on August 8, 2001, 3:33 AM
 */

package xptoolkit.cactus.tags;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspTagException;
/**
 *
 * @author  nick
 * @version
 */
public class NumberedLinksTag extends javax.servlet.jsp.tagext.BodyTagSupport {
    private int timesToRepeat;
    private int count;
    public void doInitBody() throws JspTagException{
        String repeatStr = (String)pageContext.findAttribute("total");
        if(repeatStr==null){
            throw new JspTagException("No 'total' attribute found in any scope.");
        }
        timesToRepeat = Integer.parseInt(repeatStr);
        count =1;
    }
    
    public int doAfterBody()throws JspTagException{
        BodyContent c = getBodyContent();
        JspWriter previousWriter = c.getEnclosingWriter();
        try{
            previousWriter.println("<a href='/numbered_page.jsp?id="+count+"'>");
            c.writeOut(previousWriter);
            previousWriter.print("--"+count);
            previousWriter.println("</a>");
        }
        catch(java.io.IOException e){
            /*please do not imitate this... for example only.*/
            throw new JspTagException(""+e);
        }
        if(++count > timesToRepeat){
            return this.SKIP_BODY;
        }
        return this.EVAL_BODY_TAG;
    }
}
