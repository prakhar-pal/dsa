package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class A22SortIntegerArray {
    public static void main(String[] args) {
        A22Solution solution = new A22Solution();

        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{}), new int[] {});
        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{5,2,3,1}), new int[] {1,2,3,5});
        assert ArrayUtils.isSame1DArray(solution.sortArray(new int[]{5,1,1,2,0,0}), new int[] {0,0,1,1,2,5});
    }
}

class A22Solution {
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
