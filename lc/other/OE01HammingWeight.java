package lc.other;
import lc.common.*;

/**
 * https://leetcode.com/problems/number-of-1-bits/description/
 * Write a function that takes the binary representation of a positive integer and returns the number of set bits it has 
 * (also known as the Hamming weight).
 */
public class OE01HammingWeight {
    public static void main(String[] args) {
        OE01Solution sol = new OE01Solution();
        System.out.println("sol="+sol.hammingWeight(11));
        assert sol.hammingWeight(11) == 3;
        // assert sol.hammingWeight(128) == 1;
        // assert sol.hammingWeight(2147483645) == 30;
        // assert sol.hammingWeight(2147483647) == 31;
    }
}

class OE01Solution {
    NumberToBinary ntb;
    public OE01Solution() {
        if(ntb == null) {
            ntb = new NumberToBinary();
        }
    }
    public int hammingWeight(int n) {
        int[] bits = ntb.convert(n);
        int count = 0;
        for(int i=0;i<bits.length;i++) {
            if(bits[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
