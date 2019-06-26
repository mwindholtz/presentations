/*
 * ShowBodyTag.java
 *
 * Created on August 8, 2001, 1:41 AM
 */

package xptoolkit.cactus.tags;

/**
 *
 * @author  nick
 * @version 
 */
public class ShowBodyTag extends javax.servlet.jsp.tagext.TagSupport {

    /** Holds value of property condition. */
    private boolean condition;
    
   public int doStartTag() {
    if(condition==true){
        return this.EVAL_BODY_INCLUDE;
    }
    return(SKIP_BODY);
  }
  
  /** Getter for property condition.
   * @return Value of property condition.
   */
  public String getCondition() {
      return ""+condition;
  }  
  
  /** Setter for property condition.
   * @param condition New value of property condition.
   */
  public void setCondition(String condition) {
      this.condition = condition.equalsIgnoreCase("true");
  }  

}
