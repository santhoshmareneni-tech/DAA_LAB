import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KruskalMST {

    // Represents a weighted undirected edge
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Compare edges based on their weight (ascending order)
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Disjoint Set (Union-Find) Data Structure
    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Each vertex is initially its own parent
            }
        }

        // Find root of set containing x with path compression
        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        // Union two sets
        void union(int rootX, int rootY) {
            parent[rootX] = rootY;
        }
    }

    // Computes MST using Kruskal's Algorithm
    public static void kruskalMST(int n, List<Edge> edges) {
        // Step 1: Sort all edges in non-decreasing order of weight
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(n);
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        // Step 2: Iterate through sorted edges and greedily pick edges that do not form a cycle
        for (Edge edge : edges) {
            int rootU = ds.find(edge.src);
            int rootV = ds.find(edge.dest);

            // If including this edge does not form a cycle
            if (rootU != rootV) {
                mstEdges.add(edge);
                totalCost += edge.weight;
                ds.union(rootU, rootV);

                // Stop early when MST has V - 1 edges
                if (mstEdges.size() == n - 1) {
                    break;
                }
            }
        }

        // Check if graph is connected
        if (mstEdges.size() != n - 1) {
            System.out.println("\nGraph is disconnected! Spanning tree does not cover all vertices.");
            return;
        }

        // Print constructed MST
        System.out.println("\n--- Minimum Spanning Tree (Edges and Weights) ---");
        System.out.println("Edge \t\t Weight");
        System.out.println("------------------------");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + "\t:\t" + edge.weight);
        }
        System.out.println("------------------------");
        System.out.println("Total Minimum Cost: " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Kruskal's Algorithm for Minimum Spanning Tree (MST) ===");
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.println("Enter weighted adjacency matrix (0 for no edge):");
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = sc.nextInt();
                // To avoid duplicate edges in undirected graph, consider only j > i
                if (j > i && weight != 0) {
                    edges.add(new Edge(i, j, weight));
                }
            }
        }

        kruskalMST(n, edges);

        sc.close();
    }
}
