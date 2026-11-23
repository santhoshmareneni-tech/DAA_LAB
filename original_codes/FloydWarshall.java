
import java.util.*;

public class FloydWarshall {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix (-1 for no edge):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();

                if (x == -1)
                    graph[i][j] = Integer.MAX_VALUE;
                else
                    graph[i][j] = x;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (graph[i][k] != Integer.MAX_VALUE &&
                        graph[k][j] != Integer.MAX_VALUE) {

                        graph[i][j] = Math.min(
                            graph[i][j],
                            graph[i][k] + graph[k][j]
                        );
                    }
                }
            }
        }

        System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
