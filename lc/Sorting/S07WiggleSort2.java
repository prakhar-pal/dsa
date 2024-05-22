package lc.Sorting;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class S07WiggleSort2 {
    public static void main(String[] args) {
        S07Solution sol = new S07Solution();
        int[] arr1 = new int[] {1,5,1,1,6,4};
        sol.wiggleSort(arr1);
        assert isWiggleSorted2(arr1);
        int[] arr2 = new int[] {1,3,2,2,3,1};
        sol.wiggleSort(arr2);
        assert isWiggleSorted2(arr2);
    }

    private static boolean isWiggleSorted2(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            if(i % 2 == 0 && arr[i] >= arr[i+1]) {
                return false;
            }
            if(i%2 ==1 && arr[i] <= arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
class S07Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int i=1, j = nums.length-1;
        while(i<nums.length) {
            result[i] = nums[j];
            j--;
            i+=2;
        }
        i=0;
        while(i<nums.length) {
            result[i] = nums[j];
            j--;
            i+=2;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
