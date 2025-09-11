package lc.random;

import java.util.ArrayList;
import java.util.List;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class R32InsertIntervals {
    public static void main(String[] args) {
        R32Solution solution = new R32Solution();
        assert lc.utils.ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {1,3},
            {6,9}
        }, new int[] {2,5}), new int[][] {
            {1,5},
            {6,9}
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {11,13},
            {16,19}
        }, new int[] {1,2}), new int[][] {
            {1,2},
            {11,13},
            {16,19}
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {11,13},
            {16,19}
        }, new int[] {20,25}), new int[][] {
            {11,13},
            {16,19},
            {20,25}
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {11,13},
            {16,19}
        }, new int[] {12,15}), new int[][] {
            {11,15},
            {16,19},
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {11,13},
            {16,19}
        }, new int[] {11,14}), new int[][] {
            {11,14},
            {16,19},
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {11,13},
            {18,25}
        }, new int[] {14,16}), new int[][] {
            {11,13},
            {14,16},
            {18,25},
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {1,2},{3,5},{6,7},{8,10},{12,16}
        }, new int[] {4,8}), new int[][] {
            {1,2},{3,10},{12,16}
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
        }, new int[] {5,7}), new int[][] {
            {5,7}
        });
        assert ArrayUtils.isSame2DArray(solution.insert(new int[][] {
            {1,5},
        }, new int[] {0,3}), new int[][] {
            {0,5}
        });
    }
}

class R32Solution {
    private boolean isSeparate(int[] interval1, int[] interval2) {
        return interval1[1] < interval2[0] || interval1[0] > interval2[1];
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> result = new ArrayList<>();
        boolean hasAddedAlready = false;
        if(intervals.length == 0) {
            result.add(new Integer[] { newInterval[0], newInterval[1]});
        }
        else if(newInterval[1] < intervals[0][0]) {
            result.add(new Integer[] { newInterval[0], newInterval[1]});
            for(int[] interval: intervals) {
                result.add(new Integer[] { interval[0], interval[1]});
            }
        }else if(newInterval[0] > intervals[intervals.length-1][1]) {
            for(int[] interval: intervals) {
                result.add(new Integer[] { interval[0], interval[1]});
            }
            result.add(new Integer[] { newInterval[0], newInterval[1]});
        } else {
            for(int i=0;i<intervals.length;i++) {
                int[] interval = intervals[i];
                if(isSeparate(interval, newInterval)) {
                    if(!hasAddedAlready && newInterval[1] < interval[0]) {
                        result.add(new Integer[] { newInterval[0], newInterval[1]});
                        hasAddedAlready = true;
                    }
                    result.add(new Integer[] { interval[0], interval[1]});
                    continue;
                } else if(!hasAddedAlready) {
                    hasAddedAlready = true;
                    Integer[] lastInterval = new Integer[] { interval[0], interval[1]};
                    int j=i+1;
                    while(j<intervals.length && !isSeparate(intervals[j], newInterval)) {
                        j++;
                    }
                    lastInterval[0] = Math.min(lastInterval[0], newInterval[0]);
                    lastInterval[1] = Math.max(newInterval[1], intervals[j-1][1]);
                    result.add(lastInterval);
                    i = j - 1;
                }
            }
        }
        int[][] resultArr = new int[result.size()][2];
        for(int i=0;i<result.size();i++) {
            Integer[] row = result.get(i);
            resultArr[i] = new int[] { row[0], row[1]};
        }
        return resultArr;
    }
}
