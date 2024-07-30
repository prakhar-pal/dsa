package lc.ArraysAndStrings;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/

class SolutionA06PlusOne {
    private boolean isAll9s(int[] digits){
        for(int digit: digits){
            if(digit != 9) return false;
        }
        return true;
    }
    public int[] plusOne(int[] digits) {
        if(this.isAll9s(digits)){
            int results[] = new int[digits.length + 1];
            for(int i=0;i<results.length;i++){
                results[i] = i == 0 ? 1 : 0;
            }
            return results;
        }else {
            int result[] = new int[digits.length];
            for(int i=0;i<digits.length;i++){
                result[i] = digits[i];
            }
            int carry = 1;
            for(int i=digits.length-1;i>=0;i--){
                result[i] = result[i] + carry;
                carry = result[i]/10;
                result[i] = result[i] % 10;
            }
            return result;
        }
    }
}

class A06 {
	public static void assertArrEquals(int[] arr1, int[] arr2){
		assert arr1.length == arr2.length;
		for(int i=0;i<arr1.length;i++){
		    System.out.println(arr1[i] + " == " + arr2[i]);
			assert arr1[i] == arr2[i];
		}
	}
	
    public static void main(String[] args){
        SolutionA06PlusOne sol = new SolutionA06PlusOne();
        
        // tc 1
        int arr1[] = {1,2,3};
        int result1[] = {1,2,4};
        
        // tc 2
        int arr2[] = {4,3,2,1};
        int result2[] = {4,3,2,2};
        
        // tc 3
        int arr3[] = {9};
        int result3[] = {1,0};
        
        assertArrEquals(sol.plusOne(arr1), result1);
        assertArrEquals(sol.plusOne(arr2), result2);
        assertArrEquals(sol.plusOne(arr3), result3);
    }
}
