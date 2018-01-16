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
public class TestApplication {
  public static void main(String argv[]) {
    // build the following expression 3 + 4 - 5 + 6
    // The tree structure for this expression looks like this
    //				+
    //			   / \
    //            *   6
    //			 / \
    //          +   5
    //         / \
    //        3   4
    Digit digit3 = new Digit(3);
    Digit digit4 = new Digit(4);
    Digit digit5 = new Digit(5);
    Digit digit6 = new Digit(6);
    Operator firstPlus = new Operator(OperatorType.PLUS);
    Operator secondPlus = new Operator(OperatorType.PLUS);
    Operator multiply = new Operator(OperatorType.MULTIPLY);
    int result;

    // build the tree from the top

    // build children for the first plus sign
    firstPlus.addLeftChild(multiply);
    firstPlus.addRightChild(digit6);

    // build children for the minus sign
    multiply.addLeftChild(secondPlus);
    multiply.addRightChild(digit5);

    // build children for the second plus sign
    secondPlus.addLeftChild(digit3);
    secondPlus.addRightChild(digit4);

    System.out.print("Evaluate from left to right (neglecting the operand precedence):\n");
    // display the expression
    // Print a "= " after the expression display
    // Evaluate the result
    firstPlus.display();
    System.out.print("= ");
    result = firstPlus.evaluate();
    System.out.print(result + "\n");
  }
}

