package warm_up.counting_valleys;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountingValleysTest {

  @Test
  public void testCountingValleys() {
    String path = "UDDDUDUU";
    int steps = 8;
    CountingValleys solution = new CountingValleys();
    assertEquals(solution.countingValleys(steps, path), 1);
  }
}
