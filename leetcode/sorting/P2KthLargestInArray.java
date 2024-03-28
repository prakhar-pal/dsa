// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.ArrayList;
import java.util.Collections;

interface Solution {
    public int findKthLargest(int[] nums, int k);
}
class Solution1 implements Solution {
    private static int MAX_SIZE = (int)Math.pow(10, 5) + 1;
    public int findKthLargest(int[] nums, int k) {
        int maxIndex = 1;
        int[] freqArr = new int[MAX_SIZE];
        for(int num:nums){
            freqArr[num]++;
            if(num > maxIndex) {
                maxIndex = num;
            }
        }
        int currentIndex = maxIndex;
        while(k > 1) {
            if(freqArr[currentIndex] > 0) {
                k--;
                freqArr[currentIndex]--;
            }
            if(freqArr[currentIndex] == 0) {
                for(int i=currentIndex-1;i>=0;i--){
                    currentIndex = i;
                    if(freqArr[i] != 0) {
                        break;
                    }
                }
            }
        }
        return currentIndex;
    }
}

class Solution2 implements Solution {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }

        Collections.sort(list);
        return list.get(nums.length - k);
    }
}

class P2KthLargestInArray {
    public static void main(String[] args) {
        Solution sol = new Solution2();
        int[][] case1 = {
            {3,2,1,5,6,4},
            {2}
        };
        assert sol.findKthLargest(case1[0], case1[1][0]) == 5;

        int[][] case2 = {
            {3,2,3,1,2,4,5,5,6},
            {4}
        };
        assert sol.findKthLargest(case2[0], case2[1][0]) == 4;
        
        int[][] case3 = {
            {-1,-1},
            {2}
        };
        assert sol.findKthLargest(case3[0], case3[1][0]) == -1;
    }
}
