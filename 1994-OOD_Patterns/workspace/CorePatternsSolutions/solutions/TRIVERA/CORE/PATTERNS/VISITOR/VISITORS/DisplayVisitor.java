package trivera.core.patterns.visitor.visitors;

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
 * Displays an arithmetic expression
 */
public class DisplayVisitor extends ExpressionVisitor {

  /**
   * The DisplayVisitor visits a Digit:
   * @param d
   */
  public void VisitDigit(Digit d) {
    // Print the number of the Digit and print a space character to produce readable results
    System.out.print(d.getDigit());
    System.out.print(" ");
  }

  /**
   * The DisplayVisitor visits an Operator:
   * @param op
   */
  public void VisitOperator(Operator op) {
    // For an operator there is always a left child and a right child:
    // - Pass the visitor to the operators'left child
    // - Print the character that corresponds to the Operator type
    // - Pass the visitor to the operators' left child
    OperatorType operator = op.getOperator();
    (op.getLeftChild()).accept(this);
    if (operator == OperatorType.PLUS) {
      System.out.print(OperatorType.DISPLAY_PLUS);
    } else if (operator == OperatorType.MINUS) {
      System.out.print(OperatorType.DISPLAY_MINUS);
    } else if (operator == OperatorType.MULTIPLY) {
      System.out.print(OperatorType.DISPLAY_MULTIPLY);
    } else {
      System.out.print(OperatorType.DISPLAY_DIVIDE);
    }
    (op.getRightChild()).accept(this);
  }
}

