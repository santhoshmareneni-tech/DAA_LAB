# Practical 10: Implementation of Kruskal's Algorithm

## 📌 Objective
To implement Kruskal's algorithm for finding the **Minimum Spanning Tree (MST)** of a connected, weighted, undirected graph using a Greedy approach and the **Disjoint Set Union (DSU / Union-Find)** data structure.

---

## 📖 Theoretical Background

### How Kruskal's Algorithm Works
Kruskal's algorithm builds the MST edge by edge by processing edges in non-decreasing order of weights:
1. **Sort Edges:** Sort all $E$ edges of the graph in non-decreasing order of their weights.
2. **Initialize Forest:** Treat each vertex as an isolated tree/set in a disjoint-set forest.
3. **Pick Edges Greedily:** Iterate through the sorted edges:
   - For edge $(u, v)$, find the representative root of $u$ and $v$ using `find()`.
   - If `find(u) != find(v)`, adding edge $(u, v)$ **does not create a cycle**.
   - Add edge $(u, v)$ to the MST, merge the sets using `union()`, and add its weight to the total cost.
   - If `find(u) == find(v)`, discard the edge because it forms a cycle.
4. **Termination:** Stop when $V - 1$ edges are added to the MST or all edges are processed.

---

## 📊 Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :---: | :--- |
| **Edge Sorting** | $O(E \log E)$ or $O(E \log V)$ | Dominant step in Kruskal's algorithm. |
| **Disjoint Set Operations** | $O(E \cdot \alpha(V))$ | Almost linear using path compression ($\alpha$ is the Inverse Ackermann function). |
| **Overall Time Complexity** | $O(E \log E)$ | Equivalent to $O(E \log V)$ since $E \le V^2 \implies \log E \le 2 \log V$. |
| **Space Complexity** | $O(V + E)$ | For storing edges and the parent array of the disjoint set. |
| **Best Suited For:** | **Sparse graphs** ($E \ll V^2$) | Faster than Prim's matrix implementation when $E$ is small. |

---

## ⚖️ Prim's vs Kruskal's Comparison

| Feature | Prim's Algorithm | Kruskal's Algorithm |
| :--- | :--- | :--- |
| **Strategy** | Grows a single tree starting from a vertex | Grows multiple trees (forest) and joins them |
| **Core Structure** | Priority Queue / Key array | Disjoint Set Union (DSU / Union-Find) |
| **Time Complexity** | $O(V^2)$ (matrix) or $O((V+E)\log V)$ | $O(E \log E)$ |
| **Preferred For** | Dense graphs ($E \approx V^2$) | Sparse graphs ($E \ll V^2$) |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `KruskalMST.java` | Complete Kruskal's implementation using Disjoint Set with path compression, printing all chosen edges and total cost. |

---

## 🚀 How to Compile and Run

```bash
javac KruskalMST.java
java KruskalMST
```

---

## 💻 Sample Execution

### Sample Graph (4 vertices):
```text
      10
 (0)------(1)
  | \      |
 6|  \5    |15
  |    \   |
 (2)------(3)
       4
```

**Weighted Adjacency Matrix:**
```text
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0
```

### Execution Output:
```text
=== Kruskal's Algorithm for Minimum Spanning Tree (MST) ===
Enter number of vertices: 4
Enter weighted adjacency matrix (0 for no edge):
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0

--- Minimum Spanning Tree (Edges and Weights) ---
Edge 		 Weight
------------------------
2 - 3	:	4
0 - 3	:	5
0 - 1	:	10
------------------------
Total Minimum Cost: 19
```
