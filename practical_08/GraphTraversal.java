import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal {

    private int vertices;
    private int[][] adjMatrix;

    public GraphTraversal(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // Undirected graph
    }

    // Depth First Search
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    // Breadth First Search
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Graph Traversal (DFS and BFS) ===");
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        GraphTraversal graph = new GraphTraversal(n);

        System.out.println("Enter adjacency matrix (" + n + " x " + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph.adjMatrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting vertex (0 to " + (n - 1) + "): ");
        int start = sc.nextInt();

        graph.DFS(start);
        graph.BFS(start);

        sc.close();
    }
}
