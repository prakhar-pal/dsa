import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class SolutionT7PerfTreeNextNode {
    public Node connect(Node root) {
        if(root == null) return null;
        else {
            if(root.left != null){
                root.left.next = root.right;
            }
            if(root.right != null && root.next != null){
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}

public class T7NextRightNode {
    public static void printSol(Node root){
        Queue<Node> q = new LinkedList<Node>();
        while(root != null){
            Node temp = root;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
            root = root.left;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        SolutionT7PerfTreeNextNode sol = new SolutionT7PerfTreeNextNode();
        sol.connect(root);
        printSol(root);
    }
}