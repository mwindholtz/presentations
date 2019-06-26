package trivera.core.patterns.composite;

/**
 * Our primitive class:  defines type digit
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
public class Digit extends Expression {

  // constructor sets the value of the digit
  public Digit(int d) {
    digit = d;
  }

  public void addRightChild(Expression component) {
  }

  public void addLeftChild(Expression component) {
  }

  // display the digit
  public void display() {
    System.out.print(digit);
    System.out.print(" ");
  }

  // holds the value of the digit
  private int digit;
}
