import java.util.Scanner;

public class FactorialIterative {

    // Iterative Factorial Computation
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Iterative Factorial ===");
        System.out.print("Enter a non-negative integer (e.g. 0 to 20): ");
        int n = sc.nextInt();

        long startTime = System.nanoTime();
        long fact = factorial(n);
        long endTime = System.nanoTime();

        System.out.println("Factorial of " + n + " (" + n + "!) = " + fact);
        long duration = endTime - startTime;
        System.out.println("Execution Time: " + duration + " nanoseconds (" + (duration / 1e6) + " ms)");

        sc.close();
    }
}
