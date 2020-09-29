package interview.instacart.question3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DataStoreV3 {
    // Implement Key,Value data store class
    // set(key, value) return time at which set is called
    // get(key, time) return value or null where time is value from set()
    // get(key) return value of the last set()
    // For example:
    // kv.set("foo", "bar1") --> 1
    // kv.set("foo", "bar2") --> 3
    // kv.set("foo", "bar3") --> 5

    // Similar to the DataStoreV2 with additional fuzzy logic as follow
    //
    // kv.get("foo", 3) --> "bar2"
    // kv.get("foo", 4) since time=4 is not exit, it will return the floor of 4, which is time=3
    //                  as a result kv.get("foo", 4) --> "bar2"
    // kv.get("foo") --> "bar3"

    Map<String, String> datastore;
    Map<String, TreeSet<Long>> keyTime;

    public DataStoreV3() {
        datastore = new HashMap<>();
        keyTime = new HashMap<>();
    }

    public long set(String key, String value) {
        long time = System.currentTimeMillis();
        datastore.put(makeKey(key, time), value);
        keyTime.computeIfAbsent(key, f->new TreeSet<>()).add(time);
        return time;
    }

    public String get(String key, long time) {
        if (datastore.containsKey(makeKey(key, time)))
            return datastore.get(makeKey(key, time));

        if (!keyTime.containsKey(key))
            return null;

        Long ptime = keyTime.get(key).floor(time);
        if (ptime == null)
            return null;
        return datastore.get(makeKey(key, ptime));
    }

    public String get(String key) {
        if (!keyTime.containsKey(key))
            return null;
        long time = keyTime.get(key).last();
        return datastore.get(makeKey(key, time));
    }

    private String makeKey(String key, long time) {
        return key + time;
    }
}
