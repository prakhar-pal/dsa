package lc.DynamicProgramming;
/**
 * https://leetcode.com/problems/unique-paths/
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */

public class DP06UniquePaths {
    public static void main(String[] args){
        DP06Solution sol = new DP06Solution();
        assert sol.uniquePaths(3, 7) == 28;
        assert sol.uniquePaths(3, 2) == 3;
    }
}

class DP06Solution {
    int [][] uniquePathsMatrix;
    public int uniquePaths(int m, int n) {
        uniquePathsMatrix = new int[m][n];
        return populateUniquePaths(m-1,n-1);
    }
    private int populateUniquePaths(int row, int col) {
        if(uniquePathsMatrix[row][col] != 0) {
            return uniquePathsMatrix[row][col];
        }
        if (row == 0 || col == 0) {
            return 1;
        }
        uniquePathsMatrix[row][col] = populateUniquePaths(row-1, col) + populateUniquePaths(row, col-1);
        return uniquePathsMatrix[row][col];
    }
}
