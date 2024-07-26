package lc.Sorting.Algorithms;

public class QuickSort implements Sorter {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    private void sort(int[] arr, int left, int right) {
        if(right-left <=0 || left < 0 || left >=arr.length || right <0 || right >= arr.length) {
            return;
        }
        int pivotIndex = partitionArrayNaive(arr, left, right);
        sort(arr, left, pivotIndex-1);
        sort(arr, pivotIndex + 1 , right);
    }

    private int partitionArray(int[] arr, int left, int right) {
        /**
         * https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
         */
        int pivot = arr[right];
        int pivotIndex = left;
        for(int i=left;i<right;i++) {
            if(arr[i] <= pivot) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, right, pivotIndex);
        return pivotIndex;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partitionArrayNaive(int[] arr, int left, int right) {
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

