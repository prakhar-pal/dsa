/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  const forward = [nums[0]];
  const backward = [nums[nums.length-1]];
  for(let i=1;i<nums.length;i++) {
    forward.push(forward[i-1]*nums[i]);
  }
  for(let i=nums.length-2;i>=0;i--) {
    backward.unshift(backward[0]*nums[i]);
  }
  console.log(forward, backward);
  const result = [];
  result.push(backward[1]);
  for(let i=1;i<nums.length-1;i++) {
    result.push(forward[i-1]*backward[i+1]);
  }
  result.push(forward[nums.length-2]);
  return result;
};

console.log(productExceptSelf([1, 2, 3, 4]));
console.log(productExceptSelf([-1,1,0,-3,3]));
