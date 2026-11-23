# Practical 07: Making a Change Problem using Dynamic Programming

## 📌 Objective
To implement the Making a Change (Coin Change - Minimum Coins) problem using Dynamic Programming, construct the tabulation matrix, determine the minimum number of coins needed to make a target amount, and identify the exact coin denominations selected.

---

## 📖 Theoretical Background

### Problem Statement
Given an array of coin denominations $D = [d_0, d_1, \dots, d_{n-1}]$ and a target amount $W$:
- Find the minimum number of coins needed to make change for amount $W$.
- You may assume an infinite supply of each coin denomination (Unbounded Knapsack variant).
- If it is not possible to form amount $W$, output $-1$.

### Why Greedy Fails
A greedy approach (always choosing the largest available coin) works for canonical coin systems (e.g., US currency: 25, 10, 5, 1), but fails for general coin systems.
- *Counterexample:* Coins = `[1, 5, 6]`, Target = `9`
  - Greedy: picks $6$, remaining $3 \implies 6 + 1 + 1 + 1$ (4 coins).
  - Optimal (DP): $5 + 1 + 1 + 1 + 1$ or $6 + ...$? No, $5 + ...$: Wait, $5 + 1 + 1 + 1 + 1$ is 5 coins, but for Target = `11`:
    - Greedy: $6 + 5$ (2 coins).
  - For Coins = `[1, 3, 4]`, Target = `6`:
    - Greedy: $4 + 1 + 1$ (3 coins).
    - Optimal (DP): $3 + 3$ (2 coins).
Thus, **Dynamic Programming** is required for general coin systems.

### Dynamic Programming Recurrence Relation
Let `dp[i][j]` be the minimum coins needed to make amount $j$ using only a subset of the first $i$ coin denominations $\{coins[0], \dots, coins[i]\}$:

$$dp[i][j] = \begin{cases} 
0 & \text{if } j = 0 \\
dp[i-1][j] & \text{if } j < coins[i] \\
\min(dp[i-1][j], \; 1 + dp[i][j - coins[i]]) & \text{if } j \ge coins[i] 
\end{cases}$$

Notice the term $dp[i][j - coins[i]]$: because each coin can be used multiple times, we stay on the current row $i$ rather than $i - 1$.

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Time Complexity** | $O(n \times W)$ | Computing each cell of the $n \times (W+1)$ DP table takes $O(1)$ time. |
| **Space Complexity** | $O(n \times W)$ | Size of the 2D DP matrix (can be optimized to $O(W)$ using 1D array). |
| **Problem Type** | Unbounded Knapsack / DP | Allows infinite repetition of items. |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `CoinChangeDP.java` | Solves the coin change problem, prints the complete DP matrix, and outputs the count of each selected denomination. |

---

## 🚀 How to Compile and Run

```bash
javac CoinChangeDP.java
java CoinChangeDP
```

---

## 💻 Sample Execution

```text
=== Making a Change Problem using Dynamic Programming ===
Enter number of distinct coin denominations: 3
Enter 3 coin denominations (in ascending order):
1 2 5
Enter target amount: 11

--- Coin Change DP Table (dp[i][amount]) ---
Coin \ Amt	0	1	2	3	4	5	6	7	8	9	10	11	
1		0	1	2	3	4	5	6	7	8	9	10	11	
2		0	1	1	2	2	3	3	4	4	5	5	6	
5		0	1	1	2	2	1	2	2	3	3	2	3	

--- Optimal Coin Selection ---
Denomination 1: 1 coin(s)
Denomination 5: 2 coin(s)

Minimum coins required: 3
```
*(Explanation: $5 \times 2 + 1 \times 1 = 11$, total 3 coins).*
