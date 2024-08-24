package lc.random;
/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class R31MinSizeSubarrSum {
    public static void main(String[] args) {
        R31Solution solution = new R31Solution();
        assert solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}) == 2;
        assert solution.minSubArrayLen(4, new int[] {1,4,4}) == 1;
        assert solution.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}) == 0;
    }
}


class R31Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = nums.length+1;
        int s = 0, start = 0, end = 0;
        while(end < nums.length) {
            s += nums[end];
            while(s >= target) {
                minLength = Math.min(minLength, end-start+1);
                s-=nums[start];
                start++;
            }
            end++;
        }
        return minLength == nums.length + 1 ? 0 : minLength;   
    }
}
