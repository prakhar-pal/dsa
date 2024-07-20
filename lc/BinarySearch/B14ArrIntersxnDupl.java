package lc.BinarySearch;
// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1029/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class SolutionC04ArrIntersxnDuplBySet {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums1){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else hm.put(num,1);
        }

        HashMap<Integer, Integer> rm = new HashMap<>();
        for(int num: nums2){
            if(hm.containsKey(num) && hm.get(num) > 0){
                rm.put(num, (rm.containsKey(num) ? rm.get(num) : 0) + 1);
                hm.put(num, hm.get(num)-1);
            }
        }
        int size = 0;
        for(int key: rm.keySet()){
            size += rm.get(key);
        }
        int result[] = new int[size];
        int i=0;
        while(i<size){
            for(int key: rm.keySet()){
                int rc = rm.get(key);
                for(int j=0;j<rc;j++) {
                    result[i] = key;
                    i++;
                }
            }
        }
        return result;
    }
}


class B14ArrIntersxnDupl {
    private static void isSame(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        // System.out.println("arr1:");
        for(int num: arr1){
            // System.out.print(num + "\t");
            hm1.put(num, (hm1.containsKey(num) ? hm1.get(num) : 0) + 1);
        }
        // System.out.println("\narr2:");
        for(int num: arr2){
            // System.out.print(num + "\t");
            hm2.put(num, (hm2.containsKey(num) ? hm2.get(num) : 0) + 1);
        }
        System.out.println(hm1.equals(hm2));
    }

    public static void main(String[] args){
        SolutionC04ArrIntersxnDuplBySet sol = new SolutionC04ArrIntersxnDuplBySet();
        int tc1[][] = { {1,2,2,1}, {2,2}};
        int res1[] = {2,2};
        int tc2[][] = { {4,9,5}, {9,4,9,8,4} };
        int res2[] = {4,9};

        isSame(sol.intersection(tc1[0], tc1[1]), res1);
        isSame(sol.intersection(tc2[0], tc2[1]), res2);
    }
}
