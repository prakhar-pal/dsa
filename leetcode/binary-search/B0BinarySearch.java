// https://leetcode.com/explore/learn/card/binary-search/138/background/1038/

class SolutionB0BinarySearchBinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    private int search(int[] nums, int target, int start, int end){
        int mid = (start+end)/2;
        if(nums[mid] == target) return mid;
        else if(start>end) return -1;
        else if(target < nums[mid]){
            return search(nums, target, start, mid-1);
        }else return search(nums, target, mid+1, end);
    }
}

class B0BinarySearch {
    public static void main(String[] args){
        SolutionB0BinarySearchBinarySearch sol = new SolutionB0BinarySearchBinarySearch();
        int arr1[] = {-1,0,3,5,9,12};
        int target1 = 9;
        int arr2[] = {-1,0,3,5,9,12};
        int target2 = 2;
        int result1 = sol.search(arr1, target1);
        int result2 = sol.search(arr2, target2);
        // System.out.println("result1:"+result1+" result2:"+result2);
        assert  result1 == 4;
        assert result2 == -1;
    }
}
