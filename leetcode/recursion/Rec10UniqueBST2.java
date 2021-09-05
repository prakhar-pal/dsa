// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2384/
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//  Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class Solution {
   public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
   }
   private List<TreeNode> generateTrees(int left, int right){
        List<TreeNode> list = new ArrayList<>();
        if(left > right) {
            list.add(null);
            return list;
        }
        else if(left == right) {
            list.add(new TreeNode(left));
            return list;
        }
        for(int node = left; node<=right; node++){
            List<TreeNode> leftTrees = generateTrees(left, node -1);
            List<TreeNode> rightTrees = generateTrees(node + 1, right);
            for(TreeNode leftTree: leftTrees){
                for(TreeNode rightTree: rightTrees){
                    TreeNode root = new TreeNode(node);
                    root.left = leftTree;
                    root.right = rightTree;
                    list.add(root);
                }
            }
        }
        return list;
   }
}

class Rec10UniqueBST2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.generateTrees(n).size());
    }
}
