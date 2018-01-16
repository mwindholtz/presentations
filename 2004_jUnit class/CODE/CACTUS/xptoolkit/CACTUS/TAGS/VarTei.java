/*
 * VarTei.java
 *
 * Created on August 12, 2001, 4:54 PM
 */

package xptoolkit.cactus.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.PageContext;
/**
 *
 * @author  nick
 * @version 
 */
public class VarTei extends javax.servlet.jsp.tagext.TagExtraInfo {

    /** Creates new VarTei */
    public VarTei() {
       
    }

    public VariableInfo[] getVariableInfo(TagData data){
        return new VariableInfo[]{
            new VariableInfo("varsss", "java.lang.String", true, PageContext.PAGE_SCOPE)
        };
    }
}
