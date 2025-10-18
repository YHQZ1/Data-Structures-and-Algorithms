import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
	static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int s, int d, int w) {
			this.source = s;
			this.destination = d;
			this.weight = w;
		}
	}

	public static void create(ArrayList<Edge>[] graph) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		System.out.println("Creating a weighted undirected graph...");
		System.out.println("Type 'x' to stop adding edges for a source vertex.\n");

		for (int src = 0; src < graph.length; src++) {
			System.out.println("Enter edges for source vertex " + src + ":");

			while (true) {
				System.out.print("Enter destination vertex (or 'x' to stop): ");
				String input = sc.next();
				if (input.equalsIgnoreCase("x"))
					break;

				int dest;
				try {
					dest = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Enter an integer vertex or 'x'.");
					continue;
				}

				System.out.print("Enter weight of edge from " + src + " to " + dest + ": ");
				int weight;
				try {
					weight = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid weight. Try again.");
					sc.nextLine();
					continue;
				}

				graph[src].add(new Edge(src, dest, weight));
			}
		}
		sc.close();
	}

	public static void printGraph(ArrayList<Edge>[] graph) {
		System.out.println("\nAdjacency List:");
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " -> ");
			for (Edge e : graph[i]) {
				System.out.print("(" + e.destination + ", w=" + e.weight + ") ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices: ");
		int V = sc.nextInt();

		ArrayList<Edge>[] graph = new ArrayList[V];
		create(graph);
		printGraph(graph);

		System.out.print("\nNeighbors of vertex 2: ");
		for (Edge e : graph[2]) {
			System.out.print("(" + e.destination + ", w=" + e.weight + ") ");
		}

		sc.close();
	}
}
