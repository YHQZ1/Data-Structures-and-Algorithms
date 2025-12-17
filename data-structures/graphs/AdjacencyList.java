import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

	static class Edge {
		int src;
		int dest;
		int weight;

		Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}
	}

	static void createGraph(ArrayList<Edge>[] graph, Scanner sc) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int src = 0; src < graph.length; src++) {
			while (true) {
				System.out.print("Enter destination for " + src + " (or -1 to stop): ");
				int dest = sc.nextInt();
				if (dest == -1)
					break;

				if (dest < 0 || dest >= graph.length) {
					System.out.println("Invalid vertex");
					continue;
				}

				System.out.print("Enter weight: ");
				int weight = sc.nextInt();

				graph[src].add(new Edge(src, dest, weight));
				graph[dest].add(new Edge(dest, src, weight));
			}
		}
	}

	static void printGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " -> ");
			for (Edge e : graph[i]) {
				System.out.print("(" + e.dest + ", w=" + e.weight + ") ");
			}
			System.out.println();
		}
	}

	static void printNeighbors(ArrayList<Edge>[] graph, int vertex) {
		if (vertex < 0 || vertex >= graph.length) {
			System.out.println("Invalid vertex");
			return;
		}
		System.out.print("Neighbors of " + vertex + ": ");
		for (Edge e : graph[vertex]) {
			System.out.print("(" + e.dest + ", w=" + e.weight + ") ");
		}
		System.out.println();
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
		printGraph(graph);

		System.out.print("Enter vertex to view neighbors: ");
		int v = sc.nextInt();
		printNeighbors(graph, v);

		sc.close();
	}
}
