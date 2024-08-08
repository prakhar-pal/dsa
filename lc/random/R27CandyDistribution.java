package lc.random;

/**
 * https://leetcode.com/problems/candy/
 */
public class R27CandyDistribution {
    public static void main(String[] args) {
        R27Solution solution = new R27Solution();
        assert solution.candy(new int[]{1,0,2}) == 5;
        assert solution.candy(new int[]{1,2,2}) == 4;
        assert solution.candy(new int[]{1,2,2}) == 4;
        assert solution.candy(new int[]{1,2,3}) == 6;
        assert solution.candy(new int[]{3,2,1}) == 6;
    }
}

class R27Solution {
    public int candy(int[] ratings) {
        int totalCandies = 0;
        int[] candies = new int[ratings.length];
        for(int i=0;i<ratings.length;i++) {
            candies[i] = 1;
        }
        // boolean isRightMin = i < ratings.length - 1 ? ratings[i+1] < ratings[i] : false;
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i+1] < ratings[i]) {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        for(int i=0;i<ratings.length;i++) {
            totalCandies+=candies[i];
        }
        return totalCandies;
    }
}

