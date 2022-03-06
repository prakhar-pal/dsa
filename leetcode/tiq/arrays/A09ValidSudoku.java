// https://leetcode.com/problems/valid-sudoku/
import java.util.Set;
import java.util.HashSet;


class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows have unique numbers
        for(int i=0;i<board.length;i++){
            Set<Integer> nums = new HashSet<Integer>();
            for(int j=0;j<board[i].length;j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                int fill = Integer.parseInt(String.valueOf(ch));
                if(nums.contains(fill) ||fill < 0 || fill > 9) return false;
                nums.add(fill);
            }
        }
        // check cols have unique numbers
        for(int i=0;i<board.length;i++){
            Set<Integer> nums = new HashSet<Integer>();
            for(int j=0;j<board[i].length;j++){
                char ch = board[j][i];
                if(ch == '.') continue;
                int fill = Integer.parseInt(String.valueOf(ch));
                if(nums.contains(fill) ||fill < 0 || fill > 9) return false;
                nums.add(fill);
            }
        }
        
        // 3x3 grids should have unique numbers
        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board[i].length;j=j+3){
                Set<Integer> nums = new HashSet<Integer>();
                for(int ii=i;ii<=i+2;ii++){
                    for(int jj=j;jj<=j+2;jj++){
                        char ch = board[ii][jj];
                        if(ch == '.') continue;
                        int fill = Integer.parseInt(String.valueOf(ch));
                        if(nums.contains(fill)) return false;
                        nums.add(fill);
                    }
                }
            }
        }
        return true;
    }
}

class A09 {
    public static void main(String[] args){
        Solution sol = new Solution();
        
        char board1[][] = {
            {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        };
        boolean res1 = true;
        
        char board2[][] = {
            {'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        };
        boolean res2 = false;
        
        assert sol.isValidSudoku(board1) == res1;
        assert sol.isValidSudoku(board2) == res2;
    }
}
