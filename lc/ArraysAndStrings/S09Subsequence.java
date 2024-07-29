package lc.ArraysAndStrings;
/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class S09Subsequence {
    public static void main(String[] args) {
        S09Solution solution = new S09Solution();
        assert solution.isSubsequence("abc", "ahbgdc");
        assert solution.isSubsequence("", "");
        assert solution.isSubsequence("", "abc");
        assert solution.isSubsequence("abc", "ahbgdcdef");
        assert solution.isSubsequence("axc", "ahbgdc") == false;
        assert solution.isSubsequence("a", "b") == false;
        assert solution.isSubsequence("a", "") == false;
    }
}

class S09Solution {
    public boolean isSubsequence(String s, String t) {
        int ss = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i=0;i<tc.length && ss < sc.length ;i++) {
            if(tc[i] == sc[ss]) {
                ss++;
            }
        }
        return ss == s.length();
    }
}
