package lc.Backtracking;
import java.util.*;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class BT09RemoveInvalidParantheses {
    public static void main(String[] args) {
        BT09Solution solution = new BT09Solution();

        HashSet<String> result1 = new HashSet<>();
        Collections.addAll(result1, "(())()", "()()()");
        assert new HashSet<>(solution.removeInvalidParentheses("()())()")).equals(result1);

        HashSet<String> result2 = new HashSet<>();
        Collections.addAll(result2, "(a())()","(a)()()");
        assert new HashSet<>(solution.removeInvalidParentheses("(a)())()")).equals(result2);
    }
}

class BT09Solution {
    public List<String> removeInvalidParentheses(String s) {
        int minInvalidParanthese = findInvalidParanthesesCount(s);
        StringBuffer strBuffer = new StringBuffer();
        HashSet<String> resultSet = new HashSet<>();
        ripUtil(s, 0, strBuffer, resultSet, minInvalidParanthese);
        List<String> resultList = new ArrayList<>(resultSet);
        return resultList;
    }

    private void ripUtil(String s, int index, StringBuffer buffer, HashSet<String> resultSet, int remainingReductions) {
        if(index == s.length()) {
            String resultString = buffer.toString();
            if(findInvalidParanthesesCount(resultString) == 0) {
                resultSet.add(resultString);
            }
            return;
        }
        char ch = s.charAt(index);
        if(remainingReductions > 0 && (ch == ')' || ch == '(')) {
            ripUtil(s, index+1, buffer, resultSet, remainingReductions-1);
        }
        buffer.append(ch);
        ripUtil(s, index+1, buffer, resultSet, remainingReductions);
        buffer.delete(buffer.length() - 1 , buffer.length());
    }

    private char oppositeParantheses(char ch) {
        if(ch == ')') {
            return '(';
        }
        return ')';
    }
    private int findInvalidParanthesesCount(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch != ')' && ch != '(') {
                continue;
            }
            if(ch == ')' && stack.size() > 0 && stack.peek() == oppositeParantheses(ch)) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.size();
    }
}

