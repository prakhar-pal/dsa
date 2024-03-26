// https://leetcode.com/problems/maximum-subarray/
// AKA kadane's algorithm

class Solution {
    public int maxSubArray(int[] arr){
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int value: arr){
            localMax = Math.max(value, localMax + value);
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}

public class U2MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-5,-6,-7,-1,-2,-3};
        Solution sol = new Solution();
        assert sol.maxSubArray(nums) == -1;
    }
}
