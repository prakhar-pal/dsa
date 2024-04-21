package lc.trees;
import java.util.*;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class T10ValidateBST {
    public static void main(String[] args) {
        T10Solution sol = new T10Solution();
        Integer[] arr1 = new Integer[]{2,1,3};
        assert sol.isValidBST(TreeUtils.createTree(arr1));
        Integer[] arr2 = new Integer[]{};
        assert sol.isValidBST(TreeUtils.createTree(arr2));
        Integer[] arr3 = new Integer[]{5,1,4, null, null, 3, 6};
        assert sol.isValidBST(TreeUtils.createTree(arr3)) == false;
        Integer[] arr4 = new Integer[]{5,4,6,null,null,3,7};
        assert sol.isValidBST(TreeUtils.createTree(arr4)) == false;
        Integer[] arr5 = new Integer[]{2,2,2};
        assert sol.isValidBST(TreeUtils.createTree(arr5)) == false;
    }
}

class T10Solution {
    private List<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        inOrderTraversalAndPopulateList(root);
        for(int i=1;i<list.size();i++) {
            if(list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return true;
    }
    private void inOrderTraversalAndPopulateList(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversalAndPopulateList(root.left);
        list.add(root.val);
        inOrderTraversalAndPopulateList(root.right);
    }
}

/**
 * taken from submissions page
 */
class T10SolutionTwo {
    private boolean isBST(TreeNode root, Integer min, Integer max){
        // Base case
        if(root == null){
            return true;
        }
        
        // Check if the current node's value is within the valid range
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        
        // Recursively check left and right subtrees
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
}
