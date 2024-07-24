package lc.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import lc.utils.MathUtils;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *  0 <= j <= nums[i] and
 *   i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */

public class DP04MinJumpGame {
    public static void main(String[] args) {
        IDP02Solution sol = new DP02Solution();
        assert sol.jump(new int[] {2,3,1,1,4}) == 2;
        assert sol.jump(new int[] {2,3,0,1,4}) == 2;
        assert sol.jump(new int[] {0}) == 0;
    } 
}

interface IDP02Solution {
    public int jump(int[] nums);
}
class DP02Solution implements IDP02Solution {
    /**
     * own solution
     * Uses dynamic programming
     * Runtime 751ms, Beats 5.07% of users with Java
     * Memory 56.98MB, Beats 6.15% of users with Java
     */
    int[] reachDP;
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        reachDP = new int[nums.length];
        populateMinJumps(nums, nums.length-1);
        return reachDP[nums.length-1];
    }

    private int min(List<Integer> list) {
        Integer minValue = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(list.get(i) < minValue) {
                minValue = list.get(i);
            }
        }
        return minValue;
    }
    public void populateMinJumps(int[] nums, int index) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=index-1;i>=0;i--) {
            if(index <= nums[i] + i) {
                int jumpCount = 0;
                if(i != 0) {
                    if(reachDP[i] == 0) {
                        populateMinJumps(nums, i);
                    }
                    jumpCount = reachDP[i];
                }
                list.add(1 + jumpCount);
            }
        }
        reachDP[index] = min(list);
    }
}

class DP02SolutionTwo implements IDP02Solution {
    /*
     * Faster solution
     * from leetcode
     */

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        return helper(nums, 0, 1);
    }

    private int helper(int[] nums, int start, int end) {
        int maxJump = 0;
        for(int i = start; i < end; ++i) {
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        if (maxJump + 1 >= nums.length) {
            return 1;
        }
        return 1 + helper(nums, end, maxJump + 1);
    }
}
