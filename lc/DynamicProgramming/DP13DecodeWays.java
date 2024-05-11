package lc.DynamicProgramming;

import java.util.*;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DP13DecodeWays {
    public static void main(String[] args) {
        DPH02Solution sol = new DPH02SolutionTwo();
        assert sol.numDecodings("12") == 2;
        assert sol.numDecodings("226") == 3;
        assert sol.numDecodings("0") == 0;
        assert sol.numDecodings("20111") == 3;
        assert sol.numDecodings("11106") == 2;
        assert sol.numDecodings("1123") == 5;
        assert sol.numDecodings("06") == 0;
    }
}

// https://leetcode.com/problems/decode-ways/solutions/4454037/97-43-easy-solution-with-explanation/
class DPH02SolutionThree implements DPH02Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=length;i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(oneDigit != 0) {
                dp[i]+=dp[i-1];
            }
            if(twoDigit>=10 && twoDigit <=26) {
                dp[i]+=dp[i-2];
            }
        }
        return dp[length];
    }
}


interface DPH02Solution {
    public int numDecodings(String s);
}

class DPH02SolutionTwo implements DPH02Solution {
    // TLE
    private boolean isValidDecoding(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(s);
        if(value >=1 && value <= 26) {
            return true;
        }
        return false;
    } 
    public int numDecodings(String s) {
        List<String> nodes = new ArrayList<>();
        String firstChar = s.charAt(0) + "";
        if(isValidDecoding(firstChar)) {
            nodes.add(firstChar);
        }
        for(int i=1;i<s.length();i++) {
            List<String> newNodes = new ArrayList<>();
            String ch = s.charAt(i) + "";
            boolean isChValid = isValidDecoding(ch);
            for(String ls: nodes) {
                if(isChValid) {
                    newNodes.add(ch);
                }
                String ns = ls + ch;
                if(isValidDecoding(ns)) {
                    newNodes.add(ns);
                }
            }
            nodes = newNodes;
        }
        return nodes.size();
    }
}
