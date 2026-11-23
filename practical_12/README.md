# Practical 12: Implementation of Travelling Salesperson Problem (TSP)

## 📌 Objective
To implement the **Travelling Salesperson Problem (TSP)** using **Backtracking / Branch and Bound** in Java, finding the Hamiltonian cycle of minimum total cost and outputting the optimal traversal sequence.

---

## 📖 Theoretical Background

### Problem Definition
Given a set of $n$ cities and the distance/cost between each pair of cities:
- A salesperson must start from an origin city (e.g., City $0$).
- Visit every other city **exactly once**.
- Return to the origin city.
- The objective is to minimize the total round-trip travel distance/cost.

### Computational Complexity
- TSP is a well-known **NP-hard** problem in combinatorial optimization.
- The decision version is **NP-complete**.
- A naive brute-force permutation search examines $(n-1)!$ possible tours, which becomes computationally infeasible for $n > 15$.

### Backtracking with Bounding (Pruning)
- Explore possible city paths depth-first.
- Maintain `currentCost` of the path explored so far.
- **Bounding / Pruning:** If at any point `currentCost + edgeCost >= minCost`, prune the entire subtree, avoiding redundant recursive calls.
- Once all $n$ cities are visited, if an edge exists back to city 0, check whether the total cost beats `minCost`. If so, update the best tour.

---

## 📊 Complexity Analysis

| Approach | Time Complexity | Space Complexity | Optimality |
| :--- | :---: | :---: | :---: |
| **Brute Force Permutation** | $O(n!)$ | $O(n)$ | Exact / Optimal |
| **Backtracking with Pruning (Implemented)** | $O(n!)$ worst case, faster on average | $O(n)$ (Recursion stack + tour path) | Exact / Optimal |
| **Held-Karp Dynamic Programming** | $O(n^2 \cdot 2^n)$ | $O(n \cdot 2^n)$ | Exact / Optimal |
| **Nearest Neighbor (Greedy)** | $O(n^2)$ | $O(n)$ | Heuristic (Approximation) |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `TSP.java` | Solves TSP using backtracking with cost bounding, outputs both the minimal total cost and the complete path sequence. |

---

## 🚀 How to Compile and Run

```bash
javac TSP.java
java TSP
```

---

## 💻 Sample Execution

### Sample 4-City Distance Matrix:
```text
      0    10   15   20
     10     0   35   25
     15    35    0   30
     20    25   30    0
```

### Execution Output:
```text
=== Travelling Salesperson Problem (TSP) using Backtracking ===
Enter number of cities: 4
Enter the cost adjacency matrix (4 x 4, 0 for no edge or self-loop):
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0

--- Optimal Tour Found ---
Optimal Path: City 0 -> City 1 -> City 3 -> City 2 -> City 0
Minimum Tour Cost: 80
```
*(Cost breakdown: $0 \to 1$ (10) $+ 1 \to 3$ (25) $+ 3 \to 2$ (30) $+ 2 \to 0$ (15) $= 80$).*
