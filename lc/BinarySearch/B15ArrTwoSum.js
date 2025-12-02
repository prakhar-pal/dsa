/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    function search(target2, start, end) {
        if(start > end || start >= numbers.length || end < 0) {
            return -1;
        }
        const mid = Math.floor(start + (end-start)/2);
        if(numbers[mid] === target2) {
            return mid;
        } else if(numbers[mid] > target2) {
            return search(target2, start, mid - 1);
        }
        return search(target2, mid + 1, end);
    }
    for(let i=0;i<numbers.length;i++) {
        let foundIndex = -1;
        const remaining = target - numbers[i];
        if(remaining <= numbers[i]) {
            foundIndex = search(remaining, 0, i-1);
        }
        if(remaining >= numbers[i] && foundIndex === -1) {
            foundIndex = search(remaining, i+1, numbers.length-1);
        }
        if(foundIndex !== -1) {
            return [i+1 , foundIndex + 1].sort();
        }
    }
};

console.assert(twoSum([2,3,4], 6));
console.assert(twoSum([2,7,11,15], 6));
console.assert(twoSum([-1,0], 6));
