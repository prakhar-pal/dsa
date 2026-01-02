import MaxHeap from "../core/js/MaxHeap.js";
import assert from "assert";
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// max-heap, priority-queue
/**
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function(k, nums) {
  this.heap = new MaxHeap(nums);
  this.k = k;
};


/**
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
  // console.log("list::before, adding", this.heap.list(), val);
  this.heap.push(val);
  const previousItems = [];
  let count = 1;
  while(count < this.k) {
    previousItems.push(this.heap.pop());
    count++;
  }
  const kthItem = this.heap.peek();
  for(let item of previousItems) {
    this.heap.push(item);
  }
  return kthItem;
};

KthLargest.prototype.peek = function(val) {
  return this.heap.peek();
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */

const klarge0 = new KthLargest(3, [4,5,8,2]);
assert(klarge0.add(3) === 4);
assert(klarge0.add(5) === 5);
assert(klarge0.add(10) === 5);
assert(klarge0.add(9) === 8);
assert(klarge0.add(4) === 8);

const klarge1 = new KthLargest(2, [0]);
assert(klarge1.add(-1) === -1);
assert(klarge1.add(1) === 0);
assert(klarge1.add(-2) === 0);
assert(klarge1.add(-4) === 0);
assert(klarge1.add(3) === 1);
