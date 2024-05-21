package lc.common;

public class Sorting {

    public static void main(String[] args) {
        if (args.length == 0) {
            Logger.log("Usage: java -ea lc.common.Sorting <algorithm>");
            return;
        }
        int[] arr = new int[] { 3, 2, 1 };
        Sorter sorter;
        Logger.log("Using " + args[0] + " sorting algorithm");
        switch (args[0]) {
            case "insertion":
                sorter = new InsertionSorter();
                break;
            case "selection-sort":
                sorter = new SelectionSorter();
                break;
            default:
                Logger.log("didn't find any matching algorithm, using bubble sort as default");
                sorter = new BubbleSorter();
                break;
        }
        sorter.sort(arr);
        assert isSortedArray(arr);
    }

    private static boolean isSortedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}

interface Sorter {
    public void sort(int[] arr);
}

class BubbleSorter implements Sorter {
    public void sort(int[] arr) {
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    hasSwapped = true;
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}

class InsertionSorter implements Sorter {
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
