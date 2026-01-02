// https://leetcode.com/problems/longest-common-subsequence/
// strings, arrays, dynamic-programming
/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
  const m = text1.length;
  const n = text2.length;
  const dp = Array.from({ length: m }, () => Array.from({ length: n }).fill(-1));
  const lcs = (i, j) => {
    if(i < 0 || j < 0 || i >=m || j >=n) {
        return 0;
    }
    if(dp[i][j] === -1) {
        dp[i][j] = Math.max(
            lcs(i-1, j),
            lcs(i, j-1), 
            (text1[i] === text2[j] ? 1 : 0) + lcs(i-1, j-1)
        );
    }
    return dp[i][j];
  }
  lcs(m-1,n-1);
  return dp[m-1][n-1];
};
