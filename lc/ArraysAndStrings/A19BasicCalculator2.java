package lc.ArraysAndStrings;

import java.util.*;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 */
public class A19BasicCalculator2 {
    public static void main(String[] args) {
        SolutionA19BasicCalculator2 solution = new SolutionA19BasicCalculator2();
        assert solution.calculate("3+2*2") == 7;
        assert solution.calculate(" 3/2 ") == 1;
        assert solution.calculate(" 3+5 / 2 ") == 5;
        assert solution.calculate("42") == 42;
        assert solution.calculate("1-1+1") == 1;
    }
}

class SolutionA19BasicCalculator2 {
    private boolean isMathOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '-' || ch == '+';
    }
    public int calculate(String _s) {
        String[] words = _s.split(" ");
        String s = "";
        for(String word: words) {
            s+=word;
        }
        Stack<String> stack = new Stack<>();
        int index = 0;
        List<String> list = new ArrayList<>();
        while(index < s.length()) {
            int cindex = index, startIndex = index;
            index++;
            if(isMathOperator(s.charAt(cindex))) {
                list.add(s.charAt(cindex)+"");
                continue;
            }
            while(cindex < s.length()) {
                char ch = s.charAt(cindex);
                if(isMathOperator(ch)) {
                    break;
                }
                cindex++;
            }
            index = cindex;
            list.add(s.substring(startIndex, Math.min(s.length(), cindex)));
        }
        for(int i=0;i<list.size();i++) {
            String str = list.get(i);
            if(str.equals("*") || str.equals("/")) {
                int previous = Integer.parseInt(stack.pop());
                int next = Integer.parseInt(list.get(i+1));
                int result = 0;
                if(str.equals("*")) {
                    result = previous * next;
                }else {
                    result = previous / next;
                }
                stack.push(result + "");
                i++;
            }else {
                stack.push(list.get(i));
            }
        }
        while(stack.size() != 1) {
            int next = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int previous = Integer.parseInt(stack.pop());
            String previousSign = stack.size() >= 1 ? stack.pop(): "+";
            previous *= previousSign.equals("-") ? -1 : 1;
            int result = 0;
            if(operator.equals("+")) {
                result = previous + next;
            }else {
                result = previous - next;
            }
            if(stack.size() >=1) {
                stack.push("+");
            }
            stack.push(result + "");
        }
        return Integer.parseInt(stack.pop());
    }
}
