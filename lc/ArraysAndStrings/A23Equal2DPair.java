package lc.ArraysAndStrings;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/equal-row-and-column-pairs/description/ 

class A23Equal2DPair {
    public static void main(String[] args) {
        A23Solution sol = new A23Solution();
        assert sol.equalPairs(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } }) == 1;
        assert sol.equalPairs(new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } }) == 3;
    }
}

class A23Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] row : grid) {
            int hashValue = hashArray(row);
            List<int[]> list = map.getOrDefault(hashValue, new ArrayList<>());
            list.add(row);
            map.put(hashValue, list);
        }

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            int hashValue = hashArray(col);
            if (map.containsKey(hashValue)) {

                List<int[]> matchedRows = map.get(hashValue);
                for (int[] row : matchedRows) {
                    if (isSameArray(row, col)) {
                        count++;
                    }
                    ;
                }
            }
        }

        return count;
    }

    private int hashArray(int[] arr) {
        return Arrays.hashCode(arr);
    }

    public static boolean isSameArray(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {

            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {

                return false;
            }
        }

        return true;
    }
}
