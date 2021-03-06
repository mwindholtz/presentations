package trivera.core.patterns.singleton.fixednumber;

/**
 * Define a class for an exception that is thrown by the Singleton
 * class when you try to change an upper limit for objects to a
 * number that is too low
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
 *
 */

public class SingletonException extends Exception {
  public SingletonException(String message) {
    super(message);
  }
}
