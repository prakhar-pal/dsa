package lc.random;
import java.util.*;

import lc.trees.*;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 */
public class R16MinAbsoluteDifferenceBST {
    public static void main(String[] args) {
        R16Solution solution = new R16Solution();

        TreeNode tree0 = TreeNode.createTree(new Integer[] {4,2});
        assert solution.getMinimumDifference(tree0) == 2;

        TreeNode tree1 = TreeNode.createTree(new Integer[] {4,2,6,1,3});
        assert solution.getMinimumDifference(tree1) == 1;

        TreeNode tree2 = TreeNode.createTree(new Integer[] {1,0,48,null,null,12,49});
        assert solution.getMinimumDifference(tree2) == 1;

        TreeNode tree3 = TreeNode.createTree(new Integer[] {236,104,701,null,227,null,911});
        assert solution.getMinimumDifference(tree3) == 9;

        TreeNode tree4 = TreeNode.createTree(new Integer[] {600,424,612,null,499,null,689});
        assert solution.getMinimumDifference(tree4) == 12;

        TreeNode tree5 = TreeNode.createTree(new Integer[] { 0, null, 2236, null, null, 1277, 2776, null, null, null, null, 519 });
        assert solution.getMinimumDifference(tree5) == 519;
    }
}


class R16Solution {
    private int minValue;
    private TreeNode prev;
    public int getMinimumDifference(TreeNode node) {
        this.minValue = Integer.MAX_VALUE;
        prev = null;
        gmdUtil4(node);
        return this.minValue;
    }

    private void gmdUtil4(TreeNode node) {
        /* use inorder traversal to find the difference between previous and current element*/
        if(node == null) {
            return;
        }
        gmdUtil4(node.left);
        if(this.prev != null) {
            this.minValue = Math.min(this.minValue, node.val - prev.val);
        }
        this.prev = node;
        gmdUtil4(node.right);
    }

    private void gmdUtil3(TreeNode node) {
        /** beats 12.79% */
        List<Integer> sorted = convertToSortedList(node);
        for(int i=1;i<sorted.size();i++) {
            minValue = Math.min(minValue, sorted.get(i) - sorted.get(i-1));
        }
    }
    private List<Integer> convertToSortedList(TreeNode node) {
        List<Integer> resultList = new ArrayList<>();
        if(node != null) {
            List<Integer> leftResult = convertToSortedList(node.left);
            List<Integer> rightResult = convertToSortedList(node.right);
            resultList.addAll(leftResult);
            resultList.add(node.val);
            resultList.addAll(rightResult);
        }
        return resultList;
    }

    // private int min(int ...nums) {
    //     int resultMin = Integer.MAX_VALUE;
    //     for(int num: nums) {
    //         resultMin = Math.min(num, resultMin);
    //     }
    //     return resultMin;
    // }

    // public int[] gmdUtil2(TreeNode node) {
    //     int[] result = new int[2];
    //     int leftValue = node.val, rightValue = node.val;
    //     if(node.left != null) {
    //         int[] leftResult = gmdUtil2(node.left);
    //         leftValue = leftResult[1];
    //     }
    //     if(node.right != null) {
    //         int[] rightResult = gmdUtil2(node.right);
    //         rightValue = rightResult[0];
    //     }
    //     minValue = min(
    //         minValue,
    //         node.left != null ? Math.abs(node.val - leftValue): Integer.MAX_VALUE,
    //         node.right != null ? Math.abs(node.val - rightValue): Integer.MAX_VALUE
    //     );
    //     result[0] = leftValue;
    //     result[1] = rightValue;
    //     return result;
    // }
}
