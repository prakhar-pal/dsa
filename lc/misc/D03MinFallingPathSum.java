package lc.misc;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 */
public class D03MinFallingPathSum {
    public static void main(String[] args) {
        D03Solution sol = new D03Solution();
        // Logger.log("sol.minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}})" + sol.minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}}));
        // assert sol.minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}}) == 13;
        // assert sol.minFallingPathSum(new int[][] {{-19,57},{-40,-5}}) == -59;
        assert sol.minFallingPathSum(new int[][] {{100,-42,-46,-41},{31,97,10,-10},{-58,-51,82,89},{51,81,69,-51}}) == -36;
    }
}

class D03Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] costMatrix = new int[matrix.length][matrix[0].length];
        for(int col=0;col<matrix[0].length;col++) {
            costMatrix[matrix.length-1][col] = matrix[matrix.length-1][col];
        }
        for(int row=matrix.length-2;row>=0;row--) {
            for(int col=0;col<matrix[row].length;col++) {
                costMatrix[row][col] = costMatrix[row+1][col];
                if(col-1 >=0) {
                    costMatrix[row][col] = Math.min(costMatrix[row][col], costMatrix[row+1][col-1]);
                }
                if(col + 1 < matrix[row].length) {
                    costMatrix[row][col] = Math.min(costMatrix[row][col], costMatrix[row+1][col+1]);
                }
                costMatrix[row][col]+=matrix[row][col];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++) {
            minSum = Math.min(minSum, costMatrix[0][i]);
        }
        return minSum;
    }
}
