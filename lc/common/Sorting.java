package lc.common;

public class Sorting {

    public static void main(String[] args) {
        if (args.length == 0) {
            Logger.log("Usage: java -ea lc.common.Sorting <algorithm>");
            return;
        }
        Sorter sorter = new QuickSorter();
        Logger.log("Using " + args[0] + " sorting algorithm");
        switch (args[0]) {
            case "insertion":
                sorter = new InsertionSorter();
                break;
            case "selection-sort":
                sorter = new SelectionSorter();
                break;
            case "quick-sort":
                sorter = new QuickSorter();
                break;
            default:
                Logger.log("didn't find any matching algorithm, using bubble sort as default");
                sorter = new BubbleSorter();
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

class QuickSorter implements Sorter {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    private void sort(int[] arr, int left, int right) {
        if(right-left <=0 || left < 0 || left >=arr.length || right <0 || right >= arr.length) {
            return;
        }
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
        sort(arr, left, left + cleft-1);
        sort(arr, left + cright + 1 , right);
    }
}
