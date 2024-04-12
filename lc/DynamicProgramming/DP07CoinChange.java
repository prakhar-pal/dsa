package lc.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * https://leetcode.com/problems/coin-change/description/
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Constraints
 *  1 <= coins.length <= 12
 *  1 <= coins[i] <= 231 - 1
 *  0 <= amount <= 104
 */

public class DP07CoinChange {
    public static void main(String[] args){
        DP07Solution sol = new DP07SolutionTwo();
        // System.out.println("the big one"+sol.coinChange(new int[] {411,412,413,414,415,416,417,418,419,420,421,422},9864));
        // assert sol.coinChange(new int[] {1,2,5}, 11) == 3;
        // assert sol.coinChange(new int[] {2}, 3) == -1;
        // assert sol.coinChange(new int[] {1}, 0) == 0;
        // assert sol.coinChange(new int[]{186,419,83,408}, 6249) == 20;
        // assert sol.coinChange(new int[]{1,2,5} , 3) == 2;
        // assert sol.coinChange(new int[]{1,2,5} , 9) == 3;
        // assert sol.coinChange(new int[]{1,2} , 9) == 5;
        assert sol.coinChange(new int[] {411,412,413,414,415,416,417,418,419,420,421,422},9864) == 24;
    }
}

interface DP07Solution {
    public int coinChange(int[] coins, int amount);
}


class DP07SolutionTwo implements DP07Solution {
    /**
     * This builds on classic knapsack problem (unbounded form)
     * In this solution, we use dynamic programming with tabulation format (considered as bottom up solution)
     * Here, we start with a base case by taking first currency and finding required coins for amount 0...<amount>
     * For next set of coins, we find the required coins by picking or not picking the current coin and using the dp[prevCoin][remainder]
     */
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        Arrays.sort(coins);
        for(int j=0;j<=amount;j++) {
            for(int i=0;i<coins.length;i++) {
                if(i==0) {
                    dp[i][j] = j % coins[i] == 0 ? (int)j/coins[i] : -1;
                }else {
                    if(coins[i] <= j) {
                        int minCoins = Integer.MAX_VALUE;
                        for(int k=0;k*coins[i]<=j;k++) {
                            int remainder = j - k*coins[i];
                            int prevRequiredCoins = dp[i-1][remainder];
                            if(prevRequiredCoins == -1) {
                                continue;
                            }
                            minCoins = Math.min(minCoins, prevRequiredCoins + k);
                        }
                        if(minCoins == Integer.MAX_VALUE) {
                            minCoins = -1;
                        }
                        dp[i][j] = minCoins;
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}

class DP07SolutionOne implements DP07Solution {
    /**
     * This solution should be ignored because
     * 1. The solution is exponential
     */
    private int dp[][];
    public int getMinInList(List<Integer> list) {
        int minValue = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(list.get(i).compareTo(minValue) < 0) {
                minValue = list.get(i);
            }
        }
        return minValue;
    }
    public int coinChange(int[] coins, int amount) {
        Date prevDate = new Date();
        dp = new int[amount+1][coins.length];
        int total = coinChange(coins, amount, coins.length-1);
        Date currenDate = new Date();
        System.out.println(coins + ", time =" + (currenDate.getTime() - prevDate.getTime())/1000*1.0);
        return total;
    }
    public int coinChange(int[] coins, int amount, int end){
        if(dp[amount][end] != 0) {
            return dp[amount][end];
        }
        if(amount == 0) {
            return 0;
        }
        if(end == 0) {
            if(amount % coins[end] == 0) {
                return amount/coins[end];
            }
            return -1;
        }
        if(coins[end] > amount) {
            int res = coinChange(coins, amount, end-1);
            return res;
        }
        List<Integer> combinationList = new ArrayList<>();
        for(int i=0;i*coins[end] <= amount; i++) {
            combinationList.add(coinChange(coins, amount - i*coins[end], end-1));
        }
        List<Integer> listWithValidResults = new ArrayList<>();
        for(int i=0;i<combinationList.size();i++) {
            int num = combinationList.get(i);
            if(num != -1) {
                listWithValidResults.add(num+i);
            }
        }
        if(listWithValidResults.size() == 0) {
            return -1;
        }
        dp[amount][end] = getMinInList(listWithValidResults);
        return dp[amount][end];
    }
}
