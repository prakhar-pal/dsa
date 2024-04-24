package lc.math;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class ME03RomanToInteger {
    public static void main(String[] args) {
        ME03Solution sol = new ME03Solution();
        assert sol.romanToInt("I") == 1;
        assert sol.romanToInt("V") == 5;
        assert sol.romanToInt("IV") == 4;
        assert sol.romanToInt("III") == 3;
        assert sol.romanToInt("LVIII") == 58;
        assert sol.romanToInt("MCMXCIV") == 1994;
    }
}

class ME03Solution {
    public int romanToInt(String s) {
        int prevCharValue = 0;
        int result = 0;
        for(int i=0;i<s.length();i++) {
            int currentCharValue = 0;
            char ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    currentCharValue = 1;
                    break;
                case 'V':
                    currentCharValue = 5;
                    break;
                case 'X':
                    currentCharValue = 10;
                    break;
                case 'L':
                    currentCharValue = 50;
                    break;

                case 'C':
                    currentCharValue = 100;
                    break;
                case 'D':
                    currentCharValue = 500;
                    break;
                case 'M':
                    currentCharValue = 1000;
                    break;
            }
            if(prevCharValue < currentCharValue) {
                result += - 2*prevCharValue;
            }
            result+=currentCharValue;
            prevCharValue = currentCharValue;
        }  
        return result;      
    }
}
