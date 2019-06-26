package trivera.core.patterns.interpreter;


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
/**
 * Digit Expression
 * This Class presents the role of a
 * TerminalExpression in the interpreter pattern.
 */
public class Digit extends Expression {

  public Digit(int d) {
    digit = d;
  }

  public void addRightChild(Expression component) {
  }

  public void addLeftChild(Expression component) {
  }


  /**
   * Display the Expression of the Digit node
   */
  public void display() {
    // Display the Digits' number add add a space character for clear separation of
    // digits and operators
  }

  /**
   * Evaluate the Expression of the Digit node
   */
  public int evaluate() {
    // return the Digit's numerical value
    return 0;
  }

  private int digit;
}
