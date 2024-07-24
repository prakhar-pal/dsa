package lc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

import lc.utils.Logger;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class A14SpiralMatrix {
    public static void main(String[] args) {
        A14Solution solution = new A14Solution();
        List<Integer> list = solution.spiralOrder(new int[][] {
            {1,2,3},{4,5,6},{7,8,9}
        });
        Logger.log("Spiral order is");
        for(Integer i: list) {
            Logger.logi(i);
        }
        Logger.lognl();
    }
}

class A14Solution {
    boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        visited = new boolean[matrix.length][matrix[0].length];
        spiralTraversal(matrix, list, 0, 0, "right");
        return list;
    }

    private void spiralTraversal(int[][] matrix, List<Integer> list, int row, int col, String direction) {
        Logger.log("row="+row+" col="+col+" direction="+direction);
        list.add(matrix[row][col]);
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
        spiralTraversal(matrix, list, nextRow, nextCol, newDirection);
    }
}
