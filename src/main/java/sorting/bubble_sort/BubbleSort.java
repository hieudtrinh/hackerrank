package sorting.bubble_sort;

import common.PrintUtils;

public class BubbleSort {
  void countSwaps(int[] a) {
    int numSwaps = 0;
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        // swap
        if (a[i] > a[j]) {
          int tmp = a[i];
          a[i] = a[j];
          a[j] = tmp;
          numSwaps++;
        }
      }
    }
    System.out.println(String.format("Array is sorted in %d swaps.", numSwaps));
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[a.length - 1]);
  }
}
