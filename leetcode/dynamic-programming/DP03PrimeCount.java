class Sieve {
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
class Solution {
    private static Sieve sieve = null;
    public Solution() {
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
        Solution sol = new Solution();
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
