package lc.trees;

import java.util.List;

class T31SumRootToLeafNums {
    public static void main(String[] args) {
        T31Solution sol = new T31Solution();
        TreeNode node = TreeNode.createTree(List.of(new Integer[]{1,2,3}));
        assert sol.sumNumbers(node) == 25;
        node = TreeNode.createTree(List.of(new Integer[]{4,9,0,5,1}));
        assert sol.sumNumbers(node) == 1026;
    }
}


class T31Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            dfs(root, sb);
        }
        System.out.println("sum="+sum);
        return sum;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if(node.left == null && node.right == null) {
            // left node
            sum += Integer.parseInt(sb.toString());
        }
        if(node.left != null) {
            dfs(node.left, sb);
        }
        if(node.right != null) {
            dfs(node.right, sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}