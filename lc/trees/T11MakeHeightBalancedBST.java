package lc.trees;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 */
public class T11MakeHeightBalancedBST {
    public static void main(String[] args) {
        T11Solution sol = new T11Solution();
        // sol.sortedArrayToBST(new int[]{}).printLevelOrder();
        sol.sortedArrayToBST(new int[]{1}).printLevelOrder();
        sol.sortedArrayToBST(new int[]{ 1,3 }).printLevelOrder();
        sol.sortedArrayToBST(new int[]{ -10,-3,0,5,9 }).printLevelOrder();
    }
}


class T11Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
