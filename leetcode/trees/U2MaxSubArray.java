// https://leetcode.com/problems/maximum-subarray/

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
        // int[]nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-5,-6,-7,-1,-2,-3};
        Solution s = new Solution();
        System.out.println("max sub arr tot is:"+s.maxSubArray(nums));
    }
}