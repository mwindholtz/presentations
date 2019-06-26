package trivera.core.patterns.visitor;

import trivera.core.patterns.visitor.composite.Digit;
import trivera.core.patterns.visitor.composite.Operator;
import trivera.core.patterns.visitor.composite.OperatorType;
import trivera.core.patterns.visitor.visitors.DisplayVisitor;
import trivera.core.patterns.visitor.visitors.EvaluateVisitor;

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
public class TestApplication {
  public static void main(String argv[]) {
    // build the following expression 3 + 4 * 5 + 6
    // The tree structure for this expression looks like this
    //          +
    //         / \
    //        *   6
    //       / \
    //      +   5
    //     / \
    //    3   4
    Digit digit3 = new Digit(3);
    Digit digit4 = new Digit(4);
    Digit digit5 = new Digit(5);
    Digit digit6 = new Digit(6);
    Operator firstPlus = new Operator(OperatorType.PLUS);
    Operator secondPlus = new Operator(OperatorType.PLUS);
    Operator multiply = new Operator(OperatorType.MULTIPLY);
    int result;
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    DisplayVisitor displayVisitor = new DisplayVisitor();

    // build the tree from the top

    // build children for the first plus sign
    firstPlus.addLeftChild(multiply);
    firstPlus.addRightChild(digit6);

    // build children for the multiply sign
    multiply.addLeftChild(secondPlus);
    multiply.addRightChild(digit5);

    // build children for the second plus sign
    secondPlus.addLeftChild(digit3);
    secondPlus.addRightChild(digit4);

    // display the whole expression
    System.out.print("Evaluate from left to right (neglecting the operand precedence):\n");


    // Accept the DisplayVisitor object to the top ConcreteElement firstPlus in the composite pattern
    // This visitor will do the job of dsplaying the arithmetic expression
    // Print a "= " after the expression display
    firstPlus.accept(displayVisitor);
    System.out.print("= ");

    // Accept the EvaluateVisitor object to the top ConcreteElement firstPlus in the composite pattern
    // This visitor will do the job of evaluating the arithmetic expression
    // Print a "= " after the expression display
    // Calculate the result of the expression
    firstPlus.accept(evaluateVisitor);

    // Get the calculation result from the EvaluateVisior object
    result = evaluateVisitor.getResult();
    System.out.print(result + "\n");
  }
}