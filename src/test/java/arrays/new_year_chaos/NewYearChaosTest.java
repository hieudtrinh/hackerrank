package arrays.new_year_chaos;

import org.testng.annotations.Test;

public class NewYearChaosTest {

  @Test
  public void testMinimumBribes() {
    // 2 1 5 3 4 -> 3
    // 2 5 1 3 4 -> Too chaotic
    int[] q1 = {2, 1, 5, 3, 4};
    int[] q2 = {2, 5, 1, 3, 4};
    NewYearChaos solution = new NewYearChaos();
    solution.minimumBribes(q1);
    solution.minimumBribes(q2);
  }
}
