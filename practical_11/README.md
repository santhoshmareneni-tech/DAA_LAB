# Practical 11: Implementation of Floyd-Warshall Algorithm

## 📌 Objective
To implement the **Floyd-Warshall Algorithm** to solve the **All-Pairs Shortest Path (APSP)** problem for a directed or undirected weighted graph using Dynamic Programming.

---

## 📖 Theoretical Background

### Problem Statement
Given a directed or undirected graph $G = (V, E)$ with edge weights (which may be negative, provided there are no negative-weight cycles), find the shortest path between **every pair of vertices** $(u, v) \in V$.

### Dynamic Programming Formulation
Let $D^{(k)}[i][j]$ be the length of the shortest path from vertex $i$ to vertex $j$ such that all intermediate vertices on the path belong to the set $\{0, 1, \dots, k\}$.

### Recurrence Relation
$$D^{(k)}[i][j] = \min \left( D^{(k-1)}[i][j], \; D^{(k-1)}[i][k] + D^{(k-1)}[k][j] \right)$$

- **Base Case ($k = -1$):** $D^{(0)}[i][j]$ is initialized to the direct edge weight $w(i, j)$, with $D[i][i] = 0$ and $D[i][j] = \infty$ if no direct edge exists.
- **Recursive Step:** Vertex $k$ is considered as a potential bridge/intermediate node. If routing from $i$ through $k$ to $j$ yields a shorter path than the current known distance from $i$ to $j$, we update $D[i][j]$.

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Time Complexity** | $O(V^3)$ | Three nested loops, each iterating from $0$ to $V-1$. |
| **Space Complexity** | $O(V^2)$ | 2D matrix storing the all-pairs distance table. |
| **Negative Weights** | Supported | Handles negative edge weights correctly. |
| **Negative Cycles** | Detectable | If diagonal element $D[i][i] < 0$ after completion, a negative cycle exists. |

---

## ⚖️ Comparison with Other Shortest Path Algorithms

| Algorithm | Type | Suitable For | Time Complexity | Handles Negative Edges? |
| :--- | :--- | :--- | :---: | :---: |
| **Dijkstra's** | Single-Source Shortest Path (SSSP) | Non-negative edge weights | $O((V+E)\log V)$ | No |
| **Bellman-Ford** | Single-Source Shortest Path (SSSP) | General weights (detects cycles) | $O(V \cdot E)$ | Yes |
| **Floyd-Warshall** | All-Pairs Shortest Path (APSP) | Dense graphs, all pairs | $O(V^3)$ | Yes |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `FloydWarshall.java` | Solves All-Pairs Shortest Path problem, handles infinity representation, and displays formatted distance matrix. |

---

## 🚀 How to Compile and Run

```bash
javac FloydWarshall.java
java FloydWarshall
```

---

## 💻 Sample Execution

### Sample Graph (4 vertices):
```text
      (0)
     / | \
   3/  |  \7
   /   |8  \
 (1)   |   (3)
   \   |   /
   1\  |  /2
     \ | /
      (2)
```

**Adjacency Matrix Input (-1 for no edge):**
```text
0   3   8   7
-1  0   1   -1
-1  -1  0   2
-1  -1  -1  0
```

### Execution Output:
```text
=== Floyd-Warshall All-Pairs Shortest Path Algorithm ===
Enter number of vertices: 4
Enter adjacency matrix (-1 for no direct edge, 0 for self-loops):
0 3 8 7
-1 0 1 -1
-1 -1 0 2
-1 -1 -1 0

--- All-Pairs Shortest Distance Matrix ---
	V0	V1	V2	V3	
V0	0	3	4	6	
V1	INF	0	1	3	
V2	INF	INF	0	2	
V3	INF	INF	INF	0	
```
*(Notice how the path from V0 to V2 improved from 8 (direct) to 4 via V0 -> V1 -> V2).*
