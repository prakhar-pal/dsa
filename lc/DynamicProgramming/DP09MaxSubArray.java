package lc.DynamicProgramming;
// https://leetcode.com/problems/maximum-subarray/
// AKA kadane's algorithm


interface SolutionDP09 {
    public int maxSubArray(int[] arr);
}

class SolutionDP09One implements SolutionDP09 {
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

class SolutionDP09Two implements SolutionDP09 {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int current = nums[0];
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if(num > num + current) {
                current = num;
            } else {
                current = num + current;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
public class DP09MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-5,-6,-7,-1,-2,-3};
        SolutionDP09 sol = new SolutionDP09Two();
        assert sol.maxSubArray(nums) == -1;
    }
}
