import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Design a data structure to support the following operations:
//• insert(x,T) – Insert item x into the set T .
//• delete(k,T) – Delete the kth smallest element from T .
//• member(x,T) – Return true iff x ∈ T .
//All operations must take O(log n) time on an n-element set.

class Dict {

    class Node {
        public int data, childrenCount;
        public Node parent, left, right;
        public Node(int data){
            super();
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
    }
    private Node rootNode;
    public Dict() {
        this.rootNode = null;
    }

    public int size(){
        return this.rootNode != null ? this.rootNode.childrenCount + 1 : 0;
    }

    public boolean add(int data){
        Node node = new Node(data);
        if(this.rootNode == null){
            this.rootNode = node;
            return true;
        }
        if(this.search(data)) {
            // System.out.println("Not adding "+data);
            return false;
        } 
        Node currentNode = this.rootNode;
        while(currentNode != null){
            currentNode.incrementChildrentCount();
            Node parentNode = currentNode;
            if (data < currentNode.data){
                currentNode = currentNode.left;
                if(currentNode == null){
                    parentNode.left = node;
                    // System.out.println("adding " + data + " as a child of " + parentNode.data);
                }
            }else {
                currentNode = currentNode.right;
                if(currentNode == null){
                    parentNode.right = node;
                    // System.out.println("adding " + data + " as a child of " + parentNode.data);
                }
            }
        }
        return true;
    }
    public boolean search(int data){
        Node currentNode = this.rootNode;
        while(currentNode != null){
            if(currentNode.data == data) return true;
            if(currentNode.data < data) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
        return false;
    }

    public Node findKthSmallest(int kth){
        if (kth > this.rootNode.childrenCount + 1)
            System.out.println("ERROR!");
        Node currentNode = this.rootNode;
        while(currentNode != null){
            int leftChildrenCount = currentNode.left != null ? currentNode.left.childrenCount + 1 : 0;
            // System.out.println("current Node:" + currentNode.data + " lcc:" + leftChildrenCount);
            if(kth <= leftChildrenCount){
                currentNode = currentNode.left;
            }else if(kth == leftChildrenCount + 1){
                return currentNode;
            }else {
                kth = kth - (leftChildrenCount + 1);
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    public Node findKthSmallest2(int kth){
        ArrayList<Node> list = new ArrayList<Node>();
        Node.nodeToArr(this.rootNode, list);
        // System.out.println("Priting the list:\n");
        // for (Node node : list) {
        //     System.out.print(node.data + "\t");
        // }
        // System.out.println("\n");
        return list.get(kth-1);
    }

    public void print(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this.rootNode);
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

public class Prog308 {

    public static void mainOld(String[] args){
        int data[] = {10,5,4,7,50,60,70,20,11};
        Dict dict = new Dict();
        for(int i=0;i<data.length;i++){
            dict.add(data[i]);
        }
        dict.print();
        int k = Integer.parseInt(args[0]);
        Dict.Node node = dict.findKthSmallest2(k);
        System.out.println(k+"th smallest is:" + (node != null ? node.data: "null"));
    }
    public static void main(String[] args){
        int COUNT = 1;
        int pow = Integer.parseInt(args[0]);
        while(pow >0 ) {
            COUNT*=10;
            pow--;
        }
        Dict dict = new Dict();
        for(int i=0;i<COUNT;i++){
            dict.add((int)Math.floor(Math.random() * COUNT));
        }
        System.out.println("Dictionary size:" + dict.size());
        runAlgorithms(dict, true);
        runAlgorithms(dict, false);
    }
    public static void runAlgorithms(Dict dict, boolean isEfficient){
        int totalNodes = dict.size();
        final long startTime = System.currentTimeMillis();
        for(int i = 0;i<totalNodes;i++){
            if(isEfficient)
                dict.findKthSmallest(i+1);
            else dict.findKthSmallest2(i+1);
        }
        String algoType = isEfficient ? "[short]" : "[long]";
        System.out.println("[findKthSmalles]" + algoType + " time took:" + (System.currentTimeMillis() - startTime));
    }
}
