package lc.DynamicProgramming;

public class DP08LongestIncreasingSubsequence {
    public static void main(String[] args) {
        DP08SolutionOne sol = new DP08SolutionOne();
        System.out.println("sol.lengthOfLIS(new int[]{7,7,7,7,7,7,7})"+sol.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        assert sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) == 4;
        assert sol.lengthOfLIS(new int[]{0,1,0,3,2,3}) == 4;
        assert sol.lengthOfLIS(new int[]{7,7,7,7,7,7,7}) == 1;
    }
}

class DP08SolutionOne {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            result = Math.max(result, lis[i]);
        }
        return result;
    }
}
