package lc.BinarySearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */

public class D02Search2DMatrixPt2 {
    public static void main(String[] args){
        D02Solution sol = new D02Solution();
        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 5);

        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 3);


        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 17);

        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 20) == false;


        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 25) == false;


        assert sol.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        }, 99) == false;
    }
}

/**
 * Initial solution for searching 2d matrix
 * Stats: Runtime = 6ms, Beats 47.60% of users with Java, Memory = 46.19MB Beats10.32% of users with Java
 * Notes: we narrow down the possibilities with maxRow and maxCols using binary search 
 * and then we do binary search on remaining rows selectively
 */
class D02Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int selectRow, selectCol;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0, high = rows - 1;
        while(low<high) {
            int mid = (low + high)/2;
            if(matrix[mid][0] == target) {
                return true;
            }else if(matrix[mid][0] > target) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        selectRow = low;

        low = 0;
        high = cols - 1;
        while(low<high) {
            int mid = (low + high)/2;
            if(matrix[0][mid] == target) {
                return true;
            }else if(matrix[0][mid] > target) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        selectCol = low;
        boolean found = false;
        for(int i=0;i<=selectRow;i++) {
            if(!found && matrix[i][0] <= target && matrix[i][selectCol] >= target) {
                low = 0;
                high = selectCol;
                while(low<=high) {
                    int mid = (low + high)/2;
                    int value = matrix[i][mid];
                    if(value == target) {
                        found = true;
                        break;
                    }else if(value > target) {
                        high = mid - 1;
                    }else {
                        low = mid + 1;
                    }
                }
            }
        }
        return found;
    }
}
