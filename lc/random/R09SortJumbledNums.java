package lc.random;

import java.util.*;

import lc.utils.ArrayUtils;

public class R09SortJumbledNums {
    public static void main(String[] args) {
        R09Solution solution = new R09Solution();
        // assert ArrayUtils.isSame1DArray(solution.sortJumbled(new int[] {8,9,4,0,2,1,3,5,7,6}, new int[] {991,338,38}), new int[] {338,38,991});
        // assert ArrayUtils.isSame1DArray(solution.sortJumbled(new int[] {0,1,2,3,4,5,6,7,8,9}, new int[] {789,456,123}), new int[] {123,456,789});
        // assert ArrayUtils.isSame1DArray(solution.sortJumbled(new int[] {0,1,2,3,4,5,6,7,8,9}, new int[] {0, 999999999}), new int[] {0, 999999999});
        assert ArrayUtils.isSame1DArray(solution.sortJumbled(new int[] {9,8,7,6,5,4,3,2,1,0}, new int[] {0,1,2,3,4,5,6,7,8,9}), new int[] {9,8,7,6,5,4,3,2,1,0});
    }
}

class MappedValueComparator implements Comparator<Integer[]> {
    @Override
    public int compare(Integer[] arr1, Integer[] arr2) {
        int result = arr1[1] - arr2[1];
        if(result == 0) {
            result = arr1[2] - arr2[2];
        }
        return result;
    }
}

class R09Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer[]> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            Integer[] arr = new Integer[3];
            arr[0] = nums[i];
            int value = nums[i];
            StringBuffer buffer = new StringBuffer();
            do {
                buffer.append(mapping[value % 10]);
                value/=10;
            } while(value != 0);
            buffer.reverse();
            int mappedValue = Integer.parseInt("0"+buffer.toString());
            arr[1] = mappedValue;
            arr[2] = i;
            list.add(arr);
        }
        Collections.sort(list, new MappedValueComparator());
        int[] result = new int[nums.length];
        int index = 0;
        for(Integer[] arr: list) {
            result[index++] = arr[0];
        }
        return result;
    }
}
