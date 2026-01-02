/**
 * @param {number} n
 * @param {number[][]} flights
 * @param {number} src
 * @param {number} dst
 * @param {number} k
 * @return {number}
 */
var findCheapestPrice = function(n, flights, src, dst, k) {
  const sol = new Solution();
  return sol.findCheapestPrice(n, flights, src, dst, k);
};

class SolutionTwo {
  // Modification of Bellman Ford Algorithm
  findCheapestPrice(n, flights, src, dst, k) {
    let prices = Array.from({ length: n }).map((_, index) => index === src ? 0 : Infinity);
    k++;
    while(k>0) {
      const tempPrices = prices.slice(0);
      for(let flight of flights) {
        const [s, d, p] = flight;
        if(prices[s] + p < tempPrices[d]) {
          tempPrices[d] = prices[s] + p;
        }
      }
      prices = tempPrices;
      k--;
    }
    return prices[dst] === Infinity ? -1 : prices[dst];
  }
}

class SolutionOne {
    findCheapestPrice(n, flights, src, dst, k) {
        const adj = Array.from({ length: n }).map(() => Array.from({ length: n }).fill(Infinity));
        const dp = Array.from({ length: n }).fill(Array.from({ length: n }).fill(null));
        for(let flight of flights) {
            const [s,d,c] = flight;
            adj[s][d] = Math.min(adj[s][d], c);
        }
        return this.fcp(adj, src, dst, k + 1, new Set(), dp);
    }
    fcp(adj, src, dst, remainingVisits, visitedSet, dp) {
        let cost = null;
        if(remainingVisits < 0 || visitedSet.has(src)) {
          cost = Infinity;
        } else if(src === dst) {
            cost = 0;
        } else {
            visitedSet.add(src);
            cost = Infinity;
            for(let i=0;i<adj.length;i++) {
              if(adj[src][i] !== Infinity) {
                cost = Math.min(cost, adj[src][i] + this.fcp(adj, i, dst, remainingVisits-1, visitedSet, dp));
                console.log(`src=${src}, dst=${dst}, cost=${cost}`);
              }
            }
            visitedSet.delete(src);
        }
        return cost;
    }
}

console.log(findCheapestPrice(4, [[0, 1, 200], [1, 2, 100], [1, 3, 300], [2, 3, 100]], 0, 3, 1));
