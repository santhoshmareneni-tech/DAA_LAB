import java.util.Scanner;

class Kruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int a[][] = new int[n][n];

        System.out.println("Enter weighted adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        int edges[][] = new int[n * n][3];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] != 0) {
                    edges[k][0] = i;
                    edges[k][1] = j;
                    edges[k][2] = a[i][j];
                    k++;
                }
            }
        }

        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if (edges[j][2] > edges[j + 1][2]) {
                    for (int t = 0; t < 3; t++) {
                        int temp = edges[j][t];
                        edges[j][t] = edges[j + 1][t];
                        edges[j + 1][t] = temp;
                    }
                }
            }
        }

        int parent[] = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int cost = 0, count = 0;

        for (int i = 0; i < k && count < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int x = u, y = v;

            while (parent[x] != x)
                x = parent[x];

            while (parent[y] != y)
                y = parent[y];

            if (x != y) {
                System.out.println(u + " - " + v + " : " + edges[i][2]);
                parent[x] = y;
                cost += edges[i][2];
                count++;
            }
        }

        if (count != n - 1)
            System.out.println("Graph is disconnected");
        else
            System.out.println("Minimum Cost: " + cost);
    }
}

// Enter number of vertices: 4
// Enter weighted adjacency matrix (0 for no edge):
// 0 10 6 5
// 10 0 0 15
// 6 0 0 4
// 5 15 4 0