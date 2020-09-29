package arrays.minimum_swaps_two;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinimumSwapsTwoTest {

  @Test
  public void testMinimumSwaps() {
    int[] arr = {7, 1, 3, 2, 4, 5, 6};
    int ans = 5;
    MinimumSwapsTwo solution = new MinimumSwapsTwo();
    assertEquals(solution.minimumSwaps(arr), ans);
  }
}
