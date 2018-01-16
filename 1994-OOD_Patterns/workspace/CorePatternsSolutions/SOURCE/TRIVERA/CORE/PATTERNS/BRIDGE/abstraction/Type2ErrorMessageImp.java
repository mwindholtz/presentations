package trivera.core.patterns.bridge.abstraction;

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
public class Type2ErrorMessageImp extends ErrorMessageImp {

  public void display(String msg) {
    System.out.print("Oh no, you have the following error: ");
    System.out.println(msg);
  }
}
