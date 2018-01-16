package trivera.core.patterns.observer.person;

/**
 * Person
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

public class Person {
  private String firstName = "";
  private String lastName = "";

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Person)) {
      return false;
    }

    Person person = (Person) obj;

    if (person.getFirstName().equals(this.firstName) && person.getLastName().equals(this.lastName)) {
      return true;
    }

    return false;
  }


}