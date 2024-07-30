package lc.trees;
import java.util.*;

/**
 Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
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

    public static TreeNode createTree(List<Integer> arr) {
        if(arr.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr.get(0));
        TreeNode[] nodes = new TreeNode[arr.size()];
        nodes[0] = root;
        for(int i=0;i<arr.size();i++) {
            TreeNode node = nodes[i];
            if(node == null) {
                continue;
            }
            if(2*i+1 < arr.size()) {
                Integer leftValue = arr.get(2*i+1);
                if(leftValue != null) {
                    node.left = new TreeNode(leftValue);
                }
                nodes[2*i+1] = node.left;
            }
            if(2*i+2 < arr.size()) {
                Integer rightValue = arr.get(2*i+2);
                if(rightValue != null) {
                    node.right = new TreeNode(rightValue);
                }
                nodes[2*i+2] = node.right;
            }
        }
        return root;
    }
}
