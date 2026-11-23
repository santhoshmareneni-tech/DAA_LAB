
import java.util.*;

public class DFS {

    static void dfs(int v, int graph[][], boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < graph.length; i++) {

            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean visited[] = new boolean[n];

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        dfs(start, graph, visited);
    }
}
