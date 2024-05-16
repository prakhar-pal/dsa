package lc.misc;

public class D02MinPathSum {
    public static void main(String[] args) {
        D02Solution sol = new D02Solution();
        assert sol.minPathSum(new int[][]{
            {1,3,1},{1,5,1},{4,2,1}
        }) == 7;
        assert sol.minPathSum(new int[][]{
            {1,2,3},{4,5,6}
        }) == 12;
    }
}

class D02Solution {
    public int minPathSum(int[][] grid) {
        int[][] costGrid = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                costGrid[i][j] = Integer.MAX_VALUE;
            }
        }
        updatedCosts(costGrid, grid, costGrid.length-1, costGrid[0].length-1);
        return costGrid[grid.length-1][grid[0].length-1];
    }
    private void updatedCosts(int[][] costGrid, int grid[][], int row, int col) {
        if(row <0 || col < 0) {
            return;
        }
        if(row == 0 && col == 0) {
            costGrid[row][col] = grid[row][col];
        }
        if(costGrid[row][col] == Integer.MAX_VALUE) {
            if((row - 1) >=0) {
                updatedCosts(costGrid, grid, row-1, col);
                costGrid[row][col] = Math.min(costGrid[row-1][col] + grid[row][col], costGrid[row][col]);
            }
            if((col - 1) >=0) {
                updatedCosts(costGrid, grid, row, col-1);
                costGrid[row][col] = Math.min(costGrid[row][col-1] + grid[row][col], costGrid[row][col]);
            }
        }
    }
}
