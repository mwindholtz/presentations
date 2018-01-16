package trivera.core.patterns.observer;

import trivera.core.patterns.observer.person.Person;

/**
 * Student
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

//Implement the CallRoomListener Interface

public abstract class Student extends Person {

  private String startExercisePhrase = "I will start on exercise";

  public Student(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public String getStartExercisePhrase() {
    return startExercisePhrase;
  }

  //Implement the interface methods. Within the method printout the 'startExercisePrase', using the getStartExercisePhrase() method


}