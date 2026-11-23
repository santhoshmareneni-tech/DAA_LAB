# Practical 06: Matrix Chain Multiplication using Dynamic Programming

## 📌 Objective
To implement the Matrix Chain Multiplication (MCM) algorithm using Dynamic Programming to find the optimal order of parenthesizing a sequence of matrices, minimizing the total number of scalar multiplications.

---

## 📖 Theoretical Background

### Problem Statement
Given a sequence of $n$ matrices $A_1, A_2, \dots, A_n$, where matrix $A_i$ has dimension $p_{i-1} \times p_i$:
- Matrix multiplication is **associative**: $(A_1 A_2) A_3 = A_1 (A_2 A_3)$.
- However, the number of scalar multiplications depends heavily on parenthesization:
  - Multiplying $(p \times q)$ with $(q \times r)$ costs $p \times q \times r$ operations.
- The goal is to determine the parenthesization that minimizes the total multiplication cost.

### Dynamic Programming Recurrence Relation
Let $m[i][j]$ denote the minimum number of scalar multiplications needed to compute the matrix product $A_i \dots A_j$:

$$m[i][j] = \begin{cases} 
0 & \text{if } i = j \\
\min_{i \le k < j} \left\{ m[i][k] + m[k+1][j] + p_{i-1} \cdot p_k \cdot p_j \right\} & \text{if } i < j 
\end{cases}$$

Here, $k$ is the index where the product $A_i \dots A_j$ is split into $(A_i \dots A_k)(A_{k+1} \dots A_j)$. The optimal split index is recorded in table $s[i][j]$ (or $k[i][j]$).

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Time Complexity** | $O(n^3)$ | There are $O(n^2)$ subproblems (pairs $i, j$), and finding minimum $k$ takes $O(n)$ time. |
| **Space Complexity** | $O(n^2)$ | Auxiliary space for $m[n+1][n+1]$ cost table and $s[n+1][n+1]$ split table. |
| **Approach** | Bottom-up Tabulation | Solves subproblems by increasing chain length $L = 2, 3, \dots, n$. |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `MatrixChainMultiplication.java` | Solves MCM, outputs the cost matrix ($M$), the split matrix ($K$), and the formatted optimal grouping. |

---

## 🚀 How to Compile and Run

```bash
javac MatrixChainMultiplication.java
java MatrixChainMultiplication
```

---

## 💻 Sample Execution

```text
=== Matrix Chain Multiplication using Dynamic Programming ===
Enter number of matrices: 3
Enter dimensions array of size 4 (e.g., for A1(10x20), A2(20x30), enter 10 20 30):
10 20 30 5

--- Cost Matrix (M Table) ---
0	6000	4500	
-	0	3000	
-	-	0	

--- Split Matrix (K / S Table) ---
-	1	2	
-	-	2	
-	-	-	

Minimum number of scalar multiplications: 4500
Optimal Parenthesization: ((A1 x A2) x A3)
```
