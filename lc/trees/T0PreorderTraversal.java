package  lc.trees;
import java.util.ArrayList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

class SolutionT0PreorderTraversal {
    private void ptUtil(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        ptUtil(root.left, list);
        ptUtil(root.right, list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ptUtil(root, list);
        return list;
    }
}

class T0PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.right.left = new TreeNode(3);
        SolutionT0PreorderTraversal sol = new SolutionT0PreorderTraversal();
        List<Integer> list = sol.preorderTraversal(root);
        for(Integer item : list){
            System.out.println(item);
        }
    }
}