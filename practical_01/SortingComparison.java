import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int t = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = t;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.println("   Sorting Algorithms Time Analysis & Comparison     ");
        System.out.println("=====================================================");
        System.out.print("Enter array size for benchmark (e.g., 5000): ");
        int n = sc.nextInt();

        int[] baseArray = new int[n];
        Random rand = new Random(42); // fixed seed for reproducibility
        for (int i = 0; i < n; i++) {
            baseArray[i] = rand.nextInt(100000);
        }

        System.out.println("\nTesting algorithms on " + n + " random integers...\n");

        // 1. Bubble Sort
        int[] arr1 = Arrays.copyOf(baseArray, n);
        long t1 = System.nanoTime();
        bubbleSort(arr1);
        long t2 = System.nanoTime();
        long bubbleTime = t2 - t1;

        // 2. Selection Sort
        int[] arr2 = Arrays.copyOf(baseArray, n);
        t1 = System.nanoTime();
        selectionSort(arr2);
        t2 = System.nanoTime();
        long selectionTime = t2 - t1;

        // 3. Insertion Sort
        int[] arr3 = Arrays.copyOf(baseArray, n);
        t1 = System.nanoTime();
        insertionSort(arr3);
        t2 = System.nanoTime();
        long insertionTime = t2 - t1;

        // 4. Merge Sort
        int[] arr4 = Arrays.copyOf(baseArray, n);
        t1 = System.nanoTime();
        mergeSort(arr4, 0, n - 1);
        t2 = System.nanoTime();
        long mergeTime = t2 - t1;

        // 5. Quick Sort
        int[] arr5 = Arrays.copyOf(baseArray, n);
        t1 = System.nanoTime();
        quickSort(arr5, 0, n - 1);
        t2 = System.nanoTime();
        long quickTime = t2 - t1;

        // Print Results Table
        System.out.printf("%-18s | %-18s | %-18s | %-15s\n", "Algorithm", "Time (ns)", "Time (ms)", "Time Complexity (Avg)");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-18s | %-18d | %-18.4f | %-15s\n", "Bubble Sort", bubbleTime, bubbleTime / 1e6, "O(n^2)");
        System.out.printf("%-18s | %-18d | %-18.4f | %-15s\n", "Selection Sort", selectionTime, selectionTime / 1e6, "O(n^2)");
        System.out.printf("%-18s | %-18d | %-18.4f | %-15s\n", "Insertion Sort", insertionTime, insertionTime / 1e6, "O(n^2)");
        System.out.printf("%-18s | %-18d | %-18.4f | %-15s\n", "Merge Sort", mergeTime, mergeTime / 1e6, "O(n log n)");
        System.out.printf("%-18s | %-18d | %-18.4f | %-15s\n", "Quick Sort", quickTime, quickTime / 1e6, "O(n log n)");
        System.out.println("===================================================================================");

        sc.close();
    }
}
