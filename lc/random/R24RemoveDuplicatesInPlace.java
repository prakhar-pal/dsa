package lc.random;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class R24RemoveDuplicatesInPlace {
    public static void main(String[] args) {
        R24Solution solution = new R24Solution();
        assert solution.removeDuplicates(new int[] {1,1,2}) == 3;
        assert solution.removeDuplicates(new int[] {1,1,1,2,2,3}) == 5;
        assert solution.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}) == 7;
    }
}

class R24Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 2) {
            return 2;
        }
        int i=1;
        int prev = nums[0];
        int removedCount = 0;
        while(i + removedCount < nums.length) {
            if(nums[i] == prev) {
                int count = 0;
                while(i + count + 1 < nums.length && nums[i+count+1]==prev) {
                    count++;
                }
                removedCount += count;
                if(count > 0) {
                    for(int k=i+1;k+count<nums.length;k++) {
                        nums[k] = nums[k+count];
                    }
                }
            }
            prev = nums[i];
            i++;
        }
        return i;
    }
}
