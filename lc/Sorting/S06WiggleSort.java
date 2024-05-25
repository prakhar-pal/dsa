package lc.Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class S06WiggleSort {
    public static void main(String[] args) {
        S06Solution sol = new S06SolutionTwo();
        int[] input1 = new int[] {3,5,2,1,6,4};
        int[] result1 = sol.wiggleSort(input1);
        assert isWiggleSorted(result1, input1);

        int[] input2 = new int[] {6,6,5,6,3,8};
        int[] result2 = sol.wiggleSort(input2);
        assert isWiggleSorted(result2, input2);

        int[] input3 = new int[] {1,1,12,3,4,1};
        int[] result3 = sol.wiggleSort(input3);
        assert isWiggleSorted(result3, input3);

        int[] input4 = new int[] {1,2,3};
        int[] result4 = sol.wiggleSort(input4);
        assert isWiggleSorted(result4, input4);
    }

    public static boolean isWiggleSorted(int[] result, int[] input) {
        if(result.length != input.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int value: input) {
            map.put(value, (map.containsKey(value) ? map.get(value) : 0) + 1);
        }
        for(int res: result) {
            if(!map.containsKey(res)) {
                return false;
            }
            map.put(res, map.get(res)-1);
        }
        for(int key: map.keySet()) {
            int value = map.get(key);
            if(value != 0) {
                return false;
            }
        }
        for(int i=1;i<result.length-1;i++) {
            int left = result[i-1], mid = result[i], right = result[i+1];
            if(i%2==0) {
                if(!(left>=mid && mid <=right )) {
                    return false;
                }
            }else {
                if(!(left<=mid && mid >=right)) {
                    return false;
                }
            }
        }
        return true;
    }
}


interface S06Solution {
    public int[] wiggleSort(int[] nums);
}
class S06SolutionOne implements S06Solution {
    // O(nlogn)
    public int[] wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1, index = 0;
        while(index < nums.length) {
            int useIndex = -1;
            if(index % 2 != 0) {
                useIndex = right;
                right--;
            } else {
                useIndex = left;
                left++;
            }
            result[index] = nums[useIndex];
            index++;
        }
        return result;
    }
}

class S06SolutionTwo implements S06Solution {
    // O(n) solution
    public int[] wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
