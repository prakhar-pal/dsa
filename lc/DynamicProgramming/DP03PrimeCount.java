package lc.DynamicProgramming;


/**
 * https://leetcode.com/problems/count-primes/description/
 */
class Sieve {
    /**
     * run time, beats solutions, memory, beats memory usage
     * 50ms,  98.17%, 45.20MB, 99.23% with java
     */
    private int MAX_N = (int)Math.pow(10, 6) * 5;
    /** AKA sieve of Eratosthens */
    private boolean[] isPrime = new boolean[MAX_N+1];
    public Sieve() {
        /** assume all ints are prime */
        for(int i=0;i<=MAX_N;i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2;i*i<=MAX_N; i+=1) {
            if(isPrime[i]) {
                int currentNum = i*i;
                while(currentNum <= MAX_N) {
                    this.isPrime[currentNum] = false;
                    currentNum += i;
                }
            }
        }
    }

    public int countPrimes(int upperLimit) {
        int n = Math.max(0, upperLimit - 1);
        int total = 0;
        for(int i=2; i<=n;i++){
            total +=  isPrime[i] ? 1 : 0;
        }
        return total;
    }
}

class Sieve2 {
    /**
     * run time, beats solutions, memory, beats memory usage
     * 32ms, 99.13%, 66.34MB, 5.6% with Java
     */
    private int MAX_N = (int)Math.pow(10, 6) * 5;
    /** AKA sieve of Eratosthens */
    private boolean[] isPrime = new boolean[MAX_N+1];
    private int[] primeCount = new int[MAX_N+1];
    public Sieve2() {
        /** assume all ints are prime */
        for(int i=0;i<=MAX_N;i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2;i*i<=MAX_N; i+=1) {
            if(isPrime[i]) {
                int currentNum = i*i;
                while(currentNum <= MAX_N) {
                    this.isPrime[currentNum] = false;
                    currentNum += i;
                }
            }
        }
        /*pre-compute all the possible counts of premium numbers at index i*/
        for(int i=2; i<=MAX_N;i++) {
            primeCount[i] = primeCount[i-1] + (isPrime[i] ? 1 : 0);
        }
    }

    public int countPrimes(int upperLimit) {
        int n = Math.max(1, upperLimit - 1);
        return primeCount[n];
    }
}
class SolutionDP03PrimeCount {
    private static Sieve sieve = null;
    public SolutionDP03PrimeCount() {
        if(sieve == null) {
            sieve = new Sieve();
        }
    }

    public int countPrimes(int n) {
        return sieve.countPrimes(n);
    }
}

class DP03PrimeCount {
    public static void main(String[] args) {
        SolutionDP03PrimeCount sol = new SolutionDP03PrimeCount();
        assert sol.countPrimes(7) == 3;
        assert sol.countPrimes(8) == 4;
        assert sol.countPrimes(6) == 3;
        assert sol.countPrimes(2) == 0;
        assert sol.countPrimes(1) == 0;
        assert sol.countPrimes(0) == 0;
        assert sol.countPrimes(5) == 2;
        assert sol.countPrimes(10) == 4;
        assert sol.countPrimes(100) >= 4;
        assert sol.countPrimes(5000000) >= 0;
    }
}
