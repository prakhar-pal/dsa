// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/

class SolutionB4MinInRotatedArrMinRotateArr {
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

class SolutionB4MinInRotatedArrNew {
    public int findMin(int[] arr){
        int low = 0, high = arr.length-1;
        int topIndex = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int prev = mid == 0 ? arr[arr.length-1] : arr[mid-1];
            int next = mid == arr.length-1 ? arr[0]: arr[mid+1];
            if(arr[mid] > prev && arr[mid] > next){
                topIndex = mid;
                break;
            }else if(arr[mid] < arr[low]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return topIndex == arr.length - 1 ? arr[0]: arr[topIndex+1];
    }
}

class B4MinInRotatedArr {
    public static void main(String[] args){
        int nums1[] = {4,5,6,7,0,1,2};
        int[] nums2 = {3,4,5,1,2};
        int[] nums3 = {11,13,15,17};
        int[] nums4 = {2,3,4,5,1};
        int[] nums5 = {5,1,2,3,4};
        SolutionB4MinInRotatedArrNew sol = new SolutionB4MinInRotatedArrNew();
        assert sol.findMin(nums1) == 0;
        assert sol.findMin(nums2) == 1;
        assert sol.findMin(nums3) == 11;
        assert sol.findMin(nums4) == 1;
        assert sol.findMin(nums5) == 1;
    }
}
