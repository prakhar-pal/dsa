package lc.DynamicProgramming;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class DPE01BuyAndSellStock {
   public static void main(String[] args) {
        DPE01Solution sol = new DPE01SolutionTwo();
        assert sol.maxProfit(new int[] {7,1,5,3,6,4}) == 5;
        assert sol.maxProfit(new int[] {7,6,4,3,1}) == 0;
        assert sol.maxProfit(new int[] {1,2,3,4,5,6,7}) == 6;
   } 
}


interface DPE01Solution {
    public int maxProfit(int[] prices);
}

class DPE01SolutionOne implements DPE01Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        if(length == 0) {
            return maxProfit;
        }
        int[] buyPrices = new int[length];
        int[] sellPrices = new int[length];
        buyPrices[0] = prices[0];
        sellPrices[length-1] = prices[length-1];
        for(int i=1;i<length;i++) {
            buyPrices[i] = Math.min(prices[i], buyPrices[i-1]);
            sellPrices[length-1-i] = Math.max(prices[length-1-i], sellPrices[length - i]);
        }
        for(int i=0;i<length-1;i++) {
            maxProfit = Math.max(sellPrices[i+1] - buyPrices[i], maxProfit);
        }
        return maxProfit;
    }
}

class DPE01SolutionTwo implements DPE01Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        int buyPrice = prices[0];
        for(int i=1;i<length;i++){
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        return maxProfit;
    }
}
