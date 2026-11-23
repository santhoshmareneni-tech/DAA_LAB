# Practical 01: Implementation and Time Analysis of Sorting Algorithms

## 📌 Objective
To implement and analyze the performance (time and space complexity) of fundamental sorting algorithms:
1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quick Sort

---

## 📖 Theoretical Background

### 1. Bubble Sort
- **Concept:** Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The largest element "bubbles" up to its correct position at the end of each pass.
- **Optimization:** An early-exit flag `swapped` terminates execution early if no swaps occur in a pass (yielding $O(n)$ best case for sorted input).

### 2. Selection Sort
- **Concept:** Divides the input into two parts: a sorted subarray and an unsorted subarray. In each pass, it finds the smallest element in the unsorted subarray and swaps it with the first unsorted element.
- **Characteristics:** In-place, minimizes total number of writes/swaps ($O(n)$ swaps total).

### 3. Insertion Sort
- **Concept:** Iteratively builds the final sorted array one item at a time by consuming one input element per repetition and finding its appropriate position within the sorted prefix.
- **Characteristics:** Highly efficient for small datasets ($n \le 10$) and partially/nearly sorted arrays.

### 4. Merge Sort
- **Concept:** A Divide-and-Conquer algorithm. Divides the array into two halves, recursively sorts both halves, and then merges the two sorted halves back together.
- **Recurrence Relation:**
  $$T(n) = 2T(n/2) + O(n)$$
  By Master Theorem Case 2: $T(n) = O(n \log n)$ across all cases.

### 5. Quick Sort
- **Concept:** A Divide-and-Conquer algorithm. Picks an element as a pivot and partitions the given array around the picked pivot such that smaller elements are to the left and larger elements are to the right.
- **Recurrence Relations:**
  - Best & Average Case: $T(n) = 2T(n/2) + O(n) \implies O(n \log n)$
  - Worst Case (already sorted with last element as pivot): $T(n) = T(n-1) + O(n) \implies O(n^2)$

---

## 📊 Complexity Comparison Table

| Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Stable? | In-Place? |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **Bubble Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Yes | Yes |
| **Selection Sort** | $O(n^2)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | No | Yes |
| **Insertion Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Yes | Yes |
| **Merge Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(n)$ | Yes | No |
| **Quick Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ (call stack) | No | Yes |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `BubbleSort.java` | Interactive Bubble Sort with execution time measurement. |
| `SelectionSort.java` | Interactive Selection Sort with execution time measurement. |
| `InsertionSort.java` | Interactive Insertion Sort with execution time measurement. |
| `MergeSort.java` | Interactive Merge Sort with execution time measurement. |
| `QuickSort.java` | Interactive Quick Sort with execution time measurement. |
| `SortingComparison.java` | Benchmark program comparing all 5 algorithms on identical datasets. |

---

## 🚀 How to Compile and Run

### Running an Individual Sort (e.g. Quick Sort):
```bash
javac QuickSort.java
java QuickSort
```

### Running the Comparison Benchmark:
```bash
javac SortingComparison.java
java SortingComparison
```

---

## 💻 Sample Execution

### Sample 1: Individual Sort (Bubble Sort)
```text
=== Bubble Sort with Time Analysis ===
Enter number of elements: 6
Enter 6 elements:
64 34 25 12 22 11
Original Array: 64 34 25 12 22 11 
Sorted Array:   11 12 22 25 34 64 
Execution Time: 4200 nanoseconds (0.0042 ms)
```

### Sample 2: Sorting Comparison Benchmark ($N = 5000$)
```text
=====================================================
   Sorting Algorithms Time Analysis & Comparison     
=====================================================
Enter array size for benchmark (e.g., 5000): 5000

Testing algorithms on 5000 random integers...

Algorithm          | Time (ns)          | Time (ms)          | Time Complexity (Avg)
-----------------------------------------------------------------------------------
Bubble Sort        | 32189400           | 32.1894            | O(n^2)         
Selection Sort     | 18451200           | 18.4512            | O(n^2)         
Insertion Sort     | 8943100            | 8.9431             | O(n^2)         
Merge Sort         | 1245600            | 1.2456             | O(n log n)     
Quick Sort         | 892100             | 0.8921             | O(n log n)     
===================================================================================
```
