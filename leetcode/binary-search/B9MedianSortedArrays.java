// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    private double median(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) {
            return (nums[len / 2] + nums[len / 2 - 1]) / 2.0;
        } else
            return 1.0 * nums[len / 2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return median(nums2);
        else if (nums2.length == 0)
            return median(nums1);
        else if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int count = (nums1.length + nums2.length + 1) / 2;
        int low = 0, high = nums1.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mid2 = count - mid;
            int l1 = mid - 1 >= 0 && mid - 1 < nums1.length ? nums1[mid - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 && mid2 - 1 < nums2.length ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid >= 0 && mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int r2 = mid2 >= 0 && mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else
                    return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // System.out.println("low:" + low + "\t high:" + high);
        return 0.0;
    }
}

class B9MedianSortedArrays {
    public static void main(String[] args) {
        int tc1[][] = { { 1, 3 }, { 2 } };
        int tc2[][] = { { 0, 0 }, { 0, 0 } };
        int tc3[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 } };
        int tc4[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int tc5[][] = { { 3 }, { -2, -1 } };

        Solution sol = new Solution();
        assert sol.findMedianSortedArrays(tc2[0], tc2[1]) == 0.0;
        assert sol.findMedianSortedArrays(tc1[0], tc1[1]) == 2.0;
        assert sol.findMedianSortedArrays(tc3[0], tc3[1]) == 4.5;
        assert sol.findMedianSortedArrays(tc4[0], tc4[1]) == 3.5;
        System.out.println(sol.findMedianSortedArrays(tc5[0], tc5[1]));
        assert sol.findMedianSortedArrays(tc5[0], tc5[1]) == -1.0;
    }
}
