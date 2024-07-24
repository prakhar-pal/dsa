package lc.Sorting;

import java.util.Arrays;
import java.util.Random;

import lc.utils.Logger;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * You must find a solution with a memory complexity better than O(n2).
 */
public class S08KthSmallestSortedMatrix {
    public static void main(String[] args) {
        S08Solution sol = new S08SolutionTwo();
        assert sol.kthSmallest(new int[][] {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        }, 8) == 13;

        assert sol.kthSmallest(new int[][]{
            {-5,-4},{-5,-4}
        }, 2) == -5;

        assert sol.kthSmallest(new int[][]{
            {2,3,6,6,10},{5,9,12,17,19},{10,14,17,20,20},{15,17,20,24,24},{20,20,25,26,29}
        }, 4) == 6;
    }
}

interface S08Solution {
    public int kthSmallest(int[][] matrix, int k);
}

class S08SolutionOne implements S08Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n*n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int index = n*i+j;
                arr[index] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}


class S08SolutionTwo implements S08Solution {
    // nlogK solution
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        while(min != max) {
            Random random = new Random();
            int mid = random.nextInt(min, max + 1);
            int count = 0; // count of values lesser than mid
            int row = 0, col = n - 1;
            while(col>=0 && row < n) {
                int colValue = matrix[row][col];
                if(colValue<=mid) {
                    count+=col+1;
                    row++;
                }else {
                    col--;
                }
            }
            if(count >= k) {
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }
}
