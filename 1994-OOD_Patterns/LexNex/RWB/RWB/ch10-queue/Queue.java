import java.util.ArrayList;

public class Queue {
    ArrayList delegate = new ArrayList();

    public Queue() {}
    public void addRear(String s) {delegate.add(s);}
    public int getSize() {return delegate.size();}

    public String removeFront() {
	String result = delegate.get(0).toString();
	delegate.remove(0);
	return result;
    }
}