import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TSP {

    static int n;
    static int[][] costMatrix;
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> bestTour = new ArrayList<>();

    // Backtracking function to solve Travelling Salesperson Problem
    public static void tspBacktrack(int currCity, int count, int currentCost, boolean[] visited, List<Integer> currentTour) {
        // If all cities have been visited
        if (count == n) {
            // Check if there is an edge back to the starting city (city 0)
            if (costMatrix[currCity][0] != 0) {
                int totalTourCost = currentCost + costMatrix[currCity][0];
                if (totalTourCost < minCost) {
                    minCost = totalTourCost;
                    bestTour = new ArrayList<>(currentTour);
                    bestTour.add(0); // Complete cycle back to start
                }
            }
            return;
        }

        // Try visiting all other unvisited adjacent cities
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (!visited[nextCity] && costMatrix[currCity][nextCity] != 0) {
                // Pruning / Branch & Bound condition: only explore if current path cost < minCost
                if (currentCost + costMatrix[currCity][nextCity] < minCost) {
                    visited[nextCity] = true;
                    currentTour.add(nextCity);

                    tspBacktrack(nextCity, count + 1, currentCost + costMatrix[currCity][nextCity], visited, currentTour);

                    // Backtrack
                    visited[nextCity] = false;
                    currentTour.remove(currentTour.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Travelling Salesperson Problem (TSP) using Backtracking ===");
        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        costMatrix = new int[n][n];
        System.out.println("Enter the cost adjacency matrix (" + n + " x " + n + ", 0 for no edge or self-loop):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        List<Integer> currentTour = new ArrayList<>();

        // Start tour from city 0
        visited[0] = true;
        currentTour.add(0);

        tspBacktrack(0, 1, 0, visited, currentTour);

        if (minCost == Integer.MAX_VALUE) {
            System.out.println("\nNo Hamiltonian cycle / valid tour exists.");
        } else {
            System.out.println("\n--- Optimal Tour Found ---");
            System.out.print("Optimal Path: ");
            for (int i = 0; i < bestTour.size(); i++) {
                System.out.print("City " + bestTour.get(i));
                if (i < bestTour.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
            System.out.println("Minimum Tour Cost: " + minCost);
        }

        sc.close();
    }
}
