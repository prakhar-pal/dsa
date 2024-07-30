package lc.ArraysAndStrings;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
class SolutionA03RotateArr {
    public int[] rotate(int[] nums, int k) {
		k = k % nums.length;
        int temp[] = new int[k];
		int n = nums.length;
		for(int i=0;i<k;i++){
			temp[k - 1 - i] = nums[n - 1 - i];
		}
		for(int i = n-1-k; i>=0;i--){
			nums[k+i] = nums[i];
		}
		for(int i=0;i<k;i++){
			nums[i] = temp[i];
		}
		return nums;
    }
}

class A03RotateArr {
	public static void assertArrEqual(int[] arr1, int[] arr2){
		assert arr1.length == arr2.length;
		for(int i=0;i<arr1.length;i++){
			assert arr1[i] == arr2[i];
		}
	}
	public static void main(String[] args){
		SolutionA03RotateArr sol = new SolutionA03RotateArr();

		// tc 1
		int arr1[] = {1,2,3,4,5,6,7};
		int k1 = 3;
		int result1[] = {5,6,7,1,2,3,4};

		// tc 2
		int arr2[] = {-1,-100,3,99};
		int k2 = 2;
		int result2[] = {3,99,-1,-100};

		// tc 3
		int arr3[] = {-1};
		int k3 = 2;
		int result3[] = {-1};

		assertArrEqual(sol.rotate(arr1, k1), result1);
		assertArrEqual(sol.rotate(arr2, k2), result2);
		assertArrEqual(sol.rotate(arr3, k3), result3);
	}
}
