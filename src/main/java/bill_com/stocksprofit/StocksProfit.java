package bill_com.stocksprofit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StocksProfit {
  /*
   * Complete the 'stockPairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY stocksProfit
   *  2. LONG_INTEGER target
   */

  public int stockPairs(List<Integer> stocksProfit, long target) {
    // Write your code here
    Set<Integer> set = new HashSet<>();
    Set<String> ans = new HashSet<>();
    int count = 0;
    for (int s : stocksProfit) {
      // System.out.println(s);
      if (s > target) continue;
      if (set.contains(s)) {

        int pre = (int) (target - s);
        int min = Math.min(s, pre);
        int max = Math.max(s, pre);
        String p = min + "-" + max;
        // System.out.println(p);
        count += ans.contains(p) ? 0 : 1;
        ans.add(p);
        set.remove(s);
      } else {
        set.add((int) target - s);
      }
    }
    return count;
    // return ans.size() / 2;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> stocksProfit =
        IntStream.range(0, stocksProfitCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    long target = Long.parseLong(bufferedReader.readLine().trim());

    int result = new StocksProfit().stockPairs(stocksProfit, target);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
