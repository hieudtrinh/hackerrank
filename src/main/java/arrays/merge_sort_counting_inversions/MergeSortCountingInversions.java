package arrays.merge_sort_counting_inversions;

import java.util.Arrays;

public class MergeSortCountingInversions {
  public long merge(int[] arr, int[] left, int[] right) {
    int i = 0, j = 0;
    long count = 0;
    while (i < left.length || j < right.length) {
      if (i == left.length) {
        arr[i + j] = right[j++];
      } else if (j == right.length) {
        arr[i + j] = left[i++];
      } else if (left[i] <= right[j]) {
        arr[i + j] = left[i++];
      } else {
        arr[i + j] = right[j++];
        count += left.length - i;
      }
    }
    return count;
  }

  public long countInversions(int[] arr) {
    if (arr.length < 2) return 0L;
    int m = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, m);
    int[] right = Arrays.copyOfRange(arr, m, arr.length);
    return countInversions(left) + countInversions(right) + merge(arr, left, right);
  }
}
