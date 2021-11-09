// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int start, int end){
        if(start>end) return Integer.MAX_VALUE;
        int mid = start + (end-start)/2;
        int next = mid == end ? nums[start]: nums[mid+1];
        int prev = mid == start ? nums[end] : nums[mid-1];
        if(nums[mid] < prev && nums[mid] < next) {
            return nums[mid];
        }else {
            return Math.min(Math.min(findMin(nums, start, mid-1), nums[mid]), findMin(nums, mid+1, end));
        }
    }
}

class C02MinSortedArrayDupl {
    public static void main(String[] args){
        Solution sol = new Solution();

        int tc1[] = {1,3,5};
        int tc2[] = {2,2,2,0,1};
        int tc3[] = {1,2,2,2,0};
        int tc4[] = {0};
        int tc5[] = {2,-1,2,2,2};

        assert sol.findMin(tc1) == 1;
        assert sol.findMin(tc2) == 0;
        assert sol.findMin(tc3) == 0;
        assert sol.findMin(tc4) == 0;
        assert sol.findMin(tc5) == -1;

    }
}
