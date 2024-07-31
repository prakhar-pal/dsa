package lc.random;

import java.util.*;
import lc.trees.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view
 */
public class R19BinaryTreeRightSideView {
    public static void main(String[] args) {
        R19Solution solution = new R19Solution();
        List<Integer> result1 = Arrays.asList(new Integer[] { 1, 3, 4 });
        assert solution.rightSideView(TreeNode.createTree(new Integer[] { 1, 2, 3, null, 5, null, 4 }))
                .equals(result1);
        List<Integer> result2 = Arrays.asList(new Integer[] { 1, 3 });
        assert solution.rightSideView(TreeNode.createTree(new Integer[] { 1, null, 3 }))
                .equals(result2);
        
        List<Integer> result3 = Arrays.asList(new Integer[] { 1, 2, 4, 5 });
        assert solution.rightSideView(TreeNode.createTree(new Integer[] { 1, 2, null, 3, 4, null, null, null, null, 5  }))
                .equals(result3);
        
        List<Integer> result4 = Arrays.asList(new Integer[] { 1, 3, 4 });
        assert solution.rightSideView(TreeNode.createTree(new Integer[] { 1,2,3,4 }))
                .equals(result4);
    }
}

class R19Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            List<TreeNode> level = List.of(root);
            rsvUtil(level, result);
        }
        return result;
    }
    private void rsvUtil(List<TreeNode> levelNodes, List<Integer> result) {
        if(levelNodes.size() > 0) {
            TreeNode lastNode = levelNodes.get(levelNodes.size() - 1);
            result.add(lastNode.val);
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for(TreeNode node: levelNodes) {
                if(node != null) {
                    if(node.left != null) {
                        nextLevelNodes.add(node.left);
                    }
                    if(node.right != null) {
                        nextLevelNodes.add(node.right);
                    }
                }
            }
            rsvUtil(nextLevelNodes, result);
        }
    }
}
