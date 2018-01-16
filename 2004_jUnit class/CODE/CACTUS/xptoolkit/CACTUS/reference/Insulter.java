package xptoolkit.cactus.reference;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Class under test
public class Insulter{
  public static void demonize(HttpServletRequest request,
                       HttpServletResponse response,
                       InsultGenerator generator) throws java.io.IOException{

    HttpSession sess = request.getSession();
    User user = (User)sess.getAttribute("USER_KEY");
    if(user == null){
      throw new IllegalStateException("no user in session");
    }
    
    String strengthStr = request.getParameter("INSULT_STRENGTH");
    int strength = Integer.parseInt(strengthStr);
    user.setSelfEsteem(user.getSelfEsteem()-strength);
    
    generator.setStrength(strength);
    generator.printInsult(response.getWriter());
  } 
  
}

class User{
    public User(String name){
    }
    /** Holds value of property selfEsteem. */
    private int selfEsteem;
    
    /** Getter for property selfEsteem.
     * @return Value of property selfEsteem.
     */
    public int getSelfEsteem() {
        return selfEsteem;
    }
    
    /** Setter for property selfEsteem.
     * @param selfEsteem New value of property selfEsteem.
     */
    public void setSelfEsteem(int selfEsteem) {
        this.selfEsteem = selfEsteem;
    }
    
}