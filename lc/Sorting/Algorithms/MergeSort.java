package lc.Sorting.Algorithms;

public class MergeSort implements Sorter {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    private void sort(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end)/2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
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
