package trivera.core.patterns.singleton.permanent;

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
public class Singleton {
  // The static instance singleton always exists and it is initialized at class load time
  // Code the requested statement for this;

  public void test() {
    System.out.println("Test method");
  }

  // Constructor of the Singleton class.
  // Since the constructor is private, no one outside of this class can
  private Singleton() {
    System.out.println("I am the unique instance of a Singleton. I am created at class load time");
  }
}