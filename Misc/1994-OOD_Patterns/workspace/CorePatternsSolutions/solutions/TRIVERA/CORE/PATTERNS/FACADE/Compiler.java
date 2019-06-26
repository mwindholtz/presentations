package trivera.core.patterns.facade;

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

//

public class Compiler {

  // Use a Singleton pattern for the Compiler

  private Compiler() {
  }

  private static Compiler instance = null;

  public void doCompile() {
    //Implement the compiler:
    //Instantiate a scanner and a parser
    //and call subsequently their scan-method and parse-method
    Scanner scanner = new Scanner();
    Parser parser = new Parser();

    scanner.scan();
    parser.parse();
  }

  public static Compiler getInstance() {
    if (instance == null) {
      instance = new Compiler();
    }
    return instance;
  }

}

