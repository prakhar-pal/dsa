package lc.random;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 *  Open brackets must be closed by the same type of brackets.
 *  Open brackets must be closed in the correct order.
 *  Every close bracket has a corresponding open bracket of the same type.
 */
public class R07ValidParantheses {
    public static void main(String[] args) {
        OE05Solution sol = new OE05Solution();
        assert sol.isValid("");
        assert sol.isValid("()");
        assert sol.isValid("[]");
        assert sol.isValid("[]");
        assert sol.isValid("{}");
        assert sol.isValid("{}()[]");
        assert sol.isValid("(") == false;
        assert sol.isValid("]") == false;
        assert sol.isValid("(]") == false;
    }
}

class OE05Solution {
    char[] stack;
    public boolean isValid(String s) {
        stack = new char[(int)Math.pow(10, 4)];
        int index = -1;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack[++index] = ch;
            }else if (index == -1) {
                return false;
            }else {
                char lastCharacter = stack[index];
                boolean isLastCharacterMatching = (ch == ')' && lastCharacter == '(') 
                    || (ch == '}' && stack[index] == '{')
                    || (ch == ']' && stack[index] == '[');
                if(isLastCharacterMatching) {
                    index--;
                }else {
                    return false;
                }
            }
        }
        return index == -1;
    }
}
