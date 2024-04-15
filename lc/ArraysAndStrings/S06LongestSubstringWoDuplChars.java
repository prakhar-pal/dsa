package lc.ArraysAndStrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class S06LongestSubstringWoDuplChars {
    public static void main(String[] args) {
        S06Solution sol = new S06Solution();
        // assert sol.lengthOfLongestSubstring("abcabcbb") == 3;
        // assert sol.lengthOfLongestSubstring("bbbbb") == 1;
        // assert sol.lengthOfLongestSubstring("pwwkew") == 3;
        // assert sol.lengthOfLongestSubstring("") == 0;
        assert sol.lengthOfLongestSubstring("abba") == 2;
    }
}

class S06Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int start = 0;
        HashMap<Character, Integer> positions = new HashMap<>();
        int maxLength = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            int position = positions.containsKey(ch) ? positions.get(ch): -1;
            if(position >= start) {
                start = position + 1;
            }
            positions.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
