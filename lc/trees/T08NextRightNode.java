package  lc.trees;
//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/

class SolutionT8NextRightNode {
    public Node getLeftMost(Node node){
        if(node == null) return null;
        return node.left != null ? node.left : node.right != null ? node.right : this.getLeftMost(node.next);
    }
    public Node connect(Node root) {
        if(root == null) return null;
        else {
            Node temp = root;
            while(root != null){
                if(root.left != null){
                    if(root.right != null)
                        root.left.next = root.right;
                    else {
                        root.left.next = this.getLeftMost(root.next);
                    }
                }
                if(root.right != null){
                    root.right.next = this.getLeftMost(root.next);
                }
                root = root.next;
            }
            Node nextNode = getLeftMost(temp);
            connect(nextNode);
            root = temp;
        }
        return root;
    }
}

public class T08NextRightNode {
    public static void printSol(Node root){
        while(root != null){
            Node temp = root;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
            temp = root.next;
            Node newRoot = root.left;
            if(newRoot == null && temp != null){
                while(temp != null){
                    if(temp.left != null){
                        newRoot = temp.left;
                        break;
                    }
                    if(temp.right != null){
                        newRoot = temp.right;
                        break;
                    }
                    temp = temp.next;
                }
            }
            root = newRoot;
        }
    }
    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.right = new Node(7);

        // input 2
        // Node root = new Node(2);
        // root.left = new Node(1);
        // root.right = new Node(3);
        // root.left.left = new Node(0);
        // root.left.right = new Node(7);
        // root.right.right = new Node(1);
        // root.right.left = new Node(9);
        // root.right.right.right = new Node(8);
        // root.right.right.left = new Node(8);
        // root.left.left.left = new Node(2);
        // root.left.right.left = new Node(1);
        // root.left.right.right = new Node(0);
        // root.left.right.left.left = new Node(7);
        // result
        // 2 
        // 1 3 
        // 0 7 9 1 
        // 2 1 0 8 8 
        // 7 

        //input 3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        // 
        // results
        // 1 
        // 2 3 
        // 4 5 7 
        SolutionT8NextRightNode sol = new SolutionT8NextRightNode();
        sol.connect(root);
        printSol(root);
    }
}
