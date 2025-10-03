package lc.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import lc.utils.ArrayUtils;

class T34KPairsSmallestSum {
    public static void main(String[] args) {
        T34SolutionThree sol = new T34SolutionThree();
        assert ArrayUtils.isSame2DArray(
            ArrayUtils.to2DArray(sol.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3), Integer.class),
            new Integer[][] { { 1, 2 }, { 1, 4 }, { 1, 6 } }
        );
        assert ArrayUtils.isSame2DArray(
            ArrayUtils.to2DArray(sol.kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2), Integer.class),
            new Integer[][] { { 1, 1 }, { 1, 1 } }
        );
        assert ArrayUtils.isSame2DArray(
            ArrayUtils.to2DArray(sol.kSmallestPairs(new int[] { 1, 2, 4, 5, 6 }, new int[] { 3, 5, 7, 9 }, 3), Integer.class),
            new Integer[][] {  { 1, 3 }, { 2, 3 }, { 1, 5 } }
        );
    }
}


class T34SolutionThree {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
          List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> 
            (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        // push first row candidates
        // this avoids duplicates because each row and each column in the sum matrix is sorted in rows and columns
        // so once we add first cell of each row, subsequently inserted items into the heap would be from the same row of the popped item.
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[0], j = cur[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
