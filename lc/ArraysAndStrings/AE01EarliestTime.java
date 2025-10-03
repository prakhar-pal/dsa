package lc.ArraysAndStrings;

// https://leetcode.com/contest/weekly-contest-467/problems/earliest-time-to-finish-one-task/
class AE01EarliestTime {
    public static void main(String[] args) {
        AE01Solution solution = new AE01Solution();
        assert solution.earliestTime(new int[][] {{1,6}, {2,3}}) == 5;
        assert solution.earliestTime(new int[][] {{100,100}, {100,100}, {100,100}}) == 200;
        assert solution.earliestTime(new int[][] {{1,2}, {2,3}, {1,3}}) == 3;
    }
}

class AE01Solution {
    public int earliestTime(int[][] tasks) {
        int minTime = Integer.MAX_VALUE;
        for(int[] task: tasks) {
            minTime = Math.min(minTime, task[0]+task[1]);
        }
        return minTime;
    }
}