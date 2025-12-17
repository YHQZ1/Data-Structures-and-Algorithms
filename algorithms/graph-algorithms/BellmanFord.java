import java.util.*;

public class BellmanFord {

  static class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }

  static void bellmanFord(List<Edge> edges, int V, int src) {
    int[] dist = new int[V];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int i = 1; i < V; i++) {
      for (Edge e : edges) {
        if (dist[e.u] != Integer.MAX_VALUE &&
            dist[e.u] + e.w < dist[e.v]) {
          dist[e.v] = dist[e.u] + e.w;
        }
      }
    }

    for (Edge e : edges) {
      if (dist[e.u] != Integer.MAX_VALUE &&
          dist[e.u] + e.w < dist[e.v]) {
        System.out.println("Negative weight cycle detected");
        return;
      }
    }

    System.out.println("Shortest distances from source:");
    for (int i = 0; i < V; i++)
      System.out.println(src + " -> " + i + " = " + dist[i]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter vertices and edges: ");
    int V = sc.nextInt();
    int E = sc.nextInt();

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < E; i++)
      edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

    System.out.print("Enter source vertex: ");
    int src = sc.nextInt();

    bellmanFord(edges, V, src);
    sc.close();
  }
}
