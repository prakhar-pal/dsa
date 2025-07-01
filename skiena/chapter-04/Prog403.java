import java.util.Arrays;

class Solution {
    private int[] arr;
    public Solution(int[] arr){
        this.arr = arr;
    }
    public int getSolution(){
        Arrays.sort(arr);
        int sum = Integer.MIN_VALUE;
        int start=0,end=arr.length-1;
        while(start<end){
            int[] pair = new int[2];
            pair[0]=arr[start];
            pair[1]=arr[end];
            int tempSum = pair[0]+pair[1];
            if(tempSum>sum){
                sum = tempSum;
            }
            start++;end--;
        }
        return sum;
    }
    public void print(){
        int result = this.getSolution();
        System.out.println("Solution is:"+result);
    }
}
public class Prog403 {
    public static void main(String[] args){
        int arr[] = {1,3,5,9};
        Solution sol = new Solution(arr);
        sol.print();
    }
}