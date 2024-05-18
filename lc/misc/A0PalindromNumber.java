package lc.misc;

import java.util.ArrayList;

public class A0PalindromNumber {
    public static void main(String[] args) {
        A0Solution sol = new A0SolutionThree();
        assert sol.isPalindrome(-0);
        assert sol.isPalindrome(0);
        assert sol.isPalindrome(121);
        assert sol.isPalindrome(-121) == false;
        assert sol.isPalindrome(123) == false;
    }
}

interface A0Solution {
    public boolean isPalindrome(int x);
}
class A0SolutionThree implements A0Solution {
    // beats 100%
    public boolean isPalindrome(int x) {
       int cx = x;
       int reversed = 0;
       while(cx>0) {
        reversed = reversed * 10 + cx % 10;
        cx /=10;
       }
       return x == reversed;
    }
}


class A0SolutionTwo implements A0Solution {
    // same performance as SolutionOne
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int current = x;
        while(current>0) {
            list.add(current % 10);
            current = current/10;
        }
        int left = 0, right = list.size() - 1;
        while(left <= right) {
            if(list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
class A0SolutionOne implements A0Solution {
    // beats 39 %
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        int left = 0, right = sb.length() - 1;
        while(left <= right) {
            if(sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
