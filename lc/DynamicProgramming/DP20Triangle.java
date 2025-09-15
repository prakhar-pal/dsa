package lc.DynamicProgramming;
import java.util.ArrayList;
import java.util.List;

import lc.utils.ArrayUtils;

class DP20Triangle {
    public static void main(String[] args) {
        // List<List<Integer>> list = ;
        DP20Solution sol = new DP20Solution();
        assert sol.minimumTotal(ArrayUtils.createList(new Integer[][]{
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
        })) == 11;

        assert sol.minimumTotal(ArrayUtils.createList(new Integer[][]{
            {-10},
        })) == -10;
    }
}

class DP20Solution {
    List<List<Integer>> cache;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        cache = new ArrayList<>();
        for(int i=0;i<m;i++) {
            cache.add(new ArrayList<>(triangle.get(i).size()));
        }
        mtUtil(triangle, 0, 0);
        return cache.get(0).get(0);
    }
    private int mtUtil(List<List<Integer>> triangle, int r, int c) {
        if(r >= triangle.size()) {
            return 0;
        }
        List<Integer> row = triangle.get(r);
        if(c >=row.size()) {
            return 0;
        } else {
            if(c >= cache.get(r).size()) {
                int value = triangle.get(r).get(c) + Math.min(mtUtil(triangle, r+1, c), mtUtil(triangle, r+1, c+1));
                // cache[r][c] = value;
                cache.get(r).add(value);
            }
            return cache.get(r).get(c);
        }
    }
}