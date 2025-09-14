package lc.trees;

import java.util.LinkedList;
import java.util.Queue;

class T33ConstructQuadTree {
    public static void main(String[] args) {
        T33Solution sol = new T33Solution();
        int[][] grid = new int[][] {{0,1}, {0,1}};
        T33Solution.Node node = sol.construct(grid);
        sol.levelOrder(node);
    }

}

class T33Solution {

    public void levelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Queue<Node> nq = new LinkedList<>();
            while(!q.isEmpty()) {
                Node cn = q.poll();
                if(cn != null) {
                    nq.add(cn.topLeft);
                    nq.add(cn.topRight);
                    nq.add(cn.bottomLeft);
                    nq.add(cn.bottomRight);
                    System.out.print("(val=" + cn.val + " isLeaf=" + cn.isLeaf + ")\t");
                }
                System.out.println();
            }
            q = nq;
        }
    }
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return constructUtil(grid, 0, grid[0].length - 1, 0, grid.length - 1).first;
    }

    private Node constructLeafNode(boolean val) {
        return new Node(val, true);
    }

    class Pair<T1,T2> {
        T1 first;
        T2 second;
        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    enum MadeOf {
        ONES,
        ZEROS,
        MIXED
    }

    private Pair<Node, MadeOf> constructUtil(int[][] grid, int row0, int row1, int col0, int col1) {
        if (row0 == row1 && col0 == col1) {
            // grid contains single cell
            return new Pair<Node, MadeOf>(constructLeafNode(grid[row0][col0] == 1), grid[row0][col0] == 1 ? MadeOf.ONES : MadeOf.ZEROS);
        } else {
            int gridSize = (row1 - row0 + 1);
            int rowh = row0 + gridSize / 2 - 1;
            int colh = col0 + gridSize / 2 - 1;
            Pair<Node, MadeOf> tlResult = constructUtil(grid, row0, rowh, col0, colh);
            Node tlNode = tlResult.first;
            Pair<Node, MadeOf> trResult = constructUtil(grid, row0, rowh, colh + 1, col1);
            Node trNode = trResult.first;
            Pair<Node, MadeOf> blResult = constructUtil(grid, rowh + 1, row1, col0, colh); 
            Node blNode = blResult.first;
            Pair<Node, MadeOf> brResult = constructUtil(grid, rowh + 1, row1, colh + 1, col1);
            Node brNode = brResult.first;
            if (tlResult.second == MadeOf.ONES && trResult.second == MadeOf.ONES && blResult.second == MadeOf.ONES && brResult.second == MadeOf.ONES
                    || (tlResult.second == MadeOf.ZEROS && trResult.second == MadeOf.ZEROS && blResult.second == MadeOf.ZEROS && brResult.second == MadeOf.ZEROS)) {
                // all have 1's or 0's
                return new Pair<Node, MadeOf>(constructLeafNode(tlNode.val), tlResult.second);
            } else {
                Node result = new Node(true, false);
                result.topLeft = tlNode;
                result.topRight = trNode;
                result.bottomLeft = blNode;
                result.bottomRight = brNode;
                return new Pair<Node, MadeOf>(result, MadeOf.MIXED);
            }
        }
    }
}