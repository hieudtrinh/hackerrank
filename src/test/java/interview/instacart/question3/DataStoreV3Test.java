package interview.instacart.question3;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataStoreV3Test {

  @Test
  public void testTestGet() throws InterruptedException {
    DataStoreV3 solution = new DataStoreV3();
    long time1 = solution.set("foo", "bar1");
    Thread.sleep(1000); // wait 100ms for the time will be increase
    long time2 = solution.set("foo", "bar2");
    Thread.sleep(1000);
    long time3 = solution.set("foo", "bar3");

    assertEquals(solution.get("foo", time1), "bar1");
    assertEquals(solution.get("foo", time2), "bar2");
    assertEquals(solution.get("foo", time3), "bar3");
    assertEquals(solution.get("foo"), "bar3");

    assertEquals(solution.get("foo", time2 + 10L), "bar2");
  }
}
