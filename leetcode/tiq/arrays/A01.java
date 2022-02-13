// https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/

class Solution {
    private int removeDuplicates1(int[] nums) {
        if(nums.length == 0) return 0;
        int pi = 1; // ci = current index, pi = placement index
        for (int ci = 1; ci < nums.length; ci++) {
            if(nums[ci] != nums[pi-1]){
                nums[pi] = nums[ci];
                pi++;
            }
        }
        return pi;
    }
    private int removeDuplicates2(int nums[]){
        int k = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[k++] = nums[i + 1];
            }
        }
        return k;
    }

    private int removeDuplicates3(int nums[]){
        // sample 0 ms submission
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
                
            }
        }
        return i+1;
    }
    public int removeDuplicates(int[] nums ){
        return this.removeDuplicates1(nums);
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

        // The following assertion is not handled in the online judge
        // int[] arr3 = {};
        // int[] expectedResult3 = {};
        // assertResult(arr3, expectedResult3, sol.removeDuplicates(arr3));
    }
}

