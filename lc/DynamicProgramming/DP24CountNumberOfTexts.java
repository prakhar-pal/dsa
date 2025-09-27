package lc.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DP24CountNumberOfTexts {
    public static void main(String[] args) {
        DP24Solution solution = new DP24Solution();
        assert  solution.countTexts("22233") == 8;
        assert  solution.countTexts("222222222222222222222222222222222222") == 82876089;
    }
}

class DP24Solution {
    int MOD = (int) Math.pow(10, 9) + 7;
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dp = new int[n+1];
        dp[0]=dp[1] = 1;
        for(int i=1;i<n;i++) {
            dp[i+1] = dp[i];
            char ch = pressedKeys.charAt(i);
            if(ch == pressedKeys.charAt(i-1)) {
                dp[i+1]=(dp[i+1] +dp[i-1]) % MOD;
                if(i>=2 && ch == pressedKeys.charAt(i-2)) {
                    dp[i+1] = (dp[i+1]+dp[i-2])% MOD;
                    if(i>=3 && (ch == '7' || ch == '9') && ch == pressedKeys.charAt(i-3)) {
                        dp[i+1]=(dp[i+1]+dp[i-3])% MOD;
                    }
                }
            }
        }
        return dp[n];
    }
}


