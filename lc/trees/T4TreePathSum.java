class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return this.val + "";
    }
}

class SolutionT4TreePathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // System.out.println("target sum:" + targetSum + root == null ? "null" : "searching at: " + root.val);
        if(root == null) return false;
        if(root.val == targetSum && root.left == null && root.right == null) return true;
        return this.hasPathSum(root.left, targetSum - root.val) || this.hasPathSum(root.right, targetSum - root.val);
    }
}
public class T4TreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        //swap right and left nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        SolutionT4TreePathSum sol = new SolutionT4TreePathSum();
        int sum = 22;
        System.out.println("has sum path:" + sol.hasPathSum(root, sum));
    }
}
