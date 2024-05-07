package lc.DynamicProgramming;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class DPH04PerfectSquares {
    public static void main(String[] args) {
        DPH04Solution sol = new DPH04Solution();
        assert sol.numSquares(0) == 0;
        assert sol.numSquares(12) == 3;
        assert sol.numSquares(13) == 2;
    }
}

class DPH04Solution {
    PerfectSquares ps;
    public DPH04Solution() {
        if(ps == null) {
            ps = new PerfectSquares();
        }
    }


    public int numSquares(int n) {
        return ps.numSquares(n);
    }
}

class PerfectSquares {
    HashMap<Integer, Integer> map;
    public PerfectSquares() {
        map = new HashMap<>();
    }
    public int numSquares(int n) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n<=0) {
            map.put(0, 0);
            return 0;
        }
        int sqrt = (int)Math.sqrt(n);
        int csqrt = sqrt;
        int nums = Integer.MAX_VALUE;
        while(csqrt > 0) {
            int contributor = csqrt*csqrt;
            int dividend = n/contributor;
            nums = Math.min(nums, dividend + numSquares(n - dividend * contributor));
            csqrt--;
        }
        map.put(n, nums);
        return nums;
    }
}
