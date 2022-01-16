// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;
    }

    public int findDuplicate2(int[] arr){
        int MAX_NUMS = 100000;
        boolean found[] = new boolean[MAX_NUMS+1];
        for(int i=0; i < arr.length; i++) {
            if(found[arr[i]]) return arr[i];
            found[arr[i]] = true;
        }
        return 0;
    }
}

class C06ArrDupl {
    public static void main(String[] args){
        Solution sol = new Solution();

        int tc1[] = {1,3,4,2,2};

        assert sol.findDuplicate2(tc1) == 2;
    }
}

