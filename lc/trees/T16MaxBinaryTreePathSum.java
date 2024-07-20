package lc.trees;

import lc.ArraysAndStrings.ArrayUtils;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class T16MaxBinaryTreePathSum {
    public static void main(String[] args) {
        T16Solution solution = new T16Solution();

        TreeNode root1 = TreeNode.createTree(ArrayUtils.arrayToList(new Integer[] {1,2,3}));
        assert solution.maxPathSum(root1) == 6;
        
        TreeNode root2 = TreeNode.createTree(ArrayUtils.arrayToList(new Integer[] {-10,9,20, null, null, 15, 7}));
        assert solution.maxPathSum(root2) == 42;

        TreeNode root3 = TreeNode.createTree(ArrayUtils.arrayToList(new Integer[] {2, -1}));
        assert solution.maxPathSum(root3) == 2;

        TreeNode root4 = TreeNode.createTree(ArrayUtils.arrayToList(new Integer[] {1, -2, 3}));
        assert solution.maxPathSum(root4) == 4;

        TreeNode root5 = TreeNode.createTree(ArrayUtils.arrayToList(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}));
        assert solution.maxPathSum(root5) == 49;
    }
}

class T16Solution {
    private int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        mps(root);
        return maxValue;
    }
    private int max(int... vals) {
        int maxValue = Integer.MIN_VALUE;
        for(int val: vals) {
            maxValue = Math.max(val, maxValue);
        }
        return maxValue;
    }
    private int mps(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftValue = mps(root.left);
        int rightValue =  mps(root.right);
        int value = root.val + leftValue + rightValue;
        maxValue = max(maxValue, value, root.val, root.val + leftValue, root.val + rightValue);
        return Math.max(root.val + Math.max(rightValue, leftValue), root.val);
    }
}
