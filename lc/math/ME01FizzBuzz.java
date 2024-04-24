package lc.math;
import java.util.*;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */
public class ME01FizzBuzz {
    public static void main(String[] args) {
        ME01Solution sol = new ME01Solution();
        assert sol.fizzBuzz(1).equals(new ArrayList<String>(Arrays.asList(new String[]{"1"})));
        assert sol.fizzBuzz(3).equals(new ArrayList<String>(Arrays.asList(new String[]{"1","2","Fizz"})));
        assert sol.fizzBuzz(5).equals(new ArrayList<String>(Arrays.asList(new String[]{"1","2","Fizz","4","Buzz"})));
        assert sol.fizzBuzz(15).equals(new ArrayList<String>(Arrays.asList(new String[]{"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"})));
    }
}

class ME01Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            int value = i+1;
            String strValue;
            if(value % 5 == 0 && value % 3 == 0) {
                strValue = "FizzBuzz";
            }
            else if(value % 5 == 0) {
                strValue = "Buzz";
            }
            else if(value % 3 == 0) {
                strValue = "Fizz";
            }else {
                strValue = value + "";
            }
            list.add(strValue);
        }
        return list;
    }
}

