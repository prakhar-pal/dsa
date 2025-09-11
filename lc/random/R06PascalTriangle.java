package lc.random;
import java.util.*;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class R06PascalTriangle {
    public static void main(String[] args) {
        OE04Solution sol = new OE04Solution();

        List<List<Integer>> result1 = new ArrayList<>();
        List<Integer> result11 = new ArrayList<>();
        result11.add(1);
        result1.add(result11);
        assert sol.generate(1).equals(result1);


        List<List<Integer>> result2 = new ArrayList<>();
        result2.add(ArrayUtils.arrayToList(new Integer[]{1}));
        result2.add(ArrayUtils.arrayToList(new Integer[]{1,1}));
        result2.add(ArrayUtils.arrayToList(new Integer[]{1,2,1}));
        result2.add(ArrayUtils.arrayToList(new Integer[]{1,3,3,1}));
        result2.add(ArrayUtils.arrayToList(new Integer[]{1,4,6,4,1}));
        assert sol.generate(5).equals(result2);
    }
}

class OE04Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        int rowCount = 1;
        while(rowCount< numRows) {
            List<Integer> lastRow = result.get(rowCount-1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int i=1;i<lastRow.size();i++) {
                newRow.add(lastRow.get(i-1) + lastRow.get(i));
            }
            newRow.add(1);
            result.add(newRow);
            rowCount++;
        }
        return result;
    }
}
