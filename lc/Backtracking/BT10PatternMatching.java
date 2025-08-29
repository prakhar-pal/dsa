package lc.Backtracking;

import java.util.HashSet;
import lc.utils.Clogger;

class BT10Solution {

    public boolean isMatch(String s, String p) {
        return isMatch4(s, (p));
    }

    private boolean isMatch3(String s, String p) {
        int ss = s.length();
        int pp = p.length();
        boolean[][] dp = new boolean[ss + 1][pp + 1];
        dp[0][0] = true;
        for (int j = 1; j <= pp; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int j = 1; j <= pp; j++) {
            dp[0][j] = p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= ss; i++) {
            for (int j = 1; j <= pp; j++) {
                char schar = s.charAt(i - 1);
                char pchar = p.charAt(j - 1);
                if (schar == pchar || pchar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pchar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[ss][pp];
    }

    private boolean isMatch4(String s, String p) {
        int ss = s.length();
        int pp = p.length();

        boolean[][] dp = new boolean[ss + 1][pp + 1];
        dp[0][0] = true;

        for (int j = 1; j <= pp; j++) if (p.charAt(j - 1) == '*') dp[0][j] =
            dp[0][j - 1];

        for (int i = 1; i <= ss; i++) {
            for (int j = 1; j <= pp; j++) {
                if (
                    p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'
                ) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[ss][pp];
    }
}

public class BT10PatternMatching {

    public static void main(String[] args) {
        BT10Solution solution = new BT10Solution();
        Clogger.log(
            "result:" +
            solution.isMatch(
                "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab",
                "***bba**a*bbba**aab**b"
            )
        );
        assert solution.isMatch("aa", "a") == false;
        assert solution.isMatch("aa", "*a");
        assert solution.isMatch("aa", "*");
        assert solution.isMatch("cb", "*a") == false;
        assert solution.isMatch("ababc", "a*c");
        assert solution.isMatch("ababc", "a*b") == false;
        assert solution.isMatch("ababc", "a*c");
        assert solution.isMatch("ababc", "a*?");
        assert solution.isMatch("", "*");
        assert solution.isMatch("", "?") == false;
        assert solution.isMatch("aaa", "???");
        assert solution.isMatch("aaa", "??") == false;
        assert solution.isMatch("adceb", "*a*b");
        assert solution.isMatch("", "*****");
        assert solution.isMatch(
            "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab",
            "***bba**a*bbba**aab**b"
        ) ==
        false;
        assert solution.isMatch(
            "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
            "a*******b"
        ) ==
        false;
        assert solution.isMatch(
            "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
            "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
        ) ==
        false;
    }
}
