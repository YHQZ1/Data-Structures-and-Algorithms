import java.util.*;

public class PrimsMST {

  static class Edge {
    int to, weight;

    Edge(int t, int w) {
      to = t;
      weight = w;
    }
  }

  static void prim(List<Edge>[] graph) {
    int V = graph.length;
    boolean[] visited = new boolean[V];
    java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[1]));

    pq.add(new int[] { 0, 0 });
    int cost = 0;

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int u = curr[0];

      if (visited[u])
        continue;
      visited[u] = true;
      cost += curr[1];

      for (Edge e : graph[u])
        if (!visited[e.to])
          pq.add(new int[] { e.to, e.weight });
    }

    System.out.println("Total cost of MST: " + cost);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int E = sc.nextInt();

    List<Edge>[] graph = new ArrayList[V];
    for (int i = 0; i < V; i++)
      graph[i] = new ArrayList<>();

    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();
      graph[u].add(new Edge(v, w));
      graph[v].add(new Edge(u, w));
    }

    prim(graph);
    sc.close();
  }
}
