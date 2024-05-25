package lc.Sorting.Algorithms;

public class InsertionSort implements Sorter {
    public void sort(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            int j=i;
            while(j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
