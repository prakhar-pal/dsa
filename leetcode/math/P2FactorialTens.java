// https://leetcode.com/problems/factorial-trailing-zeroes/description/

import java.util.HashMap;

interface SolutionP2FactorialTens {
    public int trailingZeroes(int n);
}
class SolutionP2FactorialTens1 implements SolutionP2FactorialTens {
    // beats 6% of the solutions
    public int trailingZeroes(int n) {
        int count5 = 0;
        while(n >= 5) {
            int currentNum = n;
            while(currentNum % 5 == 0) {
                count5++;
                currentNum/=5;
            }
            n--;
        }
        return count5;
    }
}

class SolutionP2FactorialTens2 implements SolutionP2FactorialTens {
    // beats 9.65% of the solutions
    public int trailingZeroes(int n) {
        int start = 5;
        int count5 = 0;
        while(start <= n) {
            int currentNum = start;
            while(currentNum % 5 == 0) {
                count5++;
                currentNum/=5;
            }
            start+=5;
        }
        return count5;
    }
}

class MemoizedTZ {
    HashMap<Integer, Integer> contributionMap = new HashMap<>();
    public int trailingZeroes(int n) {
        int start = 5;
        int count5 = 0;
        while(start <= n) {
            int currentNum = start;
            int currentNumOriginal = currentNum;
            int contribution = 0;
            if(contributionMap.containsKey(currentNumOriginal)) {
                // System.out.println("Hitting the cache");
                contribution = contributionMap.get(currentNumOriginal);
            } else {
                while(currentNum % 5 == 0) {
                    contribution++;
                    currentNum/=5;
                }
                // System.out.println("Putting in the cache: key=" + currentNumOriginal + "  value="+ contribution);
                contributionMap.put(currentNumOriginal, contribution);
            }
            count5+=contribution;
            start+=5;
        }
        return count5;
    }
}

class SolutionP2FactorialTens3 implements SolutionP2FactorialTens {
    public static MemoizedTZ memoizedTz;
    public SolutionP2FactorialTens3() {
        if(memoizedTz == null) {
            memoizedTz = new MemoizedTZ();
        }
    }
    public int trailingZeroes(int n) {
        return memoizedTz.trailingZeroes(n);
    }
}

class SolutionP2FactorialTens4 implements SolutionP2FactorialTens {
    // fastest solution
    public int trailingZeroes(int n) {
        int count = 0;
        // Keep dividing n by 5 and update count until n becomes less than 5
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}


public class P2FactorialTens {
 public static void main(String[] args) {
    SolutionP2FactorialTens sol = new SolutionP2FactorialTens3();
    // System.out.println("sol.trailingZeroes(23):" + sol.trailingZeroes(23));
    assert sol.trailingZeroes(0) == 0;
    assert sol.trailingZeroes(5) == 1;
    assert sol.trailingZeroes(8) == 1;
    assert sol.trailingZeroes(10) == 2;
    assert sol.trailingZeroes(15) == 3;
    assert sol.trailingZeroes(20) == 4;
    assert sol.trailingZeroes(23) == 4;
    assert sol.trailingZeroes(25) == 6;
    assert sol.trailingZeroes(26) == 6;
    assert sol.trailingZeroes(30) == 7;
 }   
}
