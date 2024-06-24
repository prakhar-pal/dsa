package lc.ArraysAndStrings;
/**
 * https://leetcode.com/problems/first-missing-positive/submissions/
 */
public class A17FirstMissingPositive {
    public static void main(String[] args) {
        A17Solution solution = new A17SolutionTwo();
        assert solution.firstMissingPositive(new int[] {1,2,0}) == 3;
        assert solution.firstMissingPositive(new int[] {3,4,-1,1}) == 2;
        assert solution.firstMissingPositive(new int[] {7,8,9,11,12}) == 1;
        assert solution.firstMissingPositive(new int[] {1,2,3, (int)Math.pow(2, 31)}) == 4;
    }
}

interface A17Solution {
    public int firstMissingPositive(int[] nums);
}

class A17SolutionTwo implements A17Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] isPresent = new boolean[nums.length];
        for(int n:nums) {
            if(n > 0 && n < nums.length) {
                isPresent[n-1] = true;
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(!isPresent[i]) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}

class A17SolutionOne implements A17Solution {
    public int firstMissingPositive(int[] nums) {
        int positiveCount = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n:nums) {
            if(n > 0) {
                min = Math.min(n, min);
                max = Math.max(n, max);
                positiveCount++;
            }
        }
        int index = 0;
        int[] positives = new int[positiveCount];
        for(int n:nums) {
            if(n>0) {
                positives[index++] = n;
            }
        }
        int size = (int) Math.pow(10, 5);
        boolean[] isPresent = new boolean[size];
        for(int n: positives) {
            if(n <= size) {
                isPresent[n-1] = true;
            }
        }
        for(int i=0;i<size;i++) {
            if(!isPresent[i]) {
                return i+1;
            }
        }
        return (int) Math.pow(10, 5) + 1;
    }
}
