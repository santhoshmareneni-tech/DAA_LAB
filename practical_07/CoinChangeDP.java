import java.util.Scanner;

public class CoinChangeDP {

    // Solves Making a Change Problem (Min Coins) using 2D DP
    public static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        int INF = 10000000; // Large value representing infinity
        int[][] dp = new int[n][amount + 1];

        // Base Case: Row 0 (only using coins[0])
        for (int j = 0; j <= amount; j++) {
            if (j == 0) {
                dp[0][j] = 0;
            } else if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = INF; // Cannot form amount j using only coins[0]
            }
        }

        // Fill remaining rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j]; // Exclude current coin
                } else {
                    // Min between excluding coin i and including coin i
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
                }
            }
        }

        // Display DP Table
        System.out.println("\n--- Coin Change DP Table (dp[i][amount]) ---");
        System.out.print("Coin \\ Amt\t");
        for (int j = 0; j <= amount; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(coins[i] + "\t\t");
            for (int j = 0; j <= amount; j++) {
                if (dp[i][j] >= INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dp[i][j] + "\t");
                }
            }
            System.out.println();
        }

        // If target amount cannot be formed
        if (dp[n - 1][amount] >= INF) {
            return -1;
        }

        // Backtrack to reconstruct selected coins
        printSelectedCoins(dp, coins, amount);

        return dp[n - 1][amount];
    }

    // Backtracks through DP table to identify denominations used
    public static void printSelectedCoins(int[][] dp, int[] coins, int amount) {
        int[] coinCount = new int[coins.length];
        int i = coins.length - 1;
        int rem = amount;

        while (rem > 0 && i >= 0) {
            if (i > 0 && dp[i][rem] == dp[i - 1][rem]) {
                i--; // Coin i was not used
            } else {
                coinCount[i]++;
                rem -= coins[i]; // Use coin i and stay on same row (unbounded)
            }
        }

        System.out.println("\n--- Optimal Coin Selection ---");
        for (int k = 0; k < coins.length; k++) {
            if (coinCount[k] > 0) {
                System.out.println("Denomination " + coins[k] + ": " + coinCount[k] + " coin(s)");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Making a Change Problem using Dynamic Programming ===");
        System.out.print("Enter number of distinct coin denominations: ");
        int n = sc.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter " + n + " coin denominations (in ascending order):");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter target amount: ");
        int amount = sc.nextInt();

        int result = minCoins(coins, amount);

        if (result == -1) {
            System.out.println("\nTarget amount " + amount + " cannot be formed with the given coins.");
        } else {
            System.out.println("\nMinimum coins required: " + result);
        }

        sc.close();
    }
}
