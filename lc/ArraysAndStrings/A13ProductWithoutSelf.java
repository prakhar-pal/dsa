package lc.ArraysAndStrings;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class A13ProductWithoutSelf {
    public static void main(String[] args) {
        A12Solution solution = new A12Solution();
        assert ArrayUtils.isSame1DArray(solution.productExceptSelf(new int[] {1,2,3,4}), new int[] {24,12,8,6});
        assert ArrayUtils.isSame1DArray(solution.productExceptSelf(new int[] {-1,1,0,-3,3}), new int[] {0,0,9,0,0});
    }
}

class A12Solution {
    public int[] productExceptSelf(int[] nums) {
        int overallProduct = 1;
        int zeroCount = 0;
        for(int num: nums) {
            overallProduct *= num == 0 ? 1 : num;
            if(num == 0) {
                zeroCount++;
            }
        }
        int[] result = new int[nums.length];
        if(zeroCount > 1) {
            return result;
        }
        for(int i=0;i<nums.length;i++) {
            if(zeroCount == 1 && nums[i] != 0) {
                continue;
            }
            result[i] = overallProduct/(nums[i] == 0 ? 1 : nums[i]);
        }
        return result;
    }
}
