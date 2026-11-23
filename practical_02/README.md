# Practical 02: Implementation and Time Analysis of Linear and Binary Search

## 📌 Objective
To implement Linear Search and Binary Search algorithms and experimentally analyze their execution time in Best, Average, and Worst-case scenarios.

---

## 📖 Theoretical Background

### 1. Linear Search (Sequential Search)
- **Concept:** Sequentially checks every element in the list from beginning to end until a match is found or the end of the array is reached.
- **Precondition:** None. Works on both sorted and unsorted arrays.
- **Analysis:**
  - **Best Case:** Target is at index $0 \implies O(1)$
  - **Worst Case:** Target is at the last index or absent $\implies O(n)$
  - **Average Case:** Target found somewhere in the middle $\implies O(n)$

### 2. Binary Search (Divide and Conquer)
- **Concept:** Compares the target value to the middle element of a sorted array. If they are unequal, the half in which the target cannot lie is eliminated, and the search continues on the remaining half.
- **Precondition:** The input array **must be sorted**.
- **Analysis:**
  - **Recurrence Relation:** $T(n) = T(n/2) + O(1) \implies T(n) = O(\log n)$
  - **Best Case:** Target is at the middle element $\implies O(1)$
  - **Worst Case:** Target is at the leaf level of division or absent $\implies O(\log_2 n)$
  - **Average Case:** $O(\log_2 n)$

---

## 📊 Complexity Comparison Table

| Feature | Linear Search | Binary Search |
| :--- | :---: | :---: |
| **Prerequisite** | None (Unsorted / Sorted) | Array **must be sorted** |
| **Methodology** | Sequential iteration | Divide and Conquer (interval halving) |
| **Best Case Time** | $O(1)$ | $O(1)$ |
| **Average Case Time** | $O(n)$ | $O(\log n)$ |
| **Worst Case Time** | $O(n)$ | $O(\log n)$ |
| **Space Complexity** | $O(1)$ | $O(1)$ (iterative) |
| **Data Structure** | Array, Linked List | Array (requires random access) |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `LinearSearch.java` | Interactive Linear Search with user inputs and execution time logging. |
| `BinarySearch.java` | Interactive Binary Search with automatic sorting and timing. |
| `SearchComparison.java` | Benchmark comparing Best, Average, and Worst-case times for both searches on a large dataset ($N = 1,000,000$). |

---

## 🚀 How to Compile and Run

### Running Linear Search:
```bash
javac LinearSearch.java
java LinearSearch
```

### Running Binary Search:
```bash
javac BinarySearch.java
java BinarySearch
```

### Running the Comparison Benchmark:
```bash
javac SearchComparison.java
java SearchComparison
```

---

## 💻 Sample Execution

### Sample 1: Linear Search
```text
=== Linear Search with Time Analysis ===
Enter number of elements: 5
Enter 5 elements:
10 50 30 70 80
Enter target element to search: 30
Element 30 found at index: 2
Execution Time: 1800 nanoseconds (0.0018 ms)
```

### Sample 2: Benchmark ($N = 1,000,000$)
```text
=====================================================
     Linear Search vs Binary Search Time Analysis    
=====================================================
Enter array size (e.g., 1000000): 1000000

Testing on array of size 1000000...

Case            | Target          | Linear Search (ns)   | Binary Search (ns)  
----------------------------------------------------------------------------------
Best Case       | 0               | 400                  | 300                 
Average Case    | 1000000         | 1450200              | 900                 
Worst Case      | 2000001         | 2984500              | 1100                
==================================================================================
```
*Notice how Binary Search takes approximately 1,100 nanoseconds even in the worst case on a million elements, while Linear Search takes nearly 3,000,000 nanoseconds!*
