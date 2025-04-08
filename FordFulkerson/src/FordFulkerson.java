
import java.util.*;

public class FordFulkerson {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of nodes: ");
    int numNodes = sc.nextInt();

    System.out.print("Enter the number of edges: ");
    int numEdges = sc.nextInt();

    int[][] graph = new int[numNodes][numNodes];

    for (int i = 0; i < numEdges; i++) {
      System.out.printf("Enter the source, destination, and capacity of edge %d: ", i + 1);
      int source = sc.nextInt();
      int dest = sc.nextInt();
      int capacity = sc.nextInt();
      graph[source][dest] = capacity;
    }

    System.out.print("Enter the source node: ");
    int source = sc.nextInt();

    System.out.print("Enter the sink node: ");
    int sink = sc.nextInt();

    int maxFlow = maxFlow(graph, source, sink);

    System.out.printf("The maximum flow from %d to %d is %d.\n", source, sink, maxFlow);
  }

  private static int maxFlow(int[][] graph, int source, int sink) {
    int numNodes = graph.length;

    int[][] residualGraph = graph;

    int[] parent = new int[numNodes];
    int maxFlow = 0;

    while (bfs(residualGraph, source, sink, parent)) {
      int pathFlow = Integer.MAX_VALUE;
      for (int v = sink; v != source; v = parent[v]) {
        int u = parent[v];
        pathFlow = Math.min(pathFlow, residualGraph[u][v]);
      }

      for (int v = sink; v != source; v = parent[v]) {
        int u = parent[v];
        residualGraph[u][v] -= pathFlow;
        residualGraph[v][u] += pathFlow;
      }

      maxFlow += pathFlow;
    }

    return maxFlow;
  }

  private static boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
    int numNodes = residualGraph.length;

    boolean[] visited = new boolean[numNodes];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(source);
    visited[source] = true;
    parent[source] = -1;

    while (!queue.isEmpty()) {
      int u = queue.poll();

      for (int v = 0; v < numNodes; v++) {
        if (!visited[v] && residualGraph[u][v] > 0) {
          queue.offer(v);
          visited[v] = true;
          parent[v] = u;
        }
      }
    }
    return visited[sink];
  }

}