package lc.random;
import java.util.*;

/** https://leetcode.com/problems/contains-duplicate-ii/description/ */
public class R12ContainsDuplicate {
    public static void main(String[] args) {
        R12Solution solution = new R12Solution();
        assert solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3);
        assert solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1);
        assert solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2) == false;
    }
}

class R12Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            List<Integer> list = numberMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            numberMap.put(nums[i], list);
        }
        for(int key: numberMap.keySet()) {
            List<Integer> list = numberMap.get(key);
            if(list.size() < 2) {
                continue;
            }
            int left = 0, right = left + 1;
            while(right < list.size()) {
                while((list.get(right) - list.get(left)) > k) {
                    left++;
                }
                if(left == right) {
                    right++;
                }
                if(right < list.size() && list.get(right) - list.get(left) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
