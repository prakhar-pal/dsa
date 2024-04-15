// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
import java.util.HashSet;

class SolutionA04ArrDuplDetect {
	 public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
		for(int num:nums){
			set.add(num);
		}
		return set.size() != nums.length;
    }
}

class A04ArrDuplDetect {
	public static void main(String[] args){
		SolutionA04ArrDuplDetect sol = new SolutionA04ArrDuplDetect();

		// tc 1
		int arr1[] = {1};
		boolean result1 = false;

		// tc2
		int arr2[] = {};
		boolean result2 = false;

		// tc 3
		int arr3[] = {1,2,3,1};
		boolean result3 = true;

		// tc 4
		int arr4[] = {1,2,3,4};
		boolean result4 = false;

		// tc 5 
		int arr5[] = {1,1,1,3,3,4,3,2,4,2};
		boolean result5 = true;

		assert sol.containsDuplicate(arr1) == result1;
		assert sol.containsDuplicate(arr2) == result2;
		assert sol.containsDuplicate(arr3) == result3;
		assert sol.containsDuplicate(arr4) == result4;
		assert sol.containsDuplicate(arr5) == result5;
	}
}