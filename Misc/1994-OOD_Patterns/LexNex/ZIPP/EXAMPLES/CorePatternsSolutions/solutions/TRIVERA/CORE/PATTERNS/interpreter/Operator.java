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
 * Operator Expression
 * This Class presents the role of a
 * NonTerminalExpression in the interpreter pattern.
 */
public class Operator extends Expression {

  private OperatorType operator;
  private Expression leftChild;
  private Expression rightChild;

  public Operator(OperatorType type) {
    operator = type;
  }

  public void addRightChild(Expression component) {
    rightChild = component;
  }

  public void addLeftChild(Expression component) {
    leftChild = component;
  }

  /**
   * Display the Expression of the Operator node
   */
  public void display() {
    // Display the operator's left child
    // Display the operator
    // Display the operator's right child
    leftChild.display();
    if (operator == OperatorType.PLUS) {
      System.out.print(OperatorType.DISPLAY_PLUS);
    } else if (operator == OperatorType.MINUS) {
      System.out.print(OperatorType.DISPLAY_MINUS);
    } else if (operator == OperatorType.MULTIPLY) {
      System.out.print(OperatorType.DISPLAY_MULTIPLY);
    } else {
      System.out.print(OperatorType.DISPLAY_DIVIDE);
    }
    rightChild.display();
  }

  /**
   * Evaluate the Expression of the Operator node
   */
  public int evaluate() {
    // Calculate the value of the node by returning the evaluated expression
    // of the evaluated left child and the evaluated right child.
    // The arithmetic operation in the expression of these operands
    // is determined by the type of the operand
    if (operator == OperatorType.PLUS) {
      return (leftChild.evaluate() + rightChild.evaluate());
    } else if (operator == OperatorType.MINUS) {
      return (leftChild.evaluate() - rightChild.evaluate());
    } else if (operator == OperatorType.MULTIPLY) {
      return (leftChild.evaluate() * rightChild.evaluate());
    } else {
      return (leftChild.evaluate() / rightChild.evaluate());
    }
  }
}