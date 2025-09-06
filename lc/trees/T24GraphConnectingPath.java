package lc.trees;

class T24GraphConnectingPath {

    public static void main(String[] args) {
        T24Solution sol = new T24Solution();
        assert sol.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2);
        assert sol.validPath(3, new int[][]{{0,1}}, 0, 2) == false;
        assert sol.validPath(10, new int[][] {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}}, 7, 5);
    }
}

class T24Solution {

    public boolean validPath(
        int n,
        int[][] edges,
        int source,
        int destination
    ) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int[] edge: edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            union(parent, e1, e2);
        }
        int sourceParent = findParent(parent, source);
        int destinationParent = findParent(parent, destination);
        return sourceParent == destinationParent;
        
    }

    int findParent(int[] parent, int id) {
        if(parent[id] != id) {
            parent[id] = findParent(parent, parent[id]);
        }
        return parent[id];
    }

    boolean union(int [] parent, int n1, int n2) {
        int parent1 = findParent(parent, n1);
        int parent2 = findParent(parent, n2);
        if(parent1 != parent2) {
            if(parent1 > parent2) {
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
