# Practical 04: Implementation and Time Analysis of Factorial Program

## 📌 Objective
To implement the Factorial computation using both **Iterative** and **Recursive** approaches, and to compare their time and space complexities.

---

## 📖 Theoretical Background

The factorial of a non-negative integer $n$, denoted by $n!$, is the product of all positive integers less than or equal to $n$:
$$n! = \begin{cases} 1 & \text{if } n = 0 \text{ or } n = 1 \\ n \times (n - 1)! & \text{if } n > 1 \end{cases}$$

### 1. Iterative Approach
- Uses an explicit `for` or `while` loop multiplying numbers sequentially from $1$ to $n$.
- No recursive function calls or stack frames are added.
- **Space Complexity:** $O(1)$ auxiliary space.

### 2. Recursive Approach
- Uses the mathematical definition where `fact(n) = n * fact(n - 1)` with base condition `n <= 1`.
- Each invocation allocates a new stack frame (activation record) on the call stack until reaching the base case.
- **Space Complexity:** $O(n)$ stack space.

---

## 📊 Complexity Comparison Table

| Feature | Iterative Method | Recursive Method |
| :--- | :---: | :---: |
| **Time Complexity** | $O(n)$ | $O(n)$ |
| **Auxiliary Space Complexity** | $O(1)$ | $O(n)$ (Stack frames) |
| **Function Call Overhead** | None | Yes (each recursion level) |
| **Stack Overflow Risk** | No | Yes (for very large $n$) |
| **Code Structure** | Loop-based | Base case + Self-calling |

---

## 📁 Source Files in this Folder

| File | Description |
| :--- | :--- |
| `FactorialIterative.java` | Computes factorial using an iterative loop with execution timing. |
| `FactorialRecursive.java` | Computes factorial recursively with execution timing. |
| `FactorialComparison.java` | Side-by-side benchmark comparing runtime performance and stack behavior. |

---

## 🚀 How to Compile and Run

### Running Iterative:
```bash
javac FactorialIterative.java
java FactorialIterative
```

### Running Recursive:
```bash
javac FactorialRecursive.java
java FactorialRecursive
```

### Running Comparison:
```bash
javac FactorialComparison.java
java FactorialComparison
```

---

## 💻 Sample Execution

```text
=====================================================
   Iterative vs Recursive Factorial Time Analysis    
=====================================================
Enter an integer n (e.g. 15): 10

Results for n = 10:
Computed Value: 3628800
Method          | Execution Time (ns) | Space Complexity
---------------------------------------------------------
Iterative       | 400                | O(1)           
Recursive       | 700                | O(n) Call Stack
=========================================================

Analysis Note:
- Iterative uses a simple loop with O(1) auxiliary space and avoids function call overhead.
- Recursive uses O(n) activation records on the call stack, potentially risking StackOverflowError for very large n.
```
