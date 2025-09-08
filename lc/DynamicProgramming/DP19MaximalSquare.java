package lc.DynamicProgramming;
// https://leetcode.com/problems/maximal-square/description/?envType=problem-list-v2&envId=matrix
class DP19MaximalSquare {
     public static void main(String[] args) {
          Dp19Solution2 sol = new Dp19Solution2();
          assert sol.maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}) == 4;
          assert sol.maximalSquare(new char[][] {{'0','1'},{'1','0'}}) == 1;
          assert sol.maximalSquare(new char[][] {{'1','1','1','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}) == 9;
     }
}

class Dp19Solution {
     int[][] counter;
     int maxi;

     public int maximalSquare(char[][] matrix) {
          int n = matrix.length, m = matrix[0].length;
          counter = new int[n][m];
          maxi = Integer.MIN_VALUE;
          for(int i=0;i<n;i++) {
               for(int j=0;j<m;j++) {             
                   counter[i][j] = -1;
               }
          }
          for(int i=0;i<n;i++) {
               for(int j=0;j<m;j++) {             
                    maxi = Math.max(maxi, dp(matrix, i, j));
               }
          }
          return maxi * maxi;
     }

     private int dp(char[][] matrix, int i, int j) {
          int n = matrix.length, m = matrix[0].length;
          if(i >= n || j >= m || matrix[i][j] == '0') {
               return 0;
          }
          if(counter[i][j] < 0) {
               int innerDp = dp(matrix, i + 1, j + 1);
               int borderSize = 0;
               int pointer = 1;
               while (i + pointer < n && j + pointer < m && matrix[i+pointer][j] == '1' && matrix[i][j+pointer] == '1') {
                    borderSize++;
                    pointer++;
               }
               counter[i][j] = 1 + Math.min(borderSize, innerDp);
          }
          return counter[i][j];
     }
}

class Dp19Solution2 {
     int[][] counter;
     int maxi;

     public int maximalSquare(char[][] matrix) {
          int n = matrix.length, m = matrix[0].length;
          counter = new int[n][m];
          maxi = Integer.MIN_VALUE;
          for(int i=0;i<n;i++) {
               for(int j=0;j<m;j++) {             
                   counter[i][j] = -1;
               }
          }
          for(int i=0;i<n;i++) {
               for(int j=0;j<m;j++) {             
                    maxi = Math.max(maxi, dp(matrix, i, j));
               }
          }
          return maxi * maxi;
     }

     private int dp(char[][] matrix, int i, int j) {
          int n = matrix.length, m = matrix[0].length;
          if(i >= n || j >= m || matrix[i][j] == '0') {
               return 0;
          }
          if(counter[i][j] < 0) {
               int diag = dp(matrix, i + 1, j + 1);
               int right = dp(matrix, i, j + 1);
               int bottom = dp(matrix, i + 1, j);
               counter[i][j] = 1 + Math.min(Math.min(right, bottom), diag);
          }
          return counter[i][j];
     }
}
