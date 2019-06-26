/*
 * VarTag.java
 *
 * Created on August 12, 2001, 4:53 PM
 */

package xptoolkit.cactus.tags;

/**
 *
 * @author  nick
 * @version 
 */
public class VarTag extends javax.servlet.jsp.tagext.TagSupport {

    public int doStartTag(){
        pageContext.setAttribute("var", "foo");
        return this.EVAL_BODY_INCLUDE;
    }
}
