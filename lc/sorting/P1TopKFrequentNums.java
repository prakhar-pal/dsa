package lc.Sorting;
import lc.common.Pair;

// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

class SolutionP1TopKFrequentNums {
    public int freqComparator(Pair a, Pair b){
        return b.second - a.second;
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }else {
                freqMap.put(num,1 );
            }
        }
        ArrayList<Pair> freqList = new ArrayList<>();
        for(int key: freqMap.keySet()){
            freqList.add(new Pair(key, freqMap.get(key)));
        }
        SolutionP1TopKFrequentNums that = this;
        Collections.sort(freqList, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return that.freqComparator(a,b);
            }
        });
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = freqList.get(i).first;
        }
        return result;
    }
}

class P1TopKFrequentNums {
    public static boolean isSameDisArray(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        HashSet<Integer> arrSet1 = new HashSet<>();
        HashSet<Integer> arrSet2 = new HashSet<>();
        for(int i=0;i<arr1.length;i++) {
            arrSet1.add(arr1[i]);
            arrSet2.add(arr2[i]);
        }
        return arrSet1.equals(arrSet2);
    }

    public static void printArray(int[] arr){
        System.out.println("--------------------------------------");
        for(int num: arr){
            System.out.print(num + "\t");
        }
        System.out.println("\n--------------------------------------");
    }

    public static void main(String[] args) {
        SolutionP1TopKFrequentNums sol = new SolutionP1TopKFrequentNums();
        int case1[][] = {
            {1,1,1,1,2,2,3},
            {1,2}
        };
        int case2[][] = {
            {1},
            {1}
        };
        int case3[][] = {
            {1,4,4,2,2,3},
            {2,4}
        };

        // printArray(sol.topKFrequent(case1[0],2));
        assert isSameDisArray(sol.topKFrequent(case1[0],2), case1[1]);
        assert isSameDisArray(sol.topKFrequent(case2[0],1), case2[1]);
        assert isSameDisArray(sol.topKFrequent(case3[0],2), case3[1]);
    }
}
