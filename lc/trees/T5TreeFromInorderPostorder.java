package lc.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
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
//    @Override
//    public String toString() {
//        return this.val + "";
//    }
//}

class SolutionT5TreeFromInorderPostorder {
    private int[] toArray(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length <= 1) {
            if(inorder.length == 1){
                return new TreeNode(inorder[0]);
            }else return null;
        }else {
            int rootValue = postorder[postorder.length-1];
            TreeNode root = new TreeNode(rootValue);
            ArrayList<Integer> leftInorder = new ArrayList<>();
            ArrayList<Integer> rightInorder = new ArrayList<>();
            ArrayList<Integer> leftPostorder = new ArrayList<>();
            ArrayList<Integer> rightPostorder = new ArrayList<>();
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
            for(int i=0;i<postorder.length-1;i++){
                if (i < leftInorder.size()) {
                    leftPostorder.add(postorder[i]);
                }else {
                    rightPostorder.add(postorder[i]);
                }
            }
            root.left = this.buildTree(toArray(leftInorder), toArray(leftPostorder));
            root.right = this.buildTree(toArray(rightInorder), toArray(rightPostorder));
            return root;
        }
    }
}

public class T5TreeFromInorderPostorder {
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
        // int inorder[] = {9,3,15,20,7};
        // int postorder[] = {9,15,7,20,3};
        // int inorder[] = {2,1};
        // int postorder[] = {2,1};
        int inorder[] = {2,3,1};
        int postorder[] = {3,2,1};
        SolutionT5TreeFromInorderPostorder sol = new SolutionT5TreeFromInorderPostorder();
        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.println("priting the result:");
        printSequence(root);
    }
}