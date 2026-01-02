// https://leetcode.com/problems/longest-increasing-subsequence/
// dynamic-programming, subsequence

import assert from "assert";

/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    const n = nums.length;
    const dp = Array.from({ length: n }).fill(0);
    dp[0] = 1;
    for(let i = 1;i < n; i++) {
     dp[i] = 1;
     for(let j = i-1; j >= 0; j--)  {
        if(nums[j] < nums[i]) {
            dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
     }
    }
    return Math.max(...dp);
};


assert(lengthOfLIS([10,9,2,5,3,7,101,18]) === 4);
assert(lengthOfLIS([0,1,0,3,2,3]) === 4);
assert(lengthOfLIS([7,7,7,7,7,7,7]) === 1);
