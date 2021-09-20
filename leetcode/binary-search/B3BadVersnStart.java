// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 2, right = n;
        if(isBadVersion(1)) return 1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(isBadVersion(mid) && !isBadVersion(mid-1)){
                return mid;
            }else if(!isBadVersion(mid)){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
