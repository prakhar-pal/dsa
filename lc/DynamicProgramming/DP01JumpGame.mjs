// https://leetcode.com/problems/jump-game/
// dynamic-programming, greedy-approach, memoization
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    const visited = new Set();
    const visit = (index) => {
        // greedy-ly try to visit the max index from the current index
        // save the result if e.g. if index j can't reach the end of the list
        if(visited.has(index)) {
            return false;
        }
        if(index >= nums.length -1) {
            return true;
        }
        const maxJump = nums[index];
        for(let j=maxJump;j>0;j--) {
            if(visit(index + j)) {
                return true;
            }
        }
        visited.add(index);
        return false;
    }
    if(nums.length === 1) {
        return true;
    }
    return visit(0);
};
