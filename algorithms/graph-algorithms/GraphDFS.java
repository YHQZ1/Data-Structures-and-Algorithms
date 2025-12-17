import java.util.ArrayList;
import java.util.Scanner;

public class GraphDFS {

  static class Edge {
    int src;
    int dest;

    Edge(int s, int d) {
      src = s;
      dest = d;
    }
  }

  static void createGraph(ArrayList<Edge>[] graph, Scanner sc) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    System.out.print("Enter number of edges: ");
    int E = sc.nextInt();

    for (int i = 0; i < E; i++) {
      int src = sc.nextInt();
      int dest = sc.nextInt();

      if (src < 0 || src >= graph.length || dest < 0 || dest >= graph.length) {
        System.out.println("Invalid edge");
        i--;
        continue;
      }

      graph[src].add(new Edge(src, dest));
      graph[dest].add(new Edge(dest, src));
    }
  }

  static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
    visited[curr] = true;
    System.out.print(curr + " ");
    for (Edge e : graph[curr]) {
      if (!visited[e.dest]) {
        dfs(graph, e.dest, visited);
      }
    }
  }

  static void dfsTraversal(ArrayList<Edge>[] graph, int start) {
    if (start < 0 || start >= graph.length) {
      System.out.println("Invalid starting vertex");
      return;
    }
    boolean[] visited = new boolean[graph.length];
    dfs(graph, start, visited);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    if (V <= 0) {
      System.out.println("Invalid number of vertices");
      sc.close();
      return;
    }

    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph, sc);

    System.out.print("Enter starting vertex: ");
    int start = sc.nextInt();

    dfsTraversal(graph, start);
    sc.close();
  }
}
