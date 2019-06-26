package trivera.core.patterns.visitor.composite;

import trivera.core.patterns.visitor.visitors.ExpressionVisitor;

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
 * ConcreteElement class Digit
 * The method accept is implemented to accept a
 * visitor do to a job on the current instance
 */
public class Digit extends Expression {

  public Digit(int d) {
    digit = d;
  }

  public void addRightChild(Expression component) {
  }

  public void addLeftChild(Expression component) {
  }

  public int getDigit() {
    return digit;
  }

  /**
   * Implements the accept method of the Element Class Expression
   * @param visitor
   */
  public void accept(ExpressionVisitor visitor) {
    visitor.VisitDigit(this);
  }

  private int digit;
}
