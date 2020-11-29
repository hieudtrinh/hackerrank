package sorting.bubble_sort;

import common.PrintUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BubbleSortTest {

  @Test
  public void testCountSwaps() {
    int[] a = new int[] { 4, 2, 3, 1 };
    BubbleSort bubbleSort = new BubbleSort();
    PrintUtils.print(a);
    bubbleSort.countSwaps(a);
    PrintUtils.print(a);
  }
}