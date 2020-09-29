package interview.instacart.question1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class DataStoreV1Test {

  @Test
  public void testSetAndGet() {
    DataStoreV1 dataStore = new DataStoreV1();
    dataStore.set("foo", "bar");
    assertEquals(dataStore.get("foo"), "bar");
    assertNull(dataStore.get("something"));
  }
}
