package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
public class S07IncTripletSeq {
    public static void main(String[] args) {
        S07Solution sol = new S07Solution();
        assert sol.increasingTriplet(new int[] {1,2,3,4,5});
        assert sol.increasingTriplet(new int[] {2,1,5,0,4,6});
        assert sol.increasingTriplet(new int[] {5,4,3,2,1}) == false;
        assert sol.increasingTriplet(new int[] {}) == false;
        assert sol.increasingTriplet(new int[] {20,100,10,12,5,13});
    }
}

class S07Solution {
    /**
     * Runtime complexity O(n)
     * Space complexity O(n)
     */
    public boolean increasingTriplet(int[] nums) {
        int numLength = nums.length;
        if(numLength < 3) {
            return false;
        }
        int[] minNums = new int[numLength];
        int[] maxNums = new int[numLength];
        for(int i=0;i<numLength;i++) {
            if(i==0) {
                minNums[0] = nums[0];
                maxNums[numLength - 1] = nums[numLength - 1];
                continue;
            }
            minNums[i] = Math.min(minNums[i-1], nums[i]);
            int ri = numLength - i - 1;
            maxNums[ri] = Math.max(maxNums[ri+1], nums[ri]);
        }

        for(int i=1;i<numLength-1;i++) {
            if(minNums[i-1] < nums[i] && nums[i] < maxNums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
