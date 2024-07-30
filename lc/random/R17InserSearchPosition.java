package lc.random;

import lc.utils.Logger;

/**
 * https://leetcode.com/problems/search-insert-position
 * */
public class R17InserSearchPosition {
   public static void main(String[] args) {
    R17Solution solution = new R17Solution();
    assert solution.searchInsert(new int[] {1,3,5,6}, 5) == 2;
    assert solution.searchInsert(new int[] {1,3,5,6}, 2) == 1;
    assert solution.searchInsert(new int[] {1,3,5,6}, 7) == 4;
    assert solution.searchInsert(new int[] {1}, 5) == 1;
    assert solution.searchInsert(new int[] {5}, 1) == 0;
    assert solution.searchInsert(new int[] {1,3}, 2) == 1;
    assert solution.searchInsert(new int[] {1,3,5}, 3) == 1;
   } 
}

class R17Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
