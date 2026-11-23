import java.util.Scanner;

public class DFS {

    // Recursive helper function for Depth First Search
    private static void dfsHelper(int vertex, int[][] graph, boolean[] visited, int n) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (graph[vertex][neighbor] == 1 && !visited[neighbor]) {
                dfsHelper(neighbor, graph, visited, n);
            }
        }
    }

    // Depth First Search traversal starting from startVertex
    public static void dfs(int[][] graph, int startVertex, int n) {
        boolean[] visited = new boolean[n];
        System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
        dfsHelper(startVertex, graph, visited, n);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Depth First Search (DFS) ===");
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter adjacency matrix (" + n + " x " + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting vertex (0 to " + (n - 1) + "): ");
        int start = sc.nextInt();

        dfs(graph, start, n);

        sc.close();
    }
}
