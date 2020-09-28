package common;

import java.util.Arrays;

public class MatrixUtils {
  public static void print(int[][] matrix) {
    System.out.println(toString(matrix));
  }

  public static String toString(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int[] ints : matrix) {
      sb.append(Arrays.toString(ints)).append("\n");
    }
    return sb.toString();
  }
}
