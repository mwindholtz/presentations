/*
MWW

 * */
package junit.framework;

public class IdleTestError extends Exception {

	String fName;
	public IdleTestError(String name) {
		fName = name;
	}
}