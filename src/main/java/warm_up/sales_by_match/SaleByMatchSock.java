package warm_up.sales_by_match;

import java.util.HashMap;
import java.util.Map;

public class SaleByMatchSock {
  int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> map = new HashMap<>();
    int pairs = 0;
    for (int i = 0; i < n; i++) {
      map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
      if (map.get(ar[i]) % 2 == 0) pairs += 1;
    }
    return pairs;
  }
}
