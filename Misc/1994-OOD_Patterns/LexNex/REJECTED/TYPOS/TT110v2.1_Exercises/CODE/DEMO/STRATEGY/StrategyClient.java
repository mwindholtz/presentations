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

import strategy.SortingContext;

import java.util.Random;

public class StrategyClient {

  public static void main(String[] args) {

    StrategyClient stc = new StrategyClient();
    stc.setContext();
    stc.generateUnsortedElements();
    System.out.println();
    stc.doSort();
  }

  private void doSort() {
    sortedArray = new int[ARRAYSIZE];

    // BubbleSort bs = new BubbleSort();
    // sortedArray = bs.sort(array);

    sortedArray = sContext.sortElements(unsortedArray);
    for (int i = 0; i < sortedArray.length; i++) {
//    System.out.print(sortedArray[i] + " ");
    }
  }

  private void setContext() {

    sContext = new SortingContext();
    sContext.setQuickSort();
  }


  private void generateUnsortedElements() {

    Random random = new Random();
    unsortedArray = new int[ARRAYSIZE];

    // Generate random ints and populate the unsortedArray

    for (int i = 0; i < unsortedArray.length; i++) {
      unsortedArray[i] = random.nextInt(10000);

//    System.out.print(unsortedArray[i] + " ");
    }
  } //End of generateUnsortedElements

// Private variables
  private static int ARRAYSIZE = 40000;
  private int[] unsortedArray, sortedArray;
  private SortingContext sContext;

} // End of class StrategyClient



