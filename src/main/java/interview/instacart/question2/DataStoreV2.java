package interview.instacart.question2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DataStoreV2 {
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

  Map<String, String> datastore;
  Map<String, PriorityQueue<Long>> keyTime;

  public DataStoreV2() {
    datastore = new HashMap<>();
    keyTime = new HashMap<>();
  }

  public long set(String key, String value) {
    long time = System.currentTimeMillis();
    datastore.put(makeKey(key, time), value);
    keyTime.computeIfAbsent(key, f -> new PriorityQueue<>(Collections.reverseOrder())).add(time);
    return time;
  }

  public String get(String key, long time) {
    return datastore.get(makeKey(key, time));
  }

  public String get(String key) {
    if (!keyTime.containsKey(key) || keyTime.get(key) == null) {
      return null;
    } else {
      Long time = keyTime.get(key).peek();
      if (time == null)
        return null;
      return datastore.get(makeKey(key, time));
    }
  }

  private String makeKey(String key, long time) {
    return key + time;
  }
}
