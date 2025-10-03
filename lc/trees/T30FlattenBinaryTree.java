package lc.trees;

import java.util.ArrayList;
import java.util.List;

class T30FlattenBinaryTree {
    public static void main(String[] args) {
        T30Solution sol = new T30Solution();

        TreeNode node = TreeNode.createTree(new Integer[]{ 1,2,5,3,4,null,6});
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode currentNode= node;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.right;
        }
        sol.flatten(node);
        node.printLevelOrder();
        List<Integer> result = List.of(new Integer[] {1, 2, 3,4,5,6});
        assert list.equals(result);
    }
}

class T30Solution {
    public void flatten(TreeNode root) {
        flattenUtil(root);
    }
    private TreeNode flattenUtil(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        TreeNode currentNode = node;
        if(left != null) {
            TreeNode leftFlatten = flattenUtil(left);
            currentNode.right = left;
            currentNode = leftFlatten; 
        }
        if(right != null) {
            TreeNode rightFlatten = flattenUtil(right);
            currentNode.right = right;
            currentNode = rightFlatten; 
        }
        return currentNode;
    }
}