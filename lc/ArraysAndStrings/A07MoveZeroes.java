package lc.ArraysAndStrings;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

class SolutionA07MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pi=0,ii=0; // pi = position index, ii = item index
        while(ii < nums.length){
            if(nums[ii] != 0){
                nums[pi] = nums[ii];
                pi++;
            }
            ii++;
        }
        while(pi < nums.length){
            nums[pi] = 0;
            pi++;
        }
    }
}

class A07 {
	public static void assertArrEquals(int[] arr1, int[] arr2){
		assert arr1.length == arr2.length;
		for(int i=0;i<arr1.length;i++){
		    System.out.println(arr1[i] + " == " + arr2[i]);
			assert arr1[i] == arr2[i];
		}
	}
	
    public static void main(String[] args){
        SolutionA07MoveZeroes sol = new SolutionA07MoveZeroes();
        
        // tc 1
        int arr1[] = {0,1,0,3,12};
        int result1[] = {1,3,12,0,0};
        
        // tc 2
        int arr2[] = {0};
        int result2[] = {0};
        
        // tc 3
        int arr3[] = {0,9};
        int result3[] = {9,0};
        
        sol.moveZeroes(arr1);
        assertArrEquals(arr1, result1);
        sol.moveZeroes(arr2);
        assertArrEquals(arr2, result2);
        sol.moveZeroes(arr3);
        assertArrEquals(arr3, result3);
    }
}
