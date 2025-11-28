package lc.ArraysAndStrings;
import java.util.Arrays;
import java.util.Comparator;
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class A27MinNumOfArrays {
    public static void main(String[] args) {
        A27Solution solution = new A27Solution();
        assert solution.findMinArrowShots(new int[][] {{10,16},{2,8},{1,6},{7,12}}) == 2;
        assert solution.findMinArrowShots(new int[][] {{1,2},{3,4},{5,6},{7,8}}) == 4;
        assert solution.findMinArrowShots(new int[][] {{1,2},{2,3},{3,4},{4,5}}) == 2;
        assert solution.findMinArrowShots(new int[][] {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}) == 2;

    }
}

class A27Solution {
    // reference: https://www.youtube.com/watch?v=lPmkKnvNPrw
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] prev = points[0];
        int arrows = points.length;
        for(int i=1;i<points.length;i++) {
            if(points[i][0] <= prev[1]) {
                arrows--;
                prev = new int[] {points[i][0], Math.min(points[i][1], prev[1])};
            } else {
                prev = points[i];
            }
        }
        return arrows;
    }
}
