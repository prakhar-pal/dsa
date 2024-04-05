package lc.BinarySearch;

public class BinaryTreeUtils {
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
}
