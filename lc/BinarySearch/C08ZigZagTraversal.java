package lc.BinarySearch;
import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */

public class C08ZigZagTraversal {
    public static TreeNode createBinaryTree(Integer[] arr, int index) {
        if(index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode head = new TreeNode(arr[index]);
        head.left = createBinaryTree(arr, 2*index + 1);
        head.right = createBinaryTree(arr, 2*index + 2);
        createBinaryTree(arr, index+1);
        return head;
    }
    public static void main(String [] args) {
        C08Solution sol = new C08SolutionOne();
        List<List<Integer>> result1 = new ArrayList<>();
        List<Integer> result1List1 = new ArrayList<>();
        result1List1.add(1);
        // result1.add(result1List1);
        assert sol.zigzagLevelOrder(null).equals(result1);

        TreeNode root2 = createBinaryTree(new Integer[] {3,9,20,null,null,15,7}, 0);
        List<List<Integer>> result2 = new ArrayList<>();

        List<Integer> result2List1 = new ArrayList<>();
        result2List1.add(3);

        List<Integer> result2List2 = new ArrayList<>();
        result2List2.add(20);
        result2List2.add(9);

        List<Integer> result2List3 = new ArrayList<>();
        result2List3.add(15);
        result2List3.add(7);

        result2.add(result2List1);
        result2.add(result2List2);
        result2.add(result2List3);
        assert sol.zigzagLevelOrder(root2).equals(result2);

    }
}

interface C08Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root);
}

class C08SolutionOne implements C08Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<TreeNode> listToProcess = new ArrayList<>();
        List<TreeNode> nextListToProcess = new ArrayList<>();
        if(root == null) {
            return list;
        }
        listToProcess.add(root);
        int index = 0;
        while(listToProcess.size() != 0) {
            List<Integer> row = new ArrayList<>();
            for(TreeNode node: listToProcess) {
                if(node.left != null) {
                    nextListToProcess.add(node.left);
                }
                if(node.right != null) {
                    nextListToProcess.add(node.right);
                }
                row.add(node.val);
            }
            if(index % 2 == 1) {
                row = row.reversed();
            }
            list.add(row);
            listToProcess = nextListToProcess;
            nextListToProcess = new ArrayList<>();
            index++;
        }
        return list;
    }
}
