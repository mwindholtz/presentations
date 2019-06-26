package trivera.core.patterns.abstractfactory;

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
// Client part of the Abstract Factory Design Pattern

public class CreateObjects {
  public static void create(Factory factory) {
    // create an object for each product
    Button buttonA = factory.createButton();
  }
}
