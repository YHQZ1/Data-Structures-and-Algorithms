import java.util.*;

public class KruskalsMST {

  static class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }

  static class DSU {
    int[] parent, rank;

    DSU(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++)
        parent[i] = i;
    }

    int find(int x) {
      if (parent[x] != x)
        parent[x] = find(parent[x]);
      return parent[x];
    }

    void union(int a, int b) {
      int ra = find(a), rb = find(b);
      if (ra != rb) {
        if (rank[ra] < rank[rb])
          parent[ra] = rb;
        else if (rank[ra] > rank[rb])
          parent[rb] = ra;
        else {
          parent[rb] = ra;
          rank[ra]++;
        }
      }
    }
  }

  static void kruskal(List<Edge> edges, int V) {
    Collections.sort(edges, Comparator.comparingInt(e -> e.w));
    DSU dsu = new DSU(V);
    int cost = 0;

    for (Edge e : edges) {
      if (dsu.find(e.u) != dsu.find(e.v)) {
        dsu.union(e.u, e.v);
        cost += e.w;
      }
    }

    System.out.println("Total cost of MST: " + cost);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int E = sc.nextInt();

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < E; i++)
      edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

    kruskal(edges, V);
    sc.close();
  }
}
