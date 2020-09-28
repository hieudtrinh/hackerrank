package arrays.new_year_chaos;

public class NewYearChaos {
  void minimumBribes(int[] q) {
    int sum = 0;
    for (int i = 0; i < q.length; i++) {
      int steps = q[i] - (i + 1);
      if (steps > 2) {
        System.out.println("Too chaotic");
        return;
      }
      // count number brides this current customer received
      // since we know that there were 3 or more brides, we
      // have deteced and return already
      for (int j = Math.max(0, q[i] - 2); j < i; j++) {
        // for each position that is off order, count it
        if (q[j] > q[i]) sum++;
      }
    }
    System.out.println(sum);
  }
}
