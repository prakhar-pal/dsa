import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionT1LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() != 0){
            Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
            List<Integer> row = new ArrayList<>();
            while(queue.size() !=0){
                TreeNode node =  queue.poll();
                row.add(node.val);
                if (node.left != null)
                    nextQueue.add(node.left);
                if (node.right != null)
                    nextQueue.add(node.right);
            }
            queue = nextQueue;
            list.add(row);
        }
        return list;
    }
}

class T1LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SolutionT1LevelOrderTraversal sol = new SolutionT1LevelOrderTraversal();
        List<List<Integer>> list = sol.levelOrder(root);
        for(List<Integer> row : list){
            for(int value: row){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}