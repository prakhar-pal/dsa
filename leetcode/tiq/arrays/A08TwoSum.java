// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int index2 = map.get(target-nums[i]);
                if(index2 > i) {
                    result[0] = i;
                    result[1] = index2;
                }else {
                    result[0] = index2;
                    result[1] = i;
                }
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

class A08 {
	public static void assertArrEquals(int[] arr1, int[] arr2){
		assert arr1.length == arr2.length;
		for(int i=0;i<arr1.length;i++){
		    // System.out.println(arr1[i] + " == " + arr2[i]);
			assert arr1[i] == arr2[i];
		}
	}
	
    public static void main(String[] args){
        Solution sol = new Solution();
        
        // tc1
        int arr1[] = {2,7,11,15};
        int target1 = 9;
        int result1[] = {0,1};
        
        // tc 2
        int arr2[] = {3,2,4};
        int target2 = 6;
        int result2[] = {1,2};
        
        // tc 2
        int arr3[] = {3,3};
        int target3 = 6;
        int result3[] = {0,1};
        
        assertArrEquals(sol.twoSum(arr1, target1), result1);
        assertArrEquals(sol.twoSum(arr2, target2), result2);
        assertArrEquals(sol.twoSum(arr3, target3), result3);
    }
}
