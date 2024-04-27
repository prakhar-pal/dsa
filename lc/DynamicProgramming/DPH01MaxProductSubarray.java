package lc.DynamicProgramming;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Given an integer array nums, find a subarray
 * that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class DPH01MaxProductSubarray {
    public static void main(String[] args) {
        DPH01Solution sol = new DPH01Solution();
        assert sol.maxProduct(new int[]{2,3,-2,4}) == 6;
        assert sol.maxProduct(new int[]{-2,0,-1}) == 0;
        assert sol.maxProduct(new int[]{1,2,3,0,-4,-6}) == 24;
        assert sol.maxProduct(new int[]{2,3,1,-4,-6}) == 144;
        assert sol.maxProduct(new int[]{2,-5,-2,-4,3}) == 24;
    }
}


class DPH01Solution {
    public int maxProduct(int[] nums) {
        int[] pnums = new int[nums.length];
        int previous = 1;
        Integer previousNegative = null;
        int maxProduct = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]> maxProduct) {
                maxProduct = nums[i];
            }
            pnums[i] = previous*nums[i];
            previous = pnums[i] == 0 ? 1: pnums[i];
            if(pnums[i] < 0) {
                if(previousNegative != null) {
                    maxProduct = Math.max(maxProduct, pnums[i]/previousNegative);
                }else {
                    previousNegative = pnums[i];
                }
            } else if (pnums[i] == 0) {
                previousNegative = null;
            }
            if(pnums[i] > maxProduct) {
                maxProduct = pnums[i];
            }
        }
        return maxProduct;
    }
}
