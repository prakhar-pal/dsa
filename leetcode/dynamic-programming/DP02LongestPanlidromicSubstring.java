// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 0;
                if (dp[i][i + 1] == 1) {
                    minIndex = i;
                    maxIndex = i + 1;
                }
            }
        }
        int substrLen = 3;
        while (substrLen <= length) {
            for (int i = 0; i < length - substrLen + 1; i++) {
                int lastIndex = i + substrLen - 1;
                dp[i][lastIndex] = s.charAt(i) == s.charAt(lastIndex) && dp[i+1][lastIndex-1] == 1 ? 1 : 0;
                if(dp[i][lastIndex] == 1){
                    minIndex = i;
                    maxIndex = lastIndex; 
                }
            }
            substrLen++;
        }
        return s.substring(minIndex, maxIndex+1);
    }
}

public class DP02LongestPanlidromicSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // System.out.println(sol.longestPalindrome("ababac"));
        assert sol.longestPalindrome("babad").length() == 3;
        assert sol.longestPalindrome("ababac").length() == 5;
        assert sol.longestPalindrome("abcde").length() == 1;
    }
}
