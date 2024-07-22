package lc.Backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class BT07PalindromPartitioning {
    public static void main(String[] args) {
        BT07Solution solution = new BT07Solution();

        List<List<String>> result1 = new ArrayList<>();
        result1.add(List.of(new String[] {"aa","b"}));
        result1.add(List.of(new String[] {"a","a","b"}));
        assert solution.partition("aab").equals(result1);
        
        List<List<String>> result2 = new ArrayList<>();
        result2.add(List.of(new String[] {"a"}));
        assert solution.partition("a").equals(result2);
    }
}

class BT07Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        partition(s, 0, 1, result, currentList);
        return result;
    }
    public void partition(String s, int beginIndex, int length, List<List<String>>result, List<String> currentList) {
        if(beginIndex == s.length()) {
            if(currentList.size() > 0) {
                List<String> copyCurrentList = List.copyOf(currentList);
                result.add(copyCurrentList);
            }
            return;
        }
        if(beginIndex + length > s.length()) {
            return;
        }
        partition(s, beginIndex, length + 1, result, currentList);
        if(isPalindrom(s, beginIndex, length)) {
            currentList.add(s.substring(beginIndex, beginIndex + length));
            partition(s, beginIndex + length, 1, result, currentList);
            currentList.remove(currentList.size()-1);
        }
    }

    private boolean isPalindrom(String s, int beginIndx, int length) {
        int endIndex = beginIndx + length - 1;
        while(beginIndx <= endIndex) {
            if(s.charAt(endIndex) != s.charAt(beginIndx)) {
                return false;
            }
            beginIndx++;
            endIndex--;
        }
        return true;
    }
}
