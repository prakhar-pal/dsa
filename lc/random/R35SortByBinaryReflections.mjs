/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortByReflection = function(nums) {
    return nums.map(n => {
        return [n, parseInt(n.toString(2).split("").reverse().join(""), 10)]
    }).sort((a, b) => {
       const [deca, bina] = a;
        const [decb, binb] = b;
        if(bina === binb) {
            return deca - decb;
        }
        return bina - binb;
    })
    .map(n => n[0]);
};

console.log(sortByReflection([4,5,4]));
console.log(sortByReflection([3,6,5,8]));
