import java.util.HashSet;;
/* https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/815/ */

class Solution {
    public HashSet<Integer> rejects = new HashSet<Integer>();
    public HashSet<Integer> accepts = new HashSet<Integer>();
    public int goHappyNext(int n) {
        int squaredSum = 0;
        while(n > 0) {
            int remainder = n % 10;
            n = n/10;
            squaredSum += remainder * remainder;
        }
        return squaredSum;
    }
    public boolean isHappy(int n) {
        // System.out.print("isHappy:for::" + n + "\n");
        HashSet<Integer> pastNexts = new HashSet<Integer>();
        int original = n;
        int next = goHappyNext(n);
        while(next != 1) {
            pastNexts.add(next);
            // System.out.print("\tnext:" + next);
            next = goHappyNext(next);
            if(pastNexts.contains(next)) {
                rejects.addAll(pastNexts);
                return false;
            }
            if(accepts.contains(next)) {
                accepts.addAll(pastNexts);
                return true;
            }
        }
        accepts.addAll(pastNexts);
        return true;
    }
}


class P1HappyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        assert sol.isHappy(19);
        assert !sol.isHappy(2);
        assert sol.isHappy(13);
    }
}
