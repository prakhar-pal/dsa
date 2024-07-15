package lc.BinarySearch;
// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class SolutionC03ArrIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num:nums1){
            hm.put(num, 0);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(hm.containsKey(num) && hm.get(num) == 0){
                list.add(num);
                hm.put(num, 1);
            }
        }
        int result[] = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}

class SolutionC03ArrIntersectionBySet {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> rs = new HashSet<>();
        for(int num: nums1){
            hs.add(num);
        }
        for(int num: nums2){
            if(hs.contains(num)){
                rs.add(num);
            }
        }
        int result[] = new int[rs.size()];
        int i=0;
        for(int num:rs){
            result[i] = num;
            i++;
        }
        return result;
    }
}


class B13ArrIntersection {
    private static void isSame(int[] arr1, int[] arr2){
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        // System.out.println("arr1:");
        for(int num: arr1){
            // System.out.print(num + "\t");
            hs1.add(num);
        }
        // System.out.println("\narr2:");
        for(int num: arr2){
            // System.out.print(num + "\t");
            hs2.add(num);
        }
        System.out.println(hs1.equals(hs2));
    }

    public static void main(String[] args){
        SolutionC03ArrIntersection sol = new SolutionC03ArrIntersection();
        int tc1[][] = { {1,2,2,1}, {2,2}};
        int res1[] = {2};
        int tc2[][] = { {4,9,5}, {9,4,9,8,4} };
        int res2[] = {4,9};

        isSame(sol.intersection(tc1[0], tc1[1]), res1);
        isSame(sol.intersection(tc2[0], tc2[1]), res2);
    }
}
