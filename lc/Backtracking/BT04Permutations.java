package lc.Backtracking;
import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

public class BT04Permutations {
    public static void main(String[] args) {
        BT04Solution sol = new BT04Solution();
        List<List<Integer>> result1 = sol.permute(new int[] {1,2,3});
        System.out.println("result1");
        for(List<Integer> list: result1) {
            for(int num: list) {
                System.out.print(num + "\t");
            }
            System.out.print("\n");
        }
    }
}

class BT04Solution {
    private List<List<Integer>> solutions;
    boolean[] isColumnUsed;
    int[] solutionCandicate;
    public List<List<Integer>> permute(int[] nums) {
        solutions = new ArrayList<>();
        isColumnUsed = new boolean[nums.length];
        solutionCandicate = new int[nums.length];
        addPermutationsToSolutions(nums, 0);
        return solutions;
    }
    private void addPermutationsToSolutions(int[] nums, int index) {
        if(index == nums.length) {
            List<Integer> solution = new ArrayList<>();
            for(int c: solutionCandicate) {
                solution.add(c);
            }
            solutions.add(solution);
        }
        for(int i=0;i<nums.length;i++) {
            if(isColumnUsed[i]) {
                continue;
            }
            isColumnUsed[i] = true;
            solutionCandicate[index] = nums[i];
            addPermutationsToSolutions(nums, index+1);
            isColumnUsed[i] = false;
        }
    }
}
