package lc.Sorting.Algorithms;

import java.util.*;

import lc.utils.Logger;

/**
 * benchmarks run time of different sorting algorithms
 * results are as following
 * arrayLength BubbleSort  InsertionSort      QuickSort
 * 1000            13           9                12
 * 10000         1408          281               74
 * 20000         5674           1042            116
 */

public class SortingBenchmark {
    public static void main(String[] args) {
        if(args.length == 0) {
            Logger.log("Usage:\n java S07Benchmark <arrayLength>");
            return;
        }
        int arrayLength = Integer.parseInt(args[0]);
        Map<String, Sorter> sortingAlgos = new HashMap<>();
        // sortingAlgos.put("BubbleSort", new BubbleSort());
        // sortingAlgos.put("InsertionSort", new InsertionSort());
        sortingAlgos.put("MergeSort", new MergeSort());
        sortingAlgos.put("QuickSort", new QuickSort());
        ArrayList<Long> averageTimes = new ArrayList<>();
        for(String sortingAlgo: sortingAlgos.keySet()) {
            int iterations = 10;
            SortingConfig config = new SortingConfig(sortingAlgos.get(sortingAlgo), arrayLength);
            long startTime = System.currentTimeMillis();
            while(iterations!=0) {
                iterations--;
                config.runConfig();
            }
            long endTime = System.currentTimeMillis();
            averageTimes.add(endTime-startTime);
        }
        for(String algo: sortingAlgos.keySet()) {
            Logger.printf("%15s", algo);
        }
        Logger.log("");
        for(long time: averageTimes) {
            Logger.printf("%15s", time);
        }
        Logger.log("");
    }
}


class SortingConfig {
    private static int[] arr;
    Sorter sorter;
    public SortingConfig(Sorter _sorter, int arrayLength) {
        this.sorter = _sorter;
        if(SortingConfig.arr == null) {
            Random random = new Random();
            int[] randomArray= new int[arrayLength];
            for(int i=0;i<randomArray.length;i++) {
                randomArray[i] = random.nextInt(arrayLength);
            }
            SortingConfig.arr = randomArray;
        }
    }
    public void runConfig() {
        int[] duplArr = Arrays.copyOf(SortingConfig.arr, SortingConfig.arr.length);
        for(int i=0;i<10;i++){
            sorter.sort(duplArr);
        }
    }
}
