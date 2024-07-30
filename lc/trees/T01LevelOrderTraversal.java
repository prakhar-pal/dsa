package  lc.trees;
import java.util.*;

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

public class T01LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        T01LevelOrderTraversal traversal = new T01LevelOrderTraversal();
        traversal.traverseAndPrint(root);
    }

    public void traverseAndPrint(TreeNode root) {
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
