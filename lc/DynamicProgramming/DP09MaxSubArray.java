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

public class DP09MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-5,-6,-7,-1,-2,-3};
        SolutionDP09 sol = new SolutionDP09One();
        System.out.println("sol"+ sol.maxSubArray(nums));
        assert sol.maxSubArray(nums) == -1;
    }
}
