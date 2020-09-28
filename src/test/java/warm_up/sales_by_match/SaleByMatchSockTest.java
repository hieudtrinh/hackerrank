package warm_up.sales_by_match;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SaleByMatchSockTest {

  @Test
  public void testSockMerchant() {
    int[] socks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    SaleByMatchSock solution = new SaleByMatchSock();
    int n = 9;
    assertEquals(solution.sockMerchant(n, socks), 3);
  }
}
