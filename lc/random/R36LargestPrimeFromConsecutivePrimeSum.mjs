/**
 * @param {number} n
 * @return {number}
 */
let instance = null;
var largestPrime = function(n) {
    // if(instance === null) {
    // }
    instance = new Primes(n);
    return instance.find();
};


class Primes {
    isPrime = null;
    primes = [];
    sums = new Set();
    primeSet = new Set();
    n = null;
    constructor(SIZE) {
        this.n = SIZE;
        // const SIZE = 5 * 10**5;
        this.isPrime = Array.from({ length: SIZE + 1 }).fill(true);
        this.isPrime[1] = false;
        this.isPrime[2] = true;
        for(let i=2;i<=SIZE;i++) {
            if(this.isPrime[i]) {
                for(let j=2;j*i<=SIZE;j++) {
                     this.isPrime[i*j] = false;   
                }
            }
        }
        for(let i=2;i<=SIZE;i++) {
            if(this.isPrime[i]) {
                this.primes.push(i);
            }
        }
        this.primeSet = new Set(this.primes);
        let current = new Set([2]);
        // console.log("primes", this.primes);
        this.sums.add(2);
        for(let n of this.primes.slice(1)) {
            const next = new Set();
            for(let c of current) {
                next.add(c+n);
            }
            next.add(n);
            console.log("next", next, current);
            [...next]
            .filter(n => n <= this.n)
            .forEach(n => {
                this.sums.add(n);
            })
            current = next;
        }
        // console.log("sums", this.sums);
    }

    find() {
        for(let i=this.n;i>=2;i--) {
            // console.log(this.primeSet, this.sums);
            if(this.sums.has(i)) {
                return i;
            }
        }
        return 0;
    }
}

console.log(largestPrime(20));
console.log(largestPrime(5));
