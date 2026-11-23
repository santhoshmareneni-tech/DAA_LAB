import java.util.Scanner;

public class FactorialRecursive {

    // Recursive Factorial Computation
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers.");
        }
        // Base condition
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive step
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Recursive Factorial ===");
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
