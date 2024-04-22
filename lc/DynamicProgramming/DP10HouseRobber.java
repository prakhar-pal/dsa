package lc.DynamicProgramming;

/**
 * https://leetcode.com/problems/house-robber/description/
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class DP10HouseRobber {
   public static void main(String[] args) {
        DP10Solution sol = new DP10Solution();
        assert sol.rob(new int[]{1,2,3,1}) == 4;
        assert sol.rob(new int[]{2,7,9,3,1}) == 12;
        assert sol.rob(new int[]{4,1,4,1,1,4,1,4}) == 16;
   } 
}

class DP10Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int maxValue = 0;
        int[] maxArr = new int[nums.length];
        for(int i=length-1;i>=0;i--) {
            int option1 = i + 2 < length ? maxArr[i+2] : 0;
            int option2 = i + 3 < length ? maxArr[i+3] : 0;
            maxArr[i] = nums[i] + Math.max(option1, option2);
            if(maxArr[i] > maxValue) {
                maxValue = maxArr[i];
            }
        }
        return maxValue;
    }
}
