package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class A16MaxWaterContainer {
    public static void main(String[] args) {
        A16Solution solution = new A16Solution();
        assert solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7}) == 49;
        assert solution.maxArea(new int[] {1,1 }) == 1;
    }
}

class A16Solution {
    // O(n) complexity
    public int maxArea(int[] height) {
        int maxCapacity = 0;
        int left = 0, right = height.length-1;
        while(left<right) {
            int capacity = (right-left) * Math.min(height[left], height[right]);
            maxCapacity = Math.max(capacity, maxCapacity);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxCapacity;
    }
}
