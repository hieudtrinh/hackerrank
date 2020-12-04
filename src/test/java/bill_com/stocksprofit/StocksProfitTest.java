package bill_com.stocksprofit;

import common.AVC3;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class StocksProfitTest {

  @Test
  public void testStockPairs() {
    List<AVC3<List<Integer>, Integer, Integer>> testdat =
        Arrays.asList(
            new AVC3(Arrays.asList(1, 3, 46, 1, 3, 9), 47, 1),
            new AVC3(Arrays.asList(6, 6, 3, 9, 3, 5, 1), 12, 2));
    StocksProfit solution = new StocksProfit();
    for (AVC3<List<Integer>, Integer, Integer> avc : testdat) {
      Assert.assertEquals(
          solution.stockPairs(avc.getAttr1(), avc.getAttr2().intValue()), avc.getAns().intValue());
    }
  }
}
