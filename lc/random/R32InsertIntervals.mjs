import assert from "node:assert";
/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    const n = intervals.length;
    const result = [];
    let index = 0;
    while(index < n && newInterval[0] > intervals[index][1]) {
        result.push(intervals[index]);
        index++;
    }

    // merge intervals
    while(index < n && intervals[index][0] <= newInterval[1]) {
        newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
        newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
        index++;
    }
    result.push(newInterval);
    while (index < n) {
        result.push(intervals[index]);
        index++;
    }

    return result;
};

console.log(insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]));
console.log(insert([[1,3],[6,9]], [2,5]));
