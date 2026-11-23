import java.util.Scanner;

class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int a[][] = new int[n][n];
        boolean visited[] = new boolean[n];

        System.out.println("Enter weighted adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        visited[0] = true;
        int cost = 0, edges = 0;

        while (edges < n - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && a[i][j] != 0
                                && a[i][j] < min) {
                            min = a[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            if (v == -1) {
                System.out.println("Graph is disconnected");
                return;
            }

            visited[v] = true;
            System.out.println(u + " - " + v + " : " + min);
            cost += min;
            edges++;
        }

        System.out.println("Minimum Cost: " + cost);
    }
}