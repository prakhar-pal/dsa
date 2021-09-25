// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        if(nums.length == 1) return nums[0];
        while(r-l > 1){
            int m = l + (r-l)/2;
            if(nums[l]>nums[m]){
                r = m;
            }else {
                l = m;
            }
        }
        int index = nums[l] > nums[r] ? l : r;
        int ans = nums[(1+index+nums.length)%nums.length];
        return ans;
    }
}

class Cholution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            int mid = start + (end-start)/2;
            if (arr[mid]>arr[mid+1]) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return arr[(start+1)%arr.length];
  }
}

class B4MinInRotatedArr {
    public static void main(String[] args){
        int nums1[] = {4,5,6,7,0,1,2};
        int[] nums2 = {3,4,5,1,2};
        int[] nums3 = {11,13,15,17};
        int[] nums4 = {2,3,4,5,1};
        int[] nums5 = {5,1,2,3,4};
        Solution sol = new Solution();
        assert sol.findMin(nums1) == 0;
        assert sol.findMin(nums2) == 1;
        assert sol.findMin(nums3) == 11;
        assert sol.findMin(nums4) == 1;
        assert sol.findMin(nums5) == 1;
    }
}
