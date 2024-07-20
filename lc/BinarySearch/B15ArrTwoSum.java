package lc.BinarySearch;
// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/
class SolutionC05ArrTwoSum {
    public int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(high > low) {
            System.out.println("low: "+low+" high: "+high);
            int sum = nums[low] + nums[high];
            if(sum == target) {
                int res[] = {low+1, high+1};
                System.out.println("---------");
                return res;
            }else if( sum > target ) {
                high--;
            }else {
                low++;
            }
        }
        int res[] = {-1,-1};
        return res;
    }
}

class B15ArrTwoSum {
    private static boolean isSame(int[] ans, int[] expected){
        if(ans.length != expected.length) return false;
        for(int i=0;i<ans.length; i++){
            if(ans[i] != expected[i]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        SolutionC05ArrTwoSum sol = new SolutionC05ArrTwoSum();

        int tc1[] = {2,7,11,15};
        int target1 = 9;
        int res1[] = {1,2};

        int tc2[] = {2,3,4};
        int target2 = 6;
        int res2[] = {1,3};

        int tc3[] = {-1,0};
        int target3 = -1;
        int res3[] = {1,2};

        assert isSame(sol.twoSum(tc1, target1), res1);
        assert isSame(sol.twoSum(tc2, target2), res2);
        assert isSame(sol.twoSum(tc3, target3), res3);
    }
}
