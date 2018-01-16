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
 * ConcreteElement class Operator
 * The method accept is implemented to accept a
 * visitor do to a job on the current instance
 */
public class Operator extends Expression {

  public Operator(OperatorType type) {
    operator = type;
  }

  public void addRightChild(Expression component) {
    rightChild = component;
  }

  public void addLeftChild(Expression component) {
    leftChild = component;
  }

  public Expression getLeftChild() {
    return leftChild;
  }

  public Expression getRightChild() {
    return rightChild;
  }

  public OperatorType getOperator() {
    return operator;
  }

  /**
   * Implements the accept method of the Element Class Expression
   * @param visitor
   */
  public void accept(ExpressionVisitor visitor) {
    visitor.VisitOperator(this);
  }

  private OperatorType operator;
  private Expression leftChild;
  private Expression rightChild;
}
