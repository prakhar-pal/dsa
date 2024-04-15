package lc.ArraysAndStrings;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
public class A12MatrixZerofy {
    public static void main(String[] args) {
    }
}

class A12MatrixZerofySolution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    Integer[] arr = new Integer[2];
                    arr[0] = i;
                    arr[1] = j;
                    list.add(arr);
                }
            }
        }
        for(Integer[] position: list) {
            int i = position[0];
            int j = position[1];
            for(int k=0;k<matrix.length;k++) {
                matrix[k][j] = 0;
            }
            for(int k=0;k<matrix[0].length;k++) {
                matrix[i][k] = 0;
            }
        }
    }
}
