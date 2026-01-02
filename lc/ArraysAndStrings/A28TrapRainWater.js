// https://leetcode.com/problems/trapping-rain-water/
// two-pointer
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    const left = [0];
    let max = height[0];
    for(let i=1;i<height.length;i++) {
        left.push(max);
        max = Math.max(max, height[i]);
    }
    const right = [0];
    max = height[height.length-1];
    for(let i=height.length-1;i>=0;i--) {
        right.unshift(max);
        max = Math.max(max, height[i]);
    }
    let water = 0;
    for(let i=1;i<height.length-1;i++) {
        water += Math.max(Math.min(left[i], right[i]) - height[i], 0);
    }
    return water;
};
