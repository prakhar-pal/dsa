package lc.BinarySearch;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

public class D01NumberOfIslands {
    public static void main(String[] args) {

        D01Solution sol = new D01SolutionOne();

        System.out.println("number of islands:" + sol.numIslands(
            new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            }
        ));

        assert sol.numIslands(
            new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            }
        ) == 1;

        assert sol.numIslands(
            new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
            }
        ) == 3;
    }
}

interface D01Solution {
    public int numIslands(char[][] grid);
}

class D01SolutionOne implements D01Solution{
    public void markIsland(char[][] grid, int i, int j) {
        // is this BFS?
        if(i < 0 || i >= grid.length) {
            return;
        }

        if(j < 0 || j >= grid[i].length) {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            markIsland(grid, i, j-1);
            markIsland(grid, i, j+1);
            markIsland(grid, i-1, j);
            markIsland(grid, i+1, j);
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
