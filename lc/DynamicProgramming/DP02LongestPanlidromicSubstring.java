package lc.DynamicProgramming;
// https://leetcode.com/problems/longest-palindromic-substring/

import java.util.*;

class SolutionDP02LPSO1 implements DP02PSSolution {
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
        DP02PSSolution sol = new SolutionDP02LPSO2();
        System.out.println("solution:" + sol.longestPalindrome("ababac"));
        assert sol.longestPalindrome("babad").length() == 3;
        assert sol.longestPalindrome("ababac").length() == 5;
        assert sol.longestPalindrome("abcde").length() == 1;
    }
}

interface DP02PSSolution {
    public String longestPalindrome(String s);
}

/**
 * explanation from https://www.youtube.com/watch?v=XYQecbcd6_c
 */
class SolutionDP02LPSO3 implements DP02PSSolution {
    public String lps(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }

    public String longestPalindrome(String s) {
        String res =  "";
        for(int i=0;i<s.length();i++) {
            String s1 = lps(s, i, i);
            String s2 = lps(s, i, i+1);
            String s3 = s1.length() > s2.length() ? s1 : s2;
            if(s3.length() > res.length()) {
                res = s3;
            }
        }
        return res;
    }
}


class SolutionDP02LPSO2 implements DP02PSSolution {
    /**
     * This solution runs in O(n^3)
     * Results in time limit exceeded
     */

    public boolean isPalindrom(String s) {
        String reversed = new StringBuffer(s).reverse().toString();
        return reversed.equals(s);
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }
        int MAX_LIST_SIZE = 26;
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        sb.reverse();
        String rs = sb.toString();
        List<List<String>> hashList = new ArrayList<List<String>>(26);
        String lps = new String(s.charAt(0) + "");
        for(int i=0;i<MAX_LIST_SIZE;i++) {
            hashList.add(i, new ArrayList<String>());
        }
        for(int i=0;i<s.length();i++) {
            int prevHashValue =  s.charAt(i) - ' ';
            for(int j=i+1;j < s.length();j++) {
                String ss = s.substring(i, j+1);
                int newHashValue = (10*prevHashValue + s.charAt(j)) % MAX_LIST_SIZE;
                List<String> list = hashList.get(newHashValue);
                list.add(ss);
            }
        }
        for(int i=0;i<rs.length();i++) {
            int prevHashValue = rs.charAt(i) - ' ';
            for(int j=i+1;j<rs.length();j++) {
                String ss = rs.substring(i, j+1);
                int newHashValue = (10*prevHashValue + rs.charAt(j)) % MAX_LIST_SIZE;
                List<String> list = hashList.get(newHashValue);
                for(int k=0;k<list.size();k++) {
                    if(list.get(k).length() > lps.length() && list.get(k).equals(ss) && isPalindrom(ss)) {
                        lps = ss;
                    }
                }
            }
        }
        return lps;
    }
}
