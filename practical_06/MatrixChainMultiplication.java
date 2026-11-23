import java.util.Scanner;

public class MatrixChainMultiplication {

    static int[][] split; // Stores the split point k that achieves optimal cost

    // Computes the minimum multiplication cost using Dynamic Programming
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Number of matrices
        int[][] m = new int[n + 1][n + 1];
        split = new int[n + 1][n + 1];

        // Cost is 0 when multiplying one matrix: m[i, i] = 0
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        // L is the chain length (from 2 up to n)
        for (int L = 2; L <= n; L++) {
            for (int i = 1; i <= n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                // Try every possible split position k between i and j - 1
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        // Display Cost Table (M Table)
        System.out.println("\n--- Cost Matrix (M Table) ---");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    System.out.print("-\t");
                } else {
                    System.out.print(m[i][j] + "\t");
                }
            }
            System.out.println();
        }

        // Display Split Table (K Table)
        System.out.println("\n--- Split Matrix (K / S Table) ---");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j) {
                    System.out.print("-\t");
                } else {
                    System.out.print(split[i][j] + "\t");
                }
            }
            System.out.println();
        }

        return m[1][n];
    }

    // Recursive helper to reconstruct and print optimal parenthesization
    public static String printOptimalParenthesis(int i, int j) {
        if (i == j) {
            return "A" + i;
        }
        int k = split[i][j];
        return "(" + printOptimalParenthesis(i, k) + " x " + printOptimalParenthesis(k + 1, j) + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Matrix Chain Multiplication using Dynamic Programming ===");
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        // Dimensions array p[] has length n + 1
        int[] p = new int[n + 1];
        System.out.println("Enter dimensions array of size " + (n + 1) + " (e.g., for A1(10x20), A2(20x30), enter 10 20 30):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int minCost = matrixChainOrder(p);

        System.out.println("\nMinimum number of scalar multiplications: " + minCost);
        System.out.println("Optimal Parenthesization: " + printOptimalParenthesis(1, n));

        sc.close();
    }
}
