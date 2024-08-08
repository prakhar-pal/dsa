package lc.random;
import java.util.*;

import lc.trees.TreeNode;

public class R28SameTree {
    public static void main(String[] args) {
        R28Solution solution = new R28Solution();
        assert solution.isSameTree(TreeNode.createTree(List.of(1, 2, 3)), TreeNode.createTree(List.of(1, 2, 3)));
        assert solution.isSameTree(TreeNode.createTree(List.of(1, 2)), TreeNode.createTree(List.of(1, null, 2)));
        assert solution.isSameTree(TreeNode.createTree(List.of(1, 2, 1)), TreeNode.createTree(List.of(1, 1, 2)));
    }
}

class R28Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (q == null && p != null)) {
            return false;
        }
        if(p == q) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
