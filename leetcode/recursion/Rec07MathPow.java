// https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
import java.util.Scanner;

class Solution {
    public double myPowUtil(double x, int n){
        if(n==0) return 1.0;
        else if(n==1) return x;
        else if(x==0) return 0;
        else {
          int half = n/2;
          double halfResult = myPowUtil(x, half);
          double result = halfResult*halfResult;
            if(n%2==1){
                result = result*x;
            }
            System.out.println(n+" : "+result);
          return result;
        }
    }
    public double myPow(double x, int n) {
        if(n > 0){
            System.out.println("positive");
            return myPowUtil(x,n);
        }

        System.out.println("positive");
         return 1/myPowUtil(x,-n);
    }
}

class Rec07MathPow {
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // double x = sc.nextDouble();
        // int n = sc.nextInt();
        // sc.close();
        double x = 2.0;
        int n = -2147483648;
        Solution sol = new Solution();
        System.out.println("result "+sol.myPow(x,n));
        // System.out.println("result2:"+sol.powPow(x,n));
    }
}
