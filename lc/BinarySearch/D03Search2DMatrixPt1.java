package lc.BinarySearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class D03Search2DMatrixPt1 {
    public static void main(String[] args) {
        BSD03Solution sol = new BSD03Solution();
        assert sol.searchMatrix(new int[][] {
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 3);


        assert sol.searchMatrix(new int[][] {
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 13) == false;
    }
}

class BSD03Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] arr = new int[rows*cols];
        int index = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                arr[index] = matrix[i][j];
                index++;
            }
        }
        int low=0,high = arr.length-1;
        boolean isFound = false;
        while(low <= high && !isFound) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                isFound = true;
            }else if(arr[mid] > target) {
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return isFound;
    }
}
