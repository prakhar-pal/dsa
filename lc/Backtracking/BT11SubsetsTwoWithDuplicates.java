package lc.DynamicProgramming;

import java.util.*;

// https://leetcode.com/problems/subsets-ii/
public class DP24Subsets2 {

    public static void main(String[] args) {
        DP24Solution solution = new DP24Solution();
        solution.subsetsWithDup(new int[] { 1, 2, 2 });
    }
}

class DP24Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        result = new ArrayList<>();
        backtrack(nums, 0, list);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> list) {
        if(i == nums.length) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            result.add(copy);
            return;
        }
        list.add(nums[i]);
        backtrack(nums, i + 1, list);
        while(i+1 < nums.length && nums[i+1] == nums[i]) {
            i++;
        }
        list.remove(list.size()-1);
        backtrack(nums, i + 1, list);
    }
}
