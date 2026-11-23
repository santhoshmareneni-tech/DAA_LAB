
import java.util.*;

public class TSP {

    static int n, minCost = Integer.MAX_VALUE;
    static int cost[][];

    static void tsp(int curr, int count, int total, boolean visited[]) {

        if (count == n) {
            if (cost[curr][0] != 0) {
                minCost = Math.min(minCost, total + cost[curr][0]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i] && cost[curr][i] != 0) {

                visited[i] = true;

                tsp(i, count + 1, total + cost[curr][i], visited);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        boolean visited[] = new boolean[n];
        visited[0] = true;

        tsp(0, 1, 0, visited);

        if (minCost == Integer.MAX_VALUE)
            System.out.println("No possible tour");
        else
            System.out.println("Minimum Cost: " + minCost);

        sc.close();
    }
}
