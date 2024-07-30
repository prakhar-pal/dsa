package lc.random;
import lc.trees.*;
import java.util.*;

/** https://leetcode.com/problems/count-complete-tree-nodes/ */
public class R14CountTreeNodes {
    public static void main(String[] args) {
        R14Solution solution = new R14Solution();

        List<Integer> list1 = List.of(1,2,3,4,5,6);
        TreeNode tree1 = TreeNode.createTree(list1);
        assert solution.countNodes(tree1) == 6;;

        List<Integer> list2 = List.of();
        TreeNode tree2 = TreeNode.createTree(list2);
        assert solution.countNodes(tree2) == 0;

    }
}

class R14Solution {
    /**
     * countNodesOne
     * when queue adds null nodes as well
     * beats 5% runtime, 92.19% memory 
     * when null nodes are ignored for adding it to the queue
     * beats 6.77% runtime, 98.70% memory 
     * 
     * countNodesTwo
     * beats 100% runtime, memory 22.14%
     * */

     public int countNodes(TreeNode root) {
        return countNodesOne(root);
     }
    public int countNodesOne(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root != null) {
            queue.add(root);
        }
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            count++;
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return count;
    }
    public int countNodesTwo(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + countNodesTwo(root.left) + countNodesTwo(root.right);
    }
}
