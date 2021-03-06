package graphs.find_the_nearest_clone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class FindTheNearestClone {
  // Complete the findShortest function below.

  private static final Scanner scanner = new Scanner(System.in);

  /*
   * For the unweighted graph, <name>:
   *
   * 1. The number of nodes is <name>Nodes.
   * 2. The number of edges is <name>Edges.
   * 3. An edge exists between <name>From[i] to <name>To[i].
   *
   */
  static int findShortest(int graphEdges, int[] graphFrom, int[] graphTo, long[] ids, int color) {
    // solve here
    // UDAG - vertex -> vertices
    Map<Integer, Set<Integer>> g = new HashMap<>();

    // set of vertices of color
    Set<Integer> vertice = new HashSet<>();

    for (int i = 0; i < graphEdges; i++) {
      int from = graphFrom[i];
      int to = graphTo[i];
      g.computeIfAbsent(from, k -> new HashSet<>()).add(to);
      g.computeIfAbsent(to, k -> new HashSet<>()).add(from);
    }

    // 1<= id <= xxx
    // ids[] color id for vertex id starting from 1, where ids[] start from 0
    // i+1 = vertex's ID
    for (int i = 0; i < ids.length; i++) {
      if ((int) ids[i] == color) {
        vertice.add(i + 1);
      }
    }

    if (vertice.size() < 2) {
      return -1;
    }

    int shortestPath = ids.length;
    for (Integer vertex : vertice) {
      int curPath = findPath(vertex, ids, color, g);
      shortestPath = Math.min(shortestPath, curPath);
    }
    return shortestPath;
  }

  static int findPath(Integer fromVertex, long[] ids, int color, Map<Integer, Set<Integer>> g) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(fromVertex);
    int paths = -1;
    Set<Integer> visited = new HashSet<>();
    visited.add(fromVertex);
    while (!queue.isEmpty()) {
      int size = queue.size();
      paths++;
      for (int i = 0; i < size; i++) {
        Integer vertex = queue.poll();
        // ids[] based 0 but vertex based 1, so need to -1
        if (!fromVertex.equals(vertex) && color == ids[vertex-1]) {
          return paths;
        }

        for (Integer neighbor : g.get(vertex)) {
          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            visited.add(neighbor);
          }
        }
      }
    }
    return ids.length;
  }

  public static void main(String[] args) { // throws IOException {
//    BufferedWriter bufferedWriter =
//        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
/*
    5 4
    1 2
    1 3
    2 4
    3 5
    1 2 3 3 2
    2

          */
    String[] graphNodesEdges = scanner.nextLine().trim().split(" ");
    int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
    int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

    int[] graphFrom = new int[graphEdges];
    int[] graphTo = new int[graphEdges];

    for (int i = 0; i < graphEdges; i++) {
      String[] graphFromTo = scanner.nextLine().trim().split(" ");
      graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
      graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
    }

    long[] ids = new long[graphNodes];

    String[] idsItems = scanner.nextLine().trim().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < graphNodes; i++) {
      long idsItem = Long.parseLong(idsItems[i].trim());
      ids[i] = idsItem;
    }

    int val = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int ans = findShortest(graphEdges, graphFrom, graphTo, ids, val);

    System.out.println(ans);
//    bufferedWriter.write(String.valueOf(ans));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();

    scanner.close();
  }
}
