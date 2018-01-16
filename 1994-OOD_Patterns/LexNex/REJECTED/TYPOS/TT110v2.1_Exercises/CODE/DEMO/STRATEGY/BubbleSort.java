package strategy;

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

import java.io.*;

public class BubbleSort implements SortingStrategy {
  private int[] array;

  public int[] sort(int a[]) {

    long lStart = System.currentTimeMillis();

    array = this.doSort(a);

    System.out.println("BubbleSort performed. " + lStart + " " + System.currentTimeMillis());

    long lDiff = System.currentTimeMillis() - lStart;

    System.out.println("BubbleSort time for array of length " + a.length + " is: " + lDiff + " ms.");
    this.pause();
    return array;
  }

  public int[] doSort(int a[]) {

    for (int i = a.length; --i >= 0;) {
      boolean flipped = false;

      for (int j = 0; j < i; j++) {

        if (a[j] > a[j + 1]) {
          int T = a[j];
          a[j] = a[j + 1];
          a[j + 1] = T;
          flipped = true;
        }
      }
      if (!flipped) {
        return a;
      }
    } // End of for (int i = a.length; --i>=0; )
    return a;
  } // End of sort (int a[])

  private void pause() {
    try {
      byte[] b = new byte[1];
      System.out.print("Press enter to continue");
      System.in.read(b);
    } catch (IOException iox) {
    }
  }
}


