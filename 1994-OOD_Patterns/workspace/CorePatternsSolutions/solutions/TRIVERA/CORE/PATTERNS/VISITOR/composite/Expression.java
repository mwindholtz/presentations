package trivera.core.patterns.visitor.composite;

import trivera.core.patterns.visitor.visitors.ExpressionVisitor;

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

/**
 * Top node of the composite pattern that comprises the arithmetic expression
 * This node performs the Element role in the pattern
 * An method accept is added to accept any expression-visitor
 */
public abstract class Expression {
  abstract public void addRightChild(Expression component);

  abstract public void addLeftChild(Expression component);

  abstract public void accept(ExpressionVisitor visitor);
}

