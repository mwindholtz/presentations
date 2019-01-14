package trivera.core.patterns.proxy;

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

public class LookupService {
  public static final String CALCULATOR_SERVICE = "calculator";

  public static Object lookup(String name) throws ServiceNotFoundException {
    if (name.equals(CALCULATOR_SERVICE))
      return (Object) new CalcProxy();
    else
      throw new ServiceNotFoundException("unknown service; only service [" + CALCULATOR_SERVICE + "] is known");
  }
}