package trivera.core.patterns.observer;

import java.util.*;

/**
 * ClassRoom event
 *
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies.
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera Technologies.
 *
 * Copyright (c) 2002 Trivera Technologies.
 * </p>
 * @author Tech Team
 * @version 1.0
 *
 *
 */

public class ClassRoomEvent extends EventObject {
  private int exerciseNo;

  /**
   * Constructor of ClassRoomEvent.
   * @param source     The EventSource
   * @param exerciseNo The ExerciseNumber to work on
   */
  public ClassRoomEvent(Object source, int exerciseNo) {
    super(source);
    this.exerciseNo = exerciseNo;
  }

  /**
   * Getter Method for the Exercise Number
   * @return Exercise Number
   */
  public int getExerciseNo() {
    return this.exerciseNo;
  }

}