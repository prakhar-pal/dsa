package lc.Backtracking;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * https://leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

class BT01NQueens {
    public static void main(String[] args) {
        BT01Solution sol = new BT01Solution();
        List<List<String>> result1 = sol.solveNQueens(4);
        for(List<String> combination1: result1) {
            System.out.println("combination");
            for(String s: combination1) {
                System.out.println(s);
            }
        }
    }
}


class BT01Solution {
    private List<List<String>>  solutions;
    private boolean[] isColumnUsed;
    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        char[][] matrix = new char[n][n];
        isColumnUsed = new boolean[n];
        for(int i=0;i<n;i++) {
            Arrays.fill(matrix[i], '.');
        }
        this.nQueen(matrix, n, 0);
        return solutions;
    }

    private void nQueen(char[][] matrix, int n, int row) {
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                list.add(new StringBuffer().append(matrix[i]).toString());
            }
            solutions.add(list);
        }
        for(int i=0;i<n;i++) {
            if(isColumnUsed[i]) {
                continue;
            }
            if(i>0) {
                matrix[row][i-1] = '.';
            }
            boolean isAllowed = true;
            if(row > 0) {
                boolean canBeDiagonallyAttacked = false;
                for(int row1=row-1, col1 = i-1;row1>=0 && col1 >=0;row1--, col1--) {
                    if(matrix[row1][col1] == 'Q') {
                        canBeDiagonallyAttacked = true;
                        break;
                    }
                }
                for(int row1=row-1, col1 = i+1;row1>=0 && col1<n;row1--, col1++) {
                    if(matrix[row1][col1] == 'Q') {
                        canBeDiagonallyAttacked = true;
                        break;
                    }
                }
                isAllowed = !isColumnUsed[i] && !canBeDiagonallyAttacked;
            }
            if(isAllowed) {
                isColumnUsed[i] = true;
                matrix[row][i] = 'Q';
                nQueen(matrix, n, row+1);
                isColumnUsed[i] = false;
                matrix[row][i] = '.';
            }
        }
    }
}
