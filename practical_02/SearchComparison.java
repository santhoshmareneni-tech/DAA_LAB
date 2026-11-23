import java.util.Arrays;
import java.util.Scanner;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.println("     Linear Search vs Binary Search Time Analysis    ");
        System.out.println("=====================================================");
        System.out.print("Enter array size (e.g., 1000000): ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2; // Sorted even numbers: 0, 2, 4, 6, ...
        }

        System.out.println("\nTesting on array of size " + n + "...\n");

        // 1. Best Case (First element)
        int targetBest = arr[0];
        long t1 = System.nanoTime();
        linearSearch(arr, targetBest);
        long linearBestTime = System.nanoTime() - t1;

        t1 = System.nanoTime();
        binarySearch(arr, targetBest);
        long binaryBestTime = System.nanoTime() - t1;

        // 2. Average Case (Middle element)
        int targetAvg = arr[n / 2];
        t1 = System.nanoTime();
        linearSearch(arr, targetAvg);
        long linearAvgTime = System.nanoTime() - t1;

        t1 = System.nanoTime();
        binarySearch(arr, targetAvg);
        long binaryAvgTime = System.nanoTime() - t1;

        // 3. Worst Case (Last element or Not present)
        int targetWorst = arr[n - 1] + 1; // not found
        t1 = System.nanoTime();
        linearSearch(arr, targetWorst);
        long linearWorstTime = System.nanoTime() - t1;

        t1 = System.nanoTime();
        binarySearch(arr, targetWorst);
        long binaryWorstTime = System.nanoTime() - t1;

        System.out.printf("%-15s | %-15s | %-20s | %-20s\n", "Case", "Target", "Linear Search (ns)", "Binary Search (ns)");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-15s | %-15d | %-20d | %-20d\n", "Best Case", targetBest, linearBestTime, binaryBestTime);
        System.out.printf("%-15s | %-15d | %-20d | %-20d\n", "Average Case", targetAvg, linearAvgTime, binaryAvgTime);
        System.out.printf("%-15s | %-15d | %-20d | %-20d\n", "Worst Case", targetWorst, linearWorstTime, binaryWorstTime);
        System.out.println("==================================================================================");

        sc.close();
    }
}
