import java.util.Scanner;

public class BubbleSort {

    // Function to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, array is sorted
            if (!swapped) break;
        }
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bubble Sort with Time Analysis ===");
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Original Array: ");
        printArray(arr);

        // Time Analysis
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        System.out.print("Sorted Array:   ");
        printArray(arr);

        long duration = endTime - startTime;
        System.out.println("Execution Time: " + duration + " nanoseconds (" + (duration / 1e6) + " ms)");

        sc.close();
    }
}
