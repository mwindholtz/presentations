package trivera.core.patterns.bridge.implementor;

import trivera.core.patterns.bridge.abstraction.*;

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
public abstract class ErrorMessage {

  public static final String TYPE1ERRORMESSAGE = "type 1";
  public static final String TYPE2ERRORMESSAGE = "type 2";

  abstract public void displayErrorMessage(String msg);

  public void setErrorMessageType(String type) {
    if (type == TYPE1ERRORMESSAGE) {
      implementation = new Type1ErrorMessageImp();
    } else if (type == TYPE2ERRORMESSAGE) {
      implementation = new Type2ErrorMessageImp();
    } else {
      implementation = new DefaultErrorMessageImp();
    }
  }

  protected ErrorMessageImp implementation = new DefaultErrorMessageImp();
}
