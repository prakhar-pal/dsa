package lc.Sorting.Algorithms;

import lc.common.Logger;

public class Sorting {

    public static void main(String[] args) {
        if (args.length == 0) {
            Logger.log("Usage: java -ea lc.common.Sorting <algorithm>");
            return;
        }
        Sorter sorter;
        Logger.log("Using " + args[0] + " sorting algorithm");
        switch (args[0]) {
            case "insertion":
                sorter = new InsertionSort();
                break;
            case "selection-sort":
                sorter = new SelectionSorter();
                break;
            case "quick-sort":
                sorter = new QuickSort();
                break;
            default:
                Logger.log("didn't find any matching algorithm, using bubble sort as default");
                sorter = new BubbleSort();
                break;
        }
        int[] arr1 = new int[] { 3, 2, 1 };
        sorter.sort(arr1);
        assert isSortedArray(arr1);

        int[] arr2 = new int[] { 1,2,3 };
        sorter.sort(arr2);
        assert isSortedArray(arr2);

        int[] arr3 = new int[] { };
        sorter.sort(arr3);
        assert isSortedArray(arr3);
        
        int[] arr4 = new int[] { 1,2,3,9,8,7,6};
        sorter.sort(arr4);
        assert isSortedArray(arr4);
    }

    private static boolean isSortedArray(int[] arr) {
        boolean result = true;
        for (int i = 1; i < arr.length && result; i++) {
            if (arr[i - 1] > arr[i]) {
                result = false;
            }
        }
        if(!result) {
            Logger.log("Not sorted");
            for(int n: arr) {
                Logger.logi(n);
            }
            Logger.log("");
        }
        return result;
    }
}
class SelectionSorter implements Sorter {
    public void sort(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            int minIndex = i;
            for(int j=i;j<arr.length;j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
