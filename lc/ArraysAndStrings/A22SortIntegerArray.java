package lc.ArraysAndStrings;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class A22SortIntegerArray {
    public static void main(String[] args) {
        A22Solution solution = new A22SolutionTwo();

        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{}), new int[] {});
        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{2,1}), new int[] {1,2});
        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{5,2,3,1}), new int[] {1,2,3,5});
        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{5,1,1,2,0,0}), new int[] {0,0,1,1,2,5});
    }
}

interface A22Solution {
    public int[] sortArray(int[] nums);
}

class A22SolutionOne implements A22Solution {
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end)/2;
        sortArray(arr, start, mid);
        sortArray(arr, mid+1, end);
        int leftIndex = start, rightIndex = mid + 1;
        int[] sortedArray = new int[end-start+1];
        int sortedArrIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if(arr[leftIndex] < arr[rightIndex]) {
                sortedArray[sortedArrIndex] = arr[leftIndex++];
            }else {
                sortedArray[sortedArrIndex] = arr[rightIndex++];
            }
            sortedArrIndex++;
        }
        while(leftIndex <= mid) {
            sortedArray[sortedArrIndex++] = arr[leftIndex++];
        }
        while(rightIndex <= end) {
            sortedArray[sortedArrIndex++] = arr[rightIndex++];
        }
        for(int i=0;i<sortedArray.length;i++) {
            arr[start+i] = sortedArray[i];
        }
    }
}



class A22SolutionTwo implements A22Solution {
    /** using quick sort */
    /** this isn't fast enough for leetcode */
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int start, int end) {
        if(start >= end || end >= nums.length) {
            return;
        }
        int pivotIndex = partition2(nums, start, end);
        sortArray(nums, start, pivotIndex-1);
        sortArray(nums, pivotIndex + 1, end);
    }


    private int partition2(int[] arr, int left, int right) {
        int pivotIndex = (left+right)/2;
        int pivotElement = arr[pivotIndex];
        int[] copy = new int[right-left+1];
        int cleft = 0, cright = copy.length-1;
        int index = 0;
        while(index != copy.length) {
            int element = arr[index+left];
            if(element < pivotElement) {
                copy[cleft] = element;
                cleft++;
            }else if(element > pivotElement){
                copy[cright] = element;
                cright--;
            }
            index++;
        }
        for(int i=0;i<copy.length;i++) {
            if(i>=cleft && i<=cright) {
                arr[left+i] = pivotElement;
            }else {
                arr[left+i] = copy[i];
            }
        }
        return left + cleft;
    }
}
