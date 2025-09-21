package lc.ArraysAndStrings;

import lc.utils.ArrayUtils;

import java.util.Arrays;

public class A26SubsequenceSumAfterCapping {
    public static void main(String[] args) {
        A26Solution solution = new A26Solution();
        assert Arrays.equals(solution.subsequenceSumAfterCapping(new int[]{4, 3, 2, 4}, 5), new boolean[]{false, false, true, true});
        assert Arrays.equals(solution.subsequenceSumAfterCapping(new int[]{1,2,3,4,5}, 3), new boolean[]{true,true,true,true,true});
        assert Arrays.equals(solution.subsequenceSumAfterCapping(new int[]{1}, 1), new boolean[]{true});
        assert Arrays.equals(solution.subsequenceSumAfterCapping(new int[]{1,1}, 1), new boolean[]{true, true});
        assert Arrays.equals(solution.subsequenceSumAfterCapping(new int[]{1,1}, 3), new boolean[]{false, false});
    }
}

class A26Solution {
    // this solution is not optimal :(
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        boolean[] result = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int[] capped = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                capped[j] = Math.min(nums[j], i + 1);
            }
            result[i] = findSubsetSub(capped, k);
        }
        return result;
    }

    private boolean findSubsetSub(int[] arr, int target) {
        boolean found = false;
        int sum = 0, i = 0, j = 0;
        while (i < arr.length) {
            sum = sum + arr[i];
            if (sum > target) {
                sum -= arr[j];
                j++;
            }
            if (sum == target) {
                found = true;
                break;
            }
            i++;
        }
        return found;
    }
}
