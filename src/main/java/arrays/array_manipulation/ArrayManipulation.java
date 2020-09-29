package arrays.array_manipulation;

public class ArrayManipulation {
  public long arrayManipulation(int n, int[][] queries) {
    int[] nums = new int[n];
    for (int[] q : queries) {
      int start = q[0];
      int end = q[1];
      nums[start-1] += q[2]; // because java has zero index base
      if (end < n) {
        nums[end] -= q[2];
      }
    }
    int max = Integer.MIN_VALUE;
    int tmp = 0;
    for (int i=0; i<n; i++) {
      tmp += nums[i];
      max = Math.max(max, tmp);
    }
    return max;
  }
}
