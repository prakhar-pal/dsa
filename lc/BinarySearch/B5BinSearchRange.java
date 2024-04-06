import lc.common.PairArray;
// https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/

class SolutionB5BinSearchRange {
    public int[] searchRange(int[] nums, int target) {
        // find start index
        int startIndex = -1, endIndex = -1;
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                startIndex = mid;
                if( mid > 0 && nums[mid - 1] == target){
                    right = mid -1;
                    continue;
                }else {
                    break;
                }
            }else if( nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

       left = 0; right = nums.length - 1;
       while(left<=right){
           int mid = left + (right - left)/2;
           if(nums[mid] == target){
               endIndex = mid;
               if(mid < nums.length-1 && nums[mid + 1] == target){
                   left = mid + 1;
                   continue;
               }else {
                   break;
               }
           }else if(nums[mid] < target){
               left = mid + 1;
           }else {
               right = mid -1;
           }
       }
       return new PairArray(startIndex, endIndex).result;
    }
}

class B5BinSearchRange {
    public static boolean isSame(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length) return false;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        SolutionB5BinSearchRange sol = new SolutionB5BinSearchRange();
        int array1[] = {5,7,7,8,8,10};
        int target1 = 8;
        int array2[] = {5,7,7,8,8,10};
        int target2 = 6;
        int array3[] = {};
        int target3 = 0;
        assert isSame(sol.searchRange(array2, target2), new PairArray(-1,-1).result);
        assert isSame(sol.searchRange(array3, target3), new PairArray(-1,-1).result);
        assert isSame(sol.searchRange(array1, target1), new PairArray(3,4).result);
    }
}
