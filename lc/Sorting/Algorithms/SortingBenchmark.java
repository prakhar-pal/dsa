package lc.Sorting.Algorithms;

import java.util.*;

import lc.utils.Clogger;

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
            Clogger.log("Usage:\n java S07Benchmark <arrayLength>");
            return;
        }
        int arrayLength = Integer.parseInt(args[0]);
        Map<String, Sorter> sortingAlgos = new HashMap<>();
        sortingAlgos.put("BubbleSort", new BubbleSort());
        sortingAlgos.put("InsertionSort", new InsertionSort());
        sortingAlgos.put("MergeSort", new MergeSort());
        sortingAlgos.put("QuickSort", new QuickSort());
        int iterations = 10;
        HashMap<String, List<Long>> timingMap = new HashMap<>();
        while(iterations!=0) {
            iterations--;
            SortingConfig config = new SortingConfig(arrayLength);
            for(String sortingAlgo: sortingAlgos.keySet()) {
                config.setSorter(sortingAlgos.get(sortingAlgo));
                long startTime = System.currentTimeMillis();
                config.runSorter();
                long endTime = System.currentTimeMillis();
                List<Long> timeTookList = timingMap.getOrDefault(sortingAlgo, new ArrayList<>());
                timeTookList.add(endTime - startTime);
                timingMap.put(sortingAlgo, timeTookList);
            }
        }
        for(String algo: timingMap.keySet()) {
            Long averageTime = 0l;
            List<Long> timeTook = timingMap.get(algo);
            for(Long time: timeTook) {
                averageTime += time;
            }
            averageTime /= timeTook.size();
            Clogger.printf("%15s %15s\n", algo, averageTime);
        }
        Clogger.log("");
    }
}


class SortingConfig {
    private static int[] arr;
    Sorter sorter;
    public SortingConfig(int arrayLength) {
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(arrayLength);
        }
        SortingConfig.arr = randomArray;
    }
    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
    public void runSorter() {
        int[] duplArr = Arrays.copyOf(SortingConfig.arr, SortingConfig.arr.length);
        for(int i=0;i<10;i++){
            sorter.sort(duplArr);
        }
    }
}
