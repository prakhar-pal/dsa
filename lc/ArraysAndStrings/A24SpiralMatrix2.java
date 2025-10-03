package lc.ArraysAndStrings;

import lc.utils.ArrayUtils;
class A24SpiralMatrix2 {
     public static void main(String[] args) {
     	A24Solution sol = new A24Solution();
     	assert ArrayUtils.isSame2DArray(sol.generateMatrix(3), new int[][] {{1,2,3},{8,9,4},{7,6,5}});
     	assert ArrayUtils.isSame2DArray(sol.generateMatrix(2), new int[][] {{1,2},{4,3}});
     	assert ArrayUtils.isSame2DArray(sol.generateMatrix(1), new int[][] {{1}});
     }
}

class A24Solution {
    
    boolean[][] visited;
    
    private void spiralTraversal(int[][] matrix, int value, int row, int col, String direction) {
        matrix[row][col] = value;
        visited[row][col] = true;
        int nextRow = row, nextCol = col;
        String newDirection = direction;
        switch (direction) {
            case "right":
                nextCol = col + 1;
                if(nextCol == matrix[0].length || visited[row][nextCol]) {
                    newDirection = "bottom";
                    nextRow = row + 1;
                    nextCol = col;
                    if(nextRow == matrix.length || visited[nextRow][nextCol]) {
                        return;
                    }
                }
                break;
            case "bottom":
                nextRow = row+1;
                if(nextRow == matrix.length || visited[nextRow][col]) {
                    newDirection = "left";
                    nextCol = col - 1;
                    nextRow = row;
                    if(nextCol < 0 || visited[nextRow][nextCol]) {
                        return;
                    }
                }
                break;
            case "left":
                nextCol = col-1;
                if(nextCol < 0 || visited[nextRow][nextCol]) {
                    newDirection = "top";
                    nextCol = col;
                    nextRow = row - 1;
                    if(nextRow < 0 || visited[nextRow][nextCol]) {
                        return;
                    }
                }
                break;
            case "top":
                nextRow = row-1;
                if(nextRow < 0 || visited[nextRow][nextCol]) {
                    newDirection = "right";
                    nextCol = col + 1;
                    nextRow = row;
                    if(nextCol >= matrix[0].length || visited[nextRow][nextCol]) {
                        return;
                    }
                }
                break;
            default:
                break;
        }
        spiralTraversal(matrix, value + 1, nextRow, nextCol, newDirection);
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        visited = new boolean[n][n];
        spiralTraversal(result, 1, 0, 0, "right");
        return result;
    }
}
