package lc.math;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * If multiple answers are possible, return any of them.
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
public class P4DivRecurringDecimals {
    public static void main(String[] args){
        P4DivRecurringDecimalsSolution sol = new P4DivRecurringDecimalsSolution();
        System.out.println("sol="+sol.fractionToDecimal(-1, -2147483648));
        assert sol.fractionToDecimal(1, 2).equals("0.5");
        assert sol.fractionToDecimal(2, 1).equals("2");
        assert sol.fractionToDecimal(4, 333).equals("0.(012)");
        assert sol.fractionToDecimal(-50, 8).equals("-6.25");
        assert sol.fractionToDecimal(-1, -2147483648).equals("0.0000000004656612873077392578125");
        assert sol.fractionToDecimal(-2147483648, 1).equals("-2147483648");
    }
}

class P4DivRecurringDecimalsSolution {
    /**
     * Note:
     * Using normal strings, it beats only 5.68% Java solutions
     * Using string builder, it beats 100% of the Java solutions
     */
    public String fractionToDecimal(int n, int d) {
        long numerator = n, denominator = d;
        boolean isNegative = numerator * denominator < 0;
        if(numerator < 0) {
            numerator = -1 *numerator;
        }
        if(denominator < 0) {
            denominator *= -1;
        }
        StringBuilder valueString = new StringBuilder();
        if(isNegative) {
            valueString.append("-");
        }
        long value = numerator/denominator;
        valueString.append(value);
        long remainder = numerator % denominator;
        if(remainder == 0) {
            return valueString.toString();
        } else {
            valueString.append(".");
            remainder = 10 * remainder;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                /** repeating characters */
                int position = map.get(remainder);
                valueString.insert(position, "(");
                valueString.append(")");
                return valueString.toString();
            }
            map.put(remainder, valueString.length());
            if(remainder >= denominator) {
                long currentValue = remainder/denominator;
                valueString.append(currentValue);
                remainder = remainder % denominator;
            }else {
                valueString.append("0");
            }
            remainder *= 10;
        }
        return valueString.toString();
    }
}
