# Practical 03: Implementation of Max-Heap Sort Algorithm

## 📌 Objective
To implement the Max-Heap Sort algorithm, demonstrate the construction of a Max-Heap data structure, and analyze its sorting performance.

---

## 📖 Theoretical Background

### What is a Binary Heap?
A Binary Heap is a complete binary tree stored compactly inside a 1D array without requiring explicit tree pointers:
- For any element at index $i$:
  - **Left Child:** `2 * i + 1`
  - **Right Child:** `2 * i + 2`
  - **Parent Node:** `(i - 1) / 2`

### Max-Heap Property
In a Max-Heap, for every node $i$ other than the root:
$$\text{arr}[\text{parent}(i)] \ge \text{arr}[i]$$
Thus, the maximum element is always at the root (`arr[0]`).

---

## ⚙️ How Heap Sort Works

Heap Sort operates in two key phases:

1. **Build Max-Heap:**
   - Starts from the last non-leaf node ($\lfloor n/2 \rfloor - 1$) down to index $0$.
   - Calls `heapify` on each node to satisfy the max-heap property.
   - Time complexity to build heap: $O(n)$.

2. **Extract Elements Repeatedly:**
   - The maximum element (`arr[0]`) is swapped with the last element of the heap (`arr[i]`).
   - The heap size is reduced by 1.
   - `heapify(arr, i, 0)` is invoked on the new root to restore the max-heap property.
   - Repeated for all $n-1$ elements.

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Best Case Time** | $O(n \log n)$ | All elements must still be heapified and extracted. |
| **Average Case Time** | $O(n \log n)$ | Standard balanced binary heap operations. |
| **Worst Case Time** | $O(n \log n)$ | Guaranteed $O(n \log n)$ even for reverse sorted arrays. |
| **Space Complexity** | $O(1)$ | Performs in-place rearrangement without extra memory. |
| **Stability** | **No** | Relative order of equal keys is not preserved during swaps. |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `HeapSort.java` | Complete Max-Heap sort implementation showing max-heap creation and final sorted output. |

---

## 🚀 How to Compile and Run

```bash
javac HeapSort.java
java HeapSort
```

---

## 💻 Sample Execution

```text
=== Max-Heap Sort Implementation ===
Enter number of elements: 6
Enter 6 elements:
12 11 13 5 6 7
Initial Array:                     12 11 13 5 6 7 
Array after Max-Heap construction: 13 11 12 5 6 7 
Sorted Array:                      5 6 7 11 12 13 
Execution Time: 3400 nanoseconds (0.0034 ms)
```
