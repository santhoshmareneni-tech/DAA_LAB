import java.util.Scanner;

public class FactorialComparison {

    // Iterative
    public static long factIterative(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    // Recursive
    public static long factRecursive(int n) {
        if (n <= 1) return 1;
        return n * factRecursive(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.println("   Iterative vs Recursive Factorial Time Analysis    ");
        System.out.println("=====================================================");
        System.out.print("Enter an integer n (e.g. 15): ");
        int n = sc.nextInt();

        // Warm up JVM JIT compiler
        for (int i = 0; i < 10000; i++) {
            factIterative(n);
            factRecursive(n);
        }

        // Benchmark Iterative
        long t1 = System.nanoTime();
        long resIter = factIterative(n);
        long timeIter = System.nanoTime() - t1;

        // Benchmark Recursive
        t1 = System.nanoTime();
        long resRec = factRecursive(n);
        long timeRec = System.nanoTime() - t1;

        System.out.println("\nResults for n = " + n + ":");
        System.out.println("Computed Value: " + resIter);
        System.out.printf("%-15s | %-18s | %-15s\n", "Method", "Execution Time (ns)", "Space Complexity");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-15s | %-18d | %-15s\n", "Iterative", timeIter, "O(1)");
        System.out.printf("%-15s | %-18d | %-15s\n", "Recursive", timeRec, "O(n) Call Stack");
        System.out.println("=========================================================");

        System.out.println("\nAnalysis Note:");
        System.out.println("- Iterative uses a simple loop with O(1) auxiliary space and avoids function call overhead.");
        System.out.println("- Recursive uses O(n) activation records on the call stack, potentially risking StackOverflowError for very large n.");

        sc.close();
    }
}
