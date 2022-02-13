// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/

class Solution {
    public int maxProfit(int[] prices) {
		int profit = 0;
		for(int i=0;i<prices.length-1;i++){
			if(prices[i+1] > prices[i]){
				profit += prices[i+1] - prices[i];
			}
		}
        return profit;
    }
}

class A02MaxProfit2 {
	public static void main(String[] args){
		Solution sol = new Solution();

		// tc 1
		int prices1[] = {7,1,5,3,6,4};
		int result1 = 7;

		// tc2
		int prices2[] = {1,2,3,4,5};
		int result2 = 4;

		// tc3
		int prices3[] = {7,6,4,3,1};
		int result3 = 0;

		assert sol.maxProfit(prices1) == result1;
		assert sol.maxProfit(prices2) == result2;
		assert sol.maxProfit(prices3) == result3;
	}	
}