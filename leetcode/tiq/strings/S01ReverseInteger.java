// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
// Reverse Integer
import java.math.BigInteger;


class SolutionS01ReverseIntegerOne {
    // The first attempt
    public int reverse(int x) {
        if(x == 0) return 0;
        int RES_MIN = -(int) Math.pow(2,31), RES_MAX = (int) Math.pow(2,31) - 1;
        int multiplier = 1;
        if(x < 0){
            x = -x;
            System.out.println("+x:"+x);
            multiplier = -1;
        }
        String revStr = "";
        while(x>0){
            revStr = revStr + x % 10;
            x = x/10;
        }
        System.out.println("revstr::" + revStr + "cx::"+x);
        BigInteger bigResult = new BigInteger(revStr);
        if(bigResult.compareTo(new BigInteger(RES_MAX+"")) > 0 || bigResult.compareTo(new BigInteger(RES_MIN+"")) < 0) return 0;
        return multiplier * Integer.parseInt(revStr);
    }
}


class SolutionS01ReverseInteger {
    // Copied from
    // https://leetcode.com/submissions/detail/667576346/
    public int reverse(int x) {
        
        int num = x;
        long rev = 0, rem;
        while(num != 0){
            rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }
        
        if(rev >= Integer.MAX_VALUE || rev <= Integer.MIN_VALUE)
                return 0;
        return (int)rev;
    }
}

class S01 {
    public static void main(String args[]){
        SolutionS01ReverseInteger sol = new SolutionS01ReverseInteger();
        int x1 = 123;
        int res1 = 321;
        
        int x2 = -123;
        int res2 = -321;
        
        int x3 = 120;
        int res3 = 21;
        
        int x4 = 0;
        int res4 = 0;
        
        int x5 = 1534236469;
        int res5 = 0;
        
        int x6 = -2147483648;
        int res6 = 0;
        assert sol.reverse(x1) == res1;
        assert sol.reverse(x2) == res2;
        assert sol.reverse(x3) == res3;
        assert sol.reverse(x4) == res4;
        assert sol.reverse(x5) == res5;
        assert sol.reverse(x6) == res6;
    }
}
