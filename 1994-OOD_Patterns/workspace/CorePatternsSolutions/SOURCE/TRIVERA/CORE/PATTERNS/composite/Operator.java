package trivera.core.patterns.composite;

/**
 * Our composite object
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
public class Operator extends Expression {

  // Constructor sets the type of the operator
  public Operator(OperatorType type) {
    operator = type;
  }

  // Methods to add children to the composite object
  public void addRightChild(Expression component) {
    rightChild = component;
  }

  public void addLeftChild(Expression component) {
    leftChild = component;
  }

  // display the leftchild first
  // the display the operator-representing character and finally
  // display right child
  // To resolve the operator use the helper class OperatorType
  public void display() {
  }

  // private data to keep track of children and operator type
  private OperatorType operator;
  private Expression leftChild;
  private Expression rightChild;
}