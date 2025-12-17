import java.util.Scanner;

public class AdjacencyMatrix {

	public static void printMatrix(int[][] matrix) {
		int V = matrix.length;
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void printNeighbors(int[][] matrix, int vertex) {
		int V = matrix.length;
		if (vertex < 0 || vertex >= V) {
			System.out.println("Invalid vertex");
			return;
		}
		System.out.print("Neighbors of vertex " + vertex + ": ");
		boolean found = false;
		for (int j = 0; j < V; j++) {
			if (matrix[vertex][j] != 0) {
				System.out.print("(" + j + ", w=" + matrix[vertex][j] + ") ");
				found = true;
			}
		}
		if (!found) {
			System.out.print("None");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices: ");
		int V = sc.nextInt();

		if (V <= 0) {
			System.out.println("Number of vertices must be positive");
			sc.close();
			return;
		}

		int[][] matrix = new int[V][V];

		System.out.println("Enter adjacency matrix values:");
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println("\nAdjacency Matrix:");
		printMatrix(matrix);

		System.out.print("\nEnter vertex to view neighbors: ");
		int vertex = sc.nextInt();
		printNeighbors(matrix, vertex);

		sc.close();
	}
}
