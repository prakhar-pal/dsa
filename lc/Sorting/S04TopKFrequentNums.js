/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
  const nbf = Object.entries(
    nums.reduce((acc, n) => {
      acc[n] = (acc[n] ?? 0) + 1;
      return acc;
    }, {}));
    nbf.sort(([_, freq1], [__, freq2]) => {
      console.log(__, _, freq1, freq2);
        return -freq1 +freq2;
    });
    return nbf.slice(0, k).map(([n]) => parseInt(n));
};

console.log(topKFrequent([4, 1, -1, 2, -1, 2, 3], 2));
