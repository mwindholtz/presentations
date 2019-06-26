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
public final class OperatorType {
  private OperatorType() {
  }

  public static final OperatorType PLUS = new OperatorType();
  public static final OperatorType MINUS = new OperatorType();
  public static final OperatorType MULTIPLY = new OperatorType();
  public static final OperatorType DIVIDE = new OperatorType();

  public static final String DISPLAY_PLUS=    "+ ";
  public static final String DISPLAY_MINUS=   "- ";
  public static final String DISPLAY_MULTIPLY= "* ";
  public static final String DISPLAY_DIVIDE=   "/ ";

}