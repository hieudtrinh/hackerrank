package arrays.left_rotation;

import common.PrintUtils;
import org.testng.annotations.Test;

public class LeftRotationTest {

  @Test
  public void testRotLeft() {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    LeftRotation solution = new LeftRotation();
    PrintUtils.print(solution.rotLeft(a, 4));
    PrintUtils.print(solution.rotLeft(a2, a2.length));
  }
}
