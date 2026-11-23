# Practical 05: 0/1 Knapsack Problem using Dynamic Programming

## 📌 Objective
To implement the 0/1 Knapsack problem using Dynamic Programming (Bottom-Up Tabulation), display the dynamic programming table, calculate maximum profit, and reconstruct the list of selected items.

---

## 📖 Theoretical Background

### Problem Formulation
Given $n$ items, each with a weight $w_i$ and a profit/value $v_i$, and a knapsack with maximum weight capacity $W$:
- Choose a subset of items to maximize total value such that total weight $\le W$.
- In the **0/1 Knapsack** variation, each item can either be taken completely ($1$) or left behind ($0$). Fractional division is not allowed.

### Dynamic Programming Recurrence Relation
Let `dp[i][w]` represent the maximum profit obtained considering a subset of the first $i$ items with capacity $w$:

$$dp[i][w] = \begin{cases} 
0 & \text{if } i = 0 \text{ or } w = 0 \\
dp[i-1][w] & \text{if } weights[i-1] > w \\
\max(v_{i-1} + dp[i-1][w - weights[i-1]], \; dp[i-1][w]) & \text{if } weights[i-1] \le w 
\end{cases}$$

### Item Backtracking
Starting from $i = n, w = W$:
- If $dp[i][w] \neq dp[i-1][w]$, item $i$ was included. Subtract $w_{i-1}$ from $w$ and decrement $i$.
- Else, item $i$ was excluded. Decrement $i$.

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Time Complexity** | $O(n \times W)$ | Computing each cell in the $(n+1) \times (W+1)$ DP table takes $O(1)$ time. |
| **Space Complexity** | $O(n \times W)$ | Size of the 2D DP matrix. |
| **Classification** | Pseudo-polynomial | Polynomial in $n$ and $W$, but exponential in the binary bit-length of $W$. |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `KnapsackDP.java` | Solves 0/1 Knapsack, prints formatted DP matrix, and outputs the selected item set. |

---

## 🚀 How to Compile and Run

```bash
javac KnapsackDP.java
java KnapsackDP
```

---

## 💻 Sample Execution

```text
=== 0/1 Knapsack Problem using Dynamic Programming ===
Enter number of items: 4
Enter profits/values of the 4 items:
10 40 30 50
Enter weights of the 4 items:
5 4 6 3
Enter total capacity of knapsack (W): 10

--- Dynamic Programming Table (DP[i][w]) ---
Item \ W	0	1	2	3	4	5	6	7	8	9	10	
0		0	0	0	0	0	0	0	0	0	0	0	
1		0	0	0	0	0	10	10	10	10	10	10	
2		0	0	0	0	40	40	40	40	40	50	50	
3		0	0	0	0	40	40	40	40	40	50	70	
4		0	0	0	50	50	50	50	90	90	90	90	

--- Selected Items in Optimal Solution ---
Item 4 -> Weight: 3, Profit: 50
Item 2 -> Weight: 4, Profit: 40
Total Weight of selected items: 7 / 10

Maximum Profit achievable = 90
```
