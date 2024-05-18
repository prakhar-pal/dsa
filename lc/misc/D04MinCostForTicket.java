package lc.misc;
/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/description/
 */
public class D04MinCostForTicket {
    public static void main(String[] args) {
        D04Solution sol = new D04Solution();
        assert sol.mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}) == 11;
        assert sol.mincostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2,7,15}) == 17;
        assert sol.mincostTickets(new int[]{1,4,6,7,8,20}, new int[] {7,2,15}) == 6;
        assert sol.mincostTickets(new int[]{1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29}, new int[] {3,14,50}) == 50;
    }
}
class D04Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        for(int i=0;i<days.length;i++) {
            if(i==0) {
                dp[0] = Math.min(costs[0], costs[1]);
                dp[0] = Math.min(dp[0], costs[2]);
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<costs.length;j++) {
                int passDays = j == 0 ? 1: j==1 ? 7 : 30;
                int lastDay = days[i] - passDays;
                int lastDayCost = 0;
                if(lastDay < days[0]) {
                    lastDayCost = 0;
                }else {
                    int left = 0, right = days.length-1;
                    while((right - left) > 1) {
                        int mid = (left+right)/2;
                        if(days[mid] > lastDay) {
                            right = mid;
                        }else {
                            left = mid;
                        }
                    }
                    lastDayCost = dp[left];
                }
                dp[i] = Math.min(dp[i], lastDayCost + costs[j]);
            }
        }
        return dp[days.length-1];
    }
}
