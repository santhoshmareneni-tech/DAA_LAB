
import java.util.*;

public class BFS {

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
        Queue<Integer> q = new LinkedList<>();

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        visited[start] = true;
        q.add(start);

        System.out.println("BFS Traversal:");

        while (!q.isEmpty()) {

            int v = q.poll();
            System.out.print(v + " ");

            for (int i = 0; i < n; i++) {

                if (graph[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        sc.close();
    }
}
