package sorting.mark_and_toys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MarkAndToysTest {

  @Test
  public void testMaximumToys() {
    int k = 50;
    int ans = 4;
    int[] prices = new int[] {1, 12, 5, 111, 200, 1000, 10};
    MarkAndToys solution = new MarkAndToys();
    Assert.assertEquals(solution.maximumToys(prices, k), ans);
  }
}
