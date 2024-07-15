package lc.trees;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class T16MaxBinaryTreePathSum {
    public static void main(String[] args) {
        T16Solution solution = new T16Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        assert solution.maxPathSum(root1) == 6;

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        assert solution.maxPathSum(root2) == 42;

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(-1);
        assert solution.maxPathSum(root3) == 2;

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(-2);
        root4.right = new TreeNode(3);
        assert solution.maxPathSum(root4) == 4;

        TreeNode root5 = new TreeNode(5);
        root5.left = new TreeNode(4);
        root5.right = new TreeNode(8);
        root5.left.left = new TreeNode(11);
        root5.left.left.left = new TreeNode(7);
        root5.left.left.right = new TreeNode(2);
        root5.right.left = new TreeNode(13);
        root5.right.left.right = new TreeNode(1);
        root5.right.right = new TreeNode(4);
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
