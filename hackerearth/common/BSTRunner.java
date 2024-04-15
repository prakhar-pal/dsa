// package hackerearth.common;
class BSTRunnerImpl {
    public int value;
    public BSTRunnerImpl left = null;
    public BSTRunnerImpl right = null;
    public BSTRunnerImpl(int value){
        this.value = value;
    }
    public void insert(int value){
        if(value < this.value){
            if(this.left == null){
                this.left = new BSTRunnerImpl(value);
            }else {
                this.left.insert(value);
            }
        }else {
            if(this.right == null){
                this.right = new BSTRunnerImpl(value);
            }else {
                this.right.insert(value);
            }
        }
    }
    public void printInorder(){
        if(this.left != null){
            this.left.printInorder();
        }
        System.out.println(this.value + " ");
        if(this.right != null){
            this.right.printInorder();
        }
    } 
}

public class BSTRunner{
    public static void main(String[] args){
        int[] items = { 10,5,5,3,6,2,7,8,3,1,0};
        BSTRunnerImpl tree = new BSTRunnerImpl(items[0]);
        for(int i=1;i<items.length;i++){
            tree.insert(items[i]);
        }
        tree.printInorder();
    }
}

