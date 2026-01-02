import assert from "assert";
// https://leetcode.com/problems/koko-eating-bananas/
// binary-search
/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    let k0 = 1, k1 = 1;
    for(let pile of piles) {
        k1 = Math.max(k1, pile);
    }
    while(k0 !== k1) {
        const mid = parseInt((k0 + k1)/2, 10);
        const hours = piles.reduce((acc, pile) =>  acc + Math.ceil(pile/mid), 0);
        if(hours > h) {
            k0 = mid + 1;
        } else {
            k1 = mid;
        }
    }
    return k0;
};


assert(minEatingSpeed([3,6,7,11], 8) === 4);
assert(minEatingSpeed([30,11,23,4,20], 5) === 30);
assert(minEatingSpeed([30,11,23,4,20], 6) === 23);
