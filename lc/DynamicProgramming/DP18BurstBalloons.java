package lc.DynamicProgramming;

import java.util.*;

/**
 * https://leetcode.com/problems/burst-balloons/description/
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class DP18BurstBalloons {
    public static void main(String[] args) {
        DP18Solution sol = new DP18SolutionTwo();
        assert sol.maxCoins(new int[] {3,1,5,8}) == 167;
        assert sol.maxCoins(new int[] {1,5}) == 10;
        assert sol.maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}) == 3630;
    }
}

class DP18SolutionTwo implements DP18Solution {
    // https://leetcode.com/problems/burst-balloons/solutions/76228/share-some-analysis-and-explanations/
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }
}

interface DP18Solution {
    public int maxCoins(int[] nums);
}

class DP18SolutionOne implements DP18Solution {
    // exponential solution
    public int maxCoins(int[] nums) {
        List<Integer> indices = new ArrayList<>(nums.length);
        for(int i=0;i<nums.length;i++) {
            indices.add(i);
        }

        return maxCoinsDp(nums, indices, new HashMap<>());
    }

    public int maxCoinsDp(int nums[], List<Integer> indices, HashMap<List<Integer>, Integer> memo) {
        if(memo.containsKey(indices)) {
            return memo.get(indices);
        }
        int result = 0;
        for(int i=0;i<indices.size();i++) {
            int wonCoins = nums[indices.get(i)];
            int previousIndex = (i-1) >= 0 ? indices.get(i-1) : -1;
            if(previousIndex >= 0) {
                wonCoins *= nums[previousIndex];
            }
            int nextIndex = (i+1) < indices.size() ? indices.get(i+1) : nums.length;
            if(nextIndex < nums.length) {
                wonCoins *= nums[nextIndex];
            }
            List<Integer> remainingIndices = new ArrayList<>();
            for(int j=0;j<indices.size();j++) {
                if(i==j) {
                    continue;
                }
                remainingIndices.add(indices.get(j));
            }
            result = Math.max(result, wonCoins + maxCoinsDp(nums, remainingIndices, memo));
        }
        memo.put(indices, result);
        return result;
    }
}
