import java.util.*;

public class Dijkstra {

  static class Edge {
    int to, weight;

    Edge(int t, int w) {
      to = t;
      weight = w;
    }
  }

  static void dijkstra(List<Edge>[] graph, int src) {
    int n = graph.length;
    int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[1]));
    pq.add(new int[] { src, 0 });

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int u = curr[0];

      for (Edge e : graph[u]) {
        if (dist[u] + e.weight < dist[e.to]) {
          dist[e.to] = dist[u] + e.weight;
          pq.add(new int[] { e.to, dist[e.to] });
        }
      }
    }

    System.out.println("Shortest distances from source:");
    for (int i = 0; i < n; i++)
      System.out.println(src + " -> " + i + " = " + dist[i]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    List<Edge>[] graph = new ArrayList[V];
    for (int i = 0; i < V; i++)
      graph[i] = new ArrayList<>();

    System.out.print("Enter number of edges: ");
    int E = sc.nextInt();

    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();
      graph[u].add(new Edge(v, w));
      graph[v].add(new Edge(u, w));
    }

    System.out.print("Enter source vertex: ");
    int src = sc.nextInt();

    dijkstra(graph, src);
    sc.close();
  }
}
