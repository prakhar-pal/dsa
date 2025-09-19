package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lc.utils.ArrayUtils;

// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
class T23MstCriticalEdges {

  public static void main(String[] args) {
    T23Solution sol = new T23Solution();
    assert Arrays.deepEquals(ArrayUtils.to2DArray(sol.findCriticalAndPseudoCriticalEdges(5,
        new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 0, 3, 2 }, { 0, 4, 3 }, { 3, 4, 3 },
            { 1, 4, 6 } }),
        Integer.class),
        new Integer[][] { { 0, 1 }, { 2, 3, 4, 5 } });
  }
}

class T23Solution {

  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
      int n,
      int[][] edges) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      result.add(new ArrayList<>());
    }

    // calculates MST weight
    // 1. store edges' index in the array as well
    for (int i = 0; i < edges.length; i++) {
      // original edge length = 3 (to, from, weight)
      // new edge length = 4 (to, from, weight, index)
      int[] newEdge = new int[4];
      for (int j = 0; j < edges[i].length; j++) {
        newEdge[j] = edges[i][j];
      }
      newEdge[3] = i;
      edges[i] = newEdge;
    }
    // 2. UnionFind algorithm
    Arrays.sort(edges, Comparator.comparingInt(a -> a[2])); // sort by weight
    int mstWeight = 0;
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
      if (uf.union(edge[0], edge[1])) {

        mstWeight += edge[2];
      }
    }

    // Checks whether an edge is critical/pseudo critical
    for (int[] currentEdge : edges) {
      // Build MST without current edge to check whether it's critical
      uf = new UnionFind(n);
      int weightWithoutEdge = 0;
      for (int[] edge : edges) {
        if (edge[3] != currentEdge[3] && uf.union(edge[0], edge[1])) {
          weightWithoutEdge += edge[2];
        }
      }
      if (uf.getComponents() > 1 || (uf.getComponents() == 1 && mstWeight < weightWithoutEdge)) {
        result.get(0).add(currentEdge[3]);
        continue;
      }

      // If upon forcing an edge, the MST weight remains the same, the edge is pseudo
      // critical
      uf = new UnionFind(n);
      int weightWithEdge = currentEdge[2];
      uf.union(currentEdge[0], currentEdge[1]);
      for (int[] edge : edges) {
        if (edge[3] != currentEdge[3] && uf.union(edge[0], edge[1])) {
          weightWithEdge += edge[2];
        }
      }
      if (weightWithEdge == mstWeight) {
        result.get(1).add(currentEdge[3]);
      }
    }
    return result;
  }

  class UnionFind {
    private int[] rank;
    private int components; // connected components

    public UnionFind(int n) {
      rank = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        rank[i] = -1;
      }
      this.components = n;
    }

    int find(int id) {
      if (rank[id] >= 0) {
        rank[id] = find(rank[id]);
        return rank[id];
      }
      return id;
    }

    public int getComponents() {
      return components;
    }

    boolean union(int n1, int n2) {
      int parent1 = find(n1);
      int parent2 = find(n2);
      if (parent1 != parent2) {
        if (Math.abs(rank[parent1]) < Math.abs(rank[parent2])) {
          int tempParent = parent1;
          parent1 = parent2;
          parent2 = tempParent;
        }
        int rankParent2 = rank[parent2];
        rank[parent2] = parent1;
        rank[parent1] += rankParent2;
        this.components--;
        return true;
      }
      return false;
    }
  }
}
