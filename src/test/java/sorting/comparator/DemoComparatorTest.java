package sorting.comparator;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoComparatorTest {

  @Test
  public void testCheker() {
    List<DemoComparator.Player> list =
        Arrays.asList(
            new DemoComparator.Player("amy", 100),
            new DemoComparator.Player("david", 100),
            new DemoComparator.Player("heraldo", 50),
            new DemoComparator.Player("aakansha", 75),
            new DemoComparator.Player("aleksa", 150));

    DemoComparator.Checker checker = new DemoComparator.Checker();
    list.sort(checker);

    for (DemoComparator.Player p : list) {
      System.out.println(p.toString());
    }
  }
}
