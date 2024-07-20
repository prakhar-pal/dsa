package  lc.trees;
//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/

class SolutionT2TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
        return 0;
        else{
            return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
        }
    }
}
public class T02TreeMaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SolutionT2TreeMaxDepth sol = new SolutionT2TreeMaxDepth();
        System.out.println("max depth is:" + sol.maxDepth(root));
    }
}
