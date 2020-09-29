package interview.instacart.question1;

import java.util.HashMap;
import java.util.Map;

public class DataStoreV1 {
  // Implement Key,Value data store class
  // set(key, value)
  // get(key) return value or null is key not in the store

  Map<String, String> datastore;

  public DataStoreV1() {
    datastore = new HashMap<>();
  }

  public void set(String key, String value) {
    datastore.put(key, value);
  }

  public String get(String key) {
    return datastore.get(key);
  }
}
