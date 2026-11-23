import java.util.Scanner;

public class FloydWarshall {

    final static int INF = 99999; // Value representing infinity (no path)

    // Computes all-pairs shortest paths using Floyd-Warshall Algorithm
    public static void floydWarshall(int[][] dist, int n) {
        // k is the intermediate vertex
        for (int k = 0; k < n; k++) {
            // i is the source vertex
            for (int i = 0; i < n; i++) {
                // j is the destination vertex
                for (int j = 0; j < n; j++) {
                    // If vertex k is on the shortest path from i to j,
                    // then update the value of dist[i][j]
                    if (dist[i][k] != INF && dist[k][j] != INF && (dist[i][k] + dist[k][j] < dist[i][j])) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist, n);
    }

    // Utility function to print the solution matrix
    public static void printSolution(int[][] dist, int n) {
        System.out.println("\n--- All-Pairs Shortest Distance Matrix ---");
        System.out.print("\t");
        for (int j = 0; j < n; j++) {
            System.out.print("V" + j + "\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("V" + i + "\t");
            for (int j = 0; j < n; j++) {
                if (dist[i][j] >= INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Floyd-Warshall All-Pairs Shortest Path Algorithm ===");
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (-1 for no direct edge, 0 for self-loops):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                if (i != j && val == -1) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = val;
                }
            }
        }

        floydWarshall(graph, n);

        sc.close();
    }
}
