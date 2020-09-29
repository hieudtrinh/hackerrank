package arrays.minimum_swaps_two;

import common.PrintUtils;

public class MinimumSwapsTwo {
  int minimumSwaps(int[] arr) {
    int count = 0;
    PrintUtils.print(arr);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == i + 1) continue;

      swap(arr, i, arr[i] - 1);
      i--; // keep swapping until the position i is satisfied arr[i] == i + 1
      PrintUtils.print(arr);
      count++;
    }
    return count;
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
