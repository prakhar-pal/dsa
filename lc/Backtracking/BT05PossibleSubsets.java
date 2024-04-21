package lc.Backtracking;
import java.util.*;


/**
 * https://leetcode.com/problems/subsets/description/
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class BT05PossibleSubsets {
    public static void main(String[] args) {
        BT05Solution sol = new BT05Solution();
        List<List<Integer>> result1 = sol.subsets(new int[] {1,2,3});
        System.out.println("result1");
        for(List<Integer> list: result1) {
            for(int num: list) {
                System.out.print(num + "\t");
            }
            System.out.print("\n");
        }
    }
}


class BT05Solution {
    List<List<Integer>> solutions;
    List<Integer> candidate;
    public List<List<Integer>> subsets(int[] nums) {
        solutions = new ArrayList<>();
        solutions.add(new ArrayList<>());
        candidate = new ArrayList<Integer>();
        subsetsUtil(nums, 0);
        return solutions;
    }

    private void subsetsUtil(int[] nums, int index) {
        if(index == nums.length) {
            if(candidate.size() != 0) {
                List<Integer> solution = new ArrayList<>();
                solution.addAll(candidate);
                solutions.add(solution);
            }
            return;
        }
        subsetsUtil(nums, index+1);
        candidate.add(nums[index]);
        subsetsUtil(nums, index+1);
        candidate.remove(candidate.size() - 1);
    }
}
