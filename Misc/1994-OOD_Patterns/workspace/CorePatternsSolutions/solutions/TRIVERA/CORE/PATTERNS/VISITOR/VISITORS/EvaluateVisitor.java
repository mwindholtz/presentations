package trivera.core.patterns.visitor.visitors;

import trivera.core.patterns.visitor.composite.Expression;
import trivera.core.patterns.visitor.composite.Digit;
import trivera.core.patterns.visitor.composite.Operator;
import trivera.core.patterns.visitor.composite.OperatorType;

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
 * Evaluates an arithmetic expression by calculating its result
 */
public class EvaluateVisitor extends ExpressionVisitor {

  /**
   * The intermediate claculation result during the expression evaluation
   * and the final result at the end of the evaluation
   */
  private int result;

  /**
   * when this visitor is created, the calculation result is set to 0.
   */
  public EvaluateVisitor() {
    result = 0;
  }

  /**
  * The EvaluateVisitor visits a Digit.
  * @param d
  */
  public void VisitDigit(Digit d) {
    // The intermediate result of the Digit evaluation is its encapsulated numeric value
    // Get this result
    result = d.getDigit();
  }

  /**
   * The EvaluateVisitor visits an Operator
   * @param op
   */
  public void VisitOperator(Operator op) {
    OperatorType operator = op.getOperator();
    int leftResult, rightResult;

    // For an operator there is always a left child and a right child:
    // -Get the left child (Expression) of the operator
    // -Get the right child (Expression) of the operator
    // - Pass the visitor to the operators'left child
    // - Assign the leftResult value to the result that is evaluated by the visitor's previous visit
    // - Pass the visitor to the operators'right child
    // - Assign the rightResult value to the result that is evaluated by the visitor's previous visit
    // - Calculate the final result of the the visitor for the argument Operator:
    //   Assign result to the outcome of the calculation  (leftResult <operator type> rightResult) where
    //   <operator type> is one of the four types you can find in the helper claas OperatorType,
    //   depending on the type of the argument operator

    Expression leftChild = op.getLeftChild();
    Expression rightChild = op.getRightChild();

    leftChild.accept(this);
    leftResult = result;

    rightChild.accept(this);
    rightResult = result;

    if (operator == OperatorType.PLUS) {
      result = leftResult + rightResult;
    } else if (operator == OperatorType.MINUS) {
      result = leftResult - rightResult;
    } else if (operator == OperatorType.MULTIPLY) {
      result = leftResult * rightResult;
    } else {
      result = leftResult / rightResult;
    }
  }

  public int getResult() {
    return result;
  }
}

