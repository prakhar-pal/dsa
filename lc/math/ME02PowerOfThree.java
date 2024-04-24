package lc.math;

/**
 * https://leetcode.com/problems/power-of-three/
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 */
public class ME02PowerOfThree {
    public static void main(String[] args) {
        ME02Solution sol = new ME02Solution();
        assert !sol.isPowerOfThree(-1);
        assert !sol.isPowerOfThree(0);
        assert sol.isPowerOfThree(1);
        assert sol.isPowerOfThree(3);
        assert sol.isPowerOfThree(27);
        assert sol.isPowerOfThree(243);
        assert sol.isPowerOfThree(1162261467);
    }
}

class ME02Solution {
    public boolean isPowerOfThree(int n) {
        double n1 = n;
        while(n1 >= 3) {
            n1 = n1/3;
        }
        double one = 3.0/3;
        return n1 == one;
    }
}
