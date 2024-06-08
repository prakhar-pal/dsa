package lc.ArraysAndStrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/4sum-ii/
 */
public class A15FourSumPart2 {
    public static void main(String[] args) {
        A15Solution solution = new A15SolutionTwo();
        assert solution.fourSumCount(new int[] {1,2}, new int[] {-2,-1}, new int[] {-1,2}, new int[] {0,2}) == 2;
        assert solution.fourSumCount(new int[] {0}, new int[] {0}, new int[] {0}, new int[] {0}) == 1;
    }
}

interface A15Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4);
}

class A15SolutionOne implements A15Solution {
   // beats 70.58%
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        HashMap<Integer, Integer> sumMap1 = new HashMap<>();
        for(int a: nums1) {
            for(int b: nums2) {
                sumMap1.put(a+b, sumMap1.getOrDefault(a+b, 0) +1);
            }
        }
        for(int c: nums3) {
            for(int d: nums4) {
                count+=sumMap1.getOrDefault(-(c+d),0);
            }
        }
        return count;
    }
}

class A15SolutionTwo implements A15Solution {
    // todo: read more about why this algorithm works
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] m1 = getMaxMin(nums1);
        int[] m2 = getMaxMin(nums2);
        int[] m3 = getMaxMin(nums3);
        int[] m4 = getMaxMin(nums4);

        int max = Math.max((m1[0]+m2[0]), -(m3[1]+m4[1]));
        int min = Math.min((m1[1]+m2[1]), -(m3[0]+m4[0]));

        int[] dp = new int[max-min+1];
        
        for(int i: nums1){
            for(int j: nums2){
                dp[i+j-min]++;
            }
        }

        int res = 0;
        for(int x: nums3){
            for(int y: nums4){
                res += dp[-(x+y)-min];
            }
        }
        
        return res;
    }
    private int[] getMaxMin(int[] nums){
        int[] res = new int[2];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MAX_VALUE;
        for(int n: nums){
            res[0] = Math.max(res[0], n);
            res[1] = Math.min(res[1], n);
        }
        return res;
    }
}
