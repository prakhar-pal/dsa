package lc.ArraysAndStrings;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/


class SolutionA05NonRepeatingNum {
	private int ZZ = 3 * (int)Math.pow(10,4);
	private int getIndex(int num){
		return num + ZZ;
	}
    public int singleNumber(int[] nums) {
        boolean present[] = new boolean[2*ZZ+1];
        for(int num: nums){
        	int i = getIndex(num);
        	present[i] = !present[i];
        }
        for(int num: nums){
        	if(present[getIndex(num)]) return num;
        }
        return -ZZ;
    }
}

class SolutionA05NonRepeatingNum2 {
	public int singleNumber(int[] nums){
		int result = nums[0];
		for(int i=1;i<nums.length;i++){
			result = result ^ nums[i];
		}
		return result;
	}
}

class A05NonRepeatingNum {
	public static void main(String[] args){
		SolutionA05NonRepeatingNum2 sol = new SolutionA05NonRepeatingNum2();

		// tc 1
		int arr1[] = {2,2,1};
		int result1 = 1;

		// tc2
		int arr2[] = {4,1,2,1,2};
		int result2 = 4;

		// tc 3
		int arr3[] = {1};
		int result3 = 1;

		// tc 4
		int arr4[] = {0,0,1,0,0};
		int result4 = 1;

		assert sol.singleNumber(arr1) == result1;
		assert sol.singleNumber(arr2) == result2;
		assert sol.singleNumber(arr3) == result3;
		assert sol.singleNumber(arr4) == result4;
	}
}
