import java.util.Scanner;

public class PrimMST {

    // Computes Minimum Spanning Tree using Prim's Greedy Algorithm
    public static void primMST(int[][] graph, int n) {
        boolean[] inMST = new boolean[n]; // Tracks vertices included in MST
        int[] key = new int[n];           // Minimum weight edge to each vertex
        int[] parent = new int[n];        // Array to store constructed MST

        // Initialize all keys as INFINITE
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex
        key[0] = 0;
        parent[0] = -1; // First node is always root of MST

        // The MST will have n vertices
        for (int count = 0; count < n - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet in MST
            int u = minKey(key, inMST, n);

            if (u == -1) {
                System.out.println("Graph is disconnected. Minimum Spanning Tree does not exist.");
                return;
            }

            // Add the picked vertex to the MST Set
            inMST[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < n; v++) {
                // graph[u][v] is non zero only for adjacent vertices of m
                // inMST[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph, n);
    }

    // A utility function to find the vertex with minimum key value, from
    // the set of vertices not yet included in MST
    private static int minKey(int[] key, boolean[] inMST, int n) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // A utility function to print the constructed MST and total cost
    private static void printMST(int[] parent, int[][] graph, int n) {
        System.out.println("\n--- Minimum Spanning Tree (Edges and Weights) ---");
        System.out.println("Edge \t\t Weight");
        System.out.println("------------------------");
        int totalCost = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t:\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("------------------------");
        System.out.println("Total Minimum Cost: " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Prim's Algorithm for Minimum Spanning Tree (MST) ===");
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter weighted adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST(graph, n);

        sc.close();
    }
}
