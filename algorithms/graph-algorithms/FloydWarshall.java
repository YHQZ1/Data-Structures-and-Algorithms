import java.util.*;

public class FloydWarshall {

  static final int INF = 999999;

  static void floydWarshall(int[][] dist, int V) {
    for (int k = 0; k < V; k++)
      for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
          if (dist[i][k] + dist[k][j] < dist[i][j])
            dist[i][j] = dist[i][k] + dist[k][j];

    System.out.println("All-pairs shortest paths:");
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++)
        System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    int[][] graph = new int[V][V];
    for (int i = 0; i < V; i++)
      for (int j = 0; j < V; j++)
        graph[i][j] = sc.nextInt();

    floydWarshall(graph, V);
    sc.close();
  }
}
