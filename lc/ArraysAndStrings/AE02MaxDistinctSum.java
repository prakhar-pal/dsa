package lc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lc.utils.ArrayUtils;

public class AE02MaxDistinctSum {
    public static void main(String[] args) {
        AE02Solution solution = new AE02Solution();
        assert ArrayUtils.isSame1DArray(solution.maxKDistinct(new int[] { 84, 93, 100, 77, 90 }, 3),
                new int[] { 100, 93, 90 });
        assert ArrayUtils.isSame1DArray(solution.maxKDistinct(new int[] { 84, 93, 100, 77, 93 }, 3),
                new int[] { 100, 93, 84 });
        assert ArrayUtils.isSame1DArray(solution.maxKDistinct(new int[] { 1,1,1,2,2,2 }, 3),
                new int[] { 2,1 });
    }
}

class AE02Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        // reverse nums
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums.length && k > 0) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                k--;
                set.add(nums[i]);
            }
            i++;
        }
        int[] result = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}