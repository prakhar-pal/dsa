package lc.misc;
/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class D01MinCostStair {
    public static void main(String[] args) {
        D01Solution sol = new D01Solution();
        assert sol.minCostClimbingStairs(new int[] {10,15,20}) == 15;
        assert sol.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}) == 6;
    }
}


class D01Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int prev0 = 0;
        int prev1 = 0;
        for(int i=2;i<=length;i++) {
            int next1 = Math.min(prev1 + cost[i-1], prev0 + cost[i-2]);
            prev0 = prev1;
            prev1 = next1;
        }
        return prev1;
    }
}
