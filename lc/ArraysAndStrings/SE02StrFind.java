package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class SE02StrFind {
    public static void main(String[] args) {
        SE02Solution  sol = new SE02Solution();
        assert sol.strStr("sadbutsad", "sad") == 0;
        assert sol.strStr("leetcode", "leeto") == -1;
        assert sol.strStr("abdabdabc", "abc") == 6;
    }
}

class SE02Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        for(int i=0;i<haystack.length() - needle.length() + 1; i++) {
            boolean didFind = true;
            for(int j=0;j<needle.length();j++) {
                char nChar = needle.charAt(j);
                char hsChar = haystack.charAt(i + j);
                if(nChar != hsChar) { 
                    didFind = false;
                }
            }
            if(didFind) {
                return i;
            }
        }
        return index;        
    }
}
