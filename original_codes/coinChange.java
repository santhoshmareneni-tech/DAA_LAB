import java.util.*;

public class coinChange {

    static int[] selected;

    public static int minCoins(int coins[], int W) {
        int n = coins.length;
        int T[][] = new int[n][W + 1];
        selected = new int[n];

        // base case
        for (int j = 0; j <= W; j++) {
            if (j == 0) {
                T[0][j] = 0;
            } else if (j % coins[0] == 0) {
                T[0][j] = j / coins[0];
            } else {
                T[0][j] = W + 1;// when we cannot make the amount with the coin
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    T[i][j] = 0;
                } else if (j < coins[i]) {
                    T[i][j] = T[i - 1][j];//cpy above values
                } else {
                    T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - coins[i]]);
                }
            }
        }

        if (T[n - 1][W] <= W) {
            int i = n - 1;
            int amount = W;

            while (amount > 0 && i >= 0) {
                if (i > 0 && T[i][amount] == T[i - 1][amount]) {
                    i--;
                } else {
                    selected[i]++;
                    amount -= coins[i];
                }
            }
        }

        return (T[n - 1][W] > W) ? -1 : T[n - 1][W]; //last row last col 
    }

    public static void printSelectedCoins(int coins[]) {
        System.out.println("Selected denominations:");

        for (int i = 0; i < coins.length; i++) {
            if (selected[i] > 0) {
                System.out.println(coins[i] + " denomination: " + selected[i] + " coin");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();

        int coins[] = new int[n];
        System.out.println("Enter " + n + " coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter target amount: ");
        int W = sc.nextInt();

        int result = minCoins(coins, W);

        if (result == -1) {
            System.out.println("Amount cannot be formed with given coins");
        } else {
            System.out.println("Minimum number of coins: " + result);
            printSelectedCoins(coins);
        }

        
    }
}