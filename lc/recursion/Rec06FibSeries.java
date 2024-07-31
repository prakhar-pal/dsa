package lc.recursion;

// https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
import java.util.HashMap;
import java.util.Scanner;

class SolutionRec06FibSeries {
    private HashMap<Integer, Integer> cache;
    public SolutionRec06FibSeries(){
        this.cache = new HashMap<>();
    }
    public int fib(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int result;
        if(n<2){
            result = n;
        }else {
            result = fib(n-1) + fib(n-2);
        }
        cache.put(n, result);
        return result;
    }
}

class Rec06FibSeries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SolutionRec06FibSeries sol = new SolutionRec06FibSeries();
        System.out.println("fib::"+n+"::"+sol.fib(n));
    }
}
