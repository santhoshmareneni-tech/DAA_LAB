# Practical 09: Implementation of Prim's Algorithm

## 📌 Objective
To implement Prim's algorithm for finding the **Minimum Spanning Tree (MST)** of a weighted, connected, undirected graph using a Greedy approach.

---

## 📖 Theoretical Background

### What is a Spanning Tree?
A Spanning Tree of a connected, undirected graph $G = (V, E)$ is a subgraph that includes all $V$ vertices and is a tree (acyclic and connected) having exactly $V - 1$ edges.

### Minimum Spanning Tree (MST)
An MST is a spanning tree whose sum of edge weights is minimized.

### How Prim's Algorithm Works (Greedy Method)
Prim's algorithm grows an MST single edge at a time starting from an arbitrary root vertex:
1. Maintain two sets of vertices:
   - Set $S$: Vertices already included in the MST.
   - Set $V - S$: Vertices not yet included in the MST.
2. At every step, find the minimum weight edge $(u, v)$ crossing the cut $(S, V - S)$, where $u \in S$ and $v \in V - S$.
3. Add vertex $v$ to $S$ and add edge $(u, v)$ to the MST.
4. Repeat until all $V$ vertices are in $S$ ($V - 1$ edges added).

---

## 📊 Complexity Analysis

| Representation | Time Complexity | Space Complexity |
| :--- | :---: | :---: |
| **Adjacency Matrix (Implemented)** | $O(V^2)$ | $O(V)$ |
| **Adjacency List + Binary Heap / Priority Queue** | $O((V + E) \log V)$ | $O(V + E)$ |
| **Adjacency List + Fibonacci Heap** | $O(E + V \log V)$ | $O(V + E)$ |

- **Best Suited For:** **Dense graphs** (where $E \approx V^2$), where the $O(V^2)$ adjacency matrix version is asymptotically optimal.

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `PrimMST.java` | Complete Prim's algorithm implementation using adjacency matrix, printing individual MST edges and total minimum weight. |

---

## 🚀 How to Compile and Run

```bash
javac PrimMST.java
java PrimMST
```

---

## 💻 Sample Execution

### Sample Graph:
```text
      2
 (0)-----(1)
  | \     |
 6|  8\   |3
  |     \ |
 (2)-----(3)
      5
```

**Adjacency Matrix:**
```text
0 2 6 8
2 0 0 3
6 0 0 5
8 3 5 0
```

### Execution Output:
```text
=== Prim's Algorithm for Minimum Spanning Tree (MST) ===
Enter number of vertices: 4
Enter weighted adjacency matrix (0 for no edge):
0 2 6 8
2 0 0 3
6 0 0 5
8 3 5 0

--- Minimum Spanning Tree (Edges and Weights) ---
Edge 		 Weight
------------------------
0 - 1	:	2
1 - 3	:	3
3 - 2	:	5
------------------------
Total Minimum Cost: 10
```
