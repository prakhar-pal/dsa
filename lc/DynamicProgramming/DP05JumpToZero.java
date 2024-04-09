package lc.DynamicProgramming;

import java.util.*;

/**
 * https://leetcode.com/problems/jump-game-iii/description/
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 * Notice that you can not jump outside of the array at any time.
 */

public class DP05JumpToZero {
    public static void main(String[] args) {
        DP03Solution sol = new DP03SolutionTwo();
        assert sol.canReach(new int[]{4,2,3,0,3,1,2}, 5);
        assert sol.canReach(new int[]{4,2,3,0,3,1,2}, 0);
        assert sol.canReach(new int[]{3,0,2,1,2}, 2) == false;
    }
}

interface DP03Solution {
    public boolean canReach(int[] arr, int start);
}

class DP03SolutionOne implements DP03Solution{
    /**
     * Runtime: better than 83%
     */
    boolean[] dp;
    public boolean canReach(int[] arr, int start) {
        dp = new boolean[arr.length];
        Arrays.fill(dp, false);
        return canReachDp(arr, start);
    }
    private boolean canReachDp(int[] arr, int index) {
        if(dp[index]) {
            return false;
        }
        if(arr[index] == 0) {
            return true;
        }
        dp[index] = true;
        int leftIndex = index - arr[index];
        int rightIndex = index + arr[index];
        boolean canReachFromLeft = leftIndex >=0 && canReachDp(arr, leftIndex);
        boolean canReachFromRight = rightIndex < arr.length && canReachDp(arr, rightIndex);
        return canReachFromLeft || canReachFromRight;
    }
}

class DP03SolutionTwo implements DP03Solution{
    /**
     * marginally faster solution
     * 100%
     */
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int item = queue.poll();
            if (item < 0 || item >= arr.length || arr[item] < 0) continue;
            if (arr[item] == 0) return true;
            
            if(item - arr[item] >= 0) queue.offer(item - arr[item]);
            if(item + arr[item] < arr.length) queue.offer(item + arr[item]);
            arr[item] = item * -1;
        }
        return false;
    }
}
