package lc.math;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * 
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class P05ReversePolishNotation {
    public static void main(String[] args) {
        P05ReversePolishNotationSolution sol = new P05ReversePolishNotationSolution();
        assert sol.evalRPN(new String[]{"2","1","+","3","*"}) == 9;
        assert sol.evalRPN(new String[]{"4","13","5","/","+"}) == 6;
        assert sol.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}) == 22;
        assert sol.evalRPN(new String[]{"3", "4", "+", "5", "6", "+", "*"}) == 77;
    }
}

class P05ReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            if(isAnOperator(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                if(s.equals("+")) {
                    result = a + b;
                }
                if(s.equals("-")) {
                    result = a - b;
                }
                if(s.equals("*")) {
                    result = a * b;
                }
                if(s.equals("/")) {
                    result = a / b;
                }
                stack.push(result);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private boolean isAnOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
