package xptoolkit.cactus.reference;


public class InsultGenerator{
    private String base;
    
    public InsultGenerator(String base){
        this.base = base;
    }
    
    /** Holds value of property strength. */
    private int strength;    
    
    /** Setter for property strength.
     * @param strength New value of property strength.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }    
    
    public void printInsult(java.io.PrintWriter writer){
        writer.print("Strength:" + strength);
        writer.println("-" + base);
    }
}