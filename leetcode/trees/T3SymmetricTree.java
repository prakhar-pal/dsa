import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        // TODO Auto-generated method stub
        return this.val + "";
    }
}

class SolutionT3SymmetricTree {
    private boolean isSymmetric(ArrayList<TreeNode> list){
        int size = list.size();
        // System.out.println("isSymmetric:list::"+ list.toString());
        for(int i=0;i<size;i++){
            TreeNode leftNode = list.get(i);
            System.out.print(leftNode != null ? leftNode.val : null + " ");
            TreeNode rightNode = list.get(size-1-i);
            if (((leftNode != null && rightNode == null) || (rightNode != null && leftNode == null))
                     ||(leftNode != null && rightNode != null && leftNode.val != rightNode.val)) {
                return false;
            }
        }
        System.out.println();
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // System.out.println("while loop");
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            while(size>0){
                size--;
                TreeNode node = q.poll();
                list.add(node);
                if(node != null) {
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(!this.isSymmetric(list)) return false;
        }
        // System.out.println(59);
        return true;
    }
}
public class T3SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SolutionT3SymmetricTree sol = new SolutionT3SymmetricTree();
        System.out.println("is symmetric:r1:" + sol.isSymmetric(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(3);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        System.out.println("is symmetric:r2::" + sol.isSymmetric(root2));
    }
}
