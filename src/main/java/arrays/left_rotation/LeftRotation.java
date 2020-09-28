package arrays.left_rotation;

public class LeftRotation {
  public int[] rotLeft(int[] a, int d) {
    // Intuitively: we shift left d's times
    //              Time complexity O(N * d)
    // Alternatively:
    // 1) reverse 0-d
    // 2) reverse d-a.length()
    // 3) reverse 0-a.length()
    if (a.length == d) return a;
    reverse(a, 0, d - 1);
    reverse(a, d, a.length - 1);
    reverse(a, 0, a.length - 1);
    return a;
  }

  private void reverse(int[] a, int start, int end) {
    while (start < end) {
      int tmp = a[start];
      a[start] = a[end];
      a[end] = tmp;
      start++;
      end--;
    }
  }
}
