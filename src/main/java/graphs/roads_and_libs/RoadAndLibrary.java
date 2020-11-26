package graphs.roads_and_libs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RoadAndLibrary {
  private static final Scanner scanner = new Scanner(System.in);

  // Complete the roadsAndLibraries function below.
  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    if (c_lib < c_road) {
      // remember that this function returns long
      return (long) c_lib * n;
    }
    UnionFind uf = new UnionFind(n, c_road, c_lib);
    // asumming each two cities, we can make a road
    for (int[] road : cities) {
      uf.union(road[0], road[1]);
    }
    return uf.getCost();
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] nmC_libC_road = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nmC_libC_road[0]);

      int m = Integer.parseInt(nmC_libC_road[1]);

      int c_lib = Integer.parseInt(nmC_libC_road[2]);

      int c_road = Integer.parseInt(nmC_libC_road[3]);

      int[][] cities = new int[m][2];

      for (int i = 0; i < m; i++) {
        String[] citiesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int citiesItem = Integer.parseInt(citiesRowItems[j]);
          cities[i][j] = citiesItem;
        }
      }

      long result = roadsAndLibraries(n, c_lib, c_road, cities);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }

  static class UnionFind {
    int count;
    long roadCost;
    long libCost;
    int[] parents;
    Set<Integer> visisted = new HashSet<>();

    long totalCost = 0;

    public UnionFind(int count, long roadCost, long libCost) {
      this.count = count;
      this.roadCost = roadCost;
      this.libCost = libCost;
      parents = new int[count + 1];
      // init parents
      for (int i = 0; i <= count; i++) {
        parents[i] = i;
      }
    }

    public int find(int id) {
      while (parents[id] != id) {
        id = parents[id];
      }
      return id;
    }

    // make root1 (parent of id1) as parent
    public void union(int id1, int id2) {
      int root1 = find(id1);
      int root2 = find(id2);
      if (root1 != root2) {
        parents[root2] = root1;
        if (!visisted.contains(id1) && !visisted.contains(id2)) {
          this.totalCost += this.libCost;
        } else if (visisted.contains(id1) && visisted.contains(id2)) {
          this.totalCost -= this.libCost;
        }
        // visisted.add(id1);
        // visisted.add(id2);
        this.totalCost += this.roadCost;
      }

      visisted.add(id1);
      visisted.add(id2);
    }

    public long getCost() {
      // Some pair of cities does not have a road connected, so repairing
      // the road is not an option.
      // For those city have no road connected, it much has a library.
      // count - visisted.size() is equals to number of cities which has no
      // road connect.
      return totalCost + (count - visisted.size()) * libCost;
    }
  }
}
