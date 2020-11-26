package graphs.shortest_reach_in_a_graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShortestReachInAGraph {
  int size;
  Map<Integer, Set<Integer>> g;

  public ShortestReachInAGraph(int size) {
    this.size = size;
    g = new HashMap<>();
    for (int i = 0; i < size; i++) {
      g.put(i, new HashSet<>());
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();

    for (int t = 0; t < queries; t++) {

      // Create a graph of size n where each edge weight is 6:
      ShortestReachInAGraph graph = new ShortestReachInAGraph(scanner.nextInt());
      int m = scanner.nextInt();

      // read and set edges
      for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        // add each edge to the graph
        graph.addEdge(u, v);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt() - 1;
      int[] distances = graph.shortestReach(startId);

      for (int i = 0; i < distances.length; i++) {
        if (i != startId) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    scanner.close();
  }

  public void addEdge(int first, int second) {
    g.get(first).add(second);
    g.get(second).add(first);
  }

  public int[] shortestReach(int startId) { // 1 indexed
    int[] distances = new int[size + 1];
    Arrays.fill(distances, -1);
    distances[startId] = 0;
    HashSet<Integer> seen = new HashSet<>();
    LinkedList<Integer> queue = new LinkedList<>();
    seen.add(startId);
    queue.offer(startId);
    while (!queue.isEmpty()) {
      Integer cnode = queue.poll();
      for (int node : g.get(cnode)) {
        if (!seen.contains(node)) {
          queue.offer(node);
          seen.add(node);
          distances[node] = distances[cnode] + 6;
        }
      }
    }

    // filter out the startId node
    int[] ans = new int[size];
    int idx = 0;
    for (int i = 1; i < distances.length; i++) {
      if (i != startId) {
        ans[idx++] = distances[i];
      }
    }
    return ans;
  }
}
