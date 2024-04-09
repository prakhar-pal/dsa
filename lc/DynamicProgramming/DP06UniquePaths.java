package lc.DynamicProgramming;

public class DP06UniquePaths {
    public static void main(String[] args){
        DP06Solution sol = new DP06Solution();
        assert sol.uniquePaths(3, 7) == 28;
        assert sol.uniquePaths(3, 2) == 3;
    }
}

class DP06Solution {
    int [][] uniquePathsMatrix;
    public int uniquePaths(int m, int n) {
        uniquePathsMatrix = new int[m][n];
        return populateUniquePaths(m-1,n-1);
    }
    private int populateUniquePaths(int row, int col) {
        if(uniquePathsMatrix[row][col] != 0) {
            System.out.println("Using memoized value");
            return uniquePathsMatrix[row][col];
        }
        if (row == 0 || col == 0) {
            return 1;
        }
        uniquePathsMatrix[row][col] = populateUniquePaths(row-1, col) + populateUniquePaths(row, col-1);
        return uniquePathsMatrix[row][col];
    }
}
