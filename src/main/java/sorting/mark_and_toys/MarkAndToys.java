package sorting.mark_and_toys;

import java.util.Arrays;

public class MarkAndToys {
  int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int count = 0;
    int sum = 0;
    for (int price : prices) {
      sum += price;
      if (sum > k)
        return count;
      count++;
    }
    return count;
  }
}
