package lc.random;

/**
 * https://leetcode.com/problems/missing-number/
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class R08MissingNumber {
    public static void main(String[] args) {
        OE06Solution sol = new OE06Solution();
        assert sol.missingNumber(new int[] {3,0,1}) == 2;
        assert sol.missingNumber(new int[] {0,1}) == 2;
        assert sol.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}) == 8;
    }
}

class OE06Solution {
    public int missingNumber(int[] nums) {
        boolean[] present = new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            present[nums[i]] = true;
        }
        for(int i=0;i<present.length;i++) {
            if(present[i] == false) {
                return i;
            }
        }
        return -1;
    }
}
