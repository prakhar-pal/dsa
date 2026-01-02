package lc.DynamicProgramming;
/**
 * https://leetcode.com/problems/jump-game/description/
 */

public class DP0JumpGame {
    public static void main(String[] args) {
        P0Solution sol = new P0SolutionOne();

        assert sol.canJump(new int[] {2,3,1,1,4}) == true;
        assert sol.canJump(new int[] {3,2,1,0,4}) == false;
        assert sol.canJump(new int[] {0});
    }
}

interface P0Solution {
    public boolean canJump(int[] nums);
}

class P0SolutionOne implements P0Solution{
    /**
     * Runtime 2ms
     * Beats 82.18% of users with Java
     * Memory 45.59MB, Beats 53.41% of users with Java
     */
    public boolean canJump(int[] nums) {
        return canReach(nums, nums.length-1);
    }
    private boolean canReach(int[] nums, int index) {
        if(index < 0) {
            return false;
        }
        for(int i=index-1;i>=0;i--) {
            boolean canJumpToIndex = index <= (i + nums[i]);
            if(canJumpToIndex) {
                if(i == 0) {
                    return true;
                }
                return canReach(nums, i);
            }
        }
        return index == 0;
    }
}


class P0SolutionTwo implements P0Solution{
    /**
     * Runtime 1ms, beats 99.91% of users with Java
     * Memory 47.96MB, beats 19.24% of users with Java
     */
    public boolean canJump(int[] nums) {
        return canReach(nums, nums.length-1);
    }
    private boolean canReach(int[] nums, int index) {
        for(int i=index-1;i>=0;i--) {
            boolean canJumpToIndex = index <= (i + nums[i]);
            if(canJumpToIndex) {
                return canReach(nums, i);
            }
        }
        return index == 0;
    }
}
