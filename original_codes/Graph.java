import java.util.*;
public class Graph {
    int n, a[][];
    boolean visited[];

    Graph(int n) {
        this.n = n;
        a = new int[n][n];
        visited = new boolean[n];
    }

    void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < n; i++) {
            if (a[v][i] == 1 && !visited[i])
                DFS(i);
        }
    }

    void BFS(int start) { //using the queue implemeting by arrays
        int q[] = new int[n];
        int front = 0, rear = 0;

        for (int i = 0; i < n; i++)
            visited[i] = false;

        visited[start] = true;
        q[rear++] = start;

        while (front < rear) {
            int v = q[front++];
            System.out.print(v + " ");

            for (int i = 0; i < n; i++) {
                if (a[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q[rear++] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        Graph g = new Graph(n);

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g.a[i][j] = sc.nextInt();

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.print("DFS: ");
        g.DFS(start);

        System.out.print("\nBFS: ");
        g.BFS(start);
    }
}