import java.util.*;
public class MatrixChainMultiplication { //O(n^3)
    static int split[][];

    public static int matrixChain(int p[]) {
        int n = p.length - 1; // no of matrices
        int m[][] = new int[n + 1][n + 1];
        split = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;// for diagonal values
        }

        for (int length=2; length <= n; length++) {
            for (int i= 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) { // where to split
                    int cost = m[i][k]+
                               m[k + 1][j]+ 
                               p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        // Print DP Matrix
        System.out.println("\nDP Matrix:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    System.out.print("-\t");
                else
                    System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }

        // print k table
        System.out.println("\nK Table:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j)
                    System.out.print("-\t");
                else
                    System.out.print(split[i][j] + "\t");
            }
            System.out.println();
        }

        return m[1][n]; 
    }

    public static String grouping(int i , int j){
        if(i==j){
            return "A" + i;
        }

        int k = split[i][j];
        return "(" + grouping(i, k)+grouping(k+1, j) + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println(
            "Minimum multiplications = " + matrixChain(p)
        );

        System.out.println("Grouped " + grouping(1, n));
    }
}

// 3 matrices 10 20 30 5