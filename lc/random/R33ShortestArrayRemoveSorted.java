package lc.random;

/**
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/?envType=daily-question&envId=2024-11-15
 **/
public class R33ShortestArrayRemoveSorted {
    public static void main(String[] args) {
        R33Solution solution = new R33SolutionTwo();
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 4, 2, 3, 5 }) == 3;
        assert solution.findLengthOfShortestSubarray(new int[] { 5, 4, 3, 2, 1 }) == 4;
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 2, 3 }) == 0;
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 2 }) == 0;
        assert solution.findLengthOfShortestSubarray(new int[] { 2, 1 }) == 1;
        assert solution.findLengthOfShortestSubarray(new int[] { 1 }) == 0;
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 3, 2 }) == 1;
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 0, 7, 8, 9 }) == 2;
        assert solution.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 4, 5, -100, 101, 102, 103 }) == 1;
        assert solution.findLengthOfShortestSubarray(new int[] { 2, 2, 2, 1, 1, 1 }) == 3;
    }
}

interface R33Solution {
    public int findLengthOfShortestSubarray(int[] arr);
}

class R33SolutionOne implements R33Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int minSize = Integer.MAX_VALUE;
        int l = 0, r = arr.length - 1;
        while (l + 1 < arr.length && arr[l + 1] >= arr[l]) {
            l++;
        }
        while (r - 1 >= 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        if (l >= r) {
            return arr.length >= 2 ? arr[0] <= arr[1] ? 0 : arr.length - 1 : 0;
        }
        if (r - l == 1) {
            if (l == 0 || r == arr.length - 1) {
                return 1;
            }
            if (r < arr.length - 1 && arr[r + 1] >= arr[l]) {
                return 1;
            }
            if (l > 0 && arr[l - 1] <= arr[r]) {
                return 1;
            }
            if (l > 0 && r < arr.length - 1 && arr[l - 1] <= arr[r + 1]) {
                return 2;
            }
        }
        // left pass
        int l1 = l;
        while (l1 >= 0 && arr[l1] > arr[r]) {
            l1--;
        }
        minSize = Math.min(minSize, l1 < 0 ? r : r - l1 - 1);
        // right pass
        int r1 = r;
        while (r1 != arr.length && arr[r1] < arr[l]) {
            r1++;
        }
        minSize = Math.min(minSize, r1 == arr.length ? arr.length - l - 1 : r1 - l - 1);
        return minSize;
    }
}

class R33SolutionTwo implements R33Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l + 1 < arr.length && arr[l + 1] >= arr[l]) {
            l++;
        }
        while (r - 1 >= 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        if (l >= r) {
            return 0;
        }
        int minSize = Math.min(arr.length - l - 1, r);
        for (int i = 0; i <= l; i++) {
            int left = r, right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[i] <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            minSize = Math.min(minSize, left - i - 1);
        }
        return minSize;
    }
}

class R33SolutionThree implements R33Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        while (l + 1 < n && arr[l + 1] >= arr[l]) {
            l++;
        }
        if (l == n - 1) {
            return 0;
        }
        int r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        int minSize = Math.min(n - l - 1, r);
        for (int i = 0; i <= l; i++) {
            int left = r, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[i] <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            minSize = Math.min(minSize, left - i - 1);
        }
        return minSize;
    }
}
