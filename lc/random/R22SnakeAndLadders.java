package lc.random;
import java.util.Stack;

/**
 * https://leetcode.com/problems/snakes-and-ladders
 */
public class R22SnakeAndLadders {
    public static void main(String[] args) {
        R22Solution solution = new R22Solution();
        assert solution.snakesAndLadders(new int[][] {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        }) == 4;

        assert solution.snakesAndLadders(new int[][] {
            {-1,-1},
            {-1,3},
        }) == 1;

        assert solution.snakesAndLadders(new int[][] {
            {-1,-1},
            {-1,1},
        }) == 1;

        assert solution.snakesAndLadders(new int[][] {
            {-1,-1,-1},{-1,9,8},{-1,8,9}
        }) == 1;
        
        assert solution.snakesAndLadders(new int[][] {
            {-1,1,2,-1},
            {2,13,15,-1},
            {-1,10,-1,-1},
            {-1,6,2,8}
        }) == 2;

        assert solution.snakesAndLadders(new int[][] {
            {1,1,-1},{1,1,1},{-1,1,1}
        }) == -1;

        assert solution.snakesAndLadders(new int[][] {
            {-1,60,32,-1,-1,-1,59,-1},
            {34,1,15,9,13,25,63,26},
            {-1,-1,-1,-1,29,-1,-1,-1},
            {-1,-1,-1,27,-1,-1,-1,5},
            {6,59,-1,2,40,13,-1,-1},
            {-1,44,20,-1,-1,-1,58,-1},
            {-1,-1,9,-1,-1,23,-1,-1},
            {-1,-1,-1,46,27,6,-1,-1}
        }) == 3;

        assert solution.snakesAndLadders(new int[][] {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {1,1,1,-1,13,-1},
            {1,1,1,1,1,8},
            {-1,8,8,8,8,8}
        }) == -1;

    }
}


class R22Solution {
    /**
     * Beats 5% solutions
     * 
     * This solution results in TLE
     * without minSteps > newSteps in the while loop
     * */
    int minSteps;
    Stack<Integer> minPath;
    public int snakesAndLadders(int[][] board) {
        minSteps = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[board.length][board.length];
        slUtil(board, 1, 0, visited);
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
    private void slUtil(int[][] board, int originalCell, int steps, boolean[][] visited) {
        int cell = originalCell;
        int[] currentIndices = cellToIndex(board, cell);
        if(visited[currentIndices[0]][currentIndices[1]]) {
            return;
        }
        if(steps > minSteps) {
            return;
        }
        visited[currentIndices[0]][currentIndices[1]] = true;
        int n = board.length;
        int newSteps = steps;
        while(cell<n*n && minSteps > newSteps) {
            int maxStopCell = -1;
            for(int i=1;i<=6 && (cell + i) <= n*n && minSteps > newSteps;i++) {
                int cc = cell + i;
                int[] cellPosition = cellToIndex(board, cc);
                int row = cellPosition[0];
                int col = cellPosition[1];
                if(board[row][col] != -1) {
                    slUtil(board, board[row][col], newSteps+1, visited);
                } else {
                    maxStopCell = Math.max(maxStopCell, cc);
                }
            }
            if(maxStopCell == -1) {
                visited[currentIndices[0]][currentIndices[1]] = false;
                return;
            }
            cell = maxStopCell;
            newSteps++;
        }
        visited[currentIndices[0]][currentIndices[1]] = false;
        if(newSteps < minSteps) {
            minSteps = Math.min(minSteps, newSteps);
            minPath = new Stack<Integer>();
        }
    }
    private int[] cellToIndex(int[][] board, int cell) {
        int n = board.length;
        int row = Math.ceilDiv(cell,n);
        boolean rightDirection = row % 2 == 1;
        int col = 0;
        if(rightDirection) {
            col = cell - 1 - (row-1)*n;
        }else {
            col = n*row-cell;
        }
        int rrow = n - row;
        return new int[] { rrow, col };
    }
}
