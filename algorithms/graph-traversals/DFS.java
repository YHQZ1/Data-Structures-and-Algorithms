import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
  static class Edge {
    int source;
    int destination;

    public Edge(int src, int dest) {
      this.source = src;
      this.destination = dest;
    }
  }

  public static void create(ArrayList<Edge>[] graph, Scanner sc) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    System.out.print("Enter number of edges: ");
    int E = sc.nextInt();

    System.out.println("Enter each edge (source destination):");
    for (int i = 0; i < E; i++) {
      System.out.print("Edge " + (i + 1) + " - Source: ");
      int src = sc.nextInt();
      System.out.print("Edge " + (i + 1) + " - Destination: ");
      int dest = sc.nextInt();

      graph[src].add(new Edge(src, dest));
      graph[dest].add(new Edge(dest, src));
    }
  }

  public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
    System.out.print(curr + " ");
    visited[curr] = true;

    for (Edge e : graph[curr]) {
      if (!visited[e.destination]) {
        dfs(graph, e.destination, visited);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    ArrayList<Edge>[] graph = new ArrayList[V];
    create(graph, sc);

    System.out.print("\nEnter starting vertex for DFS: ");
    int start = sc.nextInt();

    boolean[] visited = new boolean[V];
    System.out.println("\nDFS Traversal starting from vertex " + start + ":");
    dfs(graph, start, visited);

    sc.close();
  }
}
