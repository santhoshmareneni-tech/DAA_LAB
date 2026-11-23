# Design and Analysis of Algorithms (DAA) Laboratory

**Course Code:** 01AI0506 – Design and Analysis of Algorithm  
**Department:** Department of Computer Engineering  
**Faculty:** Faculty of Engineering and Technology  
**Repository:** [github.com/santhoshmareneni-tech/DAA_LAB](https://github.com/santhoshmareneni-tech/DAA_LAB.git)

---

## 📚 Overview

This repository contains clean, modular, and well-documented implementations in Java for all laboratory practicals prescribed in the **Design and Analysis of Algorithms (01AI0506)** curriculum. Each practical is organized into its own dedicated folder containing simple Java source code, benchmark / comparison drivers (where applicable), and an in-depth `README.md` with theoretical foundations, step-by-step algorithms, complexity analyses, and sample input/output runs.

---

## 🗂️ Table of Contents & Practicals Index

| No. | Practical Name | Algorithm Paradigm | Time Complexity | Folder Link |
| :---: | :--- | :--- | :---: | :---: |
| **01** | Implementation & Time Analysis of Sorting Algorithms (Bubble, Selection, Insertion, Merge, Quick) | Incremental / Divide & Conquer | $O(n \log n)$ to $O(n^2)$ | [📁 practical_01](./practical_01/) |
| **02** | Implementation & Time Analysis of Linear and Binary Search | Sequential / Divide & Conquer | $O(1)$ to $O(n)$ | [📁 practical_02](./practical_02/) |
| **03** | Implementation of Max-Heap Sort Algorithm | Tree / Heap Transformation | $O(n \log n)$ | [📁 practical_03](./practical_03/) |
| **04** | Implementation & Time Analysis of Factorial (Iterative vs Recursive) | Iterative vs Recursion (Stack) | $O(n)$ | [📁 practical_04](./practical_04/) |
| **05** | Implementation of 0/1 Knapsack Problem | Dynamic Programming (Tabulation) | $O(n \cdot W)$ | [📁 practical_05](./practical_05/) |
| **06** | Implementation of Matrix Chain Multiplication | Dynamic Programming (Tabulation) | $O(n^3)$ | [📁 practical_06](./practical_06/) |
| **07** | Implementation of Making a Change (Coin Change) Problem | Dynamic Programming (Unbounded) | $O(n \cdot W)$ | [📁 practical_07](./practical_07/) |
| **08** | Implementation of Graph Traversal (DFS and BFS) | Graph Exploration (Queue / Stack) | $O(V^2)$ / $O(V+E)$ | [📁 practical_08](./practical_08/) |
| **09** | Implementation of Prim's Minimum Spanning Tree Algorithm | Greedy Method (Cut Property) | $O(V^2)$ / $O(E \log V)$ | [📁 practical_09](./practical_09/) |
| **10** | Implementation of Kruskal's Minimum Spanning Tree Algorithm | Greedy Method (Disjoint Set Union) | $O(E \log E)$ | [📁 practical_10](./practical_10/) |
| **11** | Implementation of Floyd-Warshall All-Pairs Shortest Path | Dynamic Programming | $O(V^3)$ | [📁 practical_11](./practical_11/) |
| **12** | Implementation of Travelling Salesperson Problem (TSP) | Backtracking / Branch & Bound | $O(n!)$ | [📁 practical_12](./practical_12/) |

---

## 🌳 Repository Directory Structure

```text
DAA_LAB/
│
├── practical_01/                    # Practical 1: Sorting Algorithms & Time Analysis
│   ├── BubbleSort.java
│   ├── SelectionSort.java
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── SortingComparison.java      # Benchmarking all 5 algorithms
│   └── README.md
│
├── practical_02/                    # Practical 2: Linear and Binary Search
│   ├── LinearSearch.java
│   ├── BinarySearch.java
│   ├── SearchComparison.java       # Benchmarking search on 1M elements
│   └── README.md
│
├── practical_03/                    # Practical 3: Max-Heap Sort
│   ├── HeapSort.java
│   └── README.md
│
├── practical_04/                    # Practical 4: Factorial (Iterative vs Recursive)
│   ├── FactorialIterative.java
│   ├── FactorialRecursive.java
│   ├── FactorialComparison.java    # Benchmarking call stack vs loop
│   └── README.md
│
├── practical_05/                    # Practical 5: 0/1 Knapsack (DP)
│   ├── KnapsackDP.java
│   └── README.md
│
├── practical_06/                    # Practical 6: Matrix Chain Multiplication (DP)
│   ├── MatrixChainMultiplication.java
│   └── README.md
│
├── practical_07/                    # Practical 7: Coin Change Problem (DP)
│   ├── CoinChangeDP.java
│   └── README.md
│
├── practical_08/                    # Practical 8: Graph Searching (DFS & BFS)
│   ├── BFS.java
│   ├── DFS.java
│   ├── GraphTraversal.java         # Unified traversal driver
│   └── README.md
│
├── practical_09/                    # Practical 9: Prim's MST Algorithm
│   ├── PrimMST.java
│   └── README.md
│
├── practical_10/                    # Practical 10: Kruskal's MST Algorithm
│   ├── KruskalMST.java
│   └── README.md
│
├── practical_11/                    # Practical 11: Floyd-Warshall Algorithm
│   ├── FloydWarshall.java
│   └── README.md
│
├── practical_12/                    # Practical 12: Travelling Salesperson Problem (TSP)
│   ├── TSP.java
│   └── README.md
│
├── .gitignore                       # Git ignore file for Java artifacts
└── README.md                        # Master documentation
```

---

## 🛠️ How to Compile and Run Any Practical

Make sure you have JDK (Java Development Kit) version 8 or higher installed.

1. **Navigate to the target practical folder:**
   ```bash
   cd practical_01
   ```

2. **Compile the Java source file:**
   ```bash
   javac QuickSort.java
   ```

3. **Execute the compiled program:**
   ```bash
   java QuickSort
   ```

---

## 🚀 Pushing to GitHub

To push this organized repository to your GitHub repository:

```bash
# 1. Initialize git (if not already done)
git init

# 2. Add all practical folders and documentation
git add .

# 3. Commit the changes
git commit -m "Organize DAA lab practicals 01 to 12 with simple Java implementations and comprehensive READMEs"

# 4. Set main branch and remote URL
git branch -M main
git remote add origin https://github.com/santhoshmareneni-tech/DAA_LAB.git

# 5. Push to GitHub
git push -u origin main
```
*(If the remote already exists, use `git remote set-url origin https://github.com/santhoshmareneni-tech/DAA_LAB.git`)*

---

## 👨‍💻 Author
- **GitHub:** [@santhoshmareneni-tech](https://github.com/santhoshmareneni-tech)
- **Repository:** [DAA_LAB](https://github.com/santhoshmareneni-tech/DAA_LAB.git)
