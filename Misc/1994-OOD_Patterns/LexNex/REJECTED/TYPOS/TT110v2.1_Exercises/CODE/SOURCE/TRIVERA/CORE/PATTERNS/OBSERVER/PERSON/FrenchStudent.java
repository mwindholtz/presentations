package trivera.core.patterns.observer.person;

import trivera.core.patterns.observer.Student;

/**
 * FrenchStudent
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
public class FrenchStudent extends Student {
  private String startExercisePhrase = "je veux commencer avec l'exercise";

  public FrenchStudent(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public String getStartExercisePhrase() {
    return startExercisePhrase;
  }
}