import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In the bin-packing problem, we are given n metal objects, each weighing between
zero and one kilogram. Our goal is to find the smallest number of bins that will
hold the n objects, with each bin holding one kilogram at most.
• The best-fit heuristic for bin packing is as follows. Consider the objects in the
order in which they are given. For each object, place it into the partially filled
bin with the smallest amount of extra room after the object is inserted.. If
no such bin exists, start a new bin. Design an algorithm that implements the
best-fit heuristic (taking as input the n weights w 1 , w 2 , ..., w n and outputting
the number of bins used) in O(n log n) time.
 */

class Node {
    public int data, childrenCount;
    public Node parent, left, right;
    public Node(int data){
        this.data = data;
        this.parent = this.left = this.right = null;
        this.childrenCount = 0;
    }
    public void incrementChildrentCount(){
        this.childrenCount++;
    }

    public static void nodeToArr(Node node, ArrayList<Node> list){
        if(node == null) return;
        if(node.left != null) Node.nodeToArr(node.left, list);
        list.add(node);
        if(node.right != null) Node.nodeToArr(node.right, list);
    }
    
    public void print(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this);
        while(!queue.isEmpty()){
            int currentQueueSize = queue.size();
            System.out.println();
            while (currentQueueSize > 0) {
                currentQueueSize--;
                Node node = queue.peek();
                System.out.print("(" + node.data + "," + node.childrenCount + ")" + " ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                queue.poll();
            }
        }
        System.out.println();
    }
}

class BinContainer {
    private Node rootNode;
    private int binCapacity;
    private int binCount;

    public BinContainer(int binCapacity) {
        this.rootNode = null;
        this.binCapacity = binCapacity;
        this.binCount = 0;
    }

    public int size() {
        int incompleteBinCount = this.getTotalNodes(this.rootNode);
        System.out.println("full bins = " + this.binCount + " , incomplete bins = " + incompleteBinCount);
        this.rootNode.print();
        return this.binCount + incompleteBinCount;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (this.rootNode == null) {
            this.rootNode = node;
        } else {
            boolean isAdded = this.addIntoBin(this.rootNode, data);
            if (!isAdded) {
                this.insert(data);
            }
        }
    }

    public void delete(Node node) {
        if(node == null) return;
        this.rootNode.print();
        System.out.println("deleting:" + node.data);
        while(node.right != null){
            node.data = node.right.data;
            node = node.right;
        }
        if (node.parent == null){
            //it's root node;
            this.rootNode = null;
        }
        else
            node.parent.right = null;
    }
    private int getTotalNodes(Node node){
        int count = 0;
        if(node !=null){
            count++;
        }
        if(node.left != null){
            count+=this.getTotalNodes(node.left);
        }
        if(node.right != null){
            count+=this.getTotalNodes(node.right);
        }
        return count;
    }
    private void insert(int data){
        Node currentNode = this.rootNode;
        Node node = new Node(data);
        while(currentNode != null){
            Node parentNode = currentNode;
            if (data < currentNode.data){
                currentNode = currentNode.left;
                if(currentNode == null){
                    parentNode.left = node;
                    node.parent = parentNode;
                    // System.out.println("adding " + data + " as a child of " + parentNode.data);
                }
            }else {
                currentNode = currentNode.right;
                if(currentNode == null){
                    parentNode.right = node;
                    node.parent = parentNode;
                    // System.out.println("adding " + data + " as a child of " + parentNode.data);
                }
            }
        }
    }
    private boolean addIntoBin(Node node, int data){
        if(node == null) return false;
        boolean insertedOnRight = node != null ? this.addIntoBin(node.right, data): false;
        if(insertedOnRight) return true;
        if(node.data + data <= this.binCapacity) {
            node.data = node.data + data;
            if(node.data == this.binCapacity){
                this.delete(node);
                this.binCount++;
            }
            return true;
        }
        return node.left != null ? this.addIntoBin(node.left, data): false;
    }

}

public class Prog310 {
    public static void main(String[] args){
        int[] arr = {1,2,3,2,3,4,1,3,1,1,4,3,3,2,3,2,1};
        BinContainer container = new BinContainer(10);
        for(int num:arr){
            container.add(num);
        }
        System.out.println("The count of bins:" + container.size());
    }
}
