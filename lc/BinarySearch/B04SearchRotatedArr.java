package lc.BinarySearch;

// https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/

class SolutionB2SearchRotatedArrSearchRotatedArray {
    private int bs(int nums[], int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = 0;
        for(int i=01;i<nums.length-1;i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }
        int leftSearch = bs(nums, 0, pivot, target);
        int rightSearch = bs(nums, pivot +1, nums.length -1 , target);
        return leftSearch != -1 ? leftSearch: rightSearch;
    }
}

class B04SearchRotatedArr {
    public static void main(String[] args){
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        SolutionB2SearchRotatedArrSearchRotatedArray sol = new SolutionB2SearchRotatedArrSearchRotatedArray();
        assert sol.search(nums, target) == 4;
    }
}
