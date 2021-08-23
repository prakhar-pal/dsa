// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        serialize(root, str);
        return str.toString();
    }

    public void serialize(TreeNode root, StringBuffer str){
        if(root == null) {
            str.append("N,");
            return;
        }
        str.append(root.val + ",");
        serialize(root.left, str);
        serialize(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        data = data.substring(0, data.length()-1);
        String[] nodeVals = data.split(","); 
        Integer[] elms = new Integer[nodeVals.length];
        for(int i=0;i<elms.length;i++){
            elms[i]= nodeVals[i].equalsIgnoreCase("N") ? null : Integer.parseInt(nodeVals[i]);
        }
        return decode(elms);
    }
    private TreeNode decode(Integer[] elms){
        if(index>= elms.length || elms[index] == null) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(elms[this.index]);
        index++;
        node.left = decode(elms);
        node.right = decode(elms);
        return node;
    }
}

public class U1SerializeDeserializeBinTree {
    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        else {
            if( root1 == null && root2 == null) return true;
            else {
                // System.out.println("comparing root1:" + root1.val + "\t and root2:" + root2.val);
                return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
            }
        }
    }
    public static void main(String[] args) {
        // example 1
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(1);
        // root.left.left = new TreeNode(6);
        // root.left.right = new TreeNode(2);
        // root.left.right.left = new TreeNode(7);
        // root.left.right.right = new TreeNode(4);
        // root.right.right = new TreeNode(8);
        // root.right.left = new TreeNode(0);

        // example 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        Codec codec = new Codec();
        String serializedTree = codec.serialize(root);
        System.out.println("after serialzing: " + serializedTree);
        TreeNode node = codec.deserialize(serializedTree);
        System.out.println("is same tree:" + isSameTree(root, node));
        
    }
}