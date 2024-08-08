package lc.random;
/**
 * https://leetcode.com/problems/gas-station/description/
 */
public class R26GasStation {
    public static void main(String[] args) {
        R26Solution solution = new R26Solution();
        assert solution.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }) == 3;
        assert solution.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 5 }) == -1;
        assert solution.canCompleteCircuit(new int[] { 1 }, new int[] { 1 }) == 0;
    }
}

class R26Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return diff < 0 ? -1 : start;
    }
}
