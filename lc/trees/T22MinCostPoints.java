package lc.trees;

import java.util.HashSet;
import java.util.PriorityQueue;

class T22MinCostPoints {

    public static void main(String args[]) {
        T22Solution sol = new T22Solution();
        assert sol.minCostConnectPoints(
            new int[][] { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } }
        ) ==
        20;
        assert sol.minCostConnectPoints(
            new int[][] { { 3, 12 }, { -2, 5 }, { -4, 1 } }
        ) ==
        18;
        assert sol.minCostConnectPoints(
            new int[][] { { 2, -3 }, { -17, -8 }, { 13, 8 }, { -17, -15 } }
        ) ==
        53;
    }
}

class T22Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int edgeCost =
                    Math.abs(point1[0] - point2[0]) +
                    Math.abs(point1[1] - point2[1]);
                adj[i][j] = edgeCost;
                adj[j][i] = edgeCost;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        ); // heap of [cost, node]
        minHeap.add(new Integer[] { 0, 0 });
        int cost = 0;
        while (visited.size() != n) {
            Integer[] item = minHeap.poll();
            if (!visited.contains(item[1])) {
                visited.add(item[1]);
                cost += item[0];
                for (int j = 0; j < n; j++) {
                    if (!visited.contains(j)) {
                        minHeap.add(new Integer[] { adj[item[1]][j], j });
                    }
                }
            }
        }
        return cost;
    }
}
