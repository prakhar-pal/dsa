package lc.random;

import lc.utils.NumberToBinary;

/**
 * https://leetcode.com/problems/hamming-distance/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 */
public class R04HammingDistance {
   public static void main(String[] args) {
        OE02Solution sol = new OE02SolutionTwo();
        assert sol.hammingDistance(1, 4) == 2;
        assert sol.hammingDistance(3, 1) == 1;
   } 
}

interface OE02Solution {
    public int hammingDistance(int x, int y);
}

class OE02SolutionOne implements OE02Solution {
    NumberToBinary ntb;
    public OE02SolutionOne() {
        if(ntb == null) {
            ntb = new NumberToBinary();
        }
    }
    public int hammingDistance(int x, int y) {
        int[] bitx = ntb.convert(x);
        int[] bity = ntb.convert(y);
        int distance = 0;
        for(int i=0;i<bitx.length;i++) {
            if(bitx[i] != bity[i]) {
                distance++;
            }
        }
        return distance;
    }
}

class OE02SolutionTwo implements OE02Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;        
        int distance = 0;
        while (xorResult != 0) {
            distance += xorResult & 1;
            xorResult >>= 1;
        }
        return distance;
    }
}

