class Node {
    public Node next = null;
    public int data;
    public Node(int data){
        this.data = data;
    }
    public void setNext(Node node){
        this.next = node;
    }
    public Node reverse(){
        if(this == null || this.next == null) return this;
        Node prev = null, currentNode = this, next = this.next;
        while(currentNode != null){
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            if(currentNode != null){
                next = currentNode.next;
            }
        }
        return prev;

    }
    public static Node createFromArray(int[] values){
        Node rootNode = null;
        for(int i=0;i<values.length;i++){
            Node newNode = new Node(values[i]);
            if(rootNode != null){
                newNode.next = rootNode;
            }
            rootNode = newNode;
        }
        return rootNode;
    }
    void printList(){
        Node node = this;
        while(node!=null){
            System.out.print(node.data+"\t");
            node = node.next;
        }
        System.out.println("\n");
    }
}
public class Prog302 {
    public static void main(String[] args){
        int[] values = {1,2,3,4,5};
        Node rootNode = Node.createFromArray(values);
        rootNode.printList();
        Node newRoot = rootNode.reverse();
        newRoot.printList();
    }
}
