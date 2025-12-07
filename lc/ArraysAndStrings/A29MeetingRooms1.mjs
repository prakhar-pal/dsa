// https://neetcode.io/problems/meeting-schedule/question?list=neetcode150
// intervals
/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

import assert from "assert";

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {boolean}
     */
    canAttendMeetings(intervals) {
        let result = true;
        intervals.sort((a, b) => a[0] - b[0]);
        for(let i=1;i<intervals.length;i++) {
            if(intervals[i-1][1] > intervals[i][0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
const solution = new Solution();
assert(solution.canAttendMeetings([[0,30],[5,10],[15,20]]) === false);
assert(solution.canAttendMeetings([[5,8],[9,15]]) === true);
