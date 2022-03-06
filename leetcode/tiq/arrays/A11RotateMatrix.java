import java.util.Queue;
import java.util.LinkedList;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
class Solution {
    // private static void swap(int[][] matrix, int )
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] arr = matrix;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
    }
}

class A11 {
    public static void print2dArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void assertArr2dEquals(int[][] arr1, int arr2[][]){
        assert arr1.length == arr2.length;
        for(int i=0;i<arr1.length;i++){
            assertArrEquals(arr1[i], arr2[i]);
        }
    }
	public static void assertArrEquals(int[] arr1, int[] arr2){
		assert arr1.length == arr2.length;
		for(int i=0;i<arr1.length;i++){
		    // System.out.println(arr1[i] + " == " + arr2[i]);
			assert arr1[i] == arr2[i];
		}
	}
    public static void main(String[] args){
        Solution sol = new Solution();
        
        int mat1[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int result1[][] = {{7,4,1},{8,5,2},{9,6,3}};
        
        // int mat2[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        // int result2[][] = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
        sol.rotate(mat1);
        // print2dArr(mat1);
        // System.out.println();
        // print2dArr(result1);
        assertArr2dEquals(mat1, result1);
        // assertArr2dEquals(mat2, result2);
        
    }
}
