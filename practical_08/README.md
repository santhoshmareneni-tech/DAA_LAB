# Practical 08: Implementation of Graph and Searching (DFS and BFS)

## 📌 Objective
To implement graph representation using an Adjacency Matrix and execute both **Depth First Search (DFS)** and **Breadth First Search (BFS)** traversal techniques.

---

## 📖 Theoretical Background

### Graph Representation
A graph $G = (V, E)$ consists of a set of vertices $V$ and edges $E$. In this lab, graphs are represented using an **Adjacency Matrix** of size $V \times V$:
$$A[i][j] = \begin{cases} 1 & \text{if an edge exists between vertex } i \text{ and } j \\ 0 & \text{otherwise} \end{cases}$$

---

### 1. Breadth First Search (BFS)
- **Strategy:** Explores vertices level-by-level, visiting all immediate neighbors of the current vertex before moving deeper.
- **Data Structure Used:** First-In-First-Out (**FIFO Queue**).
- **Key Application:** Finds the shortest path in unweighted graphs, level-order traversal, cycle detection.
- **Algorithm:**
  1. Mark starting vertex $s$ as visited and enqueue it.
  2. While queue is not empty:
     - Dequeue front vertex $u$ and print it.
     - For each unvisited neighbor $v$ of $u$: mark $v$ as visited and enqueue $v$.

---

### 2. Depth First Search (DFS)
- **Strategy:** Traverses as far as possible down each branch before backtracking.
- **Data Structure Used:** Last-In-First-Out (**LIFO Stack** / System Call Stack via Recursion).
- **Key Application:** Topological sorting, detecting cycles in directed/undirected graphs, connected components, solving mazes.
- **Algorithm:**
  1. Mark current vertex $v$ as visited and print it.
  2. For each unvisited neighbor $w$ of $v$: recursively call DFS on $w$.

---

## 📊 Complexity Comparison Table

| Metric | BFS | DFS |
| :--- | :---: | :---: |
| **Data Structure** | Queue (FIFO) | Recursion / Stack (LIFO) |
| **Time Complexity (Adj Matrix)** | $O(V^2)$ | $O(V^2)$ |
| **Time Complexity (Adj List)** | $O(V + E)$ | $O(V + E)$ |
| **Space Complexity** | $O(V)$ (Queue + Visited) | $O(V)$ (Call Stack + Visited) |
| **Traversal Behavior** | Level-by-level (Wide) | Branch-by-branch (Deep) |
| **Shortest Path** | Yes (Unweighted graphs) | No guarantee |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `BFS.java` | Standalone Breadth First Search implementation using standard `java.util.Queue`. |
| `DFS.java` | Standalone Depth First Search implementation using recursion. |
| `GraphTraversal.java` | Unified class providing both DFS and BFS traversals from a given source vertex. |

---

## 🚀 How to Compile and Run

### Running BFS:
```bash
javac BFS.java
java BFS
```

### Running DFS:
```bash
javac DFS.java
java DFS
```

### Running Unified Graph Traversal:
```bash
javac GraphTraversal.java
java GraphTraversal
```

---

## 💻 Sample Execution

### Sample Input Graph (4 vertices):
```text
0 -- 1
|    |
2 -- 3
```

**Adjacency Matrix:**
```text
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0
```

### Execution Output:
```text
=== Graph Traversal (DFS and BFS) ===
Enter number of vertices: 4
Enter adjacency matrix (4 x 4):
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0
Enter starting vertex (0 to 3): 0

DFS Traversal: 0 1 3 2 
BFS Traversal: 0 1 2 3 
```
