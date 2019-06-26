package abstractfactory;


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
// Test class for this file, Use concrete factories to instantiate objects

public class TestApplication {
  public static void main(String argv[]) {
    FactoryStyle1 factoryStyle1 = new FactoryStyle1();
    FactoryStyle2 factoryStyle2 = new FactoryStyle2();
    FactoryStyle3 factoryStyle3 = new FactoryStyle3();

    CreateObjects.create(factoryStyle1);
    CreateObjects.create(factoryStyle2);
    CreateObjects.create(factoryStyle3);
  }
}
