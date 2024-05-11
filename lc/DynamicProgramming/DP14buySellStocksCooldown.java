package lc.DynamicProgramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class DP14buySellStocksCooldown {
   public static void main(String[] args) {
        DPH03Solution sol = new DPH03Solution();
        System.out.println("sol" + sol.maxProfit(new int[]{6,1,3,2,4,7}));
        assert sol.maxProfit(new int[] {1}) == 0;
        assert sol.maxProfit(new int[] {1,2,3,0,2}) == 3;
        assert sol.maxProfit(new int[] {1,2,3,4,5,6}) == 5;
        assert sol.maxProfit(new int[] {2,1,4}) == 3;
        assert sol.maxProfit(new int[]{6,1,3,2,4,7}) == 6;
   } 
}

class DPH03Solution {
    int[] selling;
    int[] buying;
    public int maxProfit(int[] prices) {
        selling = new int [prices.length];
        buying = new int [prices.length];
        return maxProfit(prices, 0, true);
    }

    private int maxProfit(int[] prices, int index, boolean isBuying) {
        if(index >= prices.length) {
            return 0;
        }
        if(isBuying && buying[index] != 0) {
            return buying[index];
        }
        if(!isBuying && selling[index] != 0) {
            return selling[index];
        }

        int profit = maxProfit(prices, index + 1, isBuying);

        if(isBuying) {
            profit = Math.max(maxProfit(prices, index + 1, !isBuying) - prices[index], profit);
            buying[index] = profit;
        }else {
            profit = Math.max(maxProfit(prices, index + 2, true) + prices[index], profit);
            selling[index] = profit;
        }
        return profit;
    }
}
