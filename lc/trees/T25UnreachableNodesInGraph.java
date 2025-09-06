package lc.trees;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import lc.utils.StringUtils;
import lc.utils.Clogger;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description
class T25UnreachableNodesInGraph {
  public static void main(String[] args) {
    T25Solution sol = new T25Solution();
    assert sol.countPairs(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }) == 0;
    assert sol.countPairs(7, new int[][] { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } }) == 14;
  }
}

class T25Solution {
  class UnionFind {
    public int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int id) {
      if (parent[id] != id) {
        parent[id] = find(parent[id]);
      }
      return parent[id];
    }

    boolean union(int n1, int n2) {
      int parent1 = find(n1);
      int parent2 = find(n2);
      if (parent1 != parent2) {
        if (parent1 > parent2) {
          int tempParent = parent1;
          parent1 = parent2;
          parent2 = tempParent;
        }
        parent[parent2] = parent1;
        return true;
      }
      return false;
    }
  }

  public long countPairs(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }
    HashMap<Integer, Integer> connectedComponentsByParent = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int parent = uf.find(i);
      connectedComponentsByParent.put(parent, connectedComponentsByParent.getOrDefault(parent, 0) + 1);
    }
    List<Integer> counts = new ArrayList<>();
    for (int key : connectedComponentsByParent.keySet()) {
      counts.add(connectedComponentsByParent.get(key));
    }
    long total = 0, sumOfSquares = 0, sumOfCounts = 0;
    for (int i = 0; i < counts.size(); i++) {
      sumOfSquares += (long) counts.get(i) * (long) counts.get(i);
      sumOfCounts += (long) counts.get(i);
    }
    total = (sumOfCounts * sumOfCounts - sumOfSquares)/2;
    return total;
  }
}
