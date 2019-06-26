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

public class Singleton {

  private static int numObjects = 0;    // current number of objects
  private static int maxNumObjects = 1;	// upper limit for the number of objects

  // code the Constructor:
  // If the number of current instances exceeds the maximum,
  // we cannot create another object of this class.
  // In this case throw a TooManyObjectsException(message")
  // with an appropriate content for the message
  // In the other case increment the number of currrent instances
  //
  public Singleton() throws TooManyObjectsException {
  }

  // Set a new upper limit of current objects
  // Make sure that new upper limit is positive and
  // is not less than the number of objects that currently exists
  // If these conditions are not met, throw a SingletonException("message") with an appropriate
  // content for the message
  //
  static public void setMaxNumObjects(int newMax) throws SingletonException {
  }

  /**
   * Return the upper limit of current objects
   */
  static public int getMaxNumObjects() {
    return maxNumObjects;
  }
}