import java.util.Scanner;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] matrix = new int[V][V];

        System.out.println("Enter the adjacency matrix row by row (use 0 for no edge):");

        for (int i = 0; i < V; i++) {
            System.out.println("Enter weights for edges from vertex " + i + ":");
            for (int j = 0; j < V; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nNeighbors of vertex 2: ");
        for (int j = 0; j < V; j++) {
            if (matrix[2][j] != 0) {
                System.out.print("(" + j + ", w=" + matrix[2][j] + ") ");
            }
        }

        sc.close();
    }
}
