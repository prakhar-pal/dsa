package lc.trees;
/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class T20LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        T20Solution solution = new T20Solution();
        assert solution.longestIncreasingPath(new int[][] {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        }) == 4;
        assert solution.longestIncreasingPath(new int[][] {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        }) == 4;
        assert solution.longestIncreasingPath(new int[][] {
        }) == 0;
    }
}

class T20Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        int rows = matrix.length;
        int cols = 0;
        if(rows > 0) {
            cols = matrix[0].length;
        }
        int[][] path = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(path[i][j] == 0) {
                    path[i][j] = dfs(matrix, path, i, j);
                    maxLength = Math.max(maxLength, path[i][j]);
                }
            }
        }
        return maxLength;
    }
    private int dfs(int[][] matrix, int[][] path, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if(path[i][j] == 0) {
            int contributorLength = 0;
            int currentValue = matrix[i][j];
            if(i < matrix.length - 1 && currentValue < matrix[i+1][j]) {
                contributorLength = Math.max(dfs(matrix, path, i+1, j), contributorLength);
            }
            if(i > 0 && currentValue < matrix[i-1][j]) {
                contributorLength = Math.max(dfs(matrix, path, i-1, j), contributorLength);
            }
            if(j > 0 && currentValue < matrix[i][j-1]) {
                contributorLength = Math.max(dfs(matrix, path, i, j-1), contributorLength);
            }
            if(j < matrix[0].length - 1 && currentValue < matrix[i][j+1]) {
                contributorLength = Math.max(dfs(matrix, path, i, j+1), contributorLength);
            }
            path[i][j] = 1 + contributorLength;
        }
        return path[i][j];
    }
}   
