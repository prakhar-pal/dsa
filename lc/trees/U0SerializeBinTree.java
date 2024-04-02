//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
import java.util.LinkedList;

// this one has exponential memory requirements
// e.g. for n nodes it requires arr of size 2^n-1

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    public TreeNode node;
    public int index;
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

class Codec {
    // Encodes a tree to a single string.
    public int getTreeHeight(TreeNode root){
        if(root == null) return 0;
        else return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }
    public String serialize(TreeNode root) {
        if(root == null) return "";
        LinkedList<Pair> list = new LinkedList<>();
        int maxIndex = -1;
        int nodeCount = (int) (Math.pow(2, getTreeHeight(root)) -1);
        Integer[] coded = new Integer[nodeCount];
        list.add(new Pair(root, 0));
        StringBuffer sb = new StringBuffer();
        while(list.size() != 0){
            Pair pair = list.poll();
            TreeNode node = pair.node;
            if(pair.index > maxIndex){
                maxIndex = pair.index;
            }
            if(node != null){
                coded[pair.index] = node.val;
                if(node.left != null)
                    list.add(new Pair(node.left, (pair.index +1) * 2 - 1));
                if(node.right != null)
                    list.add(new Pair(node.right, (pair.index + 1) * 2));
            }
        }
        for(int i=0;i<=maxIndex;i++){
            sb.append(coded[i]);
            if(i != maxIndex){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private Integer[] toArray(String s){
        String[] sarr = s.split(",");
        Integer[] arr = new Integer[sarr.length];
        for(int i=0;i<sarr.length;i++){
            arr[i] = sarr[i].equals("null") ? null : Integer.parseInt(sarr[i]);
        }
        return arr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        else {
            Integer[] arr = toArray(data);
            TreeNode[] nodes = new TreeNode[arr.length];
            for(int i=0;i<arr.length;i++){
                if(arr[i] == null){
                    nodes[i] = null;
                    continue;
                }
                if(i==0){
                    nodes[i] = new TreeNode(arr[i]);
                }
                int leftIndex = (i+1)*2-1;
                int rightIndex = (i+1)*2;
                if(leftIndex < arr.length && arr[leftIndex] != null){
                    TreeNode leftNode = new TreeNode(arr[leftIndex]);
                    nodes[leftIndex] = leftNode;
                    nodes[i].left = leftNode;
                }
                if(rightIndex < arr.length && arr[rightIndex] != null){
                    TreeNode rightNode = new TreeNode(arr[rightIndex]);
                    nodes[i].right = rightNode;
                    nodes[rightIndex] = rightNode;
                }
                // System.out.println("case:" + i + "\nSetting root node to:" + getNodeValue(nodes[i]) + "\n left node:"
                //         + getNodeValue(leftNode) + "\n right node:" + getNodeValue(rightNode));
            }
            return nodes[0]; 
        }
    }
}

public class U0SerializeBinTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);

        // example 2
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(5);
        // root.right.left.left = new TreeNode(6);
        // root.right.left.right = new TreeNode(7);
        Codec codec = new Codec();
        String serializedTree = codec.serialize(root);
        System.out.println("after serialzing: " + serializedTree);
        TreeNode node = codec.deserialize(serializedTree);
        System.out.println("is same tree:" + isSameTree(root, node));
        
    }
}