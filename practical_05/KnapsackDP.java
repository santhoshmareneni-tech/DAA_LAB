import java.util.Scanner;

public class KnapsackDP {

    // Solves 0/1 Knapsack using Bottom-Up Dynamic Programming
    public static int knapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // Maximum of including or excluding current item
                    int includeProfit = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    int excludeProfit = dp[i - 1][w];
                    dp[i][w] = Math.max(includeProfit, excludeProfit);
                } else {
                    // Weight of current item exceeds current capacity w
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the DP Matrix
        System.out.println("\n--- Dynamic Programming Table (DP[i][w]) ---");
        System.out.print("Item \\ W\t");
        for (int w = 0; w <= W; w++) {
            System.out.print(w + "\t");
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t\t");
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }

        // Backtrack to find selected items
        printSelectedItems(dp, values, weights, W);

        return dp[n][W];
    }

    // Backtracks through DP table to identify selected items
    public static void printSelectedItems(int[][] dp, int[] values, int[] weights, int W) {
        int n = values.length;
        int w = W;

        System.out.println("\n--- Selected Items in Optimal Solution ---");
        int totalWeight = 0;

        for (int i = n; i > 0 && w > 0; i--) {
            // If value came from dp[i-1][w], item i was NOT included
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " + i + " -> Weight: " + weights[i - 1] + ", Profit: " + values[i - 1]);
                totalWeight += weights[i - 1];
                w -= weights[i - 1]; // Reduce remaining capacity
            }
        }
        System.out.println("Total Weight of selected items: " + totalWeight + " / " + W);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 0/1 Knapsack Problem using Dynamic Programming ===");
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter profits/values of the " + n + " items:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.println("Enter weights of the " + n + " items:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter total capacity of knapsack (W): ");
        int W = sc.nextInt();

        int maxProfit = knapsack(values, weights, W);
        System.out.println("\nMaximum Profit achievable = " + maxProfit);

        sc.close();
    }
}
