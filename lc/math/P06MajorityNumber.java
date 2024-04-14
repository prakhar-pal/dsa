package lc.math;

import java.util.HashMap;
/**
 * https://leetcode.com/problems/majority-element/
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class P06MajorityNumber {
    public static void main(String[] args) {
        P06MajorityNumberSolution sol = new P06MajorityNumberSolutionOne();
        assert sol.majorityElement(new int[] {3,2,3}) == 3;
        assert sol.majorityElement(new int[] {2,2,1,1,1,2,2}) == 2;
    }
}
interface P06MajorityNumberSolution {
    public int majorityElement(int[] nums);
}

class P06MajorityNumberSolutionOne implements P06MajorityNumberSolution {
    public int majorityElement(int[] nums) {
        int me = nums[0];
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n:nums) {
            if(map.containsKey(n)) {
                int newCount = 1 + map.get(n);
                map.put(n, newCount);
                if(newCount > maxCount) {
                    maxCount = newCount;
                    me = n;
                }
            }else {
                map.put(n, 1);
            }
        }
        return me;
    }
}



class P06MajorityNumberSolutionTwo implements P06MajorityNumberSolution {
    /**
     * do not use this solution as it eats up lots of memory
     */
    private static int MAX_ARR_SIZE = (int)Math.pow(10,9);
    public int majorityElement(int[] nums) {
        int parr[] = new int[MAX_ARR_SIZE];
        int narr[] = new int[MAX_ARR_SIZE];
        int maxCount = 0;
        int me = nums[0];
        for(int n:nums) {
            int[] arr = n >= 0 ? parr : narr;
            int nabs = Math.abs(n);
            arr[nabs]++;
            if(arr[nabs] > maxCount) {
                maxCount = arr[nabs];
                me = n;
            }
        }
        return me;
    }
}
