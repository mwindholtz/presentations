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
// Test class for this file, Use concrete factories to instantiate objects
// Instantiate a new UnixLAF factory and use this factory to create a Button_UnixLAF

public class TestApplication {
  public static void main(String argv[]) {
    FactoryWinLAF factoryWinLAF = new FactoryWinLAF();
    FactoryMacLAF factoryMacLAF = new FactoryMacLAF();

    CreateObjects.create(factoryWinLAF);
    CreateObjects.create(factoryMacLAF);
  }
}