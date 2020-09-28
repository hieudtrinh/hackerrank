package warm_up.repeated_string;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RepeatedStringTest {

  @Test
  public void testRepeatedString() {
    String s = "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq";
    RepeatedString solution =  new RepeatedString();
    long ans = solution.repeatedString(s, 549382313570L);
    assertEquals(ans, 16481469408L);
  }
}