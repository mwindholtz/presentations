package trivera.core.patterns.observer;

import trivera.core.patterns.observer.person.*;
import trivera.core.patterns.observer.person.DutchStudent;
import trivera.core.patterns.observer.person.EnglishStudent;
import trivera.core.patterns.observer.person.GermanStudent;
import trivera.core.patterns.observer.person.FrenchStudent;

/**
 * The virtual ClassRoom
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

public class


    ClassRoom {


  public static void main(String[] args) {
    Trainer trainer = new Trainer("Raphael", "Parree");

    Student student1 = new DutchStudent("Jan", "de Vries");
    Student student2 = new EnglishStudent("Joe", "Smith");
    Student student3 = new GermanStudent("Heinrich", "Rott");
    Student student4 = new FrenchStudent("Pierre", "Casserole");
    Student student5 = new ItalianStudent("Mario", "Papi");
    Student student6 = new SpanishStudent("Victor", "Consalez");

    //Register All six student as Listener of the trainer


    //fire an event by invoking the 'saysStartExercise(int exerciseNumber)' method on the trainer object


    //Un-register two listeners


    //once again, fire a ClassRoomEvent

  }
}