package lc.ArraysAndStrings;
import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class A20SlidingWindowMaximum {
    public static void main(String[] args) {
        A20Solution solution = new A20SolutionThree();
        assert ArrayUtils.isSame1DArray(solution.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3), new int[] {3,3,5,5,6,7});
        assert ArrayUtils.isSame1DArray(solution.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 2), new int[] {3,3,-1,5,5,6,7});
    }
}

interface A20Solution {
    public int[] maxSlidingWindow(int[] nums, int k);
}

class A20SolutionOne implements A20Solution {
    // overall complexity O(n * log k) where n = nums.length
    // passes 37/51 test cases on leetcode
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int[] result = new int[nums.length - k + 1];
        int index = 1;
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }
        if(result.length != 0) {
            result[0] = pq.peek();
        }
        for(int i=k;i<nums.length;i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            result[index++] = pq.peek();
        }
        return result;
    }
}

class A20SolutionTwo implements A20Solution {
    // overall complexity O(nk)
    // funnily enough it passes 43/52 test cases on Leetcode
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for(int i=k-1;i<nums.length;i++) {
            int max = Integer.MIN_VALUE;
            for(int j=i-k+1;j<=i;j++) {
                max = Math.max(max, nums[j]);
            }
            result[i-k+1] = max;
        }
        return result;
    }
}


class A20SolutionThree implements A20Solution {
    // overall complexity O(n)
    public int max;
    public int maxCount;

    private void findAndSetMax(int[] nums, int start, int k) {
        max = Integer.MIN_VALUE;
        for(int i=start;i<start+k;i++) {
            int newMax = Math.max(max, nums[i]);
            if(newMax != max) {
                maxCount = 0;
            }
            max = newMax;
            if(nums[i] == max) {
                maxCount++;
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        findAndSetMax(nums, 0, k);
        if(result.length != 0) {
            result[0] = max;
        }
        int index = 1;
        for(int i=k;i<nums.length;i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxCount = 1;
            }
            if(nums[i-k] == max) {
                maxCount--;
            }
            if(maxCount == 0) {
                findAndSetMax(nums, i-k+1, k);
            }
            result[index++] = max;
        }
        return result;
    }
}



class A20SolutionFour implements A20Solution {
    // overall complexity O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<k;i++) {
            while(dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        int index = 0;
        for(int i=k;i<nums.length;i++) {
            result[index++] = nums[dq.peekFirst()];
            if(dq.size() > 0 && nums[dq.peekFirst()] == nums[i-k]) {
                dq.pollFirst();
            }
            while(dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        result[index++] = nums[dq.peekFirst()];
        return result;
    }
}
