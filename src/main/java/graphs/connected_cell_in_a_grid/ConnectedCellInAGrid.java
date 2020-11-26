package graphs.connected_cell_in_a_grid;

import java.io.IOException;
import java.util.Scanner;

public class ConnectedCellInAGrid {
  private static final Scanner scanner = new Scanner(System.in);

  private int dfs(int[][] grid, boolean[][] seen, int r, int c) {
    if (r < 0
        || r >= grid.length
        || c < 0
        || c >= grid[0].length
        || seen[r][c]
        || grid[r][c] == 0) {
      return 0;
    }
    seen[r][c] = true;
    return (1
        + dfs(grid, seen, r, c + 1)
        + dfs(grid, seen, r + 1, c)
        + dfs(grid, seen, r, c - 1)
        + dfs(grid, seen, r - 1, c)
        + dfs(grid, seen, r + 1, c + 1)
        + dfs(grid, seen, r - 1, c - 1)
        + dfs(grid, seen, r + 1, c - 1)
        + dfs(grid, seen, r - 1, c + 1));
  }

  public static void main(String[] args) { // throws IOException {
    //    BufferedWriter bufferedWriter =
    //        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int m = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[][] grid = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] gridRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < m; j++) {
        int gridItem = Integer.parseInt(gridRowItems[j]);
        grid[i][j] = gridItem;
      }
    }
    ConnectedCellInAGrid solution = new ConnectedCellInAGrid();
    int res = solution.maxRegion(grid);

    //    bufferedWriter.write(String.valueOf(res));
    //    bufferedWriter.newLine();
    //
    //    bufferedWriter.close();

    System.out.println(res);
    scanner.close();
  }

  // Complete the maxRegion function below.
  public int maxRegion(int[][] grid) {
    int max = 0;
    boolean[][] seen = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // if (grid[i][j] == 0) continue;
        max = Math.max(max, dfs(grid, seen, i, j));
      }
    }
    return max;
  }
}
