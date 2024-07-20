package lc.trees;
import java.util.ArrayList;
class SolutionT9LowestCommonAncestor {
    public boolean updatePath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
        if (root == null)
            return false;
        if (root.val == node.val) {
            list.add(node);
            return true;
        } else {
            boolean isPresentInChildren = updatePath(root.left, node, list) || updatePath(root.right, node, list);
            if (isPresentInChildren)
                list.add(root);
            return isPresentInChildren;
        }
    }
    public boolean isReachable(TreeNode fromNode, TreeNode toNode){
        if(fromNode == null) return false;
        return fromNode.val == toNode.val || isReachable(fromNode.left, toNode) || isReachable(fromNode.right, toNode);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list = new ArrayList<>();
        updatePath(root, p, list);
        int i = 0, j = list.size() - 1;
        while (i != j) {
            int mid = (i+j)/2;
            if(isReachable(list.get(mid),q)){
                j = mid;
            }else {
                i = mid+1;
            }
        }
        return list.get(i);
    }
}

public class T09LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        SolutionT9LowestCommonAncestor sol = new SolutionT9LowestCommonAncestor();
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.left.right.right);
        TreeNode lca2 = sol.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(lca.val + " " + lca2.val);
    }
}
