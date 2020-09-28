package arrays.max_hour_glass_sum;

import arrays.max_hour_glass_sum.MaximumHourGlassSumInA2D;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumHourGlassSumInA2DTest {

  @Test
  public void testHourglassSum() {
    MaximumHourGlassSumInA2D solution = new MaximumHourGlassSumInA2D();
    int[][] arr = {
      {-9, -9, -9, 1, 1, 1},
      {0, -9, 0, 4, 3, 2},
      {-9, -9, -9, 1, 2, 3},
      {0, 0, 8, 6, 6, 0},
      {0, 0, 0, -2, 0, 0},
      {0, 0, 1, 2, 4, 0}
    };
    assertEquals(solution.hourglassSum(arr), 28);
  }
}
