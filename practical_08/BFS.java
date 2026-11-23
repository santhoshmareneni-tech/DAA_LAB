import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    // Breadth First Search traversal using Queue
    public static void bfs(int[][] graph, int startVertex, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[current][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Breadth First Search (BFS) ===");
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

        bfs(graph, start, n);

        sc.close();
    }
}
