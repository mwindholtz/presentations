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

public class QuickSort implements SortingStrategy {

  public int[] sort(int array[]) {

    int n = array.length;
    a = new int[n];
    System.arraycopy(array, 0, a, 0, n);

    long lStart = System.currentTimeMillis();

    sort(a, 0, a.length - 1);

    System.out.println("QuickSort performed. " + lStart + " " + System.currentTimeMillis());

    long lDiff = System.currentTimeMillis() - lStart;

    System.out.println("QuickSort time for array of length " + n + " is: " + lDiff + " ms.");
    this.pause();
    return a;

  }

  private void sort(int a[], int lo0, int hi0) {
    int lo = lo0;
    int hi = hi0;
    if (lo >= hi) {
      return;
    } else if (lo == hi - 1) {
/*
             *  sort a two element list by swapping if necessary
             */
      if (a[lo] > a[hi]) {
        int T = a[lo];
        a[lo] = a[hi];
        a[hi] = T;
      }
      return;
    }


    /*
     *  Pick a pivot and move it out of the way
     */
    int pivot = a[(lo + hi) / 2];
    a[(lo + hi) / 2] = a[hi];
    a[hi] = pivot;

    while (lo < hi) {
      /*
       *  Search forward from a[lo] until an element is found that
       *  is greater than the pivot or lo >= hi
       */
      while (a[lo] <= pivot && lo < hi) {
        lo++;
      }

      /*
       *  Search backward from a[hi] until element is found that
       *  is less than the pivot, or lo >= hi
       */
      while (pivot <= a[hi] && lo < hi) {
        hi--;
      }

      /*
       *  Swap elements a[lo] and a[hi]
       */
      if (lo < hi) {
        int T = a[lo];
        a[lo] = a[hi];
        a[hi] = T;

      }

    }

    /*
     *  Put the median in the "center" of the list
     */
    a[hi0] = a[hi];
    a[hi] = pivot;

    /*
     *  Recursive calls, elements a[lo0] to a[lo-1] are less than or
     *  equal to pivot, elements a[hi+1] to a[hi0] are greater than
     *  pivot.
     */
    sort(a, lo0, lo - 1);
    sort(a, hi + 1, hi0);
  }

  private void pause() {
    try {
      byte[] b = new byte[1];
      System.out.print("Press enter to continue");
      System.in.read(b);
    } catch (IOException iox) {
    }


  }

  private int[] a;
}
