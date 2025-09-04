package lc.BinarySearch;
//https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/
public class B24MinCostArray {
    public static void main(String[] args) {
        B24Solution sol = new B24Solution();
        assert sol.minCost(new int[]{1,3,5,2}, new int[]{2,3,1,14}) == 8;
        assert sol.minCost(new int[]{2,2,2,2,2}, new int[]{4,2,8,1,3}) == 0;
    }
}

class B24Solution {
    public long minCost(int[] nums, int[] cost) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        int low = minValue;
        int high = maxValue;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);

            if (cost1 < cost2) {
    
                high = mid;
            } else {
    
                low = mid + 1;
            }
        }
        return getCost(nums, cost, low);
    }

    private long getCost(int[] nums, int[] cost, int sv) {
        long total = 0;
        for(int i=0;i<nums.length;i++) {
            total += (long)Math.abs(nums[i]-sv) * cost[i];
        }
        return total;
    }
}