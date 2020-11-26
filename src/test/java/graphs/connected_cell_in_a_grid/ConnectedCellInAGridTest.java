package graphs.connected_cell_in_a_grid;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectedCellInAGridTest {

  @Test
  public void testMaxRegion() {
    ConnectedCellInAGrid solution = new ConnectedCellInAGrid();
    int[][] grid =
        new int[][] {
          {1, 1, 0, 0},
          {0, 1, 1, 0},
          {0, 0, 1, 0},
          {1, 0, 0, 0}
        };

    int ans = 5;
    Assert.assertEquals(solution.maxRegion(grid), ans);
  }
}
