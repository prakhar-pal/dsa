package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 6. Return the integer as the final result.
 * 
 * Note:
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class SE01Atoi {
    public static void main(String[] args) {
        SE01Solution sol = new SE01Solution();
        assert sol.myAtoi("") == 0;
        assert sol.myAtoi("42") == 42;
        assert sol.myAtoi("  -42") == -42;
        assert sol.myAtoi("4193 with words") == 4193;
        assert sol.myAtoi("4193 with words") == 4193;
        assert sol.myAtoi("-2147483649") == -2147483648;
        assert sol.myAtoi("2147483648 abc def -") == 2147483647;
        assert sol.myAtoi("9223372036854775808") == 2147483647;
    }
}

class SE01Solution {
    public int myAtoi(String s) {
        long result = 0;
        s = s.trim();
        boolean isPositive = !s.startsWith("-");
        if(s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        boolean hasParsingFailed = false;
        boolean isShortCircuited = false;
        for(int i=0;i<s.length() && !hasParsingFailed;i++) {
            try {
                int num = Integer.parseInt(s.charAt(i) + "");
                result = result * 10 + num;
            } catch (Exception e) {
                hasParsingFailed = true;
            }
            long newResult = (isPositive ? 1 : -1) * result;
            if(isPositive && newResult > Integer.MAX_VALUE) {
                isShortCircuited = true;
                result = Integer.MAX_VALUE;
                break;
            }else if(!isPositive && newResult < Integer.MIN_VALUE) {
                isShortCircuited = true;
                result = Integer.MIN_VALUE;
                break;
            }
        }
        result = (!isPositive && !isShortCircuited ? -1 : 1) * result;
        return (int)result;
    }
}
