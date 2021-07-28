//https://www.hackerearth.com/problem/algorithm/b-sequence-f919fc86/?source=list_view
import java.util.Scanner;

class BST {
    public Integer value = null;
    public BST left = null;
    public BST right = null;
    public int size = 0;
    public BST(){
    }
    public void insert(int value){
        if(this.value == null){
            this.value = value; 
        }
        else if(value < this.value){
            if(this.left == null){
                this.left = new BST();
            }
            this.left.insert(value);
        }else {
            if(this.right == null){
                this.right = new BST();
            }
            this.right.insert(value);
        }
        this.size++;
    }
    public boolean find(int value){
        if (this.value == null)
            return false;
        return (this.value == value)
            || (this.value > value && this.left != null && this.left.find(value))
            || (this.value <= value && this.right != null && this.right.find(value));
    }
    public int getSize(){
        return this.size;
    }
    public void printInorder(String separator){
        if(this.left != null){
            this.left.printInorder(separator);
        }
        System.out.print(this.value + separator);
        if(this.right != null){
            this.right.printInorder(separator);
        }
    }
    public void printOutOforder(String separator){
        if(this.right != null){
            this.right.printInorder(separator);
        }
        System.out.print(this.value + separator);
        if(this.left != null){
            this.left.printInorder(separator);
        }
    }
}

class SeqTree {
    public BST left;
    public BST right;
    public int max;
    private int index;
    public void initializeTree(int[] sequence){
        boolean isInreasing = true;
        this.left = new BST();
        this.right = new BST();
        for(int i=0;i<sequence.length-1;i++){
            if(sequence[i]< sequence[i+1]){
                this.left.insert(sequence[i]);
            }else if(isInreasing){
                isInreasing = false;
                this.max = sequence[i];
            }else {
                this.right.insert(sequence[i]);
            }
        }
        int lastIndex = sequence.length -1;
        if (sequence[lastIndex] < sequence[lastIndex - 1]) {
            this.right.insert(sequence[lastIndex]);
        }else {
            this.left.insert(sequence[lastIndex]);
        }
    }
    public SeqTree(int[] sequence){
        this.initializeTree(sequence);
    }
    public int getSize(){
        return this.left.getSize() + this.right.getSize() + 1;
    }

    public void getArray(BST tree, int[] arr, boolean inorder) {
        if(tree != null){
            if(inorder)
                getArray(tree.left, arr, inorder);
            else getArray(tree.right, arr, inorder);
            if(tree.value != null){
                arr[this.index] = tree.value;
                this.index++;
            }
            if(inorder)
                getArray(tree.right, arr, inorder);
            else
                getArray(tree.left, arr, inorder);
        }
    }
    public int[] getArrayUtil(BST tree, boolean inorder){
        int[] arr = new int[tree.getSize()];
        this.index = 0;
        this.getArray(tree, arr, inorder);
        return arr;
    }
    public void insert(int value){
        if (value == this.max)
            return;
        else if(value > this.max){
            this.left.insert(this.max);
            this.max = value;
        }
        else if(!this.left.find(value)){
            this.left.insert(value);
        }
        else if(!this.right.find(value)){
            this.right.insert(value);
        }
    }
    public void printSequence(){
        String separator = " ";
        this.left.printInorder(separator);
        System.out.print(this.max + separator);
        this.right.printOutOforder(separator);
    }
}

public class R6BSequence {
    public static void main(String[] args){
        // int [] sequence = {1,2,5,2};
        // int[] queries = {5,1,3,2};
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] sequence = new int[N];
        for(int i=0;i<N;i++){
            sequence[i] = sc.nextInt();
        }
        int Q = sc.nextInt();
        int[] queries = new int[Q];
        for(int i=0;i<Q;i++){
            queries[i] = sc.nextInt();
        }
        sc.close();
        SeqTree sol = new SeqTree(sequence);
        for(int i=0;i<queries.length;i++){
            sol.insert(queries[i]);
            System.out.println(sol.getSize());
        }
        sol.printSequence();
        System.out.println();
    }
}