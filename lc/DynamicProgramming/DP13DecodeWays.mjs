import assert from "assert";
// https://leetcode.com/problems/decode-ways/description/
// dynamic-programming
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    const n = s.length;
    const chars = s.split("");
    const dp = Array.from({ length: n + 1 }).fill(0);
    const util = (index) => {
        if(index<0) {
            return 1;
        }
        if(dp[index+1] === 0) {
            let ways = 0;
            const n0 = parseInt(chars[index], 10);
            if(n0 !== 0) {
                ways += util(index-1);
            }
            if(index >=1 && chars[index-1] !== '0') {
                const n1 = parseInt(chars.slice(index-1, index+1).join(""), 10);
                if(n1 >=10 && n1 <= 26) {
                    ways += util(index-2);
                }
            }
            dp[index+1] = ways;
        }
        return dp[index+1];
    }
    const res = util(n-1);
    return res;
};

assert(numDecodings("12") === 2);
assert(numDecodings("226") === 3);
assert(numDecodings("11106") === 2);
