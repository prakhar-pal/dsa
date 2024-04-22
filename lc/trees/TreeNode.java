package lc.trees;
import java.util.*;

/**
 Definition for a binary tree node.
 */
public class TreeNode {
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

    public void printLevelOrder() {
        List<TreeNode> list = new ArrayList<>();
        list.add(this);
        int index = 0;
        while(list.size() != 0) {
            List<TreeNode> newList = new ArrayList<>();
            System.out.print("row="+index+"\t");
            for(TreeNode node: list) {
                if(node != null) {
                    newList.add(node.left);
                    newList.add(node.right);
                }
                System.out.print((node != null ? node.val : null) + "\t");
            }
            System.out.println();
            index++;
            list = newList;
        }
    }
}
