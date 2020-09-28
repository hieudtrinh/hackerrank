package arrays;

public class MaximumHourGlassSumInA2D {
  private int hcsum(int[][] a, int i, int j) {
    return a[i][j]
        + a[i][j + 1]
        + a[i][j + 2]
        + a[i + 1][j + 1]
        + a[i + 2][j]
        + a[i + 2][j + 1]
        + a[i + 2][j + 2];
  }

  public int hourglassSum(int[][] arr) {
    // there are 7 cells in the hour glass, so min can be 7*(-9)
    int max = -99;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int sum = hcsum(arr, i, j);
        max = Math.max(max, sum);
      }
    }
    return max;
  }
}
