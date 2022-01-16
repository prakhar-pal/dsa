// https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int ci=1,pi=1,k=1;
        while(ci < nums.length){
            if(nums[ci] != nums[pi-1]){
                nums[pi] = nums[ci];
                pi++;
                k++;
            }
            ci++;
        }
        return k;
    }
}

class A01 {
    private static void assertResult(int[] original, int[] expected, int k) {
        assert(k == expected.length);
        for(int i=0;i<expected.length;i++){
            assert(original[i] == expected[i]);
        }
    }
    public static void main(String[] args){

        Solution sol = new Solution();

        int[] arr1 = {1,1,2};
        int[] expectedResult1 = {1,2};
        assertResult(arr1, expectedResult1, sol.removeDuplicates(arr1));

        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedResult2 = {0,1,2,3,4};
        assertResult(arr2, expectedResult2, sol.removeDuplicates(arr2));
    }
}

