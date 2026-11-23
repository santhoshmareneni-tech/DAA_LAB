import java.util.Scanner;

public class HeapSort {

    // Function to maintain max-heap property at node i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child = 2*i + 1
        int right = 2 * i + 2; // right child = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Function to perform Heap Sort using Max-Heap
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.print("Array after Max-Heap construction: ");
        printArray(arr);

        // Step 2: One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Max-Heap Sort Implementation ===");
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Initial Array:                     ");
        printArray(arr);

        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        System.out.print("Sorted Array:                      ");
        printArray(arr);

        long duration = endTime - startTime;
        System.out.println("Execution Time: " + duration + " nanoseconds (" + (duration / 1e6) + " ms)");

        sc.close();
    }
}
