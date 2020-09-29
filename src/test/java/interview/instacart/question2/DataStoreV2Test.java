package interview.instacart.question2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataStoreV2Test {

  // Implement Key,Value data store class
  // set(key, value) return time at which set is called
  // get(key, time) return value or null where time is value from set()
  // get(key) return value of the last set()
  // For example:
  // kv.set("foo", "bar1") --> 1
  // kv.set("foo", "bar2") --> 2
  // kv.set("foo", "bar3") --> 2
  // kv.get("foo", 2) --> "bar2"
  // kv.get("foo") --> "bar3"

  @Test
  public void testTestGet() throws InterruptedException {
    DataStoreV2 solution = new DataStoreV2();
    long time1 = solution.set("foo", "bar1");
    Thread.sleep(100); // wait 100ms for the time will be increase
    long time2 = solution.set("foo", "bar2");
    Thread.sleep(100);
    long time3 = solution.set("foo", "bar3");

    assertEquals(solution.get("foo", time1), "bar1");
    assertEquals(solution.get("foo", time2), "bar2");
    assertEquals(solution.get("foo", time3), "bar3");
    assertEquals(solution.get("foo"), "bar3");
  }
}
