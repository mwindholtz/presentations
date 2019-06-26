package trivera.core.patterns.observer;

import trivera.core.patterns.observer.person.Person;

/**
 * Trainer
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

public class Trainer extends Person implements java.io.Serializable {
  //Create a List to store the registered listeners


  public Trainer() {
    super("", "");
  }

  public Trainer(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public void saysStartExercise(int exerciseNo) {
    //Print out the Exercise number for which an Event is thrown


    //Instantiate a ClassRoomEvent


    //Notify all registered listeners


  }

  //Implement two methods which allow listeners to register and unregister

}