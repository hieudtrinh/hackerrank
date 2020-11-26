package graphs.shortest_reach_in_a_graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestReachInAGraph_Java8 {
  static int[] shortestPath(int size, Map<Integer, Set<Integer>> g, int startId) {
    // 0 based
    int[] distances = new int[size];

    Arrays.fill(distances, -1);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startId);
    distances[startId] = 0;
    HashSet<Integer> visited = new HashSet<>();

    visited.add(startId);
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      if (g.get(node) != null) {
        for (int neighbor : g.get(node)) {
          if (!visited.contains(neighbor)) {
            queue.offer(neighbor);
            visited.add(neighbor);
            distances[neighbor] = distances[node] + 6;
          }
        }
      }
    }

    // expect to filter out the startId location.
    return distances;
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scanner = new Scanner(System.in);
    int queries = scanner.nextInt();

    for (int n = 0; n < queries; n++) {
      Map<Integer, Set<Integer>> g = new HashMap<>();
      int nodes = scanner.nextInt();
      int edges = scanner.nextInt();
      for (int i = 0; i < edges; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;
        g.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        g.computeIfAbsent(v, k -> new HashSet<>()).add(u);
      }

      // for (int i=0; i<nodes; i++) {
      //     g.computeIfAbsent(i, k->new HashSet<Integer>());
      // }

      int startNode = scanner.nextInt() - 1;
      int[] distances = shortestPath(nodes, g, startNode);
      for (int i = 0; i < distances.length; i++) {
        if (i != startNode) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
