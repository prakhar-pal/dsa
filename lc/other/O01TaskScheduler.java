package lc.other;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 * ​Return the minimum number of intervals required to complete all tasks.
 */
public class O01TaskScheduler {
    public static void main(String[] args) {
        O01TaskSchedulerSolution sol = new O01TaskSchedulerSolution();
        assert sol.leastInterval(new char[]{'A','A','A','B','B','B'}, 2) == 8;
        assert sol.leastInterval(new char[]{'A','C','A','B','D','B'}, 1) == 6;
        assert sol.leastInterval(new char[]{'A','A','A', 'B','B','B'}, 3) == 10;
        assert sol.leastInterval(new char[] {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2) == 12;
    }
}

class O01TaskSchedulerSolution {
    public int leastInterval(char[] tasks, int interval) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] frequencies = new int[26];
        for(char ch: tasks) {
            frequencies[ch - 'A']++;
        }
        for(int freq: frequencies) {
            if(freq != 0) {
                pq.add(freq);
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()) {
            if(!pq.isEmpty()) {
                int currentFreq = pq.poll();
                int newFreq = currentFreq - 1;
                if(newFreq != 0) {
                    Integer[] arr = new Integer[2];
                    arr[0] = newFreq;
                    arr[1] = time + interval;
                    queue.add(arr);
                }
            }
            if(!queue.isEmpty()) {
                Integer[] first = queue.peek();
                if(first[1] <= time) {
                    queue.poll();
                    pq.add(first[0]);
                }
            }
            time++;
        }
        return time;
    }
}
