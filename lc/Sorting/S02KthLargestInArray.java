package lc.Sorting;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

interface SolutionP2KthLargestInArray {
    public int findKthLargest(int[] nums, int k);
}
class SolutionP2KthLargestInArray1 implements SolutionP2KthLargestInArray {
    // slow solution O(nlogn) where n = nums.length
    // beats 11.3%
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }

        Collections.sort(list);
        return list.get(nums.length - k);
    }
}

class SolutionP2KthLargestInArray2 implements SolutionP2KthLargestInArray {
    // using quick select
    // TLEs passes all tests
    public int findKthLargest(int[] nums, int k){
        return findUsingQuickSelect(nums, 0, nums.length-1, k);
    }

    public int findUsingQuickSelect(int[] nums, int left, int right, int k){
        Random random = new Random();
        int pivotIndex = random.nextInt(left, right + 1);
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        pivotIndex = left;
        for(int i=left;i<right;i++){
            if(nums[i] < nums[right]) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, pivotIndex, right);
        int kthSmallest = nums.length - k;
        if(pivotIndex == kthSmallest){
            return nums[pivotIndex];
        }
        if(pivotIndex > kthSmallest) {
            return findUsingQuickSelect(nums, 0, pivotIndex-1, k);
        }
        return findUsingQuickSelect(nums, pivotIndex+1, right, k);
    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

class S02KthLargestInArray {
    public static void main(String[] args) {
        SolutionP2KthLargestInArray sol = new SolutionP2KthLargestInArray2();
        int[][] case1 = {
            {3,2,1,5,6,4},
            {2}
        };
        assert sol.findKthLargest(case1[0], case1[1][0]) == 5;

        int[][] case2 = {
            {3,2,3,1,2,4,5,5,6},
            {4}
        };
        assert sol.findKthLargest(case2[0], case2[1][0]) == 4;
        
        int[][] case3 = {
            {-1,-1},
            {2}
        };
        assert sol.findKthLargest(case3[0], case3[1][0]) == -1;
    }
}
