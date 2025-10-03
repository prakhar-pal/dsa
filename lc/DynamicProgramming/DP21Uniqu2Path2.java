package lc.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths-ii/description/
class DP21UniquePath2 {
    public static void main(String[] args) {
        DP21Solution sol = new DP21Solution();
        assert sol.uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}) == 2;
        assert sol.uniquePathsWithObstacles(new int[][] {{0,0,0},{0,0,0},{0,0,0}}) == 6;
        assert sol.uniquePathsWithObstacles(new int[][] {{0,0,0},{1,0,1},{0,0,0}}) == 1;
        assert sol.uniquePathsWithObstacles(new int[][] {{0,0},{0,1}}) == 0;
    }
}

class DP21Solution {
    int[][] paths;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : paths) {
            Arrays.fill(row, -1);       // fill each row
        }
        upwoUtil(obstacleGrid, 0, 0);
        return paths[0][0];
    }

    private int upwoUtil(int[][] obstacleGrid, int r, int c) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(r>=m || c>=n) {
            return 0;
        } else {
            if(paths[r][c] == -1) {
                if(r==m-1 && c==n-1) {
                    paths[r][c] = obstacleGrid[r][c] != 1 ? 1 : 0;
                }else if(obstacleGrid[r][c] == 1) {
                    paths[r][c] = 0;
                } else {
                    int rightPath = upwoUtil(obstacleGrid, r, c+1);
                    int bottomPath = upwoUtil(obstacleGrid, r+1, c);
                    paths[r][c] = bottomPath + rightPath; 
                }
            }
            return paths[r][c];
        }
    }
}

