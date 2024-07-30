package lc.random;
import java.util.*;
import lc.trees.TreeNode;
import lc.trees.T01LevelOrderTraversal;

/**
 * https://leetcode.com/problems/invert-binary-tree/description 
 */
public class R13InvertBinaryTree {
  public static void main(String[] args) {
    T01LevelOrderTraversal loTraversal = new T01LevelOrderTraversal();
    R13Solution solution = new R13Solution();

    List<Integer> tree1 = List.of(4,2,7,1,3,6,9);
    loTraversal.traverseAndPrint(solution.invertTree(TreeNode.createTree(tree1)));
    
    List<Integer> tree2 = List.of(2,1,3);
    loTraversal.traverseAndPrint(solution.invertTree(TreeNode.createTree(tree2)));
  }  
}

class R13Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if(node == null) {
                continue;
            }
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }
}
