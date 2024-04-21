package lc.Backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets/description/
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class BT06WordSearch {
    public static void main(String[] args) {
        BT06Solution sol = new BT06Solution();
        assert sol.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "ABCCED");
        assert sol.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "SEE");
    }
}

class BT06Solution {
    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        List<Integer[]> startIndices = new ArrayList<>();
        char firstChar = word.charAt(0);
        isVisited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == firstChar) {
                    Integer[] arr = new Integer[2];
                    arr[0] = i;
                    arr[1] = j;
                    startIndices.add(arr);
                }
            }
        }
        boolean hasFoundWord = false;
        for(int i=0;i<startIndices.size() && !hasFoundWord;i++) {
            Integer[] arr = startIndices.get(i);
            hasFoundWord = findWord(board, word, arr[0], arr[1], 0);
        }
        return hasFoundWord;
    }

    private boolean findWord(char[][] board, String word, int i, int j, int wordIndex) {
        if(wordIndex >= word.length()) {
            return true;
        }
        if(i<0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if(!isVisited[i][j] && word.charAt(wordIndex) == board[i][j]) {
            isVisited[i][j] = true;
            boolean findLeft = findWord(board, word, i, j-1, wordIndex + 1);
            boolean findRight = findWord(board, word, i, j+1, wordIndex + 1);
            boolean findTop = findWord(board, word, i-1, j, wordIndex + 1);
            boolean findBottom = findWord(board, word, i+1, j, wordIndex + 1);
            isVisited[i][j] = false;
            return findLeft || findRight || findTop || findBottom;
        }
        return false;
    }
}
