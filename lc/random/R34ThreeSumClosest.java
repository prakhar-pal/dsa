package lc.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class R34ThreeSumClosest {
    public static void main(String[] args) {
        R34Solution solution = new R34SolutionOne();
        assert solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
        assert solution.threeSumClosest(new int[]{0, 0, 0}, 1) == 0;
        assert solution.threeSumClosest(new int[] {0,3,97,102,200}, 300) == 300;
    }
}

interface R34Solution {
    // this interface was created to accommodate a potential solution defined in R34SolutionTwo
    public int threeSumClosest(int[] nums, int target);
}

class R34SolutionOne implements  R34Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1, k = n - 1;
            while (j != k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                int tempDiff = Math.abs(target - tempSum);
                if (tempDiff < diff) {
                    diff = tempDiff;
                    sum = tempSum;
                }
                if (tempSum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}


class R34SolutionTwo implements  R34Solution {
    //    Algorithm
    //    1. Sort the nums array
    //    2. fix i=0, j=nums.length-1, define k as the middle of i and j
    //    3. update k to do binary-search for the optimal value
    //    4. once all k's are exhausted update i or j in the direction which minimizes the diff
    //    Note: It fails for the input [0,3,97,102,200] but passes 100/106 test cases
    //    The issue here is the step 4, we can't do linear updates, instead we'd have to
    //    consider all the variants of i,j's subsequent values such as i+1,j and i,j+1 which becomes exponential (2**n).
    //    We can do better by memoization but that'd still be n**2, that's just exhaustively checking all the values of
    //    i and j. Considering the binary search for k, the overall complexity would be (n**2)*log(n)
    //    This is worse solution than implementation in class R34SolutionOne
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE, n = nums.length;
        int i = 0, j = nums.length - 1;
        while (i < j && i < nums.length && j>=0) {
            int k = i+ (j-i) / 2;
            Set<Integer> visited = new HashSet<>();
            while (i<k && k<j && !visited.contains(k)) {
                System.out.printf("%d %d %d\n", i,k,j);
                visited.add(k);
                int tempSum = nums[i] + nums[j] + nums[k];
                int tempDiff = Math.abs(target - tempSum);
                if(tempDiff < diff) {
                    diff = tempDiff;
                    sum = tempSum;
                }
                if(tempSum < target) {
                    k = k + ( j-k)/2;
                } else {
                    k = i + (k-i)/2;
                }
            }
            if(sum <= target) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("sum=" + sum);
        return sum;
    }
}

