package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class SE03LongestCommonPrefix {
    public static void main(String[] args) {
        SE03Solution sol = new SE03Solution();
        assert sol.longestCommonPrefix(new String[] {
            "flower","flow","flight"
        }).equals("fl");
        assert sol.longestCommonPrefix(new String[] {
            "dog","racecar","car"
        }).equals("");
        assert sol.longestCommonPrefix(new String[] {
            "car","carry","carter"
        }).equals("car");
    }
}

class SE03Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        int i=0;
        while(true) {
            if(i >= strs[0].length()) {
                break;
            }
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++) {
                if(i>= strs[j].length() || strs[j].charAt(i) != ch) {
                    return result.toString();
                }
            }
            result.append(ch);
            i++;
        }
        return result.toString();
    }
}
