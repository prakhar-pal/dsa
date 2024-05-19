package lc.Sorting;

import lc.ArraysAndStrings.ArrayUtils;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class S05MergeSortedArrays {
    public static void main(String[] args) {
        SO01Solution sol = new SO01Solution();

        int[] arr1 = new int[]{1,2,3,0,0,0};
        sol.merge(arr1, 3, new int[]{2,5,6}, 3);
        assert ArrayUtils.isSame1DArray(arr1, new int[]{1,2,2,3,5,6});

        int[] arr2 = new int[]{1};
        sol.merge(arr2, 1, new int[]{}, 0);
        assert ArrayUtils.isSame1DArray(arr2, new int[]{1});

        int[] arr3 = new int[]{0};
        sol.merge(arr3, 0, new int[]{1}, 1);
        assert ArrayUtils.isSame1DArray(arr3, new int[]{1});
    }
}

class SO01Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int index1=0,index2=0, index = 0;
        while(index1 < m && index2 < n) {
            if(nums1[index1] < nums2[index2]) {
                result[index++] = nums1[index1++];
            }else {
                result[index++] = nums2[index2++];
            }
        }
        while(index1 < m) {
            result[index++] = nums1[index1++];
        }
        while(index2 < n) {
            result[index++] = nums2[index2++];
        }
        for(int i=0;i<m+n;i++) {
            nums1[i] = result[i];
        }
    }
}
