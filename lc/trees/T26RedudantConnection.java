package lc.trees;

import lc.ArraysAndStrings.ArrayUtils;

class T26RedundantConnection {
  public static void main(String[] args) {
  	T26Solution sol = new T26Solution();
  	assert ArrayUtils.isSame1DArray(sol.findRedundantConnection(new int[][] {{1,2},{1,3},{2,3}}),  new int[] {2,3});
  	assert ArrayUtils.isSame1DArray(sol.findRedundantConnection(new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}}), new int[] {1,4});
  }
}

class T26Solution {

  class UnionFind {
      public int[] rank;

      public UnionFind(int n) {
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
          rank[i] = -1;
        }
      }

      int find(int id) {
        if (rank[id] >= 0) {
          rank[id] = find(rank[id]);
          return rank[id];
        }
        return id;
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
          return true;
        }
        return false;
      }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge: edges) {
          if(!uf.union(edge[0], edge[1])) {
            return edge;
          }
        }
        return new int[]{};
    }
}
