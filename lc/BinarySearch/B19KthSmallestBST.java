package lc.BinarySearch;
import java.util.*;

public class B19KthSmallestBST {
    public static void main(String[] args) {
        C09Solution sol = new C09SolutionOne();

        TreeNode head1 = BinaryTreeUtils.createBinaryTree(new Integer[] {3,1,4,null,2}, 0);
        assert sol.kthSmallest(head1, 1) == 1;

        TreeNode head2 = BinaryTreeUtils.createBinaryTree(new Integer[] {5,3,6,2,4,null,null,1}, 0);
        assert sol.kthSmallest(head2, 3) == 3;
    }
}

interface C09Solution {
    public int kthSmallest(TreeNode root, int k);
}

class C09SolutionOne implements C09Solution {
    List<Integer> inorderList;
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        return inorderList.get(k-1);
    }
}
