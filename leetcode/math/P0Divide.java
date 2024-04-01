// https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/820/
class SolutionP0Divide {
    public static long LOWEST_QUOTIENT = (long)Math.pow(2, 31) * (-1);
    public static long HIGHEST_QUOTIENT = (long) (Math.pow(2, 31) - 1);
    public long abs(long num) {
        if(num >=0) {
            return num;
        }else {
            return num * -1;
        }
    }
    public int divide(long dividend, long divisor) {
        boolean isPositive = true;
        if((dividend > 0 && divisor < 0 )|| (divisor > 0 && dividend < 0 )) {
            isPositive = false;
        }
        dividend = this.abs(dividend);
        divisor = this.abs(divisor);
        long result = Math.floorDiv(dividend, divisor) * (isPositive ? 1l: -1l);
        if(result < LOWEST_QUOTIENT) {
            return (int)LOWEST_QUOTIENT;
        }else if(result > HIGHEST_QUOTIENT) {
            return (int)HIGHEST_QUOTIENT;
        }

        return (int)result;
    }
}

class P0Divide {
    public static void main(String[] args) {
        SolutionP0Divide sol = new SolutionP0Divide();
        assert sol.divide(10, 3) == 3;
        assert sol.divide(7, -3) == -2;
        assert sol.divide(-2147483648, -1) == 2147483647;
    }
}
