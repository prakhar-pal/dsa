package lc.random;
/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class R05ReverseBits {
    public static void main(String[] args) {
        OE03Solution sol = new OE03Solution();
        assert sol.reverseBits(43261596) == 964176192;

    }
}

class OE03Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for(int i=0;i<32;i++) {
            boolean isBitSet = (n & 1) == 1;
            reversed <<= 1;
            n >>= 1;
            if(isBitSet) {
                reversed+=1;
            }
        }
        return reversed;
    }
}
