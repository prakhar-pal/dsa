package ArraysAndStrings;

import java.util.*;

import lc.utils.ArrayUtils;

public class A25LuckyNumbers {
  public static void main(String[] args) {
    A25Solution sol = new A25SolutionTwo();
    assert ArrayUtils.isSame1DArray(
      ArrayUtils.listToArray(sol.luckyNumbers(new int[][] {
        {3,7,8},
        {9,11,13},
        {15,16,17}
    })),new Integer[] {15});
  }
}

interface A25Solution {
  public List<Integer> luckyNumbers(int[][] matrix);
}
class A25SolutionOne implements A25Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
      int m = matrix.length, n = matrix[0].length;
      int[] max = new int[m];
      int[] min = new int[n];
      for(int r=0;r<m;r++) {
        int luckyColIndex = 0;
        for(int c=0;c<n;c++) {
          if(matrix[r][c] <= matrix[r][luckyColIndex]) {
            luckyColIndex = c;
          }
        }
        max[r] = luckyColIndex;
      }
      
      for(int c=0;c<n;c++) {
        int luckyRowIndex = 0;
        for(int r=0;r<m;r++) {
          if(matrix[r][c] >= matrix[luckyRowIndex][c]) {
            luckyRowIndex = r;
          }
        }
        min[c] = luckyRowIndex;
      }
      List<Integer> list = new ArrayList<>();
      for(int r=0;r<m;r++) {
        int colIndex = max[r]; // col index of maximum value
        if (min[colIndex] == r) {
          list.add(matrix[r][colIndex]);
        }
      }
      System.out.println("result list="+list);
      return list;
    }
}

class A25SolutionTwo implements A25Solution {
    HashMap<Integer, Integer> cache;
    public List<Integer> luckyNumbers(int[][] matrix) {
      int m = matrix.length, n = matrix[0].length;
      List<Integer> list = new ArrayList<>();
      cache = new HashMap<>();
      for(int r=0;r<m;r++) {
        int luckyColIndex = 0;
        for(int c=0;c<n;c++) {
          if(matrix[r][c] <= matrix[r][luckyColIndex]) {
            luckyColIndex = c;
          }
        }
        int luckyRowIndex = getLuckyRowIndex(matrix, luckyColIndex);
        if(luckyRowIndex == r) {
          list.add(matrix[r][luckyColIndex]);
        }
      }
      System.out.println("result list="+list);
      return list;
    }

    private int getLuckyRowIndex(int[][] matrix, int col) {
      if(cache.containsKey(col)) {
        return cache.get(col);
      }
      int luckyRowIndex = 0;
      for(int r=0;r<matrix.length;r++) {
        if(matrix[r][col] >= matrix[luckyRowIndex][col]) {
          luckyRowIndex = r;
        }
      }
      cache.put(col, luckyRowIndex);
      return luckyRowIndex;
    }
}
