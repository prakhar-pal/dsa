package lc.random;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/h-index/description/
 */
public class R25HIndex {
    public static void main(String[] args) {
        R52Solution solution = new R52Solution();
        assert solution.hIndex(new int[] {3,0,6,1,5}) == 3;
        assert solution.hIndex(new int[] {1,3,1}) == 1;
        assert solution.hIndex(new int[] {4,4,4,4}) == 4;
        assert solution.hIndex(new int[] {0,4,4,4,4}) == 4;
    }
}

class R52Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int citation: citations) {
            pq.add(citation);
        }
        while(pq.peek() < pq.size()) {
            pq.poll();
        }
        return pq.size();
    }
}
