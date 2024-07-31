package lc.random;
import java.util.*;

/**
 * https://leetcode.com/problems/summary-ranges/
 */
public class R11SummaryRanges {
    public static void main(String[] args) {
        R11Solution solution = new R11Solution();
        assert solution.summaryRanges(new int[] {0,1,2,4,5,7}).equals(List.of("0->2","4->5","7"));
        assert solution.summaryRanges(new int[] {0,2,3,4,6,8,9}).equals(List.of("0","2->4","6","8->9"));
    }
}

class R11Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<nums.length) {
            int j = i;
            while(j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            StringBuffer buffer = new StringBuffer();
            buffer.append(nums[i]);
            if(i != j) {
                buffer.append("->" + nums[j]);
            }
            list.add(buffer.toString());
            i = j + 1;
        }
        return list;
    }
}
