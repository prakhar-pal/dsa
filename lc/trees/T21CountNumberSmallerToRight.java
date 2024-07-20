package lc.trees;
import java.util.*;

import lc.ArraysAndStrings.ArrayUtils;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self
 */
public class T21CountNumberSmallerToRight {
    public static void main(String[] args) {
        T21Solution solution = new T21Solution();

        List<Integer> result1 = ArrayUtils.arrayToList(new Integer[] {2,1,1,0});
        assert solution.countSmaller(new int[] {5,2,6,1}).equals(result1);
        
        List<Integer> result2 = ArrayUtils.arrayToList(new Integer[] {0});
        assert solution.countSmaller(new int[] {-1}).equals(result2);
        
        List<Integer> result3 = ArrayUtils.arrayToList(new Integer[] {0,0});
        assert solution.countSmaller(new int[] {-1,1}).equals(result3);
        
        List<Integer> result4 = ArrayUtils.arrayToList(new Integer[] {0,3,1,1,0});
        assert solution.countSmaller(new int[] {1,9,7,8,5}).equals(result4);
    }
}

class Num {
    public int value, index;
    public Num(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class T21Solution {
    // solved using modified merge sort
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        Num[] nums2 = new Num[nums.length];
        for(int i=0;i<nums.length;i++) {
            nums2[i] = new Num(nums[i], i);
        }
        mergeSort(nums2, 0, nums.length-1, count);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            list.add(count[i]);
        }
        return list;
    }
    private Num[] mergeSort(Num[] nums, int left, int right, int[] count) {
        if(left > right) {
            return new Num[]{};
        }
        if(left == right) {
            Num[] result = new Num[1];
            result[0] = nums[left];
            return result;
        }
        int mid = (left+right)/2;
        Num[] leftNums = mergeSort(nums, left, mid, count);
        Num[] rightNums = mergeSort(nums, mid+1, right, count);
        Num[] result = new Num[right - left + 1];
        int i = 0, j = 0, resutIndex = 0;
        while(i < leftNums.length && j < rightNums.length) {
            if(leftNums[i].value > rightNums[j].value) {
                result[resutIndex++] = leftNums[i];
                count[leftNums[i].index] += rightNums.length - j;
                i++;
            }else {
                result[resutIndex++] = rightNums[j];
                j++;
            }
        }
        while (i<leftNums.length) {
            result[resutIndex++] = leftNums[i++];
        }
        while (j<rightNums.length) {
            result[resutIndex++] = rightNums[j++];
        }
        return result;
    }
}
