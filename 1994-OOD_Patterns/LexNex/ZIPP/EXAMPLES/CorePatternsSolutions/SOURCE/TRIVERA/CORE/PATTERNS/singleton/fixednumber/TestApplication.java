package trivera.core.patterns.singleton.fixednumber;


/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies.
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera Technologies.
 *
 * Copyright (c) 2003 Trivera Technologies.
 * </p>
 * @author Trivera Team
 * @version 2.0
 */
public class TestApplication {

  public static void main(String argv[]) {
    try {
      System.out.println("Creating a new Singleton...");
      Singleton a = new Singleton();
    } catch (TooManyObjectsException e) {
      System.out.println("TooManyObjectsException: " + e.getMessage());
    }
    try {
      System.out.println("Creating a new Singleton...");
      Singleton b = new Singleton();
    } catch (TooManyObjectsException e) {
      System.out.println("TooManyObjectsException: " + e.getMessage());
    }
    try {
      System.out.println("Set the maximum number of Singleton instances to 2....");
      Singleton.setMaxNumObjects(2);
      System.out.println("Creating a new Singleton...");
      Singleton c = new Singleton();
      System.out.println("Set the maximum number of Singleton instances to 1....");
      Singleton.setMaxNumObjects(1);
    } catch (SingletonException e) {
      System.out.println("SingletonException: " + e.getMessage());
    } catch (TooManyObjectsException e) {
      System.out.println("TooManyObjectsException: " + e.getMessage());
    }
  }
}
