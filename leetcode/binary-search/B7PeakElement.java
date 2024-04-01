class SolutionB7PeakElement {
    // public int findPeakElement(int[] nums){
    //     return findPeakElement(nums, 0, nums.length-1);
    // }
    public int findPeakElement(int[] nums) {
        int low=0, high = nums.length-1;
        int peak = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[mid+1]){
                low = mid;
            }else {
                high = mid;
            }
        }
        return low;
    }
}

class B7PeakElement {
    public static void main(String[] args){
        SolutionB7PeakElement sol = new SolutionB7PeakElement();
        int arr[] = {1,2,3,1};
        assert sol.findPeakElement(arr) == 3;
    }
}


