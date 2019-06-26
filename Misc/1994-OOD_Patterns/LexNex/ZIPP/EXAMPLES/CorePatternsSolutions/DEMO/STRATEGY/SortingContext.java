package strategy;

import strategy.BubbleSort;
import strategy.QuickSort;

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

public class SortingContext {


  public void setQuickSort() {
    currentSort = new QuickSort();
  }

  public void setBubbleSort() {
    currentSort = new BubbleSort();
  }

  public int[] sortElements(int array[]) {
    return currentSort.sort(array);
  }

  private SortingStrategy currentSort;

}// end of public class SortingContext
