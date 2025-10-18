import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
  static class Edge {
    int source;
    int destination;

    public Edge(int src, int dest) {
      this.source = src;
      this.destination = dest;
    }
  }

  public static void create(ArrayList<Edge>[] graph) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    System.out.println("Enter number of edges: ");
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
    sc.close();
  }

  public static void bfs(ArrayList<Edge>[] graph, int start, int V) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[V];

    q.add(start);

    System.out.println("\nBFS Traversal starting from vertex " + start + ":");
    while (!q.isEmpty()) {
      int curr = q.remove();
      if (!visited[curr]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (Edge e : graph[curr]) {
          if (!visited[e.destination]) {
            q.add(e.destination);
          }
        }
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    ArrayList<Edge>[] graph = new ArrayList[V];
    create(graph);

    System.out.print("\nEnter starting vertex for BFS: ");
    int start = sc.nextInt();

    bfs(graph, start, V);

    sc.close();
  }
}
