import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
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

class SolutionT6TreeFromInorderPreorder {
    private int[] toArray(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length <= 1) {
            if(inorder.length == 1){
                return new TreeNode(inorder[0]);
            }else return null;
        }else {
            int rootValue = preorder[0];
            TreeNode root = new TreeNode(rootValue);
            ArrayList<Integer> leftInorder = new ArrayList<>();
            ArrayList<Integer> rightInorder = new ArrayList<>();
            ArrayList<Integer> leftPreorder = new ArrayList<>();
            ArrayList<Integer> rightPreorder = new ArrayList<>();
            int rootIndexInorder = -1;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i] == rootValue){
                    rootIndexInorder = i;
                }else if(rootIndexInorder == -1){
                    leftInorder.add(inorder[i]);
                }else {
                    rightInorder.add(inorder[i]);
                }
            }
            for(int i=1;i<preorder.length;i++){
                if (i <= leftInorder.size()) {
                    leftPreorder.add(preorder[i]);
                }else {
                    rightPreorder.add(preorder[i]);
                }
            }
            root.left = this.buildTree(toArray(leftPreorder), toArray(leftInorder));
            root.right = this.buildTree(toArray(rightPreorder), toArray(rightInorder));
            return root;
        }
    }
}

public class T6TreeFromInorderPreorder {
    public static void printSequence(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size() != 0){
            TreeNode node = q.poll();
            String res = node != null ? node.val+"" : "null";
            System.out.print(res+ " ");
            if(node != null){
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int inorder[] = {9,3,15,20,7};
        int preorder[] = {3,9,20,15,7};
        SolutionT6TreeFromInorderPreorder sol = new SolutionT6TreeFromInorderPreorder();
        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println("priting the result:");
        printSequence(root);
    }
}