package lc.random;

import java.util.Arrays;

public class R34ThreeSumClosest {
    public static void main(String[] args) {
        R34Solution solution = new R34Solution();
        assert solution.threeSumClosest(new int[] { -1,2,1,-4 }, 1) == 2;
        assert solution.threeSumClosest(new int[] { 0,0,0 }, 1) == 0;
    }
}

class R34Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE, n = nums.length;
        for(int i=0;i<n-1;i++) {
            int j = i + 1, k = n-1;
            while(j != k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                int tempDiff = Math.abs(target - tempSum);
                if(tempDiff < diff) {
                    diff = tempDiff;
                    sum = tempSum;
                }
                if(tempSum <= target) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return sum;
    }
}
