import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // Iterative Binary Search: expects a sorted array
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Element found
            }

            if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Binary Search with Time Analysis ===");
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (need not be sorted, we will sort):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Binary search requires a sorted array
        Arrays.sort(arr);
        System.out.print("Sorted Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();

        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();

        // Time Analysis for search only
        long startTime = System.nanoTime();
        int result = binarySearch(arr, target);
        long endTime = System.nanoTime();

        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }

        long duration = endTime - startTime;
        System.out.println("Execution Time: " + duration + " nanoseconds (" + (duration / 1e6) + " ms)");

        sc.close();
    }
}
