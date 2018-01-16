package trivera.core.patterns.proxy;

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
public class CalcProxy implements Calculator {

  // Implement the add, substract and multiply methods
  // Since the RealSubject (implementation) CalcImpl is a Singleton,
  // you only need a local reference in your method;
  public double add(double a, double b) {
    CalcImpl c = CalcImpl.getInstance();
    return c.add(a, b);
  }

  public double subtract(double a, double b) {
    CalcImpl c = CalcImpl.getInstance();
    return c.subtract(a, b);
  }

  public double multiply(double a, double b) {
    CalcImpl c = CalcImpl.getInstance();
    return c.multiply(a, b);
  }
}
